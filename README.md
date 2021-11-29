<h1>프로젝트 개요</h1>

해당 프로젝트는 경북직업전문학교 (포항)에서 진행하는 스마트웹자바과정을 수강하면서 개인적으로 진행한 프로젝트 입니다. <br>
Java로 진행하는 대표적인 프로젝트 중 '게시판' 프로젝트를 조금 응용하여 제작 되었습니다. 

Front-end는 JSP, CSS, JavaScrpit, AJAX를 이용하였고, Back-end는 Java를 이용하였고 <br>
Framework는 Spring, DataBase는 MYSQL를 이용하였습니다.
API는 카카오지도 API를 사용하였습니다.

배포는 AWS (EC2, ROUTE 53, RDS)로 이뤄졌습니다. 

<h1>프로젝트 상세소개</h1>

유저가 메인화면으로 접속하여 '지역명'과 '음식명'을 검색하면, 지도상에 해당지역의 음식점을 보여줍니다. <br>
유저는 회원가입 후 로그인을 해야 '리뷰작성', '리뷰수정', '리뷰삭제'의 작업을 수행 할 수 있습니다.<br>

관리자로 로그인시에는 다른 유저들이 작성한 리뷰를 전부 볼 수 있으며, 수정,삭제 작업도 가능합니다.<br>

<h1>프로젝트 흐름도</h1>

1. 일반유저 접근 시 

일반유저가 접근시 검색화면을 통해 '지역명', '음식명'을 검색하면 '카카오지도 API'를 통해 해당지역의 음식점을 지도에 보여줍니다. <br>
그 음식점 중 하나를 클릭하여 리뷰를 작성 혹은 삭제를 하려면 회원가입이 필요하며, 회원가입 뒤 로그인을 하면 <br>
리뷰 관련 작업을 진행 할 수 있습니다.<br>

리뷰와 관련된 작업으로는 '작성', '수정', '삭제' 가 있습니다. 또한 내가 쓴 리뷰를 한번에 볼 수 있습니다. <br><br>

![유저버전](https://user-images.githubusercontent.com/36761618/143794773-4f92e802-fc35-4a54-b70b-3649eb9ec44c.PNG)


<br>

2. 관리자 유저 접근 시 

관리자 유저로 접근시 일반유저와 대부분 같은 흐름 입니다만, 관리자 유저의 경우 다른 일반 유저들이 작성한 모든 리뷰를 확인 및 수정, 삭제가 가능합니다. <br><br>

![관리자버전](https://user-images.githubusercontent.com/36761618/143794811-6b0afd1f-13c4-44bd-9943-6cc0b1fa3e68.PNG)


<h1>데이터베이스 구성</h1>

데이터베이스의 경우 MYSQL을 사용하였습니다. <br>
테이블은 총 2개의 테이블을 사용하였고 각각 'review', 'member'라는 테이블 생성 하였습니다.<br>
테이블의 상세 구성은 아래와 같습니다.<br>

![데이터베이스 구성](https://user-images.githubusercontent.com/36761618/143793937-291ffcf4-c80a-4c9d-8470-dcb6b29d9a41.png)<br><br>
review 테이블의 경우 순서인 num, 사용자가 작성하는 별점인 star, 사용자가 선택한 가게의 상호명 name, 가게의 주소 address, <br>
사용자가 작성한 review, 그리고 작성한 사용자의 고유식별 번호인 memberNum 의 컬럼으로 테이블이 구성되어 있습니다. <br><br>
member 테이블의 경우 사용자의 고유식별 번호인 memberNum이 있으며, review테이블의 memberNum의 외래키로써 참조가 됩니다. <br>
또한 사용자의 id인 memberId, password인 memberPw, 사용자의 이름인 memberName이 있으며, 연락처와 가입시점인 memberPhone, regDate의 컬럼으로 구성되어 있습니다.<br>

<h1>사이트 주소 및 필요정보</h1>

URL : http://myrestaruant.tk<br>
관리자 계정<br>
ID : admin<br>
PW : admin<br>
<br>
일반유저 계정<br>
ID : test1<br>
PW : test1<br>


