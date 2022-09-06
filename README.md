# egovWebWatcher
표준프레임워크로 웹 와쳐 구현

## 기간

2022-09-01 ~


## 기술 스택

### 백 엔드
- 아파피 톰켓 : 8.5
- 자바 : 1.8 jdk
- 표준프레임워크 : 3.10.0
- 스프링 : 4.3.25
- MySql : 8.0

### 프론트 엔드
- HTML5
- CSS3
- jQeury
- Material Design Lite

### CD/CI
- Git

### 배포

- heroku

https://egov-web-watcher.herokuapp.com/


## 로그

### 2022-09-01 
- clear db 연동
- heroku 최초 배포
- 프로젝트 생성 및 sample page 작성
- 깃 연동

### 2022-09-02
- 테스팅 결과 데이터 추출 및 전처리 (22953 line)
  * clearDB 무료는 시간당 가능 쿼리 횟수가 3600 이므로 데이터를 나누어서 등록할 필요가 있음 
  
### 2022-09-04
- 테스팅 결과 데이터 등록(~800)

### 2022-09-06
- login, site 테이블 db에 추가
- 사이트 패키지 추가
- 모든 사이트 리스트 출력 기능 추가
- ibatis dtd 설치 경로 변경으로인한 에러 해결
- 공통 VO commonVO 추가
  * seq, 생성/변경/삭제 column을 가지고 있는 객체
- 공통 service commonSerivce 추가
  * 현재 시간을 이용해서 ctime/cdate, utime/udate, dtime/udate 값을 설정해주는 매소드 추가
