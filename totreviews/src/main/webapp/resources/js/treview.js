$(document).ready(() => {
    // 글쓰기 버튼 클릭 시 이동
    $('#writeReviewBtn').on('click', function () {
        window.location.href = '/totreviews/review/write';
    });

    // 이미지 업로드시 미리보기 생성
    $('#reviewImage').on('change', handleImagePreview);

    // 입력 필드에서 엔터키 입력 시 새로운 입력 필드 생성 없으면 삭제
    $('#reviewContentAndImgDiv').on('keydown', '.reviewContent', function (event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            createNewInputField();
        } else if (event.key === 'Backspace') {
            handleBackspace(event);
        }
    });

    // 유효성 검사 메소드
    $('#submitButton').on('click', function (event) {
        event.preventDefault();
        const validationResult = validate();
        if (validationResult.isValid) {
            $('#reviewForm').submit();
        } else {
            alert(validationResult.errorMessage);
        }
    });
});

const handleImagePreview = event => {
    const input = event.target;
    const file = input.files[0];
    if (file) {
        let reader = new FileReader();
        reader.onload = function (e) {
            $('#imagePreview').attr('src', e.target.result).show();
        };
        reader.readAsDataURL(file);
    } else {
        $('#imagePreview').hide().attr('src', '');
    }
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
    	{ selector: '#agreeRadio', errorMessage: "개인정보 수집 및 이용에 동의하셔야 글을 작성할 수 있습니다." },
        { selector: '#reviewTitle', errorMessage: '제목을 입력해주세요.' },
        { selector: '#travelCourse', errorMessage: '여행 코스를 선택해주세요.' },
        { selector: '#reviewContentAndImgDiv .reviewContent', errorMessage: '후기 내용을 입력해주세요.' }
    ];

    for (let i = 1; i < validations.length; i++) {
        const { selector, errorMessage } = validations[i];
        const message = checkField(selector, errorMessage);
        if (message) {
            return { isValid: false, errorMessage: message };
        }
    }
    
    // 개인정보 수집 체크 유효성 검사
    if (!$(validations[0].selector)[0].checked) {
        return { isValid: false, errorMessage: validations[0].errorMessage };
    }

    return { isValid: true, errorMessage: '' };
}