package com.kh.spring_xml_in_20230714;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/*
 * Java 파일에서 XML 파일의 bean 설정 정보를 읽어오려면 어노테이션을 사용하면 된다
 * 
 */

@ImportResource("classpath:applicationCTX2.xml")
@Configuration
public class ApplicationConfig {
  /*
   * DI (Dependency Injection)
   *   - 클래스 간 의존 관계를 스프링 컨테이너가 자동으로 연결해 주는 것
   * 
   * 어노테이션 (@)
   *   - 스프링에서 bean 인스턴스가 생성된 이후 @Autowired 를 설정한 메소드가 자동으로 호출되고
   *     인스턴스가 자동으로 주입된다
   *   - 해당 변수 혹은 메소드가 스프링이 관리하는 Bean을 자동으로 매핑해 주는 개념이다
   *   
   * ApplicationConfig는 DI 설정에 사용되는 클래스라는 것을 Spring에게 알려준다
   * 
   * <bean id="" class="" />
   * 적당한 이름의 메소드를 생성한 뒤 @Bean 어노테이션을 붙이면 Bean을 설정하는 XML 파일
   * <bean /> 태그 역할을 한다는 것을 spring에게 알려준다
   * 
   * @Bean
   * public 리턴타입[class 속성값 => 클래스 이름만] 메소드이름[id 속성값]() {
   *   생성자나 setter 메소드를 이용해서 bean을 초기화하는 작업을 실행한다
   *   return bean객체;
   * }
   */

  // @Bean(initMethod = "init", destroyMethod = "close")
  // 처럼 인터페이스를 통해 구현하지 않고 메소드명을 따로 지정할 수 있다
  @Bean
  public Student student() {
    ArrayList<String> hobbies = new ArrayList<>();
    hobbies.add("바둑");
    hobbies.add("골프");
    hobbies.add("테니스");

    Student student = new Student("홍길동", 20, hobbies);
    student.setHeight(178);
    student.setWeight(80);

    // 초기화된 빈을 리턴한다
    return student;
  }

  /*
  @PostConstruct
  public void init() {}
  */
  /*
  @PreDestroy
  public void close() {}
  */
}
