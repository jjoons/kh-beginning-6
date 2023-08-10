package com.kh.spring_legacy.spring_di_mybatis_20230810.model.service;

import java.util.List;
import com.kh.spring_legacy.spring_di_mybatis_20230810.model.vo.Member;

public interface MemberService {
  int joinMember(Member member);

  Member searchMember(String id);

  List<Member> getMemberList();

  int deleteMember(String id);
}
