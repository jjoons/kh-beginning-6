package com.kh.spring_legacy.spring_mvc2_20230810.board.model.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.kh.spring_legacy.spring_mvc2_20230810.board.model.mapper.BoardMapper;
import com.kh.spring_legacy.spring_mvc2_20230810.board.model.vo.Board;
import com.kh.spring_legacy.spring_mvc2_20230810.board.model.vo.Reply;

@Service
public class BoardService {
  @Autowired
  private BoardMapper mapper;

  // 저장 메소드
  public int saveBoard(Board board) {
    int result = 0;

    if (board.getNo() == 0) {
      result = mapper.insertBoard(board);
    } else {
      result = mapper.updateBoard(board);
    }

    return result;
  }

  // 
  public int saveReply(Reply reply) {
    return mapper.insertReply(reply);
  }

  /*
   * 업로드 / 다운로드
   * 파일 저장
   */
  public String saveFile(MultipartFile upFile, String savePath) {
    File folder = new File(savePath);

    // 폴더 없으면 생성
    if (!folder.exists()) {
      folder.mkdirs();
    }

    //    System.out.println("savePath: " + savePath);
    /*
     * 파일 이름을 랜덤하게 바꾸는 코드
     * 현재 시간에 관한 format으로 설정
     *   20230811_123456789
     */
    String originalFileName = upFile.getOriginalFilename();
    String reNameFileName =
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"));
    // 현재 이름을 original + reName 연결
    reNameFileName += originalFileName.substring(originalFileName.lastIndexOf("."));
    String reNamePath = savePath + "/" + reNameFileName;

    try {
      // 실제 파일이 저장되는 코드

    } catch (IOException e) {
      return null;
    }

    return reNameFileName;
  }
}
