package com.kh.spring_web_mybatis_20230720.service;

import java.util.List;
import com.kh.spring_web_mybatis_20230720.vo.MemberVO;

public interface MemberService {
  public List<MemberVO> listMembers() throws Exception;

  public int addMember(MemberVO memberVO) throws Exception;

  public MemberVO login(MemberVO memberVO) throws Exception;

  public int removeMember(String id) throws Exception;
}
