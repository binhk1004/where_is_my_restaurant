package com.binhk.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.binhk.dao.Restaurant;
import com.binhk.model.RestautantVO;

@WebServlet("/CreateReview")
public class CreateReview extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response, Model model)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("WEB-INF/views/createreview.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
				
		int star = Integer.parseInt(request.getParameter("star"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String review = request.getParameter("review");
		int memberNum = Integer.parseInt(request.getParameter("memberNum"));
				
		RestautantVO pvo = new RestautantVO();
		pvo.setStar(star);
		pvo.setName(name);
		pvo.setAddress(address);
		pvo.setReview(review);
		pvo.setMemberNum(memberNum);
		
		
		new Restaurant().create(pvo);
		
		response.sendRedirect("/ReadReview?address="+ URLEncoder.encode(address,"UTF-8")+"&membernum="+pvo.getMemberNum());
	}
	
	
	

}
