<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 <title>书籍列表页面</title>
 </head>
 
 <body style="text-align: center">
 
 <h1>商品列表</h1>
 
 <table width="70%" border="1">
 <tr>
  <td>商品号</td>
  <td>商品名</td>
  <td>图片</td>
  <td>出产地</td>
  <td>售价</td>
  <td>描述 </td>
  <td>操作</td>
 </tr>
 
 <c:forEach var="entry" items="${map}">
  <tr>
  <td>${entry.value.id }</td>
  <td>${entry.value.name}</td>
  <td><img src="img/${entry.value.img}" alt="此处为照片"  width="80px" height="80px" /></td>
  <td>${entry.value.author }</td>
  <td>${entry.value.price }</td>
  <td>${entry.value.description } </td>
  <td>
   <a href="${pageContext.request.contextPath }/BuyServlet?id=${entry.value.id }">加入购物车</a>
  </td>
  </tr>
 </c:forEach>
 </table>
 
</body>
</html>