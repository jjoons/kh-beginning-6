package com.kh.spring_web_mybatis_20230720.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.kh.spring_web_mybatis_20230720.vo.MemberVO;

public interface MemberDAO {
  public List<MemberVO> selectAllMemberList() throws DataAccessException;

  public int insertMember(MemberVO memberVO) throws DataAccessException;

  public MemberVO loginById(MemberVO memberVO) throws DataAccessException;

  public int deleteMember(String id) throws DataAccessException;
}
