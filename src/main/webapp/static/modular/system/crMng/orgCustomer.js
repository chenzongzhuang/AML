//function search1() {
//	//var submitData=decodeURIComponent(data,true);
//	//var custNo= $("input[name=custNo]").val();
//	 $('#listForm').attr("action","/crMng/cust/perCustomer");
//	 $('#listForm').submit();
//}

$(function(){
	$('#startdiv').datetimepicker({  
        format: 'YYYY-MM-DD',  
        locale: moment.locale('zh-cn')  
    });
    $('#endDiv').datetimepicker({  
        format: 'YYYY-MM-DD',  
        locale: moment.locale('zh-cn')  
    });
	//1.初始化Table
	var oTable = new TableInit();
	oTable.Init();
	//2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    //初始化加载下拉框枚举值
    var select = new newSelectInit();
	select.Init("clientTp");
	var select = new newSelectInit();
	select.Init("riskLevel");
	var select = new newSelectInit();
	select.Init("endtime");
	var select = new newSelectInit();
	select.Init("merUnit");
    
    
});


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};

var dataUrl = ctxPath + "/crMng/orgCustomer/toPerCustomer";
//初始化Table
var TableInit = function() {
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function() {
		$('#perCustomerTable').bootstrapTable({
			contentType: "application/x-www-form-urlencoded",
			method : 'post',
			url : dataUrl,
			dataType : "json",
			idField : "id", //标识哪个字段为id主键
			singleSelect : true,//复选框只能选择一条记录
			queryParamsType : "limit", //参数格式,发送标准的RESTFul类型的参数请求
			queryParams : dataQueryParams,//传递参数（*）
			formatRecordsPerPage: function (pageNumber) {
	            return '每页显示 ' + pageNumber + ' 条记录';
	        },
	        formatShowingRows: function (pageFrom, pageTo, totalRows) {
	            return '显示第 ' + pageFrom + ' 到第 ' + pageTo + ' 条记录，总共 ' + totalRows + ' 条记录';
	        },
            uniqueId: "ID",               //每一行的唯一标识，一般为主键列  
			columns : dataColumns, //列
			silent : true, //刷新事件必须设置
		    toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 1,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            //height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false, 
			formatLoadingMessage : function() {
				return "请稍等，正在加载中...";
			},
			formatNoMatches : function(s) { //没有匹配的结果
				return '无符合条件的记录';
			},
			onLoadSuccess : function() {
				
			},
			onPageChange: function (number, size) {  
//                 currPageIndex = number;  
//                 currLimit = size;
//                 alert("当前页："+currPageIndex+"当前数据数:"+currLimit);
//                 
             },
			onLoadError : function(data) {
				console.log(data+"---"+data);
				//$('#reportTable').bootstrapTable('removeAll');
			},
			onClickRow : function(row) {
				alert(row.id);
				//window.location.href = "/qStock/qProInfo/" + row.ProductId;
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
	
	
	
//	//初始化Table
//	oTableInit.Init = function() {
//		$('#perCustomerTable').bootstrapTable({
//			contentType: "application/x-www-form-urlencoded",
//			method : 'post',
//			url : dataUrl,
//			dataType : "json",
//			striped : true, //使表格带有条纹
//			pagination : true, //在表格底部显示分页工具栏
//			pageNumber: 1,
//			pageSize : 5,
//			pageList : [ 5,10, 20, 50, 100, 200, 500 ],
//			idField : "id", //标识哪个字段为id主键
//			showToggle : false, //名片格式
//			cardView : false,//设置为True时显示名片（card）布局
////			showColumns : true, //显示隐藏列  
//			singleSelect : true,//复选框只能选择一条记录
//			clickToSelect : true,//点击行即可选中单选/复选框
//			sidePagination : "server",//表格分页的位置
//			queryParamsType : "limit", //参数格式,发送标准的RESTFul类型的参数请求
//			queryParams : dataQueryParams,
//			columns : dataColumns, //列
//			clickToSelect: true,//是否启用点击选中行
//			silent : true, //刷新事件必须设置
//			formatLoadingMessage : function() {
//				return "请稍等，正在加载中...";
//			},
//			formatNoMatches : function() { //没有匹配的结果
//				return '无符合条件的记录';
//			},
//			onLoadSuccess : function() {
//				console.log("success");
//			},
//			onLoadError : function(data,e) {
//				console.log(e);
//			},
//			onPageChange: function (number, size) {  
////                 currPageIndex = number;  
////                 currLimit = size;
////                 alert("当前页："+currPageIndex+"当前数据数:"+currLimit);
////                 
//             },
//			responseHandler : function(res) {
//				if (res.code == 1) {
//					return {
//						"total" : res.data.total,//总页数
//						"rows" : res.data.rows
//					//数据
//					};
//
//				}
//			}
//		});
//	};
	
	
	
	
	return oTableInit;
}

function dataQueryParams(params) {
//	$.each(params, function (index, value) {
//        console.log(index+"---"+value);
//    });
	return {
		_size: params.limit,  //页面大小
	    _index: params.offset, //页码
	    busiRegNo:$('#busiRegNo').val(),
	    ctnm:$('#ctnm').val(),
	    clientTp:$('#clientTp').val(),
	    agencyCtid:$('#agencyCtid').val(),
	    endtime:$('#endtime').val(),
	    riskLevel:$('#riskLevel').val(),
	    merUnit:$('#merUnit').val(),
	    rgdtStart:$('#rgdtStart').val(),
	    rgdtEnd:$('#rgdtEnd').val()
	};
}


var dataColumns = [ {
	field : 'id',
	title : '序号'
//		,
//	checkbox:true
}
, {
	field : 'busiRegNo',
	title : '客户号'
  }, {
	field : 'education',
	title : '学历'
}
  , {
	field : 'marriage',
	title : '婚姻状况'
}, {
	field : 'ctnm',
	title : '客户名称'
}, {
	field : 'ctvc',
	title : '职业'
}, {
	field : 'riskLevel',
	title : '风险等级'
}, {
	field : 'rgdt',
	title : '开户日期'
}, {
	title: '操作',
	field: 'edit',
	align: 'center',
	formatter:function(value,row,index){
		 var e = '<a href="#" onclick="look(\''+ row.id + '\')">尽职调查</a> ';  
		 return e;  
		} 
	}
];


$("#search_btn").click(function(){
	//1.初始化Table
	$('#perCustomerTable').bootstrapTable('destroy');  
	var oTable = new TableInit();
	oTable.Init();
});

//初始化加载下拉框枚举值
var url = "/crMng/perCustomer/loadDict";
var newSelectInit = function() {
	var newSelectInit = new Object();
	//初始化Table
	newSelectInit.Init = function(id) {
		$.ajax({
			url: url,//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
			//数据发送方式
			type: "get",
			async: false,
			//接受数据格式
			dataType: "json",
			//要传递的数据
			data: {"id":id},
			//回调函数，接受服务器端返回给客户端的值，即result值
			success: function (data) {
				$('#'+id+'.selectpicker').append("<option selected='selected' value=''>--请选择--</option>");
				$.each(data.data.rows, function (i) {
//					alert(data.data.rows[i].mtdtNm);
					$('#'+id+'.selectpicker').append("<option value=" + data.data.rows[i].dmCd + ">" + data.data.rows[i].dmNm + "</option>");
				});
				$('#'+id+'').selectpicker('refresh');
			},
			error: function (data) {
				alert("查询数据字典失败" + data);
			}
		});
	}
	return newSelectInit;
}


//jxl生成excel并下载
$("#exportExcel").click(function(){
	//window.open('/downLoadTemp','文件下载窗口','height=300,width=450,left='+(screen.availWidth-400)/2+',top'+(screen.availHeight-300)/2);
	$('#perCustomerTable').bootstrapTable('destroy');  
	var oTable = new TableInit();
	oTable.Init();
	$.ajax({
		url:'/crMng/orgCustomer/exportExcel',
		dataType:'json',
		data:$("#excelForm").serialize(),
		success:function(data){
			if(data.data.result=="success"){
				document.getElementById("excelForm").action="/crMng/orgCustomer/downExcel";
				document.getElementById("excelForm").submit();
			}
		}
		
	});
});


