package com.kh.spring_legacy.spring_di_mybatis_20230810.model.service;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.spring_legacy.spring_di_mybatis_20230810.model.dao.MemberDAO;
import com.kh.spring_legacy.spring_di_mybatis_20230810.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired
  private MemberDAO dao;

  /*
   * 마이바티스를 연결하기 위해서 sqlSession 객체를 생성해야한다
   */
  private SqlSessionTemplate session;

  @Override
  public int joinMember(Member member) {
    return dao.insertMember(member);
  }

  @Override
  public List<Member> getAllList() {
    return dao.selectAll();
  }

  @Override
  public Member login(String id) {
    return dao.selectById(id);
  }
}
