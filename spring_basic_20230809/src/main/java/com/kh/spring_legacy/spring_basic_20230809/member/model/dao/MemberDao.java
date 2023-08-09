package com.kh.spring_legacy.spring_basic_20230809.member.model.dao;

import java.util.List;
import com.kh.spring_legacy.spring_basic_20230809.member.model.vo.Member;

public interface MemberDao {
  int insertMember(Member member);

  List<Member> selectAll();

  Member selectById(String id);
}
