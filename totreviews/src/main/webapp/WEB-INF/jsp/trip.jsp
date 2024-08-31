<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width='device-width', initial-scale=1.0">
   	<script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=자바스크립트 인증키"></script>
    <script defer src="${pageContext.request.contextPath}/resources/js/trip.js"></script>
    <title>여행코스경로</title>
</head>
<body>
    <div class="container">
        <h1>여행 경로 표시 Map</h1>
        <div id="map" style="width:500px;height:400px;"></div>
        <div id="clickLatlng"></div>
    </div>
</body>
</html>