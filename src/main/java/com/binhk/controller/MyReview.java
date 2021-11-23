package com.binhk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binhk.dao.Restaurant;
import com.binhk.model.MemberVO;
import com.binhk.model.RestautantVO;

@WebServlet("/MyReview")
public class MyReview extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "WEB-INF/views/myreview.jsp";
		String getmembernum = request.getParameter("membernum");
		
		try {			
			new Restaurant().myreview(getmembernum);
			ArrayList<RestautantVO> pvo = new Restaurant().myreview(getmembernum);
			request.setAttribute("list", pvo);
			
		} catch (Exception e) {
			url = "errorPage500.jsp";
		}
		RequestDispatcher dispatcher
			= request.getRequestDispatcher(url);
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
