package com.binhk.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.ui.Model;

import com.binhk.dao.Restaurant;
import com.binhk.model.MemberVO;

@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		MemberVO pvo = new MemberVO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response, Model model)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher
			= request.getRequestDispatcher("WEB-INF/views/memberlogin.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
				
		HttpSession session = request.getSession();
		pvo.setMemberId(member_id);
		pvo.setMemberPw(member_pw);
		
		int result = new Restaurant().memberlogin(pvo);
		
		if(result == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 완료 되었습니다.');window.open('about:blank','_self').self.close();opener.document.location.reload();</script>");
			out.flush();
			memberSession(session, request, pvo);
		}
		else if(result ==5) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자로 로그인 되었습니다.');window.open('about:blank','_self').self.close();opener.document.location.reload();</script>");
			out.flush();
			adminSession(session, request, pvo);
			
		}
		else if(result == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디 혹은 비밀번호가 틀립니다.');history.back()</script>");
			out.flush();	
		}
		else if(result == -1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('존재하지 않는 계정입니다.');history.back()</script>");
			out.flush();	
		}
		
	}
	
	public String adminSession (HttpSession session, HttpServletRequest request, MemberVO pvo) {
		HttpSession Session = request.getSession(true);
		session.setAttribute("memberNum", pvo.getMemberNum());
		return "map";
	}
	
	public String memberSession (HttpSession session, HttpServletRequest request, MemberVO pvo) {
		HttpSession Session = request.getSession(true);
		session.setAttribute("memberNum", pvo.getMemberNum());
		return "map";
	}
}
