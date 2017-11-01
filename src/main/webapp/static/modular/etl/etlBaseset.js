var editUrl = ctxPath + "/etl/editEtlBaseSet";
function esitBeseSet(){
	//获取隐藏的id,如果没有 则为新增
	$.ajax({
		type:'post',
		dataType : 'json',
		url:editUrl,
		timeout:3000,
		 data:$('#EtlBaseSetFrom').serialize(),//formid,
		error:function () {
			alert("网络出现异常，请稍后再试！");
		},
		success:function (data) {
			var json = eval(data);
			if("success"==json.data.arg){
				alert("编辑成功！");
				
			}else{
				alert("编辑失败！");
			}
		}
	});
}

