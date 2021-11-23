<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- <%@ page session="false" %> --%>
<%String localName = request.getParameter("localName");%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>지도 생성하기</title>
    <link type="text/css" rel='stylesheet' href=<c:url value="/resources/css/map.css"/>?after/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

    </head>

    <body>
        <!-- 지도를 표시할 div 입니다 -->
        <div id="map">
        	<div class="nav">
        		<button class="menu btn btn-primary" for = "menu" onclick="location.href='/'">검색화면으로</button>
        		<c:if test="${empty memberNum}" >
        		<button class="menu btn btn-primary" for = "menu" onclick="memberjoin()">회원가입</button>
        		<!-- <input id = "menu" type="checkbox"> -->
        		<button class="menu btn btn-primary" for = "menu" onclick="memberlogin()">로그인</button>
        		</c:if>
     			<c:if test="${memberNum > 1}" >
        		<button class="menu btn btn-primary" for = "menu" onclick='location.href="/MemberLogout?localName=<%=localName%>"'>로그아웃</button>
        		<button class="menu btn btn-primary" for = "menu" onclick="myreview()">내가 작성한 리뷰 보기</button>
        		<!-- <input id = "menu" type="checkbox"> -->
        		</c:if>
        		<c:if test="${memberNum == 1}" >
        		<button class="menu btn btn-primary" for = "menu" onclick='location.href="/MemberLogout?localName=<%=localName%>"'>로그아웃</button>
        		<button class="menu btn btn-primary" for = "menu" onclick="adminreview()">전체 리뷰 보기</button>
        		<!-- <input id = "menu" type="checkbox"> -->
        		</c:if>
        	</div>
        </div>
        <script
            type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=39a62d934842f81bdceca6be47059bbb&libraries=services"></script>
        <script>
            var places = new kakao
                .maps
                .services
                .Places();

            const callback = function (result, status) {
                if (status === kakao.maps.services.Status.OK) {

                    var mapContainer = document.getElementById('map'), // 지도를 표시할 div

                        mapOption = {
                            center: new kakao
                                .maps
                                .LatLng(parseFloat(result[0].y + ','), parseFloat(result[0].x)), // 지도의 중심좌표
                            level: 8 // 지도의 확대 레벨
                        };

                    var map = new kakao
                        .maps
                        .Map(mapContainer, mapOption); // 지도를 생성합니다

                    let positionlist = [];
                    for (var i = 0; i < result.length; i++) {

                        var xlocation = parseFloat(result[i].x);
                        var ylocation = parseFloat(result[i].y + ',');

                        var position = [

                            {
                                title: result[i].place_name,
                                address: result[i].road_address_name,
                                latlng: new kakao
                                    .maps
                                    .LatLng(ylocation, xlocation)
                            }
                        ];
                        positionlist.push(position);
                    }

                    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

                    var imageSize = new kakao
                        .maps
                        .Size(24, 35);

                    // 마커 이미지를 생성합니다
                    var markerImage = new kakao
                        .maps
                        .MarkerImage(imageSrc, imageSize);

                    for (var i = 0; i < positionlist.length; i++) {
                        var marker = new kakao
                            .maps
                            .Marker({
                                map: map, // 마커를 표시할 지도
                                position: positionlist[i][0].latlng, // 마커를 표시할 위치
                                image: markerImage, // 마커 이미지,
                            });
                        var data = positionlist[i];
                        displayMarker(data)
                    }

                    function displayMarker(data) {

                        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
                        let store_name = data[0].title;
                        let store_address = data[0].address;

                        var Customcontent = document.createElement('div');
                        Customcontent.className = "wrap";

                        var info = document.createElement('div');
                        info.className = "info"
                        Customcontent.appendChild(info);

                        //커스텀오버레이 타이틀
                        var contentTitle = document.createElement("div");
                        contentTitle.className = "title"
                        contentTitle.appendChild(document.createTextNode(store_name));
                        info.appendChild(contentTitle);

                        //커스텀오버레이 닫기 버튼
                        var closeBtn = document.createElement("div");
                        closeBtn.className = "close";
                        closeBtn.setAttribute("title", "닫기");
                        closeBtn.onclick = function () {
                            overlay.setMap(null);
                        };
                        contentTitle.appendChild(closeBtn);

                        var bodyContent = document.createElement("div");
                        bodyContent.className = "body";
                        info.appendChild(bodyContent);

                        var descContent = document.createElement("div");
                        descContent.className = "desc"
                        bodyContent.appendChild(descContent);

                        //커스텀오버레이 주소
                        var addressContent = document.createElement("div");
                        addressContent.className = "ellipsis";
                        addressContent.appendChild(document.createTextNode(
                            "주소 : " + store_address
                        ));
                        descContent.appendChild(addressContent);

                        var buttonGroups = document.createElement("div");
                        buttonGroups.className = "d-flex justify-content-evenly"
                        descContent.appendChild(buttonGroups)

                        var button = document.createElement("button");
                        button.className = "btn btn-primary"
                        button.appendChild(document.createTextNode("리뷰입력"));
                        button.onclick = function () {
                        	var checkLogin = "${memberNum}"
                        		console.log(checkLogin)
                        	if (checkLogin != ''){
	                            let url = "/CreateReview?name=" + store_name + "&address=" +
	                                    store_address;
	                            let name = "팝업";
	                            let option = "width = 600px, height=400px, top=400px, left=300px, scrollbars=no";
	                            window.open(url, name, option)
                        } else {
                        		alert("로그인이 필요합니다.")
                        		let url = "/MemberLogin";
                            	let name = "팝업";
                                let option = "width = 600px, height=400px, top=400px, left=300px, scrollbars=no";
                                window.open(url, name, option);
                        	}
                        }
                        buttonGroups.appendChild(button);

                        var button = document.createElement("button");
                        button.className = "btn btn-primary"
                        button.appendChild(document.createTextNode("리뷰보기"));
                        button.onclick = function () {
                        	var  checkLogin = "${memberNum}"
                        	if(checkLogin != ''){
                        		 let url = "/ReadReview?address=" + store_address +"&membernum="+checkLogin
                                 let name = "팝업";
                                 let option = "width = 800px, height=400px, top=400px, left=300px, scrollbars=no";
                                 window.open(url, name, option)
                        	} else {
                        		alert("로그인이 필요합니다.")
                        		let url = "/MemberLogin";
                            	let name = "팝업";
                                let option = "width = 600px, height=400px, top=400px, left=300px, scrollbars=no";
                                window.open(url, name, option);
                        	}
                        };
                        buttonGroups.appendChild(button);

                        var overlay = new kakao
                            .maps
                            .CustomOverlay(
                                {content: Customcontent, map: map, position: marker.getPosition()}
                            );

                        kakao
                            .maps
                            .event
                            .addListener(marker, 'click', function () {
                                overlay.setMap(map);
                            })
                    }
                }

            }
            places.keywordSearch('${localName}', callback);
            
            function memberjoin(){
            	let url = "/MemberJoin";
            	let name = "팝업";
                let option = "width = 600px, height=400px, top=400px, left=300px, scrollbars=no";
                window.open(url, name, option);
            }
            
            function memberlogin(){
            	let url = "/MemberLogin";
            	let name = "팝업";
                let option = "width = 600px, height=400px, top=400px, left=300px, scrollbars=no";
                window.open(url, name, option);
            }
            
            function memberlogout(){
            	let url = "/MemberLogout";
            	/* let name = "팝업";
                let option = "width = 600px, height=400px, top=400px, left=300px, scrollbars=no";
                window.open(url, name, option); */
            }
            
            function myreview() {
            	var  checkLogin = "${memberNum}"
            	let url = "/MyReview?membernum="+checkLogin;
            	let name = "팝업";
            	let option = "width = 750px, height=350px, top=400px, left=300px, scrollbars=no";
            	window.open(url, name, option);
			}
            
            function adminreview() {
            	var  checkLogin = "${memberNum}"
            	let url = "/AdminReview?membernum="+checkLogin;
            	let name = "팝업";
            	let option = "width = 900px, height=400px, top=400px, left=300px, scrollbars=no";
            	window.open(url, name, option);
			}
            
        </script>
    </body>
</html>