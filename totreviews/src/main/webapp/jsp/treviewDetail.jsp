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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/treview.js"></script>
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
                <c:forEach var="course" items="${courses}" varStatus="courseStatus">
                    <div class="courseDay">
                        <!-- DAY 번호 출력 -->
                        <div class="day">Day ${courseStatus.index + 1}</div>
                        <div class="course">
                            <c:forEach var="detail" items="${course.courseDetail}" varStatus="detailStatus">
                                <c:choose>
                                    <c:when test="${not empty detail.dname}">
                                        <c:out value="${detail.dname}" />
                                        <c:choose>
                                            <c:when test="${not empty detail.daddress}">
                                                <c:if test="${detailStatus.index < course.courseDetail.size() - 1}">
                                                    &rsaquo;
                                                </c:if>
                                            </c:when>
                                        </c:choose>
                                    </c:when>
                                    <c:when test="${not empty detail.daddress}">
                                        <c:out value="${detail.daddress}" />
                                        <c:if test="${detailStatus.index < course.courseDetail.size() - 1}">
                                            &rsaquo;
                                        </c:if>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>     
        <!-- 여행 코스 날짜별 상세 내역 리스트 -->
		<div class="reviewCourseDetailDiv">
		    <c:set var="imageIndex" value="0" />
		    <c:forEach var="content" items="${fn:split(review.trevcontent, ',')}" varStatus="status">
		        <div class="reviewCourseDetailItem">
		            <c:choose>
		                <c:when test="${content == 'image'}">
		                    <c:if test="${imageIndex < review.trevimages.size()}">
		                        <img src="${pageContext.request.contextPath}${review.trevimages[imageIndex].trevimgpath}" alt="Review Detail Image">
		                        <c:set var="imageIndex" value="${imageIndex + 1}" />
		                    </c:if>
		                </c:when>
		                <c:otherwise>
		                    <div class="detailContent">${content}</div>
		                </c:otherwise>
		            </c:choose>
		        </div>
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
            <c:forEach var="comment" items="${comments}">
		        <div class="commentItem">
		            <div class="commentDetailItem">
		                <div class="profileImg">
		                    <img src="https://via.placeholder.com/50" alt="Profile Image">
		                </div>
		                <div class="commentMemberDiv">
		                    <div id="commentMember" class="commentMember" name="member">${comment.memnick}</div>
		                    <div class="commentText">${comment.content}</div>
		                </div>
		                <div class="commentDate">
		                	<fmt:formatDate value="${comment.regdate}" pattern="yyyy-MM-dd HH:mm" />
		                </div>
		                <div id="commentSetting" class="commentSetting">⋮</div>
		            </div>
		            <div class="commentReplyForm">
		                <div type="submit" class="commentReply">댓글 작성</div>
		            </div>
		        </div>
		    </c:forEach>
            <!-- 댓글 목록 END -->
        </div>
    </div>
</body>
</html>