package com.aml.sys.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EasyuiTreeNode implements Comparable {
	
	private Integer id;
	private String text;
	private String state;
	private String checked;
    private Integer ismenu;
	private Integer levels;
	
	private Integer parentId;
	private List<EasyuiTreeNode> children;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}

    public static MenuNode createRoot() {
        return new MenuNode(0, -1);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    /**
     * 按钮的排序
     */
    private Integer num;




    public List<EasyuiTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<EasyuiTreeNode> children) {
		this.children = children;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Integer getIsmenu() {
		return ismenu;
	}
	public void setIsmenu(Integer ismenu) {
		this.ismenu = ismenu;
	}
	
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	
	 /**
     * 查询子节点时候的临时集合
     */
    private List<EasyuiTreeNode> linkedList = new ArrayList<EasyuiTreeNode>();
    
	@Override
    public String toString() {
        return "MenuNode{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", levels=" + levels +
                ", children=" + children +
                '}';
    }

    @Override
    public int compareTo(Object o) {
    	EasyuiTreeNode menuNode = (EasyuiTreeNode) o;
        Integer num = menuNode.getNum();
        if (num == null) {
            num = 0;
        }
        return this.num.compareTo(num);
    }

    /**
     * 构建整个菜单树
     *
     */
    public void buildNodeTree(List<EasyuiTreeNode> nodeList) {
        for (EasyuiTreeNode treeNode : nodeList) {
            List<EasyuiTreeNode> linkedList = treeNode.findChildNodes(nodeList, treeNode.getId());
            if (linkedList.size() > 0) {
                treeNode.setChildren(linkedList);
            }
        }
    }

    /**
     * 查询子节点的集合
     *
     */
    public List<EasyuiTreeNode> findChildNodes(List<EasyuiTreeNode> nodeList, Integer parentId) {
        if (nodeList == null && parentId == null)
            return null;
        for (Iterator<EasyuiTreeNode> iterator = nodeList.iterator(); iterator.hasNext(); ) {
        	EasyuiTreeNode node = (EasyuiTreeNode) iterator.next();
            // 根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentId() != 0 && parentId.equals(node.getParentId())) {
                recursionFn(nodeList, node, parentId);
            }
        }
        return linkedList;
    }

    /**
     * 遍历一个节点的子节点
     *
     */
    public void recursionFn(List<EasyuiTreeNode> nodeList, EasyuiTreeNode node, Integer pId) {
        List<EasyuiTreeNode> childList = getChildList(nodeList, node);// 得到子节点列表
        if (childList.size() > 0) {// 判断是否有子节点
            if (node.getParentId().equals(pId)) {
                linkedList.add(node);
            }
            Iterator<EasyuiTreeNode> it = childList.iterator();
            while (it.hasNext()) {
            	EasyuiTreeNode n = (EasyuiTreeNode) it.next();
                recursionFn(nodeList, n, pId);
            }
        } else {
            if (node.getParentId().equals(pId)) {
                linkedList.add(node);
            }
        }
    }

    /**
     * 得到子节点列表
     *
     */
    private List<EasyuiTreeNode> getChildList(List<EasyuiTreeNode> list, EasyuiTreeNode node) {
        List<EasyuiTreeNode> nodeList = new ArrayList<EasyuiTreeNode>();
        Iterator<EasyuiTreeNode> it = list.iterator();
        while (it.hasNext()) {
        	EasyuiTreeNode n = (EasyuiTreeNode) it.next();
            if (n.getParentId().equals(node.getId())) {
                nodeList.add(n);
            }
        }
        return nodeList;
    }

    /**
     * 清除掉按钮级别的资源
     *
     */
    public static List<EasyuiTreeNode> clearBtn(List<EasyuiTreeNode> nodes) {
        ArrayList<EasyuiTreeNode> noBtns = new ArrayList<EasyuiTreeNode>();
        for (EasyuiTreeNode node : nodes) {
            if(node.getIsmenu() == IsMenu.YES.getCode()){
                noBtns.add(node);
            }
        }
        return noBtns;
    }

    /**
     * 清除所有二级菜单
     *
     */
    public static List<EasyuiTreeNode> clearLevelTwo(List<EasyuiTreeNode> nodes) {
        ArrayList<EasyuiTreeNode> results = new ArrayList<EasyuiTreeNode>();
        for (EasyuiTreeNode node : nodes) {
            Integer levels = node.getLevels();
            if (levels.equals(1)) {
                results.add(node);
            }
        }
        return results;
    }
    /**
     * 构建菜单列表
     *
     */
    public static List<EasyuiTreeNode> buildTitle(List<EasyuiTreeNode> nodes) {

        List<EasyuiTreeNode> clearBtn = clearBtn(nodes);

        new EasyuiTreeNode().buildNodeTree(clearBtn);

        List<EasyuiTreeNode> menuNodes = clearLevelTwo(clearBtn);

        //对菜单排序
        Collections.sort(menuNodes);

        //对菜单的子菜单进行排序
        for (EasyuiTreeNode menuNode : menuNodes) {
            if (menuNode.getChildren() != null && menuNode.getChildren().size() > 0) {
                Collections.sort(menuNode.getChildren());
            }
        }
        return menuNodes;
    }
}
