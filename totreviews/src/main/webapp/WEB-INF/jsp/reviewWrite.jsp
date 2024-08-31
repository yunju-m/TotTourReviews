<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/review.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/treview.js"></script>
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
            <form id="reviewForm" action="${pageContext.request.contextPath}/review/write" method="post" enctype="multipart/form-data">
                <!-- 1. 여행 후기 제목 입력 -->
                <div class="formGroup">
                    <label for="reviewTitle">제목</label>
                    <input id="reviewTitle" type="text" class="titleInput" name="trevtitle" required>
                </div>
                <!-- 2. 여행 코스 선택 -->
                <div class="formGroup">
                    <label for="travelCourse">여행 코스</label>
                    <select id="travelCourse" class="courseSelect" name="trevcourse" required>
                        <option value="" disabled selected>여행 코스를 선택하세요</option>
                        <option value="course1">코스 1</option>
                        <option value="course2">코스 2</option>
                        <option value="course3">코스 3</option>
                    </select>
                </div>
                <!-- 3. 여행 후기 내용 입력 -->
                <div class="reviewImagePreview">
                    <label for="reviewContent">후기 내용</label>
                    <img id="imagePreview" src="" alt="이미지 미리보기" style="display: none;">
                    <input id="reviewContent" class="contentInput" name="trevcontent" placeholder="여행 후기 내용을 작성하세요."
                        required />
                </div>
                <!-- 4. 이미지 파일 업로드 -->
                <div class="formGroup">
                    <label for="reviewImage">이미지 업로드</label>
                    <div class="reviewImageDiv">
                        <input id="reviewImage" type="file" name="image" accept="image/*" />
                    </div>
                </div>
                <!-- 5. 이용 약관 동의 -->
                <div class="formGroup">
                    <fieldset class="termsFieldset">
                        <legend>개인정보 수집 및 이용 동의</legend>
                        <label>
                            <input type="radio" name="terms" value="agree" class="termsRadio" id="agreeRadio">
                            동의함
                        </label>
                        <label>
                            <input type="radio" name="terms" value="disagree" class="termsRadio" id="disagreeRadio">
                            동의하지 않음
                        </label>
                    </fieldset>
                </div>
                <!-- 버튼 -->
                <div class="formGroup">
                    <div class="gotoReviewBtnDiv">
                        <button type="button" class="initButton2">목록가기</button>
                    </div>
                    <div class="submitAndCancleBtnDiv">
                        <button type="submit" class="initButton active">글 작성하기</button>
                        <button type="button" class="initButton">취소하기</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- 여행 후기 작섬 폼 END -->
    </div>
</body>
</html>