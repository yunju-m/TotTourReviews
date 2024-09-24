const SPRITE_MARKER_URL = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markers_sprites2.png';
const SPRITE_WIDTH = 126, SPRITE_HEIGHT = 146;
const MARKER_WIDTH = 33, MARKER_HEIGHT = 36;
const OVER_MARKER_WIDTH = 40, OVER_MARKER_HEIGHT = 42;
const SPRITE_GAP = 10;

const markerSize = new kakao.maps.Size(MARKER_WIDTH, MARKER_HEIGHT);
const markerOffset = new kakao.maps.Point(12, MARKER_HEIGHT);
const overMarkerSize = new kakao.maps.Size(OVER_MARKER_WIDTH, OVER_MARKER_HEIGHT);
const overMarkerOffset = new kakao.maps.Point(13, OVER_MARKER_HEIGHT);
const spriteImageSize = new kakao.maps.Size(SPRITE_WIDTH, SPRITE_HEIGHT);

let selectedMarker = null;
let clickMarker = null;

// 마커 이미지 생성 함수
const createMarkerImage = (size, offset, origin) => {
    return new kakao.maps.MarkerImage(
        SPRITE_MARKER_URL,
        size,
        {
            offset: offset,
            spriteOrigin: origin,
            spriteSize: spriteImageSize
        }
    );
};

// 마커 클릭 핸들러
const handleMarkerClick = (map, marker, infowindow) => {
    return () => {
        if (selectedMarker === marker) {
            infowindow.close();
            marker.setImage(marker.normalImage);
            selectedMarker = null;
        } else {
            if (selectedMarker) {
                selectedMarker.setImage(selectedMarker.normalImage);
                infowindow.close();
            }
            marker.setImage(marker.clickImage);
            infowindow.open(map, marker);
            selectedMarker = marker;
        }
    };
};


// 마커 추가 함수
const addMarker = (map, position, normalOrigin, overOrigin, clickOrigin, tour) => {
    const normalImage = createMarkerImage(markerSize, markerOffset, normalOrigin);
    const overImage = createMarkerImage(overMarkerSize, overMarkerOffset, overOrigin);
    const clickImage = createMarkerImage(markerSize, markerOffset, clickOrigin);

    const marker = new kakao.maps.Marker({
        map: map,
        position: position,
        image: normalImage,
        clickable: true
    });

    marker.normalImage = normalImage;
    marker.clickImage = clickImage;
    marker.overImage = overImage;

    const iwContent = `<div style="padding:5px;">${tour.toname}!</div>`;
    const infowindow = new kakao.maps.InfoWindow({
        content: iwContent,
        removable: false
    });

    kakao.maps.event.addListener(marker, 'mouseover', () => {
        if (selectedMarker !== marker) {
            marker.setImage(marker.overImage);
        }
    });

    kakao.maps.event.addListener(marker, 'mouseout', () => {
        if (selectedMarker !== marker) {
            marker.setImage(marker.normalImage);
        }
    });

    kakao.maps.event.addListener(marker, 'click', handleMarkerClick(map, marker, infowindow));
};


// 지도 초기화 함수
const initializeMap = (tour) => {
    const container = document.getElementById('map');
    const mapOptions = {
        center: new kakao.maps.LatLng(tour.toy, tour.tox),
        level: 3
    };
    const map = new kakao.maps.Map(container, mapOptions);

    const positions = [
        new kakao.maps.LatLng(tour.toy, tour.tox),
    ];

    positions.forEach((position, i) => {
        const gapX = (MARKER_WIDTH + SPRITE_GAP);
        const originY = (MARKER_HEIGHT + SPRITE_GAP) * i;
        const overOriginY = (OVER_MARKER_HEIGHT + SPRITE_GAP) * i;
        const normalOrigin = new kakao.maps.Point(0, originY);
        const clickOrigin = new kakao.maps.Point(gapX, originY);
        const overOrigin = new kakao.maps.Point(gapX * 2, overOriginY);

        addMarker(map, position, normalOrigin, overOrigin, clickOrigin, tour);
    });

    kakao.maps.event.addListener(map, 'click', (mouseEvent) => {
        const latlng = mouseEvent.latLng;

        if (clickMarker) {
            clickMarker.setMap(null);
        }

        clickMarker = new kakao.maps.Marker({
            map: map,
            position: latlng
        });

        const message = `클릭한 위치의 위도는 ${latlng.getLat()} 이고, 경도는 ${latlng.getLng()} 입니다`;
        document.getElementById('clickLatlng').innerHTML = message;
    });
};

// 코스ID에 해당하는 코스 정보 반환받는 함수
const getCourseById = async (courseId) => {
    try {
        const response = await fetch(`/totreviews/course/${courseId}`);
        if (!response.ok) throw new Error('코스 응답이 올바르지 않습니다.');
        return await response.json();
    } catch (error) {
        console.error('Course Error:', error);
    }
};

// 상세 코스의 관광지 정보 반환받는 함수
const getTourById = async (tourId) => {
    try {
        const response = await fetch(`/totreviews/tour/${tourId}`);
        if (!response.ok) throw new Error('관광 정보 반환 응답이 올바르지 않습니다.');
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Tour Error:', error);
    }
};

// DOMContentLoaded 이벤트 핸들러
document.addEventListener('DOMContentLoaded', () => {
    // 여행 코스 버튼 클릭 이벤트 설정
    document.querySelectorAll('.courseBtnDiv button').forEach(button => {
        button.addEventListener('click', async function () {
            const courseId = this.getAttribute('data-course');
            const course = await getCourseById(courseId);
            if (course) {
                const tourId = JSON.parse(course.dcourse)[1];
                let tour = await getTourById(tourId);
                kakao.maps.load(initializeMap(tour));
            }
        });
    });
});