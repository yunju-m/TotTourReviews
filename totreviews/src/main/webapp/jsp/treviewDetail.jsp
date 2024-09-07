<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/global.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/review.css" />
    <title>여행 후기 상세</title>
</head>
<body>
    <div class="mainDiv">
        <div class="reviewTitleDiv">
            <div class="bigTitle">${review.trevtitle}</div>
        </div>
        <div class="reviewIntroDiv">
            <div><fmt:formatDate value="${review.trevregdate}" pattern="yyyy년 MM월 dd일" /></div>
        </div>
        <!-- 여행 코스 내용 -->
        <div class="reviewCourseDiv">
            <!-- 여행 코스 이미지 -->
            <div class="reviewCourseImg">
                <img src="https://via.placeholder.com/300x200" alt="Review Course Image">
                <div class="initButton2">경로 상세보기 ></div>
            </div>
            <!-- 여행 코스 날짜별 내역 리스트 -->
            <div class="reviewCourseDayDiv">
                <div class="courseDay">
                    <div class="day">day1</div>
                    <div class="course">course > course > course</div>
                </div>
                <div class="courseDay">
                    <div class="day">day2</div>
                    <div class="course">course > course > course</div>
                </div>
                <div class="courseDay">
                    <div class="day">day3</div>
                    <div class="course">course > course > course</div>
                </div>
            </div>
        </div>
        <!-- 여행 코스 날짜별 상세 내역 리스트 -->
        <div class="reviewCourseDetailDiv">
         	<c:forEach var="image" items="${review.trevimages}">
	         	<c:if test="${image.trevimgpath != null && image.trevimgpath != ''}">
		            <div class="reviewCourseDetailItem">
		                <div class="day">Day 1</div>
		                <div class="course">course > course > course</div>
		                <img src="${pageContext.request.contextPath}${image.trevimgpath}" alt="Review Detail Image">
		                <div class="detailContent">
		                    첫째 날 여행 후기 내용입니다. 상세한 설명과 후기글을 여기에 작성합니다.
		                </div>
		            </div>
	            </c:if>
            </c:forEach>
            <button id="reviewListBtn" class="initButton2">목록으로</button>
        </div>
        <!-- 댓글 작성 및 목록 -->
        <div class="commentsSection">
            <h2>댓글</h2>
            <!-- 댓글 입력 폼 -->
            <div class="commentInputDiv">
                <div class="profileImg">
                    <img src="https://via.placeholder.com/50" alt="Profile Image 1">
                </div>
                <form id="commentForm" action="" method="post">
                    <div id="commentMember" class="commentMember" name="member">회원1</div>
                    <input id="commentContent" name="comment" type="text" placeholder="댓글을 작성해주세요." required />
                    <button id="commentRegBtn" type="submit" class="initButton active">댓글 작성</button>
                    <button id="commentCancelBtn" type="button" class="initButton">취소</button>
                </form>
            </div>
            <!-- 댓글 목록 -->
            <div class="commentItem">
                <div class="commentDetailItem">
                    <div class="profileImg">
                        <img src="https://via.placeholder.com/50" alt="Profile Image 1">
                    </div>
                    <div class="commentMemberDiv">
                        <div id="commentMember" class="commentMember" name="member">댓글사용자1</div>
                        <div class="commentText">이것은 첫 번째 댓글입니다. 아주 유익한 후기네요!</div>
                    </div>
                    <div class="commentDate">2024-08-27 14:00 </div>
                    <div id="commentSetting" class="commentSetting">⋮</div>
                </div>
                <div class="commentReplyForm">
                    <div type="submit" class="commentReply">댓글 작성</div>
                </div>
            </div>
            <div class="commentItem">
                <div class="commentDetailItem">
                    <div class="profileImg">
                        <img src="https://via.placeholder.com/50" alt="Profile Image 1">
                    </div>
                    <div class="commentMemberDiv">
                        <div id="commentMember" class="commentMember" name="member">댓글사용자2</div>
                        <div class="commentText">이것은 두 번째 댓글입니다. 너무 좋은 코스에요!</div>
                    </div>
                    <div class="commentDate">2024-08-25 14:40 </div>
                    <div id="commentSetting" class="commentSetting">⋮</div>
                </div>
                <div class="commentReplyForm">
                    <div type="submit" class="commentReply">댓글 작성</div>
                </div>
            </div>
            <!-- 댓글 목록 END -->
        </div>
    </div>
</body>
</html>