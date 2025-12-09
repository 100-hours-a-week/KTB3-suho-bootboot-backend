# KTB3-suho-bootboot-backend

## 프로젝트 소개
부트캠프 수강생들을 위한 커뮤니티 플랫폼 백엔드 프로젝트입니다.

## 소개 영상
https://github.com/user-attachments/assets/ecc1d80e-27ce-41d9-b32e-6b1e123a0e3f

## 개발 인원 및 기간
- 개발기간 : 2025-09-29 ~ 2025-12-07 (약 2개월) 
- 개발 인원 : 프론트엔드/백엔드 1명 (개인 프로젝트)
- 프론트엔드 GitHub: https://github.com/100-hours-a-week/KTB3-suho-bootboot-frontend

## 기술 스택
### 🔧 Framework & Language
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring data jpa-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  
### 💾 Database
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">

<details>
<summary><h2>📁 프로젝트 구조</h2></summary>
  
```
 src/main/java/kr/adapterz/jpa_suho/
  ├── annotation/
  │   └── swagger/              # Swagger API 문서화 커스텀 어노테이션
  │       ├── AuthenticatedApi.java    # 인증 필요 API 표시
  │       ├── AuthorizedApi.java       # 권한 필요 API 표시
  │       ├── PublicApi.java           # 공개 API 표시
  │       ├── CreateApi.java           # 생성 API 표시
  │       ├── ReadApi.java             # 조회 API 표시
  │       └── DeleteApi.java           # 삭제 API 표시
  │
  ├── config/
  │   └── SecurityConfig.java   # Spring Security 보안 설정
  │                             # - CSRF/CORS 설정
  │                             # - 세션 관리
  │                             # - 인증/인가 규칙
  │
  ├── controller/               # REST API 컨트롤러 계층
  │   ├── AuthController.java  # CSRF 토큰 발급
  │   ├── LoginController.java # 로그인/로그아웃
  │   ├── UserController.java  # 사용자 관리
  │   ├── PostController.java  # 게시글 CRUD
  │   ├── CommentController.java # 댓글 CRUD
  │   └── LikeController.java  # 좋아요 기능
  │
  ├── dto/                      # 데이터 전송 객체 (Request/Response)
  │   ├── common/
  │   │   └── CommonResponse.java      # 공통 응답 형식
  │   ├── user/
  │   │   ├── CreateUserRequest.java
  │   │   ├── CreateUserResponse.java
  │   │   ├── LoginRequest.java
  │   │   ├── GetUserResponse.java
  │   │   ├── ChangePasswordRequest.java
  │   │   ├── ChangeNicknameRequest.java
  │   │   ├── UserInfo.java
  │   │   └── WriterInfo.java
  │   ├── post/
  │   │   ├── CreatePostRequest.java
  │   │   ├── CreatePostResponse.java
  │   │   ├── UpdatePostRequest.java
  │   │   ├── UpdatePostResponse.java
  │   │   ├── GetPostsResponse.java
  │   │   ├── DetailPostResponse.java
  │   │   ├── PostInfo.java
  │   │   ├── DetailStatistic.java
  │   │   └── Pagination.java
  │   ├── comment/
  │   │   ├── CommentRequest.java
  │   │   ├── CommentResponse.java
  │   │   └── CommentItem.java
  │   └── like/
  │       └── CreateLikeResponse.java
  │
  ├── entity/                   # JPA 엔티티 계층
  │   ├── User.java            # 사용자 엔티티
  │   ├── Post.java            # 게시글 엔티티
  │   ├── Comment.java         # 댓글 엔티티
  │   ├── Like.java            # 좋아요 엔티티
  │   └── LikeId.java          # 좋아요 복합키
  │
  ├── repository/               # JPA Repository 계층
  │   ├── UserRepository.java
  │   ├── PostRepository.java
  │   ├── CommentRepository.java
  │   └── LikeRepository.java
  │
  ├── service/                  # 비즈니스 로직 계층
  │   ├── UserService.java
  │   ├── PostService.java
  │   ├── CommentService.java
  │   └── LikeService.java
  │
  ├── exception/                # 예외 처리
  │   ├── GlobalExceptionHandler.java  # 전역 예외 핸들러
  │   └── ForbiddenException.java      # 커스텀 예외
  │
  └── JpaSuhoApplication.java   # Spring Boot 애플리케이션 진입점
```

</details>

## 기능 소개

- 사용자 관리 (회원가입, 로그인, 정보 수정)
- 게시글 관리 (CRUD, 페이지네이션)
- 댓글 관리
- 좋아요 기능

## 인증/보안 구성

 ### 🔐 인증 방식
 - **세션 기반 인증**: 쿠키를 통한 JSESSIONID 관리
  - **Spring Security**: SecurityFilterChain 기반 보안 설정
  - **인증 흐름**:
    1. 로그인 시 사용자 검증 후 SecurityContext에 인증 정보 저장
    2. 세션에 SecurityContext 저장
    3. 이후 요청마다 세션의 인증 정보로 자동 검증

### 🛡️ 보안 기능  

 #### CSRF 보호
  - **방식**: XorCsrfTokenRequestAttributeHandler 사용
  - **토큰 저장**: `XSRF-TOKEN` 쿠키 사용 (HttpOnly: false)
  - **SameSite 정책**: `Lax` 설정으로 외부 사이트 요청 차단
  - **보호 제외 경로**:
    - `/api/v1/login` - 로그인
    - `/api/v1/users` - 회원가입
      
#### CORS 설정
  - **허용 Origin**: `http://localhost:5500` (프론트엔드)
  - **허용 메서드**: GET, POST, PUT, DELETE, PATCH
  - **Credentials**: 쿠키 전송 허용 (`Access-Control-Allow-Credentials:
  true`)
  - **노출 헤더**: Authorization, Content-Type, X-Xsrf-Token

### 🚀 실행 방법

  #### 1. 레포지토리 클론
  ```bash
  git clone
  https://github.com/your-username/KTB3-suho-bootboot-backend.git
  cd KTB3-suho-bootboot-backend/jpa_suho
  ```
 #### 2. 데이터베이스 설정

  MySQL에 데이터베이스를 생성합니다.
  ```
  CREATE DATABASE bootboot;
  USE bootboot;
  ```

  src/main/resorces/application.properties 파일에서 다음과 같이 수정합니다.
  ```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/bootboot?serverTimezone=UTC
    username: your-username
    password: your-passowrd
    driver-class-name: com.mysql.cj.jdbc.Driver
  ```
  - url : localhost 포트 번호 확인 이후, bootboot (사용한 데이터베이스 이름)으로 설정
  - username : database에서 설정한 username으로 설정
  - password : database에서 설정한 password로 설정

  #### 개발 모드 실행
  
  IDE에서 실행 (IntelliJ IDEA)

  1. 프로젝트를 IntelliJ에서 엽니다.
  2. JpaSuhoApplication.java 파일을 찾습니다.
  3. main 메서드 옆의 실행 버튼을 클릭합니다.
