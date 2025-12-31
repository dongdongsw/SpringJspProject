package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 *     Spring-Boot
 *     ------------
 *     Maven / Gradle
 *           | 프로젝트 빌드 / 테스트 / 라이브러리 / 배포 자동처리 기능
 *           | 소스 코드를 실행 가능한 프로그램으로 만들어주는 도구 
 *     1. 프로젝트 구조
 *        => ThymeLeaf
 *          => resource
 *             | static : CSS / JS / Image
 *             | templates : HTML
 *       => JSP 
 *          | main => webapp => WEB-INF => JSP
 *          | 자동 생성이 아니다 (직접 => 폴더) => JSP ThymeLeaf권장 
 *       => Spring Boot보다 Spring Framework 
 *     2. DI (의존성 주입) : @Autowired => @RequiredArgsConstructor
 *       객체 중심 => 스프링에서 생성된 객체 주소를 대입 
 *       public class A
 *       {
 *          @Autowired
 *          private B b; => 속도의 문제 => private를 해제 => 주소 주입
 *          => 객체지향의 캡슐화가 무력화 
 * 
 *          public A(B b)
 *          public A(B b)
 *          {
 *           this.b=b;
 *          }
 * 
 *          @RequiredArgsConstructor : lombok
 *       }
 * 
 *       => 주입(객체생성시에 필요한 데이터를 추가)
 *          = setter
 *          = constructor
 *       => 큰의미 : 클래스와 클래스간의 연관 설정 => IoC => DI
 *       => Annotation
 *          ------------------- 기능별 클래스 분리
 *          @Controller
 *          @RestController
 *          ------------------- 브라우저와 연동 (값 전송 / 화면 변경)
 *                         DispatcherServlet
 *          @Repository : 테이블당 1개 설정 
 *          @Service : 부가적 추가 내용 / Repository 여러개 통합 
 *                  ------------------------------------
 *                    BI
 *          ------------------- 데이터베이스 관련
 *          @ControllerAdvice
 *          ------------------- 메모리를 할당 (스프링에서 객체 생성)
 *       => MVC
 *       => 일반 게시판 
 *     2. AOP
 *       => 반복수행된  기능을 모아서 자동화 처리 
 *       => 어떤 메소드에 적용 
 *          execution("* com.sist.web.MainController.main(.String)")
 *       => 메소드 호출 위치 : PointCut
 *          public Stirng aaa()
 *          {
 *            ------------------------- @Before
 *            try
 *            {
 *              -----------------| @Around
 * 
 *                처리
 * 
 *              -----------------| @Around
 *                
 *            }catch(Exception e)
 *            {
 *              ---------- @AfterThrowing
 *            }
 *            finally
 *            {
 *              ---------- @After
 *            }
 * 
 *            return ""  ---------- @AfterReturning
 * 
 *         }
 *         사용자 정의는 거의 없다 : 응용 : Transaction =>
 *                              => @transactional
 *                              @Around
 *                              -------------setAutoCommit(false)
 *                              SQL 처리
 *                              SQL 처리
 *                              --------------commit()
 *                              @AfterThroing --- rollback()
 *                              @After ----- setAutoCommit(true)
 *         => Security : 인가 / 인증 / 권한 부여
 *         => 로그 파일 
 *         ---------------------------------------- 초급
 *       3. 중급
 *         데이터베이스 관련
 *         = ORM / OXM 
 *          | MyBatis / JPA
 *                   => 메소드 규칙 
 *                   => JOIN (관계) 1:N , N:M
 *                   => 개인 프로젝트 Spring-Boot / JPA / MySQL
 *            => Procedure / Function / Trigger : ERP
 *            => 동적 쿼리 
 *          공통 예외처리 
 *          인터셉트 
 * 
 *          user ======= DispatcherServlet ===== HandlerMapping
 *                                         | ==> interceptor
 *                                         | ==> 자동 로그인
 *                                       @Controller
 *                                       @RestController
 *                                         |
 *                                       DispatcherServlet
 *                                         | ==> interceptor
 *                                       ViewResolver
 *                                         | ==> interceptor
 *                                           ==> 로그인후에 사용 
 *                                        JSP/HTML
 *          --------------------------------- remember-me
 *          => 회원 가입 / 로그인
 *          => 페이징 / 검색 
 *       -------------------------------------------------------------
 *        취업 수준(실무) 
 *        => spring security : 일반 / JWT (카카오,구글)
 *        => Rest API 
 *        => 테스트
 *          JUnit
 *        => 파일 업로드
 *        => Swagger : Rest API 설계 / 문서화 테스트 
 *                  ------------ 표준화 / 개발자간의 의사소통 
 *        => application.yml
 *        ------------------------------------------------
 *        Docker / EC2 / RDS / CI/CD 
 * 
 *        ------------------------------------------------
 *        ****Security / Batch / Kafka / WebSocket : 선택 (옵션)
 *        ------------------------------------------------
 * 
 *        Front
 *          = 자바스크립트
 *          = Jquery (Ajax)
 *          = VueJS == Vuex/Pinia
 *          ***= React == Redux / tanStack-Query 
 *          ---------------------------------
 *          ***| NodeJS / NextJS / TypeScript
 *          ----------------------------------------------
 *          
 */
@SpringBootApplication
public class SpringJspProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJspProjectApplication.class, args);
	}

}
