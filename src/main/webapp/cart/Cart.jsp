
<%@ page language="java" import="java.util.*,com.clps.demo.domain.*,java.lang.Integer" pageEncoding="UTF-8"%>


<%@ include file="../common/IncludeTop.jsp" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">

	$(function(){	
		//未登录用户修改数量
		var number=0;
		$(".textview").bind({
			
			focus:function(){
				console.log($(this).parent().parent().children().children().first().html());
				console.log($(this).val());
				number=$(this).val();
			},
			blur:function(){
				var textview=$(this);
				var itemid=$(this).parent().parent().children().children().first().html();
				var param = "item.itemid=" +itemid + "&item.count=" + $(this).val() + "&signon.userid=null";
				console.log(param);
				var count = $(this).val();
				var price = $(this).parent().parent().children().eq(5).html();
				
				$(this).parent().parent().children().eq(6).html((price * count).toFixed(2));
				//判断是否为正整数 
				var r = /^\+?[0-9][0-9]*$/;
			    if(!r.test(count)){
			    	  alert("请输入0-9的数字！");
			    	  textview.val(number);
					  textview.parent().parent().children().eq(6).html((number*price).toFixed(2));
					  return;
			     }
				
				if(count==0){
					var param = "item.itemid=" + itemid+ "&signon.userid=null";
					
					$.ajax({
						url:"deleteShoppingAction",
						data:param,
						type:"GET",
						dataType:"json",
						success:function(data){
							
							if(data==1){
								location.href ="queryShoppingAction?signon.userid=null";	
							}
					
						},
						error:function(){
							alert("出现未知错误！");
						}
					})
					return;
					/* location.href = "deleteShoppingAction?item.itemid=" +itemid + "&signon.userid=null"; */
					
				}
				$.ajax({
					url:"saveCountAction",
					data:param,
					type:"GET",
					dataType:"json",
					success:function(data){
						
						if(data.qtyResult==0.0){
							alert("商品 :"+itemid+"  库存不足！");
							textview.val(number);
							
							textview.parent().parent().children().eq(6).html((number*price).toFixed(2));
							/* var param2 = "item.itemid=" +itemid + "&item.count="+textview.val(count)+
							"&signon.userid=null";				
							console.log(param2);
							textview.parent().parent().children().eq(6).html(price);
							   $.ajax({
								url:"saveCountAction",
								data:param2,
								type:"GET",
								dataType:"json",
								success:function(data){
									if(data==0){
										alert("商品 :"+itemid+"  已经售完！");
										location.href = "deleteShoppingAction?item.itemid=" 
									+ itemid + "&signon.userid=null";
										
									}		
								},
							
							})  */
						}
						if(data.qtyResult==1.0){
							 $("#maxprice").html(data.total);
						}
						
					},
					error:function(){
						alert("出现未知错误！");
					
					}
				})
			}
		
		});
		
		//登录用户修改数量
		var number2=0;
		$(".textviewtwo").bind({
			
			focus:function(){
				console.log($(this).parent().parent().children().children().first().html());
				console.log($(this).val());
				number2=$(this).val();
			},
			blur:function(){
				var textviewtwo=$(this);
				var itemid=$(this).parent().parent().children().children().first().html();
				var param = "item.itemid=" + itemid + "&item.count=" + $(this).val() + "&signon.userid=" + "${userid }" + 
							"&item.listprice=" + $(this).parent().parent().children().eq(5).html();
				console.log(param);
				var count = $(this).val();
				var price = $(this).parent().parent().children().eq(5).html();
				$(this).parent().parent().children().eq(6).html((price * count).toFixed(2));
				//判断是否为正整数 
				var r = /^\+?[0-9][0-9]*$/;
			      if(!r.test(count)){
			    	  alert("请输入0-9的数字！");
			    	  textviewtwo.val(number2);
						textviewtwo.parent().parent().children().eq(6).html((number2*price).toFixed(2));
						return;
			      }
				
				if(count==0){
					var msg = "您确定要删除商品："+$(this).parent().parent().children().children().first().html(); 
					 if (confirm(msg)==true){ 
					/* alert($(this).parent().parent().children().children().first().html()); */
					 var param = "item.itemid=" + $(this).parent().parent().children().children().first().html() 
						+ "&signon.userid="+ "${userid }";
					$.ajax({
						url:"deleteShoppingAction",
						data:param,
						type:"GET",
						dataType:"json",
						success:function(data){
							
							if(data==1){
								location.href ="queryShoppingAction?signon.userid="+ "${userid }";	
							}
					
						},
						error:function(){
							alert("出现未知错误！");
						}
					})
					/* location.href = "deleteShoppingAction?signon.userid=" + "${userid }"+ "&item.itemid=" + $(this).parent().parent().children().children().first().html();
					 */
					 
					/* var msg = "您确定要删除商品："+ itemid; 
					 if (confirm(msg)==true){ 
					location.href = "deleteShoppingAction?signon.userid=" + "${userid }"+ "&item.itemid=" + itemid; */
					 }
				}
				$.ajax({
					url:"saveCountAction",
					data:param,
					type:"GET",
					dataType:"json",
					success:function(data){
						if(data.qtyResult==0){
							alert("商品 :"+itemid+"  库存不足！");
							textviewtwo.val(number2);
							textviewtwo.parent().parent().children().eq(6).html((number2*price).toFixed(2));
							/* var param2 =  "item.itemid=" + itemid + "&item.count=1&signon.userid=" + "${userid }" + 
							"&item.listprice=" +textviewtwo.parent().parent().children().eq(5).html();		
							console.log(param2);
							textviewtwo.parent().parent().children().eq(6).html(price);
							$.ajax({
								url:"saveCountAction",
								data:param2,
								type:"GET",
								dataType:"json",
								success:function(data){
									if(data==0){
										alert("商品 :"+itemid+"  已经售完！");
										location.href = "deleteShoppingAction?item.itemid=" 
									+ itemid + "&signon.userid="+"${userid }";
										
									}		
								},
							
							}) */
						}
						if(data.qtyResult==1.0){
							 $("#maxprice").html(data.total);
						}
					},
					error:function(){
						alert("出现未知错误！");
					}
				})
				
				/* var sumprice = $(this).parent().parent().children().eq(6).html(); */
			}
		
		});
		
		/*删除未登录用户商品  */
		$(".btnOne").click(function(){
			
			var param = "item.itemid=" + $(this).parent().parent().children().children().first().html() 
						+ "&signon.userid=null";
			$.ajax({
				url:"deleteShoppingAction",
				data:param,
				type:"GET",
				dataType:"json",
				success:function(data){
					
					if(data==1){
						location.href ="queryShoppingAction?signon.userid=null";	
					}
			
				},
				error:function(){
					alert("出现未知错误！");
				}
			})
			
		});
		
		/*删除登录用户商品  */
		$(".btnTwo").click(function(){
			var msg = "您确定要删除商品："+$(this).parent().parent().children().children().first().html(); 
			 if (confirm(msg)==true){ 
			/* alert($(this).parent().parent().children().children().first().html()); */
			 var param = "item.itemid=" + $(this).parent().parent().children().children().first().html() 
				+ "&signon.userid="+ "${userid }";
			$.ajax({
				url:"deleteShoppingAction",
				data:param,
				type:"GET",
				dataType:"json",
				success:function(data){
					
					if(data==1){
						location.href ="queryShoppingAction?signon.userid="+ "${userid }";	
					}
			
				},
				error:function(){
					alert("出现未知错误！");
				}
			})
			/* location.href = "deleteShoppingAction?signon.userid=" + "${userid }"+ "&item.itemid=" + $(this).parent().parent().children().children().first().html();
			 */
			 }
			
			 
			 });

		/*进入页面时查询总价  */
		$(".sumprice").each(function(){
				var price = $(this).parent().parent().children().eq(5).html();
				var sumprice = $(this).parent().parent().children().eq(6).html();
				var count = $(this).parent().parent().children().eq(4).children().val();
				$(this).html((price * count).toFixed(2));
				var countPirce = parseInt($(this).html());		
		})		
		$(".sumpriceTwo").each(function(){
				var price = $(this).parent().parent().children().eq(5).html();
				var sumprice = $(this).parent().parent().children().eq(6).html();
				var count = $(this).parent().parent().children().eq(4).children().val();
				$(this).html((price * count).toFixed(2));
				var countPirce = parseInt($(this).html());
	
		})

		/* 链接  */
		$("table tr td a.item").click(function(){
				location.href="queryQtyAction?item.itemid=" + $(this).html();
			
		});
		
		
		$("#buy").click(function(){
			 if("${userid }" == ""||"${userid }" ==null||"null"=="${userid }"){
			 	location.href="account/SignonForm.jsp";
			 }else{
				 location.href="queryShoppingTwoAction?signon.userid=" + "${userid }"; 
				/*  var param = "signon.userid=" + "${userid }";
				$.ajax({
					url:"queryShoppingTwoAction",
					data:param,
					type:"GET",
					dataType:"json",
					success:function(data){
						alert(data);
						if(data!=null){
							alert(data.warn);
						}
						else{
							location.href="cart/Checkout.jsp";
						}

					},
					error:function(){
						alert("出现未知错误！");
					}
				}) */
			}
		})
		
		if("${profile.mylistopt}" == 0){
			$("#MyList").css("display","none");
		
		}
		
	});
	
	
