# 📝 My Memopad
### 캡스톤 졸업 프로젝트 <나만의 필요한 정보를 모아 두는 다용도 메모장>


## ✔️ 개요 및 필요성
평소에 웹 사이트를 통해서 원하는 정보를 따로 저장해 관리해 주는 곳이 없어 나중에 다시 찾게 될 때 종종 링크를 잊어버리는 경우가 많다. 따라서 다시 원하는 정보를 찾기까지 많은 시간이 소요되고 결국 찾지 못한다. 이런 경우를 방지하기 위해서 자신이 원하는 정보들과 알림들을 미리 스크랩한 뒤 저장하여 한곳에 모아 두는 다용도 메모장을 구상하게 되었다. 본인이 사고 싶은 물건을 발견해 놓았다가 나중에 집에 가서 확인하고 싶을 때, 같은 가격의 물건은 도저히 찾기 힘들 때 등 실생활에서 불편하거나 까먹기 쉬운 부분들을 잊지 않고 기억하기 위해 해당 링크를 복사하여 메모장에 스크랩해 놓는다. 이후에 그것들을 어디서든지 확인하고 비교하기 쉽게 자신의 노트북이나 휴대 전화에 연동되게 하는 다목적성 메모장 서비스이다.  


## 🖥 PROJECT 소개

2021년 1학기 창의공학설계(캡스톤디자인) 강의 졸업 팀 프로젝트

사용 환경에 제약받지 않고 동기화하여 본인이 메모하고 싶은 정보와 링크를 저장할 수 있는 메모 서비스 제작

🗓️ **작업기간** : 2021. 03 ~ 2021. 06

👨‍💻 **투입인원** : 4명

📒 **주요업무**

-   기획 및 디자인
-   HTML, CSS3 퍼블리싱 진행
-   부트스트랩 이용한 반응형 웹 디자인
-   DB 구축 및 JSP 통한 서버 구축


🌱 **스킬 및 사용 툴**

`HTML5` `css3` `Bootstrap`: 시각적인 디자인 설계, 반응형 웹으로 제작  
`JavaScript` `jQuery`: 회원가입 시 유효성 검사 기능  
`JSP`: 구축된 데이터베이스와 웹 서버의 동기화  
`MySQL`: 사용자가 입력하는 메모 정보를 데이터베이스에 저장, 회원 정보 저장  
`git`: 버전 관리  
`Eclipse` `Tomcat`

## 🖌️ UI

>로그인 & 회원가입 화면

<img src="https://cdn.discordapp.com/attachments/838470575566880792/868908514704257044/image0.png" width="600px" />

#

>  메인 화면

- 사용자가 다른 페이지와 나란히 두고 사용하며 편하게 작성할 수 있도록 반응형으로 디자인하기 위해 부트스트랩 사용

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/05bae759-c141-4f3f-9ea5-c8705b2a2e41/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210725%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210725T170815Z&X-Amz-Expires=86400&X-Amz-Signature=28a7ca5a7cee7e87598866db1f8768923193ec8bcd6ac5a523c5860a5c997b67&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22" width="300px" />

#

>  메모 보기 화면

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/54bab6b9-78ea-4736-8331-a2508bf37dc2/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210725%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210725T170846Z&X-Amz-Expires=86400&X-Amz-Signature=337407556bd25fa7f9b4cc345b1356b292b1ea87dbbf4486b4602ea1b84ce752&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22" width="300px" />

#

> 카테고리 모달 화면

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a91749f9-ef5e-4514-b0b2-41d25e477708/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210725%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210725T170918Z&X-Amz-Expires=86400&X-Amz-Signature=61a2ea0e9295c5040f079e72e45f9399842529809910d85c544202694fe2b274&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22" width="300px" />

#

>  메모 추가 화면

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f2591cb3-520c-40e3-a873-e5ecd51f53e6/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210725%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210725T170943Z&X-Amz-Expires=86400&X-Amz-Signature=ea493ccc9e71c59f8f4a68258be662bc19a223c513ea9c8694911b7782515e7c&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22" width="300px" />

#

>   소개 페이지

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/996af592-2f14-456f-90a0-9fe9c86b282d/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20210725%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20210725T171011Z&X-Amz-Expires=86400&X-Amz-Signature=192b7e55589c1f2ec0edc5bd93cf165f63c7b330ced8ce4904aa8920e47ddf59&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22" width="300px" />
