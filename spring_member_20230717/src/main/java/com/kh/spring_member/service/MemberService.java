package com.kh.spring_member.service;

import com.kh.spring_member.dao.MemberDAO;
import com.kh.spring_member.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberService {
  private MemberDAO dao = null;

  public MemberService(MemberDAO dao) {
    this.dao = dao;
  }

  public boolean login(String id, String password) {
    if (id == null || password == null) {
      return false;
    }

    int result = this.dao.checkIdPassword(id, password);

    return result == 1;
  }

  public boolean join(String id, String password, String email) {
    if (id == null || password == null || email == null) {
      return false;
    }

    if (this.dao.checkDuplicateId(id) > 0) {
      return false;
    }

    MemberDTO dto = MemberDTO.builder().id(id).password(password).email(email).build();

    return this.dao.join(dto) == 1;
  }

  public boolean update(String id, String password) {
    if (id == null || password == null) {
      return false;
    }

    int result = this.dao.update(id, password);
    return result == 1;
  }
}
