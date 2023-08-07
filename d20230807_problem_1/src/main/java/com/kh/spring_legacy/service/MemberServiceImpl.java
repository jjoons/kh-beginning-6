package com.kh.spring_legacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.kh.spring_legacy.dao.MemberDAO;
import com.kh.spring_legacy.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired
  private MemberDAO memberDAO;

  public String memberLoginPro(String id, String pw, Model model) {
    Member member = this.memberDAO.getMemberById(id);

    if (member == null || !member.getMemberPwd().equals(pw)) {
      model.addAttribute("msg", "로그인 실패");
      return "";
    }

    model.addAttribute("msg", member.getMemberName() + "님 환영합니다.");
    return "";
  }
}
