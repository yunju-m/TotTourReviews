<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/global.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/review.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/treview.js"></script>
    <title>여행 후기</title>
</head>
<body>
    <div class="mainDiv">
        <div class="reviewTitleDiv">
            <div class="bigTitle">여행 후기</div>
        </div>
        <div class="reviewIntroDiv">
            <div>여행 후기는 여행지에서의 경험을 기록하고 공유하는 중요한 방법입니다.</div>
            <div>아래 목록에서 다양한 여행 후기를 확인하고, 자신이 작성한 후기 목록을 선택할 수 있습니다.</div>
        </div>
        <div class="menu">
            <div class="initButton active" id="TotalReviewsBtn">전체 여행 후기</div>
            <div class="initButton" id="myReviewsBtn">나의 여행 후기</div>
        </div>
        <div class="searchAndWriteDiv">
            <div class="searchDiv">
                <select id="searchCategory" class="select">
                    <option value="all">전체</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input id="searchInput" class="searchInput" type="text" placeholder="검색어를 입력하세요.">
                <button id="searchReviewBtn" class="initButton2">검색</button>
            </div>
            <div class="writeReviewDiv">
                <button id="writeReviewBtn" class="initButton2">글쓰기</button>
            </div>
        </div>
        <hr />
        <!-- 여행 후기 목록 리스트 -->
        <div class="reviewList">
            <c:forEach var="review" items="${pagination.postList}">
                <div class="reviewItem">
                    <!-- 리뷰 이미지 표시, 첫 번째 이미지 사용 -->
                    <c:choose>
                        <c:when test="${not empty review.trevimgpath}">
                            <c:set var="imgPaths" value="${fn:split(review.trevimgpath, ',')}" />
                            <img src="${pageContext.request.contextPath}${fn:trim(imgPaths[0])}" alt="Review Title Image">
                        </c:when>
                        <c:otherwise>
                            <img src="${pageContext.request.contextPath}/static/image/treviewDefaultImg.png" alt="Review Default Image">
                        </c:otherwise>
                    </c:choose>
                    <div class="info">
                        <div class="title">${review.trevtitle}</div>
                        <div class="author">${review.memid}</div>
                        <div class="rating">평점: ${review.trevrating}</div>
                        <div class="count">조회수: ${review.trevcount}</div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!-- 여행 후기 목록 리스트 END-->
        <!-- 페이징 버튼 -->
		<nav class="paginationNav">
		    <ul class="paginationList">
		        <!-- 처음 페이지로 이동하는 버튼 -->
	            <li class="paginationItem">
	                <a href="${pageContext.request.contextPath}/review/${pagination.startBlockPage}" class="paginationLink">&laquo;</a>
	            </li>
		
		        <!-- 이전 페이지 버튼 -->
		        <c:if test="${pagination.isPrev}">
		            <li class="paginationItem">
		                <a href="${pageContext.request.contextPath}/review/${pagination.currentPage - 1}" class="paginationLink">이전</a>
		            </li>
		        </c:if>
		
		        <!-- 페이지 번호 출력 -->
		        <c:forEach begin="${pagination.startBlockPage}" end="${pagination.endBlockPage}" var="pageNum">
		            <c:choose>
		                <c:when test="${pagination.currentPage == pageNum}">
		                    <li class="paginationItem active">
		                        <span class="paginationLink">${pageNum}</span>
		                    </li>
		                </c:when>
		                <c:otherwise>
		                    <li class="paginationItem">
		                        <a href="${pageContext.request.contextPath}/review/${pageNum}" class="paginationLink">${pageNum}</a>
		                    </li>
		                </c:otherwise>
		            </c:choose>
		        </c:forEach>
		
		        <!-- 다음 페이지 버튼 -->
		        <c:if test="${pagination.isNext}">
		            <li class="paginationItem">
		                <a href="${pageContext.request.contextPath}/review/${pagination.currentPage + 1}" class="paginationLink">다음</a>
		            </li>
		        </c:if>
		
		        <!-- 맨 끝으로 버튼 -->
	            <li class="paginationItem">
	                <a href="${pageContext.request.contextPath}/review/${pagination.endBlockPage}" class="paginationLink">&raquo;</a>
	            </li>
		    </ul>
		</nav>
		<!-- 페이징 버튼 끝 -->
    </div>
</body>
</html>