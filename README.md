# 과제 제출 필수 사항

### 1. 지원자의 성명
    - 왕준수
    
### 2. 애플리케이션의 실행 방법 (엔드포인트 호출 방법 포함)

### 3. 데이터베이스 테이블 구조
    - ![image](https://github.com/wnstn819/wanted-pre-onboarding-backend/assets/48230951/efa7c1ab-059d-4937-9b52-58c2b003834b)
    
### 4. 구현한 API의 동작을 촬영한 데모 영상 링크

### 5. 구현 방법 및 이유에 대한 간략한 설명

### 6. API 명세(request/response 포함)

**회원가입 (api/v1/join)**

- Request 
```
{
    "email":"test@naver.com",
    "password" : "123412357"
}
```

- Response
    - success
      ```
      {
        "data": null,
        "message": "성공",
        "code": "success"    
      }
      
      ```
    - fail
      ```
      이메일 유효성 검사
      {
        "code": "fail",
        "message": "이메일에 @가 포함되지 않았습니다. 다시 입력해주세요!"
      }
      비밀번호 유효성 검사
      {
        "code": "fail",
        "message": "비밀번호를 8자 이상 입력해주세요!"
      } 

      이메일 중복 검사
      {
        "code": "fail",
        "message": "이미 등록된 이메일이 있습니다."
      }
      ```


**로그인 (api/v1/login)**

- Request 
```
{
    "email":"test@naver.com",
    "password" : "123412357"
}
```

- Response
    - success
      ```
      {
        "data": {
          "accessToken":                     
             "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjQsImlhdCI6MTY5MjEzMzc5OSwiZXhwIjoxNjkyMTM3Mzk5fQ.dSF2dIzRj2vK8E9DOI1GvCaoPFnR9QCtUoYhj5YeYWw",
          "refreshToken":         
             "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjQsImlhdCI6MTY5MjEzMzc5OSwiZXhwIjoxNjkyOTk3Nzk5fQ.nNdsbNslCzj1McloPxtaIR_898DSL1c9cnIde2PkI3Q"
        },
        "message": "성공",
        "code": "success"
      }
      
      ```
    - fail
      ```
      이메일 유효성 검사
      {
        "code": "fail",
        "message": "이메일에 @가 포함되지 않았습니다. 다시 입력해주세요!"
      }
      비밀번호 유효성 검사
      {
        "code": "fail",
        "message": "비밀번호가 일치하지 않습니다.!"
      } 

      이메일 검사
      {
        "code": "fail",
        "message": "이미 등록된 이메일이 없습니다."
      }
      ```




# 원티드 프리온보딩 백엔드 인턴십 - 선발 과제
<br></br>
## 1. 과제 안내
### 과제 안내

- 본 과제는 원티드 프리온보딩 백엔드 인턴십 과정 이수를 위한 최소한의 수준을 파악하고, 교육생 선별을 목적으로 합니다.
- 교육생은 Python/Flask, Python/Django, JavaScript/Express, Java/Spring Boot 중 기술 스택을 선택하여, 게시판을 관리하는 RESTful API를 개발하고 그 결과를 제출해야 합니다. (3. API 요구사항 참고)
- 데이터 저장소로는 MySQL 8.0 버전의 관계형데이터베이스를 사용해주세요.
- API의 정상 동작 여부, 작성된 코드의 품질, Git & Github의 사용 수준 등이 평가 기준이 됩니다.
- 요구사항에 맞게 API를 만든 후에 아래의 기능을 추가할 경우 가산점이 주어집니다.
    - 통합 테스트 또는 단위 테스트 코드를 추가한 경우
    - docker compose를 이용하여 애플리케이션 환경을 구성한 경우 (README.md 파일에 docker-compose 실행 방법 반드시 기입)
    - 클라우드 환경(AWS, GCP)에 배포 환경을 설계하고 애플리케이션을 배포한 경우 (README.md 파일에 배포된 API 주소와 설계한 AWS 환경 그림으로 첨부) 
- 진행 중 발생하는 문의사항은 이 레포지토리의 Issue로 등록해주세요.

### 과제 제출 필수 사항

- 과제의 소스코드는 반드시 본인의 GitHub 레포지토리에 **Public**으로 설정하여 업로드 해주세요.
- 레파지토리의 이름은 `wanted-pre-onboarding-backend`로 지정해야 합니다.
- README.md 파일에는 다음과 같은 사항들이 포함되어야 합니다:
    - 지원자의 성명
    - 애플리케이션의 실행 방법 (엔드포인트 호출 방법 포함)
    - 데이터베이스 테이블 구조
    - 구현한 API의 동작을 촬영한 데모 영상 링크
    - 구현 방법 및 이유에 대한 간략한 설명
    - API 명세(request/response 포함)
- 과제 제출은 참가 신청 시 수행한 과제의 레포지토리 주소를 제출하면 됩니다.

<br></br>
## 2. 주의 사항
- 제출한 링크가 잘못되었거나, 레파지토리에 접근할 수 없는 경우에는 탈락 처리됩니다.
- “과제 제출 필수 사항”을 준수하지 않을 경우에도 탈락 처리됩니다.
- 레파지토리에 접속했을 때 바로 소스코드가 보일 수 있도록 해주세요. 불필요한 depth는 허용되지 않습니다.
- 과제 제출 후에는 코드 변경을 지양해주시고, 평가와 무관하게 수정을 하고 싶을 경우 default branch(master or main)가 아닌 별도의 브랜치에서 작업해주세요.

<br></br>
## 3. API 요구 사항
게시판을 관리하는 RESTful API를 개발해 주세요. 이때, 다음의 기능을 구현해야 합니다. 데이터베이스의 테이블 설계는 지원자분의 판단에 맡겨져 있습니다. 요구사항을 충족시키는 데 필요하다고 생각되는 구조로 자유롭게 설계해 주세요.

- **과제 1. 사용자 회원가입 엔드포인트**
    - 이메일과 비밀번호로 회원가입할 수 있는 엔드포인트를 구현해 주세요.
    - 이메일과 비밀번호에 대한 유효성 검사를 구현해 주세요.
        - 이메일 조건: **@** 포함
        - 비밀번호 조건: 8자 이상
        - 비밀번호는 반드시 암호화하여 저장해 주세요.
        - 이메일과 비밀번호의 유효성 검사는 위의 조건만으로 진행해 주세요. 추가적인 유효성 검사 조건은 포함하지 마세요.
- **과제 2. 사용자 로그인 엔드포인트**
    - 사용자가 올바른 이메일과 비밀번호를 제공하면, 사용자 인증을 거친 후에 JWT(JSON Web Token)를 생성하여 사용자에게 반환하도록 해주세요.
    - 과제 1과 마찬가지로 회원가입 엔드포인트에 이메일과 비밀번호의 유효성 검사기능을 구현해주세요.
- **과제 3. 새로운 게시글을 생성하는 엔드포인트**
- **과제 4. 게시글 목록을 조회하는 엔드포인트**
    - 반드시 Pagination 기능을 구현해 주세요.
- **과제 5. 특정 게시글을 조회하는 엔드포인트**
    - 게시글의 ID를 받아 해당 게시글을 조회하는 엔드포인트를 구현해 주세요.
- **과제 6. 특정 게시글을 수정하는 엔드포인트**
    - 게시글의 ID와 수정 내용을 받아 해당 게시글을 수정하는 엔드포인트를 구현해 주세요.
    - 게시글을 수정할 수 있는 사용자는 게시글 작성자만이어야 합니다.
- **과제 7. 특정 게시글을 삭제하는 엔드포인트**
    - 게시글의 ID를 받아 해당 게시글을 삭제하는 엔드포인트를 구현해 주세요.
    - 게시글을 삭제할 수 있는 사용자는 게시글 작성자만이어야 합니다.
