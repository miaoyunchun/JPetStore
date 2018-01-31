<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	$(function(){
		
		$("#submitBtn").click(function(){
			
			var param = $("#forgetPassword").serialize();
			console.log(param);
			$.ajax({
				url:"forgetPasswordAction",
				data:param,
				dataType:"json",
				type:"POST",
				success:function(data){
					if(data.forgetPasswordResult > 0 ){
						location.href="account/UpdatePassword.jsp?userid="+data.signon.userid;
					}else{
						alert("用户名或者邮箱不正确！");
					}
					
				},
				error:function(){
				
				}
		});
		
		
		})
	
	})
	
	</script>
<div id="Catalog">
 <form id="forgetPassword" action="" method="post">

    <p>请输入您的用户名和邮箱.</p>
    <p>
      用户名:<input type="text" value="" name="signon.userid"/>
      <br/> 
     邮&nbsp; &nbsp;&nbsp;箱:<input type="email" value="" name="account.email"/>&nbsp;&nbsp;
    </p>
    <input type="button" id="submitBtn"  name="submit" value="验证"/>
  </form>
  </div>


<%@ include file="../common/IncludeBottom.jsp" %>
