package com.binhk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.binhk.dao.Restaurant;
import com.binhk.model.MemberVO;
import com.binhk.model.RestautantVO;

@WebServlet("/MemberJoin")
public class MemberJoin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response, Model model)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("WEB-INF/views/memberjoin.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
				
		String member_id = request.getParameter("memberId");
		String member_pw = request.getParameter("memberPw");
		String member_name = request.getParameter("memberName");
		String member_phone = request.getParameter("memberPhone");
		
				
		MemberVO pvo = new MemberVO();
		pvo.setMemberId(member_id);
		pvo.setMemberPw(member_pw);
		pvo.setMemberName(member_name);
		pvo.setMemberPhone(member_phone);
		
		new Restaurant().memberjoin(pvo);
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('회원가입이 완료 되었습니다.');window.open('about:blank','_self').self.close();</script>");
		out.flush();
		
		/* response.sendRedirect("/"); */
	}
	
	
	

}
