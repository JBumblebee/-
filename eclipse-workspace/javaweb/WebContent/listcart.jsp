<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车列表</title>
<script type="text/javascript">

function changeQuantity(input,id,oldvalue){
	  var quantity = input.value; //得到要修改的数量 
	  
	  
	  //检查用户输入的数量是不是一个正整数
	  if(quantity<0 || quantity!=parseInt(quantity)){
	  alert("请输入正整数！！");
	  input.value = oldvalue;
	  return;
	  }  
	  
	  var b = window.confirm("您确认把书的数量修改为:" + quantity);
	  if(b){
	  window.location.href="${pageContext.request.contextPath}/ChangeQuantityServlet?id=" rel="external nofollow" + id + "&quantity=" + quantity;
	  }
	 }
</script>
</head>
<body style="text-align: center">

 <h1>购物车列表</h1>
  <c:if test="${empty(cart.map)}"> 
 您没有购买任何商品！！！
 </br>
 <a href="${pageContext.request.contextPath}/ListGoodsServlet">继续购物</a>
 </c:if> 

 
 <c:if test="${!empty(cart.map)}"> 
 <table width="70%" border="1">
 <tr>
  <td>商品名</td>
  <td>出产地</td>
  <td>单价</td>
  <td>数量 </td>
  <td>小计</td>
  <td>操作</td>
 </tr>
 <c:forEach var="entry" items="${cart.map}">
  <tr>
  <td>${entry.value.book.name }</td>
  <td>${entry.value.book.author }</td>
  <td>${entry.value.book.price }</td>
  <td>
  
  <input type="text" name="quantity" value="${entry.value.quantity }" style="width:35px" onchange="changeQuantity(this,${entry.key},${entry.value.quantity})">
  
  </td>
  <td>${entry.value.price }</td>
  <td>
   <a href="${pageContext.request.contextPath }/DeleteItemServlet?id=${entry.value.book.id }">删除</a> 

   
  </td>
  </tr>
 </c:forEach>
 
 <tr>
  <td colspan="3">总价</td>
  <td colspan="2">${cart.price }元</td>
  <td colspan="1">
  <a href="${pageContext.request.contextPath}/ClearCartServlet">清空购物车</a>
  </td>
 </tr>
 </table>
  <a href="${pageContext.request.contextPath}/ListGoodsServlet">继续购物</a>
 </c:if>

</body>
</html>