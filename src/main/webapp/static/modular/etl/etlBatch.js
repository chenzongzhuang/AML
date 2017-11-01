var editUrl = ctxPath + "/etl/addBatch";
//格式化日期插件
$('#colDt').datepicker({
	  format: 'yyyy-mm-dd',
	        weekStart: 1,
	        autoclose: true,
	        todayBtn: 'linked',
	        language: 'zh-CN'
	 }).on('changeDate',function(ev){
 });

function addBatch(){
	//获取隐藏的id,如果没有 则为新增
	$.ajax({
		type:'post',
		dataType : 'json',
		url:editUrl,
		timeout:3000,
		 data:$('#EtlAddFrom').serialize(),//formid,
		error:function () {
			alert("网络出现异常，请稍后再试！");
		},
		success:function (data) {
			var json = eval(data);
			if("success"==json.data.arg){
				alert("保存成功！");
				
			}else{
				alert("保存失败！");
			}
		}
	});
}

