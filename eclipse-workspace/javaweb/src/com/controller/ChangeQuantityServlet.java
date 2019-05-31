package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Cart;
import com.service.BusinessService;

//把购物车中的书修改为指定数量
@WebServlet("/ChangeQuantityServlet")
public class ChangeQuantityServlet extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

 String id = request.getParameter("id");
 String quantity = request.getParameter("quantity");
 
 Cart cart = (Cart) request.getSession().getAttribute("cart");
 
 BusinessService service = new BusinessService();
 service.changeItemQuantity(id,quantity,cart);
 

 request.getRequestDispatcher("/listcart.jsp").forward(request, response);
 }

 public void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
 doGet(request, response);
 }

}