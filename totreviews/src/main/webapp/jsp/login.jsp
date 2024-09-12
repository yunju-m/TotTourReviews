<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="totreviews.domain.MemberVO"%>
<%
	MemberVO member = new MemberVO("user123", "M01", "TT01", "member", 
			new Timestamp(System.currentTimeMillis()), "");
	
	session.setAttribute("member", member);
	
	out.print("회원 정보 저장완료");
%>