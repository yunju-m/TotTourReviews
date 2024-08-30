// JavaScript로 이미지 미리보기 기능 구현
$(document).ready(() => {
	// 글쓰기 버튼 클릭 시 이동
	$('#writeReviewBtn').on('click', function() {
        window.location.href = '/totreviews/review/write';
    });
    $('#reviewImage').on('change', handleImagePreview);
});

const handleImagePreview = (event) => {
    var input = event.target;
    var file = input.files[0];
    var reader = new FileReader();

    reader.onload = function (e) {
        var image = document.getElementById('imagePreview');
        image.src = e.target.result;
        image.style.display = 'block';
    }

    if (file) {
        reader.readAsDataURL(file);
    }
}