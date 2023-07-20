package com.kh.spring_web_ojdbc_template_20230719.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;
import com.kh.spring_web_ojdbc_template_20230719.dao.MvcBoardDAO;
import com.kh.spring_web_ojdbc_template_20230719.vo.MvcBoardVO;

public class InsertService implements MvcBoardService {
  private static final Logger logger = LoggerFactory.getLogger(InsertService.class);

  @Override
  public void execute(MvcBoardVO mvcBoardVO) {}

  @Override
  public void execute(Model model) {
    logger.info("execute(model)");
    Map<String, Object> map = model.asMap();
    HttpServletRequest request = (HttpServletRequest) map.get("request");
    String name = request.getParameter("name");
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");

    // XML 파일에서 빈 가지고 오기
    AbstractApplicationContext ctx =
        new GenericXmlApplicationContext("classpath:applicationCTX.xml");
    MvcBoardVO mvcBoardVO = ctx.getBean("mvcBoardVO", MvcBoardVO.class);
    mvcBoardVO.setName(name);
    mvcBoardVO.setSubject(subject);
    mvcBoardVO.setContent(content);

    MvcBoardDAO mvcBoardDAO = ctx.getBean("mvcBoardDAO", MvcBoardDAO.class);
    mvcBoardDAO.insert(mvcBoardVO);
  }
}
