package com.kh.spring_web_ojdbc_template_20230719.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;
import com.kh.spring_web_ojdbc_template_20230719.dao.MvcBoardDAO;
import com.kh.spring_web_ojdbc_template_20230719.vo.MvcBoardList;
import com.kh.spring_web_ojdbc_template_20230719.vo.MvcBoardVO;

public class SelectService implements MvcBoardService {
  private static final Logger logger = LoggerFactory.getLogger(SelectService.class);

  @Override
  public void execute(MvcBoardVO mvcBoardVO) {}

  @Override
  public void execute(Model model) {
    logger.info("execute(model)");

    Map<String, Object> map = model.asMap();
    HttpServletRequest request = (HttpServletRequest) map.get("request");

    AbstractApplicationContext ctx =
        new GenericXmlApplicationContext("classpath:applicationCTX.xml");
    //    SelectService selectService = ctx.getBean("select", SelectService.class);

    MvcBoardDAO boardDAO = ctx.getBean("mvcBoardDAO", MvcBoardDAO.class);
    int pageSize = 10;
    int currentPage = 1;
    try {
      currentPage = Integer.parseInt(request.getParameter("currentPage"));
    } catch (NumberFormatException e) {
      // list 페이지를 구현하기 위해서 가장 첫 번째 게시글 수
    }

    int totalCount = boardDAO.selectCount();
    logger.info("테이블에 저장된 전체 글 개수: {}", totalCount);

    /* 
     * 현재 테이블은 기본적으로 4개가 저장되어있다
     * 만약 글이 없다면 예외가 발생할 수도 있으니 예외를 처리해 주는 내용 추가
     */
    MvcBoardList mvcBoardList = ctx.getBean("mvcBoardList", MvcBoardList.class);
    logger.info("{}", mvcBoardList);

    // 게시글을 보여줄 때 가장 중요한 시작하는 행, 끝나는 행
    HashMap<String, Integer> hmap = new HashMap<>();
    hmap.put("startNo", mvcBoardList.getStartNo());
    hmap.put("endNo", mvcBoardList.getEndNo());

    mvcBoardList.setList(boardDAO.selectList(hmap));
  }
}
