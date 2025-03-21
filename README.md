# SPRING PLUS 과제

## 1. Level 1) 코드 개선 퀴즈-@Transactional의 이해
에러가 발생하지 않고 정상적으로 할 일을 저장할 수 있도록 코드 수정
![image](https://github.com/user-attachments/assets/1ad2c70a-03b3-45a1-ab20-7271efc6bb3d)
->Transactional 추가

## 2. Level 1) 코드 추가 퀴즈 - JWT의 이해
- User 테이블에 nickname 컬럼 추가
- nickname은 중복 가능
- JWT에서 유저의 닉네임을 꺼내 화면에 보여줌

## 3. Level 1) 코드 개선 퀴즈 -  JPA의 이해
- 할 일 검색 시 weather 조건으로도 검색
- 할 일 검색 시 수정일 기준으로 기간 검색 가능
- JPQL 사용하고 쿼리 메소드 명은 너무 길지 않게 지정
![image](https://github.com/user-attachments/assets/813a4b56-cc2c-4e5b-8059-8cc58a664781)

## 4. Level 1) 테스트 코드 퀴즈 - 컨트롤러 테스트의 이해
- 테스트 패키지 org.example.expert.domain.todo.controller의 todo_단건_조회_시_todo가_존재하지_않아_예외가_발생한다() 테스트가 실패
- 테스트가 정상적으로 수행되어 통과할 수 있도록 테스트 코드 수정
![image](https://github.com/user-attachments/assets/a464eab6-23ca-4cb2-8ebd-428335b13697)
-> BAD_REQUEST로 변경

## 5. Level 1) 코드 개선 퀴즈 - AOP의 이해
- AdminAccessLoggingAspect 클래스에 있는 AOP가 개발 의도에 맞도록 코드를 수정
![image](https://github.com/user-attachments/assets/c6d3443d-45cc-4050-ba55-edefcdcf7562)
-> @After를 @Before로 변경

## 6. Level 2) JPA Cascade
- JPA의 cascade 기능을 활용해 할 일을 생성한 유저가 담당자로 등록될 수 있게 코드 수정
![image](https://github.com/user-attachments/assets/6e27cc8e-a9c5-49a9-b83d-b558ff989f96)

## 7. Level 2) N+1
- CommentController 클래스의 getComments() API를 호출할 때 N+1 문제가 발생하는 것 해결
![image](https://github.com/user-attachments/assets/1e72e97a-6a38-40df-a4fe-8b15a98b6ea9)

## 8. Level 2) QueryDSL
- findByIdWithUser 를 QueryDSL로 변경
- JPAConfiguration과 TodoQueryRepository,TodoQueryRepositoryImpl 추가

## 9. Level 2) Spring Security
- 기존 Filter와 Argument Resolver를 사용하던 코드들을 Spring Security로 변경
- 접근 권한 및 유저 권한 기능은 그대로 유지하고 권한은 Spring Security의 기능 사용
- token 기반 인증 방식은 유지하고 JWT도 그대로 사용

## 10. Level 3) QueryDSL 을 사용하여 검색 기능 만들기
- 일정 검색하는 기능 생성
- 검색 기능의 성능 및 사용성 높이기 위해 QueryDSL 활용한 쿼리 최적화
- Projections 활용하여 필요한 필드만 반환
- 검색 키워드로 일정의 제목을 검색 가능
- 일정의 생성일 범위로 검색 가능
- 담당자의 닉네임으로 검색 가능
- 검색 결과 반환 시 일정의 제목, 해당 일정의 담당자 수, 해당 일정의 총 댓글 개수 반환
- 검색 결과는 페이징 처리되어 반환

## 11. Level 3) Transaction 심화
- 매니저 등록 요청 시 로그를 남기되 매니저 등록과 로그 기록이 각각 독립적으로 처리될 수 있게함
- 매니저 등록은 실패할 수 있지만 로그는 반드시 저장
- 로그 생성 기간 필요

