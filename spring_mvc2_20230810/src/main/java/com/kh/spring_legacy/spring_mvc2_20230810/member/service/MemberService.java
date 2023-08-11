package com.kh.spring_legacy.spring_mvc2_20230810.member.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.spring_legacy.spring_mvc2_20230810.member.mapper.MemberMapper;
import com.kh.spring_legacy.spring_mvc2_20230810.member.model.vo.Member;

@Service
public class MemberService {
  @Autowired
  private MemberMapper mapper;

  public boolean validate(String userId) {
    return this.findById(userId) != null;
  }

  public Member login(String id, String pw) {
    /*
     * 로그인할 때 아이디 값으로 가지고 와서
     * 데이터베이스에 있는 내용을 확인하고 결과를 반환함
     */
    Member member = this.mapper.selectMember(id);

    /* admin 테스트를 위한 코드 */
    if (id.equals("admin")) {
      return member;
    }

    if (member == null) {
      return null;
    }

    return member;
  }

  public int save(Member member) {
    int result = 0;

    if (member.getNo() == 0) {
      result = mapper.insertMember(member);
    } else {
      // 회원 수정
      result = mapper.updateMember(member);
    }

    return result;
  }

  public Member findById(String id) {
    return this.mapper.selectMember(id);
  }

  public int delete(int no) {
    return this.mapper.deleteMember(no);
  }

  public int updatePwd(Member logMember, String userPw) {
    Map<String, String> map = new HashMap<>();
    map.put("no", Integer.toString(logMember.getNo()));
    map.put("newPwd", userPw);

    return this.mapper.updatePwd(map);
  }
}
