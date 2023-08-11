package com.kh.spring_legacy.spring_mvc2_20230810.member.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.kh.spring_legacy.spring_mvc2_20230810.member.model.vo.Member;
import com.kh.spring_legacy.spring_mvc2_20230810.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Controller
// loginMember를 model에서 처리할 때 세션으로 처리할 수 있도록 도와주는 어노테이션
@SessionAttributes(value = "loginMember")
@Slf4j
public class MemberController {
  @Autowired
  private MemberService service;

  @PostMapping(value = "/login")
  public String login(Model model, String userId, String userPwd) {
    Member loginMember = this.service.login(userId, userPwd);

    if (loginMember != null) {
      model.addAttribute("loginMember", loginMember);
      return "redirect:/";
    }

    model.addAttribute("msg", "아이디나 비밀번호를 잘못 입력했습니다");
    model.addAttribute("location", "/");

    return "common/msg";
  }

  // 로그아웃
  public String logout() {

  }

  // 가입 페이지 요청
  @GetMapping(value = "/member/enroll")
  public String enrollPage() {
    return "member/enroll";
  }

  // 중복 확인 (Ajax 회원 아이디 확인)
  @GetMapping(value = "/member/idCheck")
  public ResponseEntity<Map<String, Object>> idCheck(String id) {
    boolean result = this.service.validate(id);

    Map<String, Object> map = new HashMap<>();
    map.put("validate", result);


    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping(value = "/member/update")
  public String update(
      Model model,
      @ModelAttribute Member updateMember,
      @SessionAttribute(name = "loginMember", required = false) Member loginMember) {
    if (loginMember == null || !loginMember.getId().equals(updateMember.getId())) {
      model.addAttribute("msg", "잘못된 접근입니다");
      model.addAttribute("location", "/");

      return "common/msg";
    }

    updateMember.setNo(loginMember.getNo());
    int result = this.service.save(updateMember);

    if (result > 0) {
      model.addAttribute("loginMember", this.service.findById(loginMember.getId()));
      model.addAttribute("msg", "회원 정보를 수정했습니다");
      model.addAttribute("location", "/member/view");
    }

    model.addAttribute("msg", "회원 정보를 수정하지 못 했습니다");
    model.addAttribute("location", "/member/view");

    return "common/msg";
  }

  @GetMapping(value = "/member/view")
  public String memberView() {
    return "member/view";
  }

  @GetMapping(value = "/member/updatePwd")
  public String updatePwdPage() {
    return "member/updatePwd";
  }
}
