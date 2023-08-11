package com.kh.spring_legacy.spring_mvc2_20230810.member.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.kh.spring_legacy.spring_mvc2_20230810.member.model.vo.Member;

/*
 * DAO 없이 자동으로 Mapper 객체를 생성해 주는 어노테이션
 * DAO를 작성할 필요가 없다
 * 주의: mapper의 id와 동일한 메소드 네이밍을 맞춰야 한다
 */
@Mapper
public interface MemberMapper {
  int selectCount();

  List<Member> selectAll();

  // 파라미터임을 알리는 어노테이션
  Member selectMember(@Param(value = "id") String id);

  int insertMember(Member member);

  int updateMember(Member member);

  int updatePwd(Map<String, String> map);

  int deleteMember(int no);
}
