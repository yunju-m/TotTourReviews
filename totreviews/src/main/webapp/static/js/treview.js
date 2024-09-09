//  URL 선언
const BASE_TREVIEW_URL = '/totreviews/review';
const GET_ALL_TREVIEW = `${BASE_TREVIEW_URL}/all/1`;
const GET_MY_TREVIEW = `${BASE_TREVIEW_URL}/my/1`;
const GET_WRITE_TREVIEW = `${BASE_TREVIEW_URL}/all/write`;

// 에러 메시지 선언
const ERROR_MESSAGES = {
    TITLE_REQUIRED: '제목을 입력해주세요.',
    TRIP_REQUIRED: '작성할 여행을 선택해주세요.',
    CONTENT_REQUIRED: '후기 내용을 입력해주세요.',
    AGREE_REQUIRED: '개인정보 수집 및 이용에 동의하셔야 글을 작성할 수 있습니다.',
    FILE_UPLOAD: '파일 업로드 중 오류가 발생했습니다.'
};

let fileList = [];

$(document).ready(() => {

    // 여행 후기 종류별 활성화 기능
    let path = window.location.pathname;

    if (path.includes(GET_ALL_TREVIEW)) {
        $('#TotalReviewsBtn').addClass('active');
        $('#myReviewsBtn').removeClass('active');
    } else if (path.includes(GET_MY_TREVIEW)) {
        $('#myReviewsBtn').addClass('active');
        $('#TotalReviewsBtn').removeClass('active');
    }

    // 여행 후기의 여행을 선택하는 경우
    $('#travelTrip').on('change', function () {
        var tripId = $(this).val();

        if (tripId) {
            handleCourseSelect(tripId);
        }
    });

    // 글쓰기 버튼 클릭 시 이동
    $('#writeReviewBtn').on('click', function () {
        window.location.href = GET_WRITE_TREVIEW;
    });

    // 이미지 업로드시 미리보기 생성
    $('#reviewImage').on('change', handleFileSelect);

    // 입력 필드에서 엔터키 입력 시 새로운 입력 필드 생성 없으면 삭제
    $('#reviewContentAndImgDiv').on('keydown', '.reviewContent', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            createNewInputField();
        } else if (event.key === 'Backspace') {
            handleBackspace(event);
        }
    });

    // 여행 후기 항목 유효성 검사 및 등록
    $('#submitButton').on('click', function (event) {
        event.preventDefault();

        const validationResult = validate();
        if (validationResult.isValid) {
            submitReview();
        } else {
            alert(validationResult.errorMessage);
        }
    });

    // 전체 여행 후기 버튼 클릭 시 전체 여행 후기 리스트 출력
    $('#TotalReviewsBtn').on('click', () => {
        window.location.href = GET_ALL_TREVIEW;
    });

    // 나의 여행 후기 버튼 클릭 시 내가 작성한 여행 후기 리스트 출력
    $('#myReviewsBtn').on('click', () => {
        window.location.href = GET_MY_TREVIEW;
    });

    // 취소하기 버튼 클릭 시 목록 페이지로 이동
    $('#cancleButton').on('click', () => {
        window.history.back();
    });

    // 나의 여행 상세 후기 목록 버튼 클릭 시 뒤로가기
    $('#reviewListBtn').on('click', () => {
        window.history.back();
    });

});

// 여행 선택 시 이벤트 처리
const handleCourseSelect = tripId => {
    $.ajax({
        url: `${GET_WRITE_TREVIEW}/${tripId}`,
        type: 'GET',
        data: { tripId: tripId },
        success: function (courses) {
            let courseHtml = '';
            courses.forEach((course, index) => {
                let day = `[Day${index + 1}]`;
                let courseDetails = course.courseDetail.map(detail => detail.dname).join(' &rarr; ');
                courseHtml += `<div class="courseDetailItem">${day} ${courseDetails}</div><hr/>`;
            });
            $('#travelCourse').html(courseHtml);
        },
        error: function () {
            alert('코스를 가져오는 데 실패했습니다.');
        }
    });
}

