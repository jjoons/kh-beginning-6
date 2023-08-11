package com.kh.spring_legacy.spring_mvc2_20230810.board.model.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import com.kh.spring_legacy.spring_mvc2_20230810.board.model.vo.Board;
import com.kh.spring_legacy.spring_mvc2_20230810.board.model.vo.Reply;

@Mapper
public interface BoardMapper {
  // MySQL page 기능 활용
  List<Board> selectBoardList1(Map<String, String> map);

  // MyBatis page 기능 활용
  List<Board> selectBoardList2(RowBounds rowBounds, Map<String, String> map);

  int selectBoardCount(Map<String, String> map);

  Board selectBoardByNo(int no);

  int insertBoard(Board board);

  int insertReply(Reply reply);

  int updateBoard(Board board);

  int updateReadCount(Board board);

  int deleteBoard(int no);

  int deleteReply(int no);
}
