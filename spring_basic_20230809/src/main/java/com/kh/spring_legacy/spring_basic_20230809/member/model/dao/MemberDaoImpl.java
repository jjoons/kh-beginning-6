package com.kh.spring_legacy.spring_basic_20230809.member.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.kh.spring_legacy.spring_basic_20230809.member.model.vo.Member;

// 실제 동작하는 Dao를 알리는 어노테이션
// spring에서 bean으로 자동으로 생성해준다.
@Repository
public class MemberDaoImpl implements MemberDao {
  //저장하는 공간
  private List<Member> list = new ArrayList<>();

  @Override
  public int insertMember(Member member) {
    // 아이디가 없거나 길이가 0이면 아이디가 없다는 뜻!
    // 굳이 저장 할 필요가 없다!
    if (member.getId() == null || member.getId().length() == 0) {
      return 0;
    }

    list.add(member);
    return 1;
  }

  @Override
  public List<Member> selectAll() {
    return this.list;
  }

  @Override
  public Member selectById(String id) {
    if (id == null) {
      return null;
    }

    for (int i = 0; i < this.list.size(); i++) {
      Member member = this.list.get(i);
      if (member.getId().equals(id)) {
        return member;
      }
    }

    return null; //id검색후 데이터가 없으면 null 반환
  }
}
