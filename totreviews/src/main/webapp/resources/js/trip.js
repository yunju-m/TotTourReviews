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

    // 스프라이트 이미지 및 마커 크기 정의
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

    const positions = [
        new kakao.maps.LatLng(33.44975, 126.56967),
        new kakao.maps.LatLng(33.450579, 126.56956),
        new kakao.maps.LatLng(33.4506468, 126.5707)
    ];

    let selectedMarker = null;

    // 지도 위에 마커를 표시합니다
    positions.forEach((position, i) => {
        const gapX = (MARKER_WIDTH + SPRITE_GAP);
        const originY = (MARKER_HEIGHT + SPRITE_GAP) * i;
        const overOriginY = (OVER_MARKER_HEIGHT + SPRITE_GAP) * i;
        const normalOrigin = new kakao.maps.Point(0, originY);
        const clickOrigin = new kakao.maps.Point(gapX, originY);
        const overOrigin = new kakao.maps.Point(gapX * 2, overOriginY);

        addMarker(map, position, normalOrigin, overOrigin, clickOrigin);
    });

    // 마커를 생성하고 지도 위에 표시하고, 마커에 mouseover, mouseout, click 이벤트를 등록하는 함수입니다
    function addMarker(map, position, normalOrigin, overOrigin, clickOrigin) {
        const normalImage = createMarkerImage(markerSize, markerOffset, normalOrigin);
        const overImage = createMarkerImage(overMarkerSize, overMarkerOffset, overOrigin);
        const clickImage = createMarkerImage(markerSize, markerOffset, clickOrigin);

        const marker = new kakao.maps.Marker({
            map: map,
            position: position,
            image: normalImage,
            clickable: true // 마커를 클릭할 수 있도록 설정
        });

        marker.normalImage = normalImage;
        marker.clickImage = clickImage;
        marker.overImage = overImage;

        // 인포윈도우 설정
        const iwContent = '<div style="padding:5px;">Hello World!</div>';
        const iwRemoveable = true;
        const infowindow = new kakao.maps.InfoWindow({
            content: iwContent,
            removable: false
        });

        kakao.maps.event.addListener(marker, 'mouseover', () => {
            if (!selectedMarker || selectedMarker !== marker) {
                marker.setImage(marker.overImage);
            }
        });

        kakao.maps.event.addListener(marker, 'mouseout', () => {
            if (!selectedMarker || selectedMarker !== marker) {
                marker.setImage(marker.normalImage);
            }
        });

        kakao.maps.event.addListener(marker, 'click', () => {
            if (selectedMarker === marker) {
                // 이미 클릭된 상태인 마커를 클릭하면 인포윈도우를 닫고 이미지도 기본 이미지로 변경
                infowindow.close();
                marker.setImage(marker.normalImage);
                selectedMarker = null;
            } else {
                // 클릭된 상태가 아닌 경우
                if (selectedMarker) {
                    // 기존 클릭된 마커의 이미지와 인포윈도우를 기본 상태로 되돌리기
                    selectedMarker.setImage(selectedMarker.normalImage);
                    infowindow.close();
                }
                // 현재 클릭된 마커의 이미지와 인포윈도우를 설정
                marker.setImage(marker.clickImage);
                infowindow.open(map, marker);
                selectedMarker = marker;
            }
        });
    }

    // MarkerImage 객체를 생성하여 반환하는 함수입니다
    function createMarkerImage(markerSize, offset, spriteOrigin) {
        return new kakao.maps.MarkerImage(
            SPRITE_MARKER_URL,
            markerSize,
            {
                offset: offset,
                spriteOrigin: spriteOrigin,
                spriteSize: spriteImageSize
            }
        );
    }
};
