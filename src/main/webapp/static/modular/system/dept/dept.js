var dataUrl = ctxPath + "/sys/dept/getDeptList";
var addDept = ctxPath+"/sys/dept/addDept";
var showDept = ctxPath+"/sys/dept/showDept";
var delDept = ctxPath+"/sys/dept/delDept";
var editDept = ctxPath+"/sys/dept/editDept";
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
			pageList : [ 5,10, 20, 50, 100, 200, 500 ],
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
	field : 'fullname',
	title : '机构全名'
}, {
	field : 'code',
	title : '机构代码'
}, {
	field : 'pid',
	title : '上级机构'
}, {
	field : '',
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
$("#search_btn").click(function(){
	//1.初始化Table
	$('#dataTable').bootstrapTable('destroy');  
	var oTable = new TableInit();
	oTable.Init();
});

function dataQueryParams(params) {
	$.each(params, function (index, value){
		
    })
	return {
		_size: params.limit,  //页面大小
	    _index: params.offset, //页码
	    Name:$('#search_name').val(),
        Cd:$('#search_cd').val()
	};
}
function edit(id){
	alert("修改部门："+id);
	$("#reviseDept").on("show.bs.modal",function () {
		$(this).removeData("modal");
	});
	$.get(showDept,{id:id,round:Math.random()},function (data) {
	$("#editForm").append(data);
	  $("#deptId").val(data.data.id);
      $("#deptCode").val(data.data.code);
      $("#deptFullname").val(data.data.fullname);
      $("#deptPid").val(data.data.pid);
		$("#reviseDept").modal("show");
	})
}
$('#editBtn').click(function() {
	//表单提交
    $.ajax({
	     type: "POST",
	     dataType : 'json',
	     url: editDept,
	     data:$('#editForm').serialize(),// 你的formid
	     success :function(json) {
	           json = eval(json);
	           if("suc"==json.data.arg){
	        	   alert("修改成功！"+json.data.arg);
				   $('#reviseDept').modal('hide');
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
	$("#deleteDept").modal("show");
}
function delDeptSubmit() {
	var delId = $("#delId").val();
	$.ajax({
		type:'post',
		dataType : 'json',
		url:delDept,
		timeout:3000,
		data:{id:delId},
		error:function () {
			alert("网络出现异常，请稍后再试！");
		},
		success:function (data) {
			var json = eval(data);
			if("success"==json.data.arg){
				alert("删除成功！");
				$("#deleteDept").modal("hide");
				$('#addDept').modal('hide');
				$('#dataTable').bootstrapTable('destroy');
				var oTable = new TableInit();
				oTable.Init();
			}else if(json.code == "1001"){
				alert(json.message);
				$("#deleteDept").modal("hide");
				$('#addDept').modal('hide');
				$('#dataTable').bootstrapTable('destroy');
				var oTable = new TableInit();
				oTable.Init();
			}else{
				alert("删除失败！");
				$("#deleteDept").modal("hide");
				$('#addDept').modal('hide');
				$('#dataTable').bootstrapTable('destroy');
				var oTable = new TableInit();
				oTable.Init();
			}
		}
	});
}

/**
 * 日期格式化
 * @param time
 * @returns {*}
 */
function formatDate(time) {
	if (time == '' || time == null || time == undefined)
		return '';
	var datetime = new Date();
	datetime.setTime(time);
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1)
			: datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime
			.getDate();
	var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime
			.getHours();
	var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes()
			: datetime.getMinutes();
	var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds()
			: datetime.getSeconds();
	return year + "年" + month + "月" + date + "日 " + hour + ":" + minute + ":"
			+ second;
}

$("#btn_add").click(function() {
	$('#addDept').modal('show');
});
$('#validateBtn').click(function() {
	//表单提交
    $.ajax({
	     type: "POST",
	     dataType : 'json',
	     url: addDept,
	     data:$('#DeptAddFrom').serialize(),// 你的formid,
	     success :function(json) {
	           json = eval(json);
	           if("suc"==json.data.arg){
	        	   alert("添加成功！"+json.data.arg);
				   $('#addDept').modal('hide');
	           }else{
	        	   alert("添加失败！"+json.data.arg);
	           }
	           
	     },error:function(e){
	    	 alert('error:'+e);
	     }
   });
});

$('#addDept').on('hidden.bs.modal', function() {
	$("#DeptAddFrom").data('bootstrapValidator').destroy();
	$('#DeptAddFrom').data('bootstrapValidator', null);
});


$('#resetBtn').click(function() {
	 $('#DeptAddFrom').bootstrapValidator('resetForm', true);  
});
function addFormValidator(){
	$('#DeptAddFrom').bootstrapValidator({
	    message: 'This value is not valid',
	    feedbackIcons: {/*输入框不同状态，显示图片的样式*/
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {/*验证*/
	    	account: {/*键名username和input name值对应*/
	            message: 'The account is not valid',
	            validators: {
	                notEmpty: {/*非空提示*/
	                    message: '用户名不能为空'
	                }/*最后一个没有逗号*/
	            }
	        },
	        password: {
	            message:'密码无效',
	            validators: {
	                notEmpty: {
	                    message: '密码不能为空'
	                },
	                stringLength: {
	                    min: 6,
	                    max: 30,
	                    message: '用户名长度必须在6到30之间'
	                }
	            }
	        },
	        email: {
	            validators: {
	                notEmpty: {
	                    message: '邮箱不能为空'
	                },
	                emailAddress: {
	                    message: 'The input is not a valid email address'
	                }
	            }
	        }
	    }
	});
};

//清除弹窗原数据
$("#addDept").on("hidden.bs.modal", function() {
	 $('#DeptAddFrom').bootstrapValidator('resetForm', true);  
});

$('#addDept').on('show.bs.modal', function () {
	 $('#DeptAddFrom').bootstrapValidator('resetForm', true);  
});


