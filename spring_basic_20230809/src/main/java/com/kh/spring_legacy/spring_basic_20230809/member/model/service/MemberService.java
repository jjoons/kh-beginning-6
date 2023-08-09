package com.kh.spring_legacy.spring_basic_20230809.member.model.service;

import java.util.List;
import com.kh.spring_legacy.spring_basic_20230809.member.model.vo.Member;

public interface MemberService {
  int joinMember(Member member);

  List<Member> getAllList();

  Member login(String id);
}
