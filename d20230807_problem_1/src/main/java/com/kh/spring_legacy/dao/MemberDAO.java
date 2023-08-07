package com.kh.spring_legacy.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kh.spring_legacy.vo.Member;

@Repository
public class MemberDAO {
  @Autowired
  private SqlSessionTemplate sessionTemplate;

  public Member getMemberById(String id) {
    return this.sessionTemplate.selectOne("selectMemberById", id);
  }
}
