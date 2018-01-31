<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("table tr td a").click(function(){
			if($(this).html() == "添加到购物车"){
				var param ="item.itemid=" + $(this).parent().parent().children().children().first().html() + 
					"&signon.userid=<%=session.getAttribute("userid") %>";
			
				$.ajax({
					url:"saveShoppingAction",
					data:param,
					dataType:"json",
					type:"POST",
					success:function(data){
						if(data>0){
							alert("添加购物车成功!");
						}else{
							
							alert("库存不足，请选购其他商品！");}
					
					},
					error:function(){
						alert("添加购物车失败!");
					}
			});
		
				<%-- location.href="saveShoppingAction?item.itemid=" + $(this).parent().parent().children().children().first().html() + 
				"&signon.userid=<%=session.getAttribute("userid") %>"; --%>
		
			}else{
				location.href="queryQtyAction?item.itemid=" + $(this).html();
			}			
		})
	});
	
</script>

<div id="Catalog">
<div id="BackLink">

 <%--  <a href="<%=basePath %>catalog/Category/<s:property value='product.name'/>"> --%>
  <a href="<%=basePath %>categoryAction?category.catid=<s:property value='itemlist[0].product.category.catid'/>">
 
  <s:property value="itemlist[0].product.category.catid"/> </a>

</div>
  <h2><s:property value="product.productid"/></h2>

  <table>
    <tr><th>商品编号</th>  <th>产品编号</th>  <th>产品描述</th>  <th>定价</th>  <th>&nbsp;</th></tr>
   
    
      
       <s:iterator value="itemlist" var="item">
		    	<tr>
		    		<td><a><s:property value="#item.itemid"/></a></td>
		    		<td><s:property value="#item.product.productid"/></td>
		    		<td><s:property value="#item.attr1"/></td>
		    		<td>$<s:property value="#item.listprice"/></td>
		    		<td><a  class="Button">添加到购物车</a></td>    		
		    	</tr>    		
    	</s:iterator>
  </table>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>





