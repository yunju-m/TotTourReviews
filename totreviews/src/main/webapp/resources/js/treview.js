let fileList = [];

$(document).ready(() => {
    // 글쓰기 버튼 클릭 시 이동
    $('#writeReviewBtn').on('click', function () {
        window.location.href = '/totreviews/review/write';
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

    // 취소하기 버튼 클릭 시 목록 페이지로 이동
    $('#cancleButton').on('click', function (event) {
        window.location.href = "/totreviews/review";
    });
});

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
            window.location.href = '/totreviews/review';
        },
        error: function (error) {
            alert('파일 업로드 중 오류가 발생했습니다.');
        }
    });

}

const handleFileSelect = event => {
    const input = event.target;
    const files = Array.from(input.files);
    fileList = [...fileList, ...files]; // Update fileList
    console.log(fileList);
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
                $('#reviewContentAndImgDiv').append(img);
                addNewFileInput(file, img);
            };
            reader.readAsDataURL(file);
        });
    }
}

const addNewFileInput = (file, img) => {
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
        img.remove();
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
        { selector: '#reviewTitle', errorMessage: '제목을 입력해주세요.' },
        { selector: '#travelCourse', errorMessage: '여행 코스를 선택해주세요.' },
        { selector: '#reviewContentAndImgDiv .reviewContent', errorMessage: '후기 내용을 입력해주세요.' }
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
        return { isValid: false, errorMessage: '개인정보 수집 및 이용에 동의하셔야 글을 작성할 수 있습니다.' };
    }

    return { isValid: true, errorMessage: '' };
}