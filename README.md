# Photo Album

## 1️⃣ 개발 환경

### 🛠️ Backend
- Java 17
- Spring boot 3.2.3
- MySQL 8.0.32
- JPA / Hibernate
- Thymeleaf

### 🛠 IDE, Tools
- IntelliJ Ultimate
- Postman
- Sourcetree

---
## 2️⃣ 기능 목록

### 1) 유저 관련
- 로그인
- 회원가입

### 2) 앨범 관련
- 앨범 생성
- 앨범 목록 조회
- 앨범 정렬 후 조회
- 앨범 기본 정보 조회
- 앨범 이름 변경
- 앨범 삭제

### 3) 사진 관련
- 사진 업로드
- 사진 목록 조회
- 사진 상세 정보 조회
- 앨범 이동
- 사진 다운로드
- 사진 삭제

---
## 3️⃣ API Document

### 1) 유저 관련
- 로그인
- 회원가입

### 2) 앨범 관련
- 앨범 생성
  - `POST /albums`
- 앨범 목록 조회
    - `GET /albums`
- 앨범 정렬 후 조회
    - sort : string
    - keyword : string
- 앨범 기본 정보 조회
    - `GET /albums/{albumId}`
- 앨범 이름 변경
  - `PUT /albums/{albumId}`
- 앨범 삭제
    - `DELETE /albums/{albumId}`

### 3) 사진 관련
- 사진 업로드
  - `POST /albums/{albumId}/photos`
- 사진 목록 조회
    - `GET /albums/{albumId}/photos`
- 사진 상세 정보 조회
    - `GET /albums/{albumId}/photos/{photoId}`
- 앨범 이동
    - `PUT /albums/{albumId}/photos/move`
- 사진 다운로드
    - `GET /albums/{albumId}/photos/download`
- 사진 삭제
    - `DELETE /albums/{albumId}/photos`

---
## 4️⃣ ERD

![image](https://github.com/junseoparkk/today-my-school-back/assets/98972385/423ecbb3-6728-4095-89c2-ae4fb55212f7)
