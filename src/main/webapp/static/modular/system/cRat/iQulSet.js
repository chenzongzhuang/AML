$(function() {
	//1.初始化Table
	var oTable = new iQulSetTableInit();
	oTable.Init();
	 //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
	$(".leftMeun").find("li").not(":has(ul)").children("a").css({
		textDecoration : "none",
		color : "#333",
		background : "none"
	}).click(function() {
//		$(this).get(0).location.href = "'" + $(this).attr("href") + "'";
	});
	$(".leftMeun").find("li:has(ul)").children("a").css({
		background : "url(images/statu_close.gif) no-repeat left top;"
	}).click(
			function() {
				if ($(this).next("ul").is(":hidden")) {
					$(this).next("ul").slideDown("slow");
					if ($(this).parent("li").siblings("li").children(
							"ul").is(":visible")) {
						$(this).parent("li").siblings("li").find("ul")
								.slideUp("1000");
						$(this).parent("li").siblings("li:has(ul)").children("a").css(
										{background : "url(images/statu_close.gif) no-repeat left top;"}).end().find("li:has(ul)")
								.children("a")
								.css({
										background : "url(images/statu_close.gif) no-repeat left top;"
									});
					}
					$(this).css({
									background : "url(images/statu_open.gif) no-repeat left top;"
								});
					return false;
				} else {
					$(this).next("ul").slideUp("normal");
					//不用toggle()的原因是为了在收缩菜单的时候同时也将该菜单的下级菜单以后的所有元素都隐藏
					$(this).css({
									background : "url(images/statu_close.gif) no-repeat left top;"
								});
					$(this).next("ul").children("li").find("ul")
							.fadeOut("normal");
					$(this).next("ul").find("li:has(ul)").children("a").css(
									{
										background : "url(images/statu_close.gif) no-repeat left top;"
									});
					return false;
				}
			});
})
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};

var dataUrl = ctxPath + "/sys/cRat/getIQulSetList";
//初始化Table
var iQulSetTableInit = function() {
	var iQulSetTableInit = new Object();
	//初始化Table
	iQulSetTableInit.Init = function() {
		$('#iQulSetTableInit').bootstrapTable({
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
				//$('#reportTable').bootstrapTable('removeAll');
			},
			onClickRow : function(row) {
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
	return iQulSetTableInit;
};
function dataQueryParams(params) {
	$.each(params, function (index, value) {
        console.log(index+"---"+value);
    })
	return {
		_size: params.limit,  //页面大小
	    _index: params.offset //页码
	};
}
var dataColumns = [ {
	field : 'id',
	title : '序号',
	checkbox:true
},{
	title: '操作',
	field: 'edit',
	align: 'center',
	formatter:function(value,row,index){
		 var e = '<a href="#" class="btn btn-primary" onclick="edit(\''+ row.rlCd + '\')">编辑</a> ';  
		 var d = '<a href="#" class="btn btn-primary" onclick="del(\''+ row.rlCd +'\')">删除</a> ';  
		 return e+d;  
	} 
}, {
	field : 'rlCd',
	title : '规则名称'
}, {
	field : 'rlTp',
	title : '规则模型'
}, {
	field : 'status',
	title : '状态'
}, {
	field : 'adjRank',
	title : '需要调整的等级'
}, {
	field : 'tgtRank',
	title : '目标等级'
}, {
	field : 'priority',
	title : '优先级'
}, {
	title: '定性条件',
	field: 'detail',
	align: 'center',
	formatter:function(value,row,index){
		var e = '<a href="/cRat/ratRankRule?rlCd='+ row.rlCd + '">条件明细</a> ';
		return e;  
	} 
}
];
$("#IQulSet_add").click(function() {
	$('#addIQulSet').modal('show');
});
//新增风险等级维护
var addIQulSet = ctxPath+"/sys/cRat/addIQulSet";
$('#saveIQulSet').click(function() {
	//表单提交
    $.ajax({
	     type: "POST",
	     dataType : 'json',
	     url: addIQulSet,
	     data:$('#addIQulSetFrom').serialize(),// 你的formid,
	     success :function(json) {
	           json = eval(json);
	           if("suc"==json.data.arg){
	        	   alert("添加成功！"+json.data.arg);
	        	   $('#iQulSetTableInit').bootstrapTable('destroy');
	        	   var oTable = new iQulSetTableInit();
	        	   oTable.Init();
				   $('#addIQulSet').modal('hide');
	           }else if(json.data.pkConf){
	        	   alert("您填写的等级代码："+json.data.arg+"已经存在，请重新填写！");
	           }else{
	        	   alert("添加失败！"+json.data.arg);
	           }
	           
	     },error:function(e){
	    	 alert('error:'+e);
	     }
   });
});
//修改指标定性设置
function edit(rkCd){
	$("#editForm").empty();
	$.get(ctxPath+"/sys/cRat/showIQulSet",{rkCd:rkCd},function (data) {
		$("#editForm").append(data);
		$("#reviseIQulSet").modal("show");
	})
}
var editIQulSet = ctxPath+"/sys/cRat/editIQulSet";
$('#editIQulSet').click(function() {
	//表单提交
    $.ajax({
	     type: "POST",
	     dataType : 'json',
	     url: editIQulSet,
	     data:$('#editForm').serialize(),// 你的formid,
	     success :function(json) {
	           json = eval(json);
	           if("suc"==json.data.arg){
	        	   alert("保存成功！"+json.data.arg);
	        	   $('#iQulSetTableInit').bootstrapTable('destroy');
	        	   var oTable = new iQulSetTableInit();
	        	   oTable.Init();
				   $('#reviseIQulSet').modal('hide');
	           }else if(json.data.pkConf){
	        	   alert("您填写的等级代码："+json.data.arg+"已经存在，请重新填写！");
	           }else{
	        	   alert("保存失败！"+json.data.arg);
	           }
	           
	     },error:function(e){
	    	 alert('error:'+e);
	     }
   });
});
//删除
function del(rlCd){
	$("#delId").val(rlCd);
	$("#deleteIQulSet").modal("show");
}
var delIQulSet = ctxPath+"/sys/cRat/delIQulSet";
function delIQulSetSubmit() {
	var rlCd = $("#delId").val();
	$.ajax({
		type:'post',
		dataType : 'json',
		url:delIQulSet,
		timeout:3000,
		data:{rlCd:rlCd},
		error:function () {
			alert("网络出现异常，请稍后再试！");
		},
		success:function (data) {
			var json = eval(data);
			if("suc"==json.data.arg){
				alert("删除成功！");
				$('#deleteIQulSet').modal('hide');
				 $('#iQulSetTableInit').bootstrapTable('destroy');
	        	   var oTable = new iQulSetTableInit();
	        	   oTable.Init();
			}else{
				alert("删除失败！");
			}
		}
	});
}