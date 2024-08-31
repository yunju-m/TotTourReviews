document.addEventListener('DOMContentLoaded', () => {
    kakao.maps.load(initializeMap);
});

// 지도 초기화 및 마커 생성 함수
const initializeMap = () => {
    const container = document.getElementById('map');
    const mapOptions = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3
    };
    const map = new kakao.maps.Map(container, mapOptions);

    // 기존 마커 이미지 정의
    const markerImages = {
        start: createMarkerImage(
            'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_b.png',
            new kakao.maps.Size(50, 45),
            new kakao.maps.Point(15, 43)
        ),
        startDrag: createMarkerImage(
            'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/red_drag.png',
            new kakao.maps.Size(50, 64),
            new kakao.maps.Point(15, 54)
        ),
        arrive: createMarkerImage(
            'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/blue_b.png',
            new kakao.maps.Size(50, 45),
            new kakao.maps.Point(15, 43)
        ),
        arriveDrag: createMarkerImage(
            'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/blue_drag.png',
            new kakao.maps.Size(50, 64),
            new kakao.maps.Point(15, 54)
        ),
        static: createMarkerImage(
            'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png',
            new kakao.maps.Size(24, 35)
        )
    };

    // 기존 마커 위치 정의
    const markerPositions = [
        {
            position: new kakao.maps.LatLng(33.450701, 126.570667),
            image: markerImages.start,
            dragImage: markerImages.startDrag
        },
        {
            position: new kakao.maps.LatLng(33.450701, 126.572667),
            image: markerImages.arrive,
            dragImage: markerImages.arriveDrag
        }
    ];

    // 마커 생성
    markerPositions.forEach(({ position, image, dragImage }) => {
        createMarker(map, position, image, dragImage);
    });

    // 정적 마커 위치 및 타이틀 정의
    const staticMarkers = [
        { title: '카카오', latlng: new kakao.maps.LatLng(33.450705, 126.570677) },
        { title: '생태연못', latlng: new kakao.maps.LatLng(33.450936, 126.569477) },
        { title: '텃밭', latlng: new kakao.maps.LatLng(33.450879, 126.569940) },
        { title: '근린공원', latlng: new kakao.maps.LatLng(33.451393, 126.570738) }
    ];

    // 정적 마커 생성
    staticMarkers.forEach(({ title, latlng }) => {
        new kakao.maps.Marker({
            map: map,
            position: latlng,
            title: title,
            image: markerImages.static
        });
    });
};

// 마커 이미지 생성 함수
const createMarkerImage = (src, size, offset) =>
    new kakao.maps.MarkerImage(src, size, { offset });

// 마커 생성 및 이벤트 설정 함수
const createMarker = (map, position, image, dragImage) => {
    const marker = new kakao.maps.Marker({
        map: map,
        position: position,
        draggable: true,
        image: image
    });

    kakao.maps.event.addListener(marker, 'dragstart', () => {
        marker.setImage(dragImage);
    });

    kakao.maps.event.addListener(marker, 'dragend', () => {
        marker.setImage(image);
    });

    return marker;
};