</script>


<div id="Catalog">
<div id="BackLink" >
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>
  <div id="Cart">
    <h2>购物车</h2>
    <form  method="post">
      <table id="shopping">
        <tr>
          <th><b>商品编号</b></th>  <th><b>产品编号</b></th>  <th><b>产品描述</b></th> <th><b>存货数</b></th>
          <th><b>产品数量</b></th>  <th><b>单价</b></th> <th><b>商品总价</b></th>  <th>&nbsp;</th>
        </tr>
        <%
        if(session.getAttribute("userid")==null||session.getAttribute("userid")==""
        ||"null".equals(session.getAttribute("userid"))){
		%>
		  <s:iterator value="itemMap" var="item">
	    	<tr>
	            <td><a class="item"><s:property value="value.itemid"/></a></td>
	            <td><s:property value="value.product.productid"/></td>
		        <td><s:property value="value.attr1"/></td>
		        <td>有</td>
              	<td><input type="text" class="textview" name="inStock" size="5"
              	 value="<s:property value="value.count"/>"/> </td>
	            <td><s:property value="value.listprice"/></td>
	            <td>$<span class="sumprice"></span></td>
	            <td><a  class="btnOne" href="javascript:void(0)">
	              取消</a></td>
	    		
	    	</tr>  		
    	</s:iterator>
		<%
        }
		else{	
        %>  
        <s:iterator value="listcart" var="cart">
		    	<tr>		    	
		            <td><a class="item"><s:property value="#cart.item.itemid"/></a></td>
		            <td><s:property value="#cart.item.product.productid"/></td>
		            <td><s:property value="#cart.item.attr1"/></td>
		            <td><span class="qty">有</span></td>
		            <td><input type="text" name="inStock" class="textviewtwo" size="5" value="<s:property value="#cart.quantity"/>"/> </td>
		            <td><s:property value="#cart.item.listprice"/> 	</td>
		            <td>$<span class="sumpriceTwo"></span></td>
		            <td><a class="btnTwo" href="javascript:void(0)">取消</a></td>
		    	</tr>
    		
    	</s:iterator>
       
       <%
       }
		%>
        
       
        <tr>
          <td colspan="7">
         <p style="color:red;font-weight:bold"> 总金额:&nbsp;&nbsp;&nbsp;$&nbsp;<span id="maxprice"><s:property value="total"/></span></p> 
          <!--   <input type="submit" name="update" value="更新购物车" class="Button" /> -->

          </td>
          <td>&nbsp;</td>
        </tr>
      </table>
      
          
       <%--  <a class="Button" href="queryShoppingAction?begin=${begin-1 }&signon.userid=${userid }">&lt;&lt; 上一页</a>
      
      
        <a class="Button" href="queryShoppingAction?begin=${begin+1 }&signon.userid=${userid }">下一页 &gt;&gt;</a>
 --%>

    </form>

  <a class="Button" id="buy" href="javascript:void(0)" >付款</a>


  </div>
    <div id="MyList" style="margin-top:10px;">
    <%@ include file="IncludeMyList.jsp" %>
    </div>
  <div id="Separator">&nbsp;</div>

</div>



<%@ include file="../common/IncludeBottom.jsp" %>



