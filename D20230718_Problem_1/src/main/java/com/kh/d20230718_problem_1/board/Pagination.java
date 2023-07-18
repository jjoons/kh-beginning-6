package com.kh.d20230718_problem_1.board;

import lombok.ToString;

@ToString
public class Pagination {
  private int limit;
  private int totalCount;
  private int totalPage;
  private int currentPage;
  private int startPage;
  private int endPage;
  private int pageCount;

  public Pagination(int limit, int totalCount, int currentPage, int pageCount) {
    this.limit = limit;
    this.totalCount = totalCount;
    this.currentPage = currentPage;
    this.pageCount = pageCount;

    this.calculate();
  }

  public void calculate() {
    //    this.totalPage = this.totalCount / this.limit + (this.totalCount % this.limit > 0 ? 1 : 0);
    this.totalPage = (this.totalCount - 1) / this.limit + 1;
    this.endPage = (((this.currentPage - 1) / this.pageCount) + 1) * this.pageCount;
    this.startPage = this.endPage - this.pageCount + 1;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
    this.calculate();
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
    this.calculate();
  }

  public int getTotalPage() {
    return totalPage;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
    this.calculate();
  }

  public int getStartPage() {
    return startPage;
  }

  public int getEndPage() {
    return endPage;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
    this.calculate();
  }
}
