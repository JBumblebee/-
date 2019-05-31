package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Cart;
import com.service.BusinessService;
//删除指定的购物项
@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

 String id = request.getParameter("id");
 Cart cart = (Cart) request.getSession().getAttribute("cart");
 
 
 BusinessService service = new BusinessService();
 service.deleteCartItem(id,cart);
 //System.out.print("删除成功"+id);
 //删除成功
 request.getRequestDispatcher("/listcart.jsp").forward(request, response);
 
 }

 public void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
 doGet(request, response);
 }

}