var dataUrl  = ctxPath + "/cms/getCmsList";
var delUrl = ctxPath + "/cms/delCms";
var getUrl = ctxPath + "/cms/getCmsEntity";
var editUrl = ctxPath + "/cms/editCmsEntity";
$(function() {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
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
    field : 'dict.dmNm',
    title : '栏目'
}, {
    field : 'title',
    title : '标题'
}, {
    field : 'publishTime',
    title : '发布时间'
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
function del(id){
	$("#delId").val(id);
	$("#deleteCms").modal("show");
}
function delSubmit() {
	var delId = $("#delId").val();
	$.ajax({
		type:'post',
		dataType : 'json',
		url:delUrl,
		timeout:3000,
		data:{id:delId},
		error:function () {
			alert("网络出现异常，请稍后再试！");
		},
		success:function (data) {
			var json = eval(data);
			if("success"==json.data.arg){
				alert("删除成功！");
				$("#deleteCms").modal("hide");
				$('#dataTable').bootstrapTable('destroy');
				var oTable = new TableInit();
				oTable.Init();
			}else{
				alert("删除失败！");
			}
		}
	});
}
function edit(id){
	//获取修改信息 getUrl
	$.ajax({
		type:'post',
		dataType : 'json',
		url:getUrl,
		timeout:3000,
		data:{id:id},
		error:function () {
			alert("网络出现异常，请稍后再试！");
		},
		success:function (data) {
			var json = eval(data);
			if("success"==json.data.arg){
				$('#editChannelId').val(json.data.cms.channelId);
				$('#editTitle').val(json.data.cms.title);
				$('#editContent').val(json.data.cms.content);
				$('#editId').val(json.data.cms.id);
				$("#editModal").modal("show");
			}else{
				alert("获取失败！");
			}
		}
	});
}


$('#editModal').on('hidden.bs.modal', function() {
	$('#cmsEditFrom').data('bootstrapValidator', null);
});
function dataQueryParams(params) {
    return {
        _size: params.limit,  //页面大小
        _index: params.offset, //页码
        title:$('#title').val(),
        channelId:$('#channelId').val()
    };
}
$("#cms_btn").click(function () {
    window.open(ctxPath+"/cms/addCmsNews",'_blank')
});

$("#search_btn").click(function(){
	//1.初始化Table
	$('#dataTable').bootstrapTable('destroy');  
	var oTable = new TableInit();
	oTable.Init();
});
