<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<bean:define id="product" name="catalogBean" property="product"/>
<bean:define id="item" name="catalogBean" property="item"/>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("table tr td a").click(function(){
					
					var param ="item.itemid=<s:property value='item.itemid'/>" + 
					"&signon.userid=<%=session.getAttribute("userid") %>";
				
					$.ajax({
						url:"saveShoppingAction",
						data:param,
						dataType:"json",
						type:"POST",
						success:function(data){
							if(data>0){
								alert("添加购物车成功!");
							}else{alert("库存不足，请选购其他商品！");}
						
						},
						error:function(){
							alert("添加购物车失败!");
						}
				});
	
				<%-- location.href="saveShoppingAction?item.itemid=<s:property value='item.itemid'/>" + 
							"&signon.userid=<%=session.getAttribute("userid") %>"; --%>
			
			})
			$("#aaa").html("<s:property value='item.product.descn'/>");
			$("#imagespan").html($("#aaa").text());
		})
		
	</script>

<div id="Catalog">
<div id="BackLink">
 <a href="queryItemAction?product.productid=<s:property value="item.product.productid"/>">
    <s:property value="item.product.name"/></a> 
</div>
<br><br><br><br>
<table id="itemTable">
    <tr><th>商品种类</th> <th>商品编号</th>  <th>产品编号</th>  <th>产品名</th>  
    <th>产品描述</th>  <th>库存量</th> <th>定价</th>  <th>加入购物车</th></tr>
		    	<tr>
		    		<td>
				      	<span id="aaa" style="display:none"></span>
				     	<span id="imagespan"></span> 				     	
			      	</td>
		    		<td>		
				        <b><s:property value="item.itemid"/></b>
				    </td>		    		
					 <td>				
					      <s:property value="item.product.productid"/>
					 </td>		
					  <td>
					    <s:property value="item.product.name"/>
					 </td>			 
					 <td>
					     <b><font size="4">
					     <s:property value="item.attr1"/>
					     </font></b>
					</td>
		    		 <td>
					       <s:property value="qty"/>					    
					 </td>
					 <td>
						    ￥<s:property value="item.listprice"/>
					 </td>
					  <td>
						      <a class="Button" href="javascript:void(0)">
						       添加到购物车</a>
					  </td>
		    	</tr>    		
    	
  </table>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>



