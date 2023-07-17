package com.kh.spring_member.dao;

import java.util.ArrayList;
import java.util.List;
import com.kh.spring_member.dto.MemberDTO;

public class MemberDAO {
  private List<MemberDTO> list = new ArrayList<>();

  public MemberDAO() {
    //    String [] id = {"test" , "koreait" , "stst" , "jsp" }; 
    //    String[] name = {"이만수" , "김철수" ,"이영희" , "유재석"};
    //    int [] num = {1001, 1002, 1003 , 1004};

    this.list.add(new MemberDTO(1001, "test", "1234", "test@example.com"));
    this.list.add(new MemberDTO(1002, "koreait", "1234", "koreait@example.com"));
    this.list.add(new MemberDTO(1003, "stst", "1234", "stst@example.com"));
    this.list.add(new MemberDTO(1004, "jsp", "1234", "jsp@example.com"));
  }

  public int checkIdPassword(String id, String password) {
    int result = 0;

    for (MemberDTO dto : this.list) {
      if (dto.getId().equals(id) && dto.getPassword().equals(password)) {
        result++;
      }
    }

    return result;
  }

  public int checkDuplicateId(String id) {
    int result = 0;

    for (MemberDTO dto : this.list) {
      if (dto.getId().equals(id)) {
        result++;
      }
    }

    return result;
  }

  public int join(MemberDTO dto) {
    this.list.add(dto);
    return 1;
  }

  public MemberDTO findById(String id) {
    MemberDTO result = null;

    for (MemberDTO dto : this.list) {
      if (dto.getId().equals(id)) {
        result = dto;
        break;
      }
    }

    return result;
  }

  public int update(MemberDTO dto) {

  }
}
