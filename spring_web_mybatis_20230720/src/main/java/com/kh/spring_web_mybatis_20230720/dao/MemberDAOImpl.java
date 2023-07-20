package com.kh.spring_web_mybatis_20230720.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.kh.spring_web_mybatis_20230720.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
  @Autowired
  private SqlSession sqlSession;

  @Override
  public List<MemberVO> selectAllMemberList() throws DataAccessException {
    List<MemberVO> memberList = null;
    memberList = sqlSession.selectList("mapper.member.selectAllMemberList");

    return memberList;
  }

  @Override
  public int insertMember(MemberVO memberVO) throws DataAccessException {
    return this.sqlSession.insert("insertMember", memberVO);
  }

  @Override
  public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
    return null;
  }

  @Override
  public int deleteMember(String id) throws DataAccessException {
    return 0;
  }
}
