package com.kh.myspring_books_20230724.book;

import javax.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class Upload {
  public String fileUpload(MultipartHttpServletRequest request) {
    String re = "";
    boolean isUpload = false;

    ServletContext context = request.getSession().getServletContext();
    String saveFolder = "/resources/file/";
    String uploadPath = context.getRealPath(saveFolder);
    System.out.println("realFolder: " + uploadPath);


    return re;
  }
}
