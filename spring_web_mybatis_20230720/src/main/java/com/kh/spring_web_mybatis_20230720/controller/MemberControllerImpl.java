package com.kh.spring_web_mybatis_20230720.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.kh.spring_web_mybatis_20230720.service.MemberService;
import com.kh.spring_web_mybatis_20230720.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
  @Autowired
  private MemberService memberService;

  @RequestMapping(value = "/member/joinForm")
  public ModelAndView joinForm(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    String viewName = getViewName(request);
    ModelAndView mav = new ModelAndView(viewName);

    return mav;
  }

  @Override
  @RequestMapping(value = "/member/listMembers")
  public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    String viewName = getViewName(request);
    List<MemberVO> membersList = memberService.listMembers();
    ModelAndView mav = new ModelAndView(viewName);
    mav.addObject("memberList", membersList);

    return mav;
  }

  @Override
  @RequestMapping(value = "/member/joinPro")
  public ModelAndView addMember(MemberVO memberVO, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    // 인코딩

    int result = 0;
    result = memberService.addMember(memberVO);
    ModelAndView mav = new ModelAndView("redirect:/member/listMembers");

    return mav;
  }

  @Override
  public ModelAndView login(MemberVO memberVO, HttpServletRequest request, RedirectAttributes rAttr,
      HttpServletResponse response) throws Exception {
    return null;
  }

  @Override
  public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    return null;
  }

  private String getViewName(HttpServletRequest request) throws Exception {
    String contextPath = request.getContextPath();
    String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
    if (uri == null || uri.trim().equals("")) {
      uri = request.getRequestURI();
    }

    int begin = 0;
    if (!((contextPath == null) || ("".equals(contextPath)))) {
      begin = contextPath.length();
    }

    int end;
    if (uri.indexOf(";") != -1) {
      end = uri.indexOf(";");
    } else if (uri.indexOf("?") != -1) {
      end = uri.indexOf("?");
    } else {
      end = uri.length();
    }

    String viewName = uri.substring(begin, end);
    if (viewName.indexOf(".") != -1) {
      viewName = viewName.substring(0, viewName.lastIndexOf("."));
    }
    if (viewName.lastIndexOf("/") != -1) {
      viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
    }
    return viewName;
  }
}
