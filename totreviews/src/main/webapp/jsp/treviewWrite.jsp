<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/global.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/review.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/treview.js"></script>
    <title>여행 후기 작성</title>
</head>
<body>
    <div class="mainDiv">
        <div class="reviewTitleDiv">
            <div class="bigTitle">여행 후기 작성</div>
        </div>
        <div class="reviewIntroDiv">
            <div>나의 여행 후기글을 작성해보세요!</div>
        </div>
        <!-- 여행 후기 작섬 폼 -->
        <div class="reviewForm">
            <form id="reviewForm" action="${pageContext.request.contextPath}/review/all/write" method="post"
                enctype="multipart/form-data">
                
                <input type="hidden" name="memid" value="${sessionScope.member.memid}" />
                
                <!-- 1. 여행 후기 제목 입력 -->
                <div class="formGroup">
                    <label for="reviewTitle">제목</label>
                    <input id="reviewTitle" type="text" class="titleInput" name="trevtitle">
                </div>
                <!-- 2. 여행 코스 선택 -->
                <div class="formGroup">
                    <label for="travelCourse">여행 코스</label>
                    <select id="travelCourse" class="courseSelect" name="trevcourse">
                        <option value="" disabled selected>여행 코스를 선택하세요</option>
                        <c:forEach var="course" items="${courses}">
                            <c:set var="courseDetails" value="" />
                            <c:forEach var="detail" items="${course.courseDetail}">
                                <c:if test="${not empty courseDetails}">
                                    <c:set var="courseDetails" value="${courseDetails} → ${detail.dname}" />
                                </c:if>
                                <c:if test="${empty courseDetails}">
                                    <c:set var="courseDetails" value="${detail.dname}" />
                                </c:if>
                            </c:forEach>
                            <option value="${course.courseid}">
                                ${courseDetails}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <!-- 3. 여행 후기 내용 입력 -->
                <div class="reviewContentDiv">
                    <label for="reviewContent">후기 내용</label>
                    <div id="reviewContentAndImgDiv" class="reviewContentAndImgDiv">
                        <input class="reviewContent" name="trevcontent" />
                    </div>
                </div>
                <!-- 4. 이미지 파일 업로드 -->
                <div class="formGroup">
                    <label for="reviewImage">이미지 업로드</label>
                    <div class="reviewImageDiv">
                        <input id="reviewImage" type="file" name="image" multiple />
                    </div>
                </div>
                <!-- 5. 이용 약관 동의 -->
                <div class="formGroup">
                    <fieldset class="termsFieldset">
                        <legend>개인정보 수집 및 이용 동의</legend>
                        <label>
                            <input type="radio" name="trevAgree" value="agree" class="termsRadio" id="agreeRadio">
                            동의함
                        </label>
                        <label>
                            <input type="radio" name="trevAgree" value="disagree" class="termsRadio" id="disagreeRadio">
                            동의하지 않음
                        </label>
                    </fieldset>
                </div>
                <!-- 버튼 -->
                <div class="formGroup">
                    <div class="submitAndCancleBtnDiv">
                        <button id="submitButton" type="button" class="initButton active">글 작성하기</button>
                        <button id="cancleButton" type="button" class="initButton">취소하기</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- 여행 후기 작섬 폼 END -->
    </div>
</body>
</html>