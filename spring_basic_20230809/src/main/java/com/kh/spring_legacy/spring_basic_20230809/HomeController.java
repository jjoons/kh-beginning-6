package com.kh.spring_legacy.spring_basic_20230809;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Spring MVC 개념 정리
 *   Spring은 서블릿 대비 어노테이션의 활용도가 높아졌다
 *   Spring 프레임워크는 상속 설계를 지양하고 interface 기반 설계를 권장한다
 *   Dependency injection(의존성 주입)을 통해 객체를 직접 생성하지 않고
 *   Spring에서 생성하고 주입시킴. new 키워드를 지양하고 프레임워크에서 대신 생성함.
 *   장점: 의존성이 좋고 메모리 관리가 우수하다
 *   
 *   Spring MVC는 철저하게 MVC 2 패턴을 사용하도록 설계되어있다
 *     Request(URL + 파라미터) > Controller(Java 객체) + Model > View (JSP or Thymeleaf)
 *     
 *   서블릿 class 단위로 URL을 매핑했던 기능이 @Controller에 핸들러 메소드로 이전
 *   
 *   WEB-INF 구조 (보안) 기능으로 인해 URL을 통해 직접적인 접근이 불가능하며
 *   반드시 Controller에서 view로 접근이 필요하다
 *   
 */
// 컨트롤러임을 알리는 어노테이션. Servlet class 기능을 대체함
@Controller
public class HomeController {

  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  /*
   * 핸들러 메소드 (Handler Method)
   *   - URL 매핑이 되어있는 메소드를 지칭, 특정 단위 하나의 기능을 담당하는 것이 일반적
   *   
   *   return 값이 문자열일 경우 기본적으로 forward되는 JSP 페이지를 지칭한다
   *   매핑되는 URL은 주로 .do를 붙여서 특정 행위에 대한 처리를 담당시킨다
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);

    Date date = new Date();
    DateFormat dateFormat =
        DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

    String formattedDate = dateFormat.format(date);

    model.addAttribute("serverTime", formattedDate);

    return "home";
  }

  /*
   * URL 매핑시키는 간단한 방법
   */
  @RequestMapping(value = "home2.do")
  public String home2() {
    // /WEB-INF/views/home2.jsp 로 forward로 전달됨
    return "home2";
  }

  // 메소드 이름(home2)과 가장 유사한 JSP로 연결한다
  // @RequestMapping(value = "home2.do")
  // public void home2() {}

  // home3 메소드에서 home2.do 호출하고 싶을 경우
  @RequestMapping(value = "home3.do")
  public String home3() {
    /*
     * 리턴값을 home2.do로 하면
     * /WEB-INF/views/home2.do.jsp 로 forward로 전달된다.
     * 주소가 잘못되어 오류가 발생할 수 있다
     * 
     * redirect: 를 통해 전달
     */
    return "redirect:home2.do";
  }
}
