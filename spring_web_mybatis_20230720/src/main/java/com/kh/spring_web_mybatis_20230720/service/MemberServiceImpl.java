package com.kh.spring_web_mybatis_20230720.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.spring_web_mybatis_20230720.dao.MemberDAO;
import com.kh.spring_web_mybatis_20230720.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
  @Autowired
  private MemberDAO memberDAO;

  @Override
  public List<MemberVO> listMembers() throws Exception {
    List<MemberVO> memberList = null;
    memberList = memberDAO.selectAllMemberList();

    return memberList;
  }

  @Override
  public int addMember(MemberVO memberVO) throws Exception {
    return this.memberDAO.insertMember(memberVO);
  }

  @Override
  public MemberVO login(MemberVO memberVO) throws Exception {
    return null;
  }

  @Override
  public int removeMember(String id) throws Exception {
    return 0;
  }
}
