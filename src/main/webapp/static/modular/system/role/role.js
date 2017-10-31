var dataUrl = ctxPath + "/sys/role/getRoleList";
var addRole = ctxPath+"/sys/role/addRole";
var showRole = ctxPath+"/sys/role/showRole";
var delRole = ctxPath+"/sys/role/delRole";
var editRole = ctxPath+"/sys/role/editRole";
var menuTree = ctxPath+"/sys/role/getMenuTree";
var menuTreeOfEdit = ctxPath+"/sys/role/getMenuTreeOfEdit";
$(function() {
	//1.初始化Table
	var oTable = new TableInit();
	oTable.Init();
	//2.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();
	addFormValidator();
})
var ButtonInit = function() {
	var oInit = new Object();
	var postdata = {};
	oInit.Init = function() {
		//初始化页面上面的按钮事件
	};
	return oInit;
};
//开始初始化Table
var TableInit = function() {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function() {
        $('#dataTable').bootstrapTable({
        	contentType: "application/x-www-form-urlencoded",
			method : 'post',
			url : dataUrl,
			dataType : "json",
			striped : true, //使表格带有条纹
			pagination : true, //在表格底部显示分页工具栏
			pageNumber: 1,
			pageSize : 5,
			pageList : [ 5,10, 20],
			idField : "id", //标识哪个字段为id主键
			showToggle : false, //名片格式
			cardView : false,//设置为True时显示名片（card）布局
			singleSelect : true,//复选框只能选择一条记录
			clickToSelect : true,//点击行即可选中单选/复选框
			sidePagination : "server",//表格分页的位置
			queryParamsType : "limit", //参数格式,发送标准的RESTFul类型的参数请求
			queryParams : dataQueryParams,
			columns : dataColumns, //列
			clickToSelect: true,//是否启用点击选中行
			silent : true, //刷新事件必须设置
            formatLoadingMessage : function() {
                return "请稍等，正在加载中...";
            },
            formatNoMatches : function() { //没有匹配的结果
                return '无符合条件的记录';
            },
            onLoadSuccess : function() {

            },
            onPageChange: function (number, size) {
                //
            },
            responseHandler : function(res) {
                if (res.code == 1) {
                    return {
                        "total" : res.data.total,//总页数
                        "rows" : res.data.rows
                    };
                }
            }
        });
    };
    return oTableInit;
};
var dataColumns = [ {
	field : 'id',
	title : '序号'
}, {
	field : 'name',
	title : '角色名'
}, {
	field : 'tips',
	title : '描述'
}, {
	field : 'version',
	title : '备注'
}, {
	title: '操作',
	field: 'id',
	align: 'center',
	formatter:function(value,row,index){  
		 var e = '<button class="btn btn-primary" id="btn_edit" onclick="edit(\''+ row.id + '\')" >修改</button>';
		 var d = ' <button class="btn btn-primary" id="btn_del" onclick="del(\''+ row.id +'\')" >删除</button>';
		 return e+d;  
	} 
}
];

function dataQueryParams(params) {
	$.each(params, function (index, value){
		
    })
	return {
		_size: params.limit,  //页面大小
	    _index: params.offset //页码
	};
}
function edit(id){
	alert("修改角色："+id);
	$("#reviseRole").on("show.bs.modal",function () {
		$(this).removeData("modal");
	});
	$.get(showRole,{id:id,round:Math.random()},function (data) {
		$("#editForm").append(data);
        $("#roleId").val(data.data.id);
        $("#roleName").val(data.data.name);
        $("#roleTips").val(data.data.tips);
        $("#roleVersion").val(data.data.version);
      //  $("#getMenuTreeOfEdit").val(data.data.getMenuTreeOfEdit);
		$("#reviseRole").modal("show");
	});
    $("#roleTreeOfEdit").tree({
        url:menuTreeOfEdit+"?id="+id,
        checkbox:true,
        onBeforeLoad:function(node,param){
            if(node!=null){
                return false;
            }else{
                return true;
            }
        }
    });
   
}

function getCheck(){
	var nodes = $('#roleTreeOfEdit').tree('getCheck');
	var s = '';
	for(var i=0; i<nodes.length; i++){
		if (s != '') s += ',';
		s += nodes[i].id;
	}
	$('#menuListValue').val(s);
}

