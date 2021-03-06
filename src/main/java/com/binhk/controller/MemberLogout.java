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
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

@WebServlet("/MemberLogout")
public class MemberLogout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session(session, request);
		out.println("<script>");
		out.println("var localName = location.search");
		out.println("function getParameterByName(name) "
				+ "{ name = name.replace(/[\\[]/, \"\\\\[\").replace(/[\\]]/, \"\\\\]\"); "
				+ "var regex = new RegExp(\"[\\\\?&]\" + name + \"=([^&#]*)\"), "
				+ "results = regex.exec(location.search); "
				+ "return results == null ? \"\" : decodeURIComponent(results[1].replace(/\\+/g, \" \")); }");
		out.println("var test = getParameterByName('localName')");
		out.println("console.log(test)");
		out.println("alert('로그아웃이 완료 되었습니다.');");
		out.println("location.replace('/Map?localName='+test)");
		out.println("</script>");
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
	}
	
	public String session (HttpSession session, HttpServletRequest request) {
		session.invalidate();
		return "map";
	}
	
}
