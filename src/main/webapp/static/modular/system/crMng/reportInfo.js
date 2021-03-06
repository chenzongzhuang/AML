$(function() {
	// 1.初始化Table
	var oTablePstr = new TableInitPstr();
	oTablePstr.Init();
	var oTablePctr = new TableInitPctr();
	oTablePctr.Init();
	$('#myTab a:last').tab('show');
});
$('#myTab a').click(function(e) {
	e.preventDefault();
	$(this).tab('show');
});

var dataUrlPstr = ctxPath + "/crMngInfo/toTPstrRbif";
// 初始化Table
var TableInitPstr = function() {
	var oTableInitPstr = new Object();
	// 初始化Table
	oTableInitPstr.Init = function() {
		$('#toTPstrRbif').bootstrapTable(
				{
					contentType : "application/x-www-form-urlencoded",
					method : 'post',
					url : dataUrlPstr,
					dataType : "json",
					idField : "id", // 标识哪个字段为id主键
					singleSelect : true,// 复选框只能选择一条记录
					queryParamsType : "limit", // 参数格式,发送标准的RESTFul类型的参数请求
					queryParams : dataQueryParams,// 传递参数（*）
					formatRecordsPerPage : function(pageNumber) {
						return '每页显示 ' + pageNumber + ' 条记录';
					},
					formatShowingRows : function(pageFrom, pageTo, totalRows) {
						return '显示第 ' + pageFrom + ' 到第 ' + pageTo + ' 条记录，总共 '
								+ totalRows + ' 条记录';
					},
					uniqueId : "ID", // 每一行的唯一标识，一般为主键列
					columns : pstrColumns, // 列
					silent : true, // 刷新事件必须设置
					toolbar : '#toolbar', // 工具按钮用哪个容器
					striped : true, // 是否显示行间隔色
					cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination : true, // 是否显示分页（*）
					sortable : false, // 是否启用排序
					sortOrder : "asc", // 排序方式
					sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
					pageNumber : 1, // 初始化加载第一页，默认第一页
					pageSize : 10, // 每页的记录行数（*）
					pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
					search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
					strictSearch : true,
					showColumns : true, // 是否显示所有的列
					showRefresh : true, // 是否显示刷新按钮
					minimumCountColumns : 1, // 最少允许的列数
					clickToSelect : true, // 是否启用点击选中行
					// height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					showToggle : false, // 是否显示详细视图和列表视图的切换按钮
					cardView : false, // 是否显示详细视图
					detailView : false,
					formatLoadingMessage : function() {
						return "请稍等，正在加载中...";
					},
					formatNoMatches : function(s) { // 没有匹配的结果
						return '无符合条件的记录';
					},
					onLoadSuccess : function() {
					},
					onPageChange : function(number, size) {
						// currPageIndex = number;
						// currLimit = size;
						// alert("当前页："+currPageIndex+"当前数据数:"+currLimit);
						//                 
					},
					onLoadError : function(data) {
						console.log(data + "---" + data);
						// $('#reportTable').bootstrapTable('removeAll');
					},
					onClickRow : function(row) {
						alert(row.id);
						// window.location.href = "/qStock/qProInfo/" +
						// row.ProductId;
					},
					responseHandler : function(res) {
						if (res.code == 1) {
							return {
								"total" : res.data.total,// 总页数
								"rows" : res.data.rows
							// 数据
							};

						}
					}
				});
	};
	return oTableInitPstr;
}


var pctrColumns = [ {
	field : 'id',
	title : '序号',
	checkbox : true
}, {
	field : 'repName',
	title : '报告名称'
}, {
	field : 'redt',
	title : '生成时间'
}];

var pstrColumns = [ {
	field : 'id',
	title : '序号',
	checkbox : true
}, {
	field : 'repNm',
	title : '报告名称'
}, {
	field : 'redt',
	title : '生成时间'
}];

var dataUrlPctr = ctxPath + "/crMngInfo/toTPctrRbif";
// 初始化Table
var TableInitPctr = function() {
	var oTableInitPctr = new Object();
	// 初始化Table
	oTableInitPctr.Init = function() {
		$('#toTPctrRbif').bootstrapTable(
				{
					contentType : "application/x-www-form-urlencoded",
					method : 'post',
					url : dataUrlPctr,
					dataType : "json",
					idField : "id", // 标识哪个字段为id主键
					singleSelect : true,// 复选框只能选择一条记录
					queryParamsType : "limit", // 参数格式,发送标准的RESTFul类型的参数请求
					queryParams : dataQueryParams,// 传递参数（*）
					formatRecordsPerPage : function(pageNumber) {
						return '每页显示 ' + pageNumber + ' 条记录';
					},
					formatShowingRows : function(pageFrom, pageTo, totalRows) {
						return '显示第 ' + pageFrom + ' 到第 ' + pageTo + ' 条记录，总共 '
								+ totalRows + ' 条记录';
					},
					uniqueId : "ID", // 每一行的唯一标识，一般为主键列
					columns : pctrColumns, // 列
					silent : true, // 刷新事件必须设置
					toolbar : '#toolbar', // 工具按钮用哪个容器
					striped : true, // 是否显示行间隔色
					cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					pagination : true, // 是否显示分页（*）
					sortable : false, // 是否启用排序
					sortOrder : "asc", // 排序方式
					sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
					pageNumber : 1, // 初始化加载第一页，默认第一页
					pageSize : 10, // 每页的记录行数（*）
					pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
					search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
					strictSearch : true,
					showColumns : true, // 是否显示所有的列
					showRefresh : true, // 是否显示刷新按钮
					minimumCountColumns : 1, // 最少允许的列数
					clickToSelect : true, // 是否启用点击选中行
					// height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					showToggle : false, // 是否显示详细视图和列表视图的切换按钮
					cardView : false, // 是否显示详细视图
					detailView : false,
					formatLoadingMessage : function() {
						return "请稍等，正在加载中...";
					},
					formatNoMatches : function(s) { // 没有匹配的结果
						return '无符合条件的记录';
					},
					onLoadSuccess : function() {
					},
					onPageChange : function(number, size) {
						// currPageIndex = number;
						// currLimit = size;
						// alert("当前页："+currPageIndex+"当前数据数:"+currLimit);
						//                 
					},
					onLoadError : function(data) {
						console.log(data + "---" + data);
						// $('#reportTable').bootstrapTable('removeAll');
					},
					onClickRow : function(row) {
						alert(row.id);
						// window.location.href = "/qStock/qProInfo/" +
						// row.ProductId;
					},
					responseHandler : function(res) {
						if (res.code == 1) {
							return {
								"total" : res.data.total,// 总页数
								"rows" : res.data.rows
							// 数据
							};

						}
					}
				});
	};
	return oTableInitPctr;
}

function dataQueryParams(params) {
	// $.each(params, function (index, value) {
	// console.log(index+"---"+value);
	// });
	return {
		_size : params.limit, // 页面大小
		_index : params.offset, // 页码
	};
}
