<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/review.css" />
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
            <div class="reviewItem">
                <img src="https://via.placeholder.com/300x200" alt="Review Image">
                <div class="info">
                    <div class="title">여행 후기 글 1</div>
                    <div class="author">작성자 1</div>
                </div>
            </div>
            <div class="reviewItem">
                <img src="https://via.placeholder.com/300x200" alt="Review Image">
                <div class="info">
                    <div class="title">여행 후기 글 2</div>
                    <div class="author">작성자 2</div>
                </div>
            </div>
            <div class="reviewItem">
                <img src="https://via.placeholder.com/300x200" alt="Review Image">
                <div class="info">
                    <div class="title">여행 후기 글 3</div>
                    <div class="author">작성자 3</div>
                </div>
            </div>
            <div class="reviewItem">
                <img src="https://via.placeholder.com/300x200" alt="Review Image">
                <div class="info">
                    <div class="title">여행 후기 글 4</div>
                    <div class="author">작성자 4</div>
                </div>
            </div>
            <div class="reviewItem">
                <img src="https://via.placeholder.com/300x200" alt="Review Image">
                <div class="info">
                    <div class="title">여행 후기 글 5</div>
                    <div class="author">작성자 5</div>
                </div>
            </div>
            <div class="reviewItem">
                <img src="https://via.placeholder.com/300x200" alt="Review Image">
                <div class="info">
                    <div class="title">여행 후기 글 6</div>
                    <div class="author">작성자 6</div>
                </div>
            </div>
            <div class="reviewItem">
                <img src="https://via.placeholder.com/300x200" alt="Review Image">
                <div class="info">
                    <div class="title">여행 후기 글 7</div>
                    <div class="author">작성자 7</div>
                </div>
            </div>
            <div class="reviewItem">
                <img src="https://via.placeholder.com/300x200" alt="Review Image">
                <div class="info">
                    <div class="title">여행 후기 글 8</div>
                    <div class="author">작성자 8</div>
                </div>
            </div>
        </div>
        <!-- 여행 후기 목록 리스트 END-->
    </div>
</body>
</html>