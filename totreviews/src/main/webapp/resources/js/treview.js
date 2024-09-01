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