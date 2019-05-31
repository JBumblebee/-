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
//清空购物车
@WebServlet("/ClearCartServlet")
public class ClearCartServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

 Cart cart = (Cart) request.getSession().getAttribute("cart");
 
 BusinessService service = new BusinessService();
 service.clearCart(cart);
 
 request.getRequestDispatcher("/listcart.jsp").forward(request, response);
 
 }

 public void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
 doGet(request, response);
 }

}