/*function getMenuTreeOfEdit() {
	alert($("#roleTreeOfEdit").html());
    $("#roleTreeOfEdit").tree({
        url:getMenuTreeOfEdit,
        checkbox:true,
        onBeforeLoad:function(node,param){
            if(node!=null){
                return false;
            }else{
                return true;
            }
        }
    });
}*/
$('#editBtn').click(function() {
	alert("1");
	getCheck();
	//表单提交
    $.ajax({
	     type: "POST",
	     dataType : 'json',
	     url: editRole,
	     data:$('#editForm').serialize(),// 你的formid
	     success :function(json) {
	           json = eval(json);
	           if("suc"==json.data.arg){
	        	   alert("修改成功！"+json.data.arg);
				   $('#editRole').modal('hide');
	           }else{
	        	   alert("修改失败！"+json.data.arg);
	           }
	           
	     },error:function(e){
	    	 alert('error:'+e);
	     }
   });
});
function del(id){
	$("#delId").val(id);
	$("#deleteRole").modal("show");
}
function delRoleSubmit() {
	var delId = $("#delId").val();
	$.ajax({
		type:'post',
		dataType : 'json',
		url:delRole,
		timeout:3000,
		data:{id:delId},
		error:function () {
			alert("网络出现异常，请稍后再试！");
		},
		success:function (data) {
			var json = eval(data);
			if("success"==json.data.arg){
				alert("删除成功！");
				$("#deleteRole").modal("hide");
				$('#addRole').modal('hide');
				$('#dataTable').bootstrapTable('destroy');
				var oTable = new TableInit();
				oTable.Init();
			}else if(json.code == "1001"){
				alert(json.message);
				$("#deleteRole").modal("hide");
				$('#addRole').modal('hide');
				$('#dataTable').bootstrapTable('destroy');
				var oTable = new TableInit();
				oTable.Init();
			}else{
				alert("删除失败！");
				$("#deleteRole").modal("hide");
				$('#addRole').modal('hide');
				$('#dataTable').bootstrapTable('destroy');
				var oTable = new TableInit();
				oTable.Init();
			}
		}
	});
}

$("#btn_add").click(function() {
	$('#addRole').modal('show');
	$("#roleTree").tree({
		url:menuTree,
		checkbox:true,
		onBeforeLoad:function(node,param){
			if(node!=null){
				return false;
			}else{
				return true;
			}
		}
	});
});

function getChecked(){
	var nodes = $('#roleTree').tree('getChecked');
	var s = '';
	for(var i=0; i<nodes.length; i++){
		if (s != '') s += ',';
		s += nodes[i].id;
	}
	$('#menuListValue').val(s);
}

$('#validateBtn').click(function() {
	getChecked();
	//表单提交
    $.ajax({
	     type: "POST",
	     dataType : 'json',
	     url: addRole,
	     data:$('#roleAddFrom').serialize(),// 你的formid,
	     success :function(json) {
	           json = eval(json);
	           if("suc"==json.data.arg){
	        	   alert("添加成功！"+json.data.arg);
	        	   window.location.reload();
				   $('#addRole').modal('hide');
	           }else{
	        	   alert("添加失败！"+json.data.arg);
	           }
	           
	     },error:function(e){
	    	 alert('error:'+e);
	     }
   });
});


$('#addRole').on('hidden.bs.modal', function() {
	$("#roleAddFrom").data('bootstrapValidator').destroy();
	$('#roleAddFrom').data('bootstrapValidator', null);
});


$('#resetBtn').click(function() {
	 $('#roleAddFrom').bootstrapValidator('resetForm', true);  
});
function addFormValidator(){
	$('#roleAddFrom').bootstrapValidator({
	    message: 'This value is not valid',
	    feedbackIcons: {/*输入框不同状态，显示图片的样式*/
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {/*验证*/
	    	name: {/*键名username和input name值对应*/
	            message: 'The account is not valid',
	            validators: {
	                notEmpty: {/*非空提示*/
	                    message: '角色名不能为空'
	                }/*最后一个没有逗号*/
	            }
	        }
	    }
	});
};

//清除弹窗原数据
$("#addRole").on("hidden.bs.modal", function() {
	 $('#roleAddFrom').bootstrapValidator('resetForm', true);  
});

$('#addRole').on('show.bs.modal', function () {
	 $('#roleAddFrom').bootstrapValidator('resetForm', true);  
});


0000000