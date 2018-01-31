<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
				
				var param = "signon.userid=<%=session.getAttribute("userid") %>";
				console.log(param);
				
			$.ajax({
					url:"queryBannerdataAction",
					data:param,
					dataType:"json",
					type:"POST",
					success:function(data){	
					if(data.bannerdata!=null){
					if(data.bannerdata.bannername != null){	
						console.log(data.bannerdata.bannername);
						console.log(typeof(data.bannerdata.bannername));
						$("#Banner").append(data.bannerdata.bannername);						
					}
					}
				},
				error:function(){	
				}

			}) 
		
		})
	
	</script>


<html>

<body>

<div id="Footer">

  <div id="PoweredBy">
    <a href="http://ibatis.apache.org"><img src="./images/poweredby.gif"/></a>
  </div>

  <div id="Banner">
  
  </div>

</div>

</body>
</html>