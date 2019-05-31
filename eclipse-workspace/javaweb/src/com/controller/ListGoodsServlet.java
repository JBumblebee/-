package com.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BusinessService;
//获取所有书籍


@WebServlet("/ListGoodsServlet")
public class ListGoodsServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		
    	try {
    		 BusinessService service = new BusinessService();
    		 Map map = service.getAllGood();
    		 request.setAttribute("map", map);
    		 //System.out.print(map.keySet());
    		 request.getRequestDispatcher("/listGoods.jsp").forward(request, response);
    		 return;
    		 
    	}catch(Exception e){
    		request.setAttribute("message", "请求失败！");
    		System.out.print("请求失败");
    		request.getRequestDispatcher("/error.jsp").forward(request, response);
    		return;
    	}
 
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}