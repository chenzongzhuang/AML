var dataUrl = ctxPath + "/sys/log/getOpLogList";
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
//初始化Table
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
			pageSize : 10,
			pageList : [ 10,10, 20, 50, 100, 200, 500 ],
			idField : "id", //标识哪个字段为id主键
			showToggle : false, //名片格式
			cardView : false,//设置为True时显示名片（card）布局
//			showColumns : true, //显示隐藏列  
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
			responseHandler : function(res) {
				if (res.code == 1) {
					return {
						"total" : res.data.total,//总页数
						"rows" : res.data.rows
					//数据
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
	field : 'createtime',
	title : '操作日期'
}, {
	field : 'userid',
	title : '操作用户ID',
	align: 'center'
},
{
	field : 'message',
	title : '操作内容'
}, {
	field : 'ip',
	title : 'IP地址' 
}
];
$("#search_btn").click(function(){
	//1.初始化Table
	$('#dataTable').bootstrapTable('destroy');  
	var oTable = new TableInit();
	oTable.Init();
});

function dataQueryParams(params) {
	return {
		_size: params.limit,  //页面大小
	    _index: params.offset, //页码
	    startDate:$('#startDate').val(),
	    endDate:$('#endDate').val(),
	    userid:$('#userid').val(),
	    ip:$('#ip').val()
	};
}
//格式化日期插件
$('#startDate').datepicker({
	  format: 'yyyy-mm-dd',
	        weekStart: 1,
	        autoclose: true,
	        todayBtn: 'linked',
	        language: 'zh-CN'
	 }).on('changeDate',function(ev){
 });
$('#endDate').datepicker({
	  format: 'yyyy-mm-dd',
	        weekStart: 1,
	        autoclose: true,
	        todayBtn: 'linked',
	        language: 'zh-CN'
	 }).on('changeDate',function(ev){
});

