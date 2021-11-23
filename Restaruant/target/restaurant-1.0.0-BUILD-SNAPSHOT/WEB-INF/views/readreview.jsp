<%@page import="com.binhk.model.RestautantVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- <%@ page session="false" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" rel='stylesheet' href=<c:url value="/resources/css/readreview.css"/>/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>Document</title>
    </head>
    <body>
    <input type="hidden" name="memberNum" value="${memberNum}"/>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">선택</th>
                    <th scope="col">별점</th>
                    <th scope="col">상호명</th>
                    <th scope="col">주소명</th>
                    <th scope="col">리뷰</th>
                </tr>
            </thead>
            <tbody>
                <%
                ArrayList<RestautantVO> al = (ArrayList)request.getAttribute("list");
                Iterator<RestautantVO> it = al.iterator();

                while(it.hasNext()) {
                	RestautantVO pvo = it.next();
            %>
                    <tr>
                        <th scope="row"><input type="radio" id="radio" value='<%=pvo.getNum() %>'/></th>
                        <td><%=pvo.getStar() %></td>
                        <td><%=pvo.getName() %></td>
                        <td><%=pvo.getAddress() %></td>
                        <td><%=pvo.getReview()%></td>
                    </tr>
                <%
                }
            %>
            </tbody>
        </table>
        <div class="button">
            <button type="submit" class="btn btn-primary" onclick="changereview(store_address)">리뷰수정</button>
            <button type="submit" class="btn btn-primary" onclick="deletereview()">리뷰삭제</button>
        </div>
        
        <script>
        	let store_address = '<%=request.getParameter("address")%>'
	       	  function changereview(){
        		var checkLogin = "${memberNum}"
                var input_number = $("input[id='radio']:checked").val();
                if(input_number == null){
                    alert('수정할 리뷰를 선택해주세요.')
                } else{
	       		  let url = "/UpdateReview?address="+store_address+'&num='+input_number+'&membernum='+checkLogin
	       	      let name = "팝업";
	       	      let option = "width = 800px, height=400px, top=400px, left=300px, scrollbars=no";
	       	      window.open(url, name, option) 
                }
	       	  }
	
	       	  function deletereview(){
	       		var checkLogin = "${memberNum}"
                var input_number = $("input[id='radio']:checked").val();

                if(input_number == null){
                    alert('삭제할 리뷰를 선택해주세요.')
                } else {
                    confirm("정말로 삭제하시겠습니까?")
                    {
                        location.href='DeleteReview?address='+store_address+'&num='+input_number+'&membernum='+checkLogin;
                    }
                }
	       	  }
        
        </script>

    </body>
</html>