package com.binhk.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binhk.dao.Restaurant;
import com.binhk.model.RestautantVO;

	
	@WebServlet("/UpdateMyReview")
	public class UpdateMyReview extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public UpdateMyReview() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "WEB-INF/views/updatermyeview.jsp";
			
			try {
				String getmembernum = request.getParameter("membernum");
				int num = Integer.parseInt(request.getParameter("num"));
				RestautantVO pvo = new Restaurant().anothermyreview(getmembernum, num);
				
				request.setAttribute("update", pvo);
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
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			int star = Integer.parseInt(request.getParameter("star"));
			String review = request.getParameter("review");
			String address = request.getParameter("address");
			int num = Integer.parseInt(request.getParameter("num"));
			String getmembernum = request.getParameter("membernum");
			
			RestautantVO pvo = new RestautantVO();
			
			pvo.setStar(star);
			pvo.setReview(review);
			
			
			new Restaurant().updatemyreview(pvo, num, getmembernum);
			
			response.sendRedirect("/MyReview?membernum="+getmembernum);
		}


}
