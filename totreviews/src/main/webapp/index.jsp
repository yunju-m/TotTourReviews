<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.Timestamp"%>
<%@page import="totreviews.domain.MemberVO" %>
<%
    // 예제 값
    String memid = "user001";
    String member_001 = "m01";
    String member_002 = "tt01";
    String member_003 = "intj";
    String memnick = "회원";
    Timestamp memregdate = new Timestamp(System.currentTimeMillis()); // 현재 시간
    String ttimg = "/static/image/userDefaultImg.jpg";
    
    // MemberVO 객체 생성
    MemberVO member = new MemberVO(memid, member_001, member_002, memnick, memregdate, ttimg);
    
    // 세션에 member 객체 저장
    session.setAttribute("member", member);
    
    // 세션 저장 성공 메시지
    out.println("세션에 회원 정보가 저장되었습니다.");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>Main화면</h1>
</body>
</html>
