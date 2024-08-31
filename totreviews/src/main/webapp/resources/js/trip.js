document.addEventListener('DOMContentLoaded', () => {
    kakao.maps.load(initializeMap);
});

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

const addMarker = (map, position, normalOrigin, overOrigin, clickOrigin) => {
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

    const iwContent = '<div style="padding:5px;">Hello World!</div>';
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

    kakao.maps.event.addListener(marker, 'click', handleMarkerClick(map, marker, infowindow));
};

const initializeMap = () => {
    const container = document.getElementById('map');
    const mapOptions = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3
    };
    const map = new kakao.maps.Map(container, mapOptions);

    const positions = [
        new kakao.maps.LatLng(33.44975, 126.56967),
        new kakao.maps.LatLng(33.450579, 126.56956),
        new kakao.maps.LatLng(33.4506468, 126.5707)
    ];

    positions.forEach((position, i) => {
        const gapX = (MARKER_WIDTH + SPRITE_GAP);
        const originY = (MARKER_HEIGHT + SPRITE_GAP) * i;
        const overOriginY = (OVER_MARKER_HEIGHT + SPRITE_GAP) * i;
        const normalOrigin = new kakao.maps.Point(0, originY);
        const clickOrigin = new kakao.maps.Point(gapX, originY);
        const overOrigin = new kakao.maps.Point(gapX * 2, overOriginY);

        addMarker(map, position, normalOrigin, overOrigin, clickOrigin);
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
