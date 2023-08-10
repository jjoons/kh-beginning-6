package com.kh.spring_legacy.spring_di_mybatis_20230810;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *  DI (Dependency injection) 의존성주입의 개념 
 *   - 등장 배경 : 서블릿과 같이 복잡한 상속으로 설계된 코드는 결합도 높다 
 *              코드 유지보수의 어려움이 발생 
 *              강한 결합도를 갖는 경우 코드부 수정이 다른 코드에 영향을 미칠수 있다.
 *   
 *   상속개념 완전 배재 불가. 상속으로 설계된 이유는 로직부를 프레임워크에서 로드하기 위해 결합도
 *   를 낮추기 위한 IOC 개념을 활용
 *    -> 직접적인 상속은 배제하고 간접적으로 interface 사용 
 *       생성(new 사용)을 배재하고 어노테이션 또는 xml활용 
 * 
 *    -> DI의 개념은 사용자가 직접 객체 생성하지 않고 프레임워크에서 사용자가 만든 객체를 직접 생성하여
 *       프로그램에 주입시킴 
 *   -> 프레임 워크에서 사용자가 만든 객체 생성을 제한하여 의존성을 최대한 낮추는 방향으로 설계된다.
 *   --> 장점: 느슨한 결합구조로 코드의 간결성, 유지보수성 증가, 상속에 의한 복잡성을 감소 
 *   --> 단점: DI 사용을 위해 java 외의 어노테이션 표기와 xml코드의 코드부가 증가 할 수있다.
 *    --> 단점을 극복하고자...xml를 걷어내기 위해서 (spring boot)
 * 
 *  DI를 활용하기 위한 MVC 주요 레이어에 붙는 어노테이션
 *  @Controller : url 처리가 가능한 Controller에 붙는다.
 *  @Service : 비지니스 로직 처리를 위한 서비스 계층에 붙는다.
 *  @Repository: DB나 Data처리가 가능한 계층(주로 DAO)에 붙는다.
 *  @Component : 계층이 아닌 일반 객체를 생성할 때 사용하는 어노테이션!
 *  
 *  DI를 통한 객체 생성시 활용 어노테이션 
 *  @AutoWwired : new 키워드 대신 객체를 생성할 때 사용한다.
 *  @Value : 단순 값을 주입할 때 사용한다.
 *  @Resource: 자원 연결시 사용, 주로 프로퍼티에 사용한다.
 * 
 * 
 */
@Controller
public class HomeController {
  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "redirect:/member/index.do";
  }
}
