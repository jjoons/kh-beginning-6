package com.kh.spring_legacy.spring_mvc2_20230810.common.util;

import lombok.Getter;

@Getter
public class PageInfo {
  private int currentPage;
  private int pageLimit;
  private int listCount;
  private int listLimit;

  /**
   * @param currentPage 현재 페이지
   * @param pageLimit 한 페이지에 보여질 페이지 수
   * @param listCount 전체 리스트 수
   * @param listLimit 한 페이지에 표시될 리스트 수
   */
  public PageInfo(int currentPage, int pageLimit, int listCount, int listLimit) {
    this.currentPage = currentPage;
    this.pageLimit = pageLimit;
    this.listCount = listCount;
    this.listLimit = listLimit;
  }

  /**
   * @return 전체 페이지 중 가장 마지막 페이지
   * 리스트의 총 개수를 가지고 몇 페이지인지 계산하는 명령문
   * 
   * listCount = 100; listLimit = 10
   * 100 / 10 = 10.0 // 10페이지
   * 101 / 10 = 10.1 // 11페이지
   * 102 / 10 = 10.2 // 11페이지
   * 110 / 10 = 11.0 // 11페이지
   * 111 / 10 = 11.1 // 12페이지
   */
  public int getMaxPage() {
    // 뒷자리가 있으면 무조건 올림
    return (int) Math.ceil((double) this.listCount / this.listCount);
  }

  /**
   * @return 페이징 된 페이지 중 시작 페이지
   */
  public int getStartPage() {}

  /**
   * @return 페이징 된 페이지 중 마지막 페이지
   */
  public int getEndPage() {}

  /**
   * @return 이전 페이지
   */
  public int getPrevPage() {
    int prevPage = this.currentPage - 1;

    return prevPage < 1 ? 1 : prevPage;
  }

  /**
   * @return 다음 페이지
   */
  public int getNextPage() {
    int nextPage = this.currentPage + 1;
    int maxPage = this.getMaxPage();

    /*
     * 페이지가 10이고 현재 페이지 10 일 때는
     * 11 페이지는 존재하지 않으니 10 페이지로 고정
     */
    return nextPage > maxPage ? maxPage : nextPage;
  }

  /**
   * @return 페이지 시작 리스트
   */
  public int getStartList() {}

  /**
   * @return 페이지 마지막 리스트
   */
  public int getEndList() {}
}
