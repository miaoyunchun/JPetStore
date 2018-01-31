<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp"%>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("input:eq(1)").bind({
			focus:function(){
			
				$("#password").css("display","inline");
				$("#password").html("输入密码");
			},
			blur:function(){
			
				if($(this).val() == ""){
					$("#password").html("密码不能为空");
					$("#password").css("color","red");
				}else{
					$("#password").css("display","none");
				}
			}
		
		
		})
		$("#accountTable input:eq(2)").bind({
			focus:function(){
			
				$("#passwordcommit").css("display","inline");
				$("#passwordcommit").html("请重复密码");
			},
			blur:function(){
			
				if($(this).val() == ""){
					$("#passwordcommit").html("密码不能为空");
					$("#passwordcommit").css("color","red");
				}else if($("#accountTable input:eq(1)").val() != $("#accountTable input:eq(2)").val()){
					$("#passwordcommit").html("密码不一样，请重新输入");
					$("#passwordcommit").css("color","red");
				}else{
					$("#passwordcommit").css("display","none");
				}
			}
		
		
		})

		$("#submitBtn").click(
				function() {

					var param = "signon.userid=" + $(":disabled").val() + "&"
							+ $("#updatePassword").serialize();
					console.log(param);
					$.ajax({
						url : "updatePasswordAction",
						data : param,
						dataType:"json",
						type : "GET",
						success : function(data) {
							console.log(data);
							if(data.updatePasswordRresult>0){
							alert("修改密码成功！");
							location.href = "account/SignonForm.jsp";
							}
						},
						error : function() {
							alert("修改密码失败！");
						}
					});

				})

	})
</script>
<div id="Catalog">
	<form id="updatePassword" action="updatePasswordAction">

		<p>请输入您的新密码.</p>
		<p>
			用&nbsp;户名:<input type="text" value="${param.userid }"
				name="signon.userid" disabled="disabled" /> <br> 新&nbsp;密码:<input
				type="text" value="" name="signon.password" /><span id="password"></span>  <br /> 确认密码:<input
				type="text" value="" />&nbsp;&nbsp;
		</p>
		<input type="button" id="submitBtn" name="submit" value="提交" />
	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