// 업로드 파일 정보와 함께 글쓰기 등록 처리
const submitReview = () => {
    const formData = new FormData($('#reviewForm')[0]);
    fileList.forEach(file => {
        formData.append('reviewImage', file);
    });

    $.ajax({
        url: $('#reviewForm').attr('action'), // form action 경로
        type: 'POST',
        data: formData,
        contentType: false,
        processData: false,
        success: function () {
            window.location.href = GET_ALL_TREVIEW;
        },
        error: function (error) {
            alert(ERROR_MESSAGES.FILE_UPLOAD + " ");
        }
    });
}

const handleFileSelect = event => {
    const input = event.target;
    const files = Array.from(input.files);
    fileList = [...fileList, ...files];

    if (files) {
        $.each(files, (index, file) => {
            let reader = new FileReader();
            reader.onload = function (e) {
                const img = $('<img>', {
                    src: e.target.result,
                    alt: `여행후기업로드사진미리보기${index + 1}`,
                    name: 'reviewImage',
                    class: 'reviewImage'
                });
                const imgWrapper = $('<div>', { class: 'img-wrapper' });

                let hiddenImageInput = $('<input>', {
                    type: 'hidden',
                    name: 'trevcontent',
                    value: 'image'
                });
                imgWrapper.append(img).append(hiddenImageInput);
                $('#reviewContentAndImgDiv').append(imgWrapper);

                addNewFileInput(file, imgWrapper);
            };
            reader.readAsDataURL(file);
        });
        $('#reviewImage').val('');
    }
}

const addNewFileInput = (file, imgWrapper) => {
    const inputWrapper = $('<div>', {
        class: 'file-input-wrapper'
    });

    const fileNameInput = $('<input>', {
        type: 'text',
        name: 'reviewImage',
        value: `${file.name}`,
        multiple: 'multiple'
    });

    const deleteButton = $('<button>', {
        type: 'button',
        text: '삭제',
        class: 'initButton'
    }).on('click', function () {
        // 삭제 버튼 클릭 시 해당 요소 삭제
        imgWrapper.remove();
        inputWrapper.remove();
        fileList = fileList.filter(f => f !== file);
    });

    inputWrapper.append(fileNameInput).append(deleteButton);
    $('.reviewImageDiv').append(inputWrapper);
}

const createNewInputField = () => {
    let newInput = $('<input>', {
        class: 'reviewContent',
        name: 'trevcontent'
    });

    $('#reviewContentAndImgDiv').append(newInput);
    newInput.focus();
}

const handleBackspace = event => {
    const currentInput = $(event.target);
    if (currentInput.val().length === 0) {
        const inputs = $('#reviewContentAndImgDiv').find('.reviewContent');

        if (inputs.length > 1) {
            event.preventDefault();
            currentInput.remove();

            const lastInput = $('#reviewContentAndImgDiv').find('.reviewContent').last();
            lastInput.focus();
        }
    }
}

// 공백 여부 유효성 검사
const checkField = (selector, errorMessage) => {
    const value = $(selector)[0].value;
    return value === '' ? errorMessage : '';
};

const validate = () => {
    const validations = [
        { selector: '#reviewTitle', errorMessage: ERROR_MESSAGES.TITLE_REQUIRED },
        { selector: '#travelTrip', errorMessage: ERROR_MESSAGES.TRIP_REQUIRED },
        { selector: '#reviewContentAndImgDiv .reviewContent', errorMessage: ERROR_MESSAGES.CONTENT_REQUIRED }
    ];

    // 나머지 필드 유효성 검사
    for (const { selector, errorMessage } of validations) {
        const message = checkField(selector, errorMessage);
        if (message) {
            return { isValid: false, errorMessage: message };
        }
    }

    // 체크박스 유효성 검사
    if (!$('#agreeRadio').is(':checked')) {
        return { isValid: false, errorMessage: ERROR_MESSAGES.AGREE_REQUIRED };
    }

    return { isValid: true, errorMessage: '' };
}