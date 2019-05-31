package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Good;
import com.model.Cart;
import com.service.BusinessService;

//完成书籍购买
//完成书籍购买
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

 String id = request.getParameter("id");//获得id
 BusinessService service = new BusinessService();
 Good good = service.findGood(id);//找到商品的id
 
 //得到用户的购物车
 Cart cart = (Cart) request.getSession().getAttribute("cart");
 if(cart==null){
  cart = new Cart();
  request.getSession().setAttribute("cart", cart);
 }
 
 //把书加到用户购物车中,完成购买
 cart.add(good);
 
 request.getRequestDispatcher("/listcart.jsp").forward(request, response);
 
 }

 public void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
 doGet(request, response);
 }

} 