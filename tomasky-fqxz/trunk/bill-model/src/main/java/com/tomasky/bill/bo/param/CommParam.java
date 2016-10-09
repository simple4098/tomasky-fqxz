package com.tomasky.bill.bo.param;

import com.tomasky.bill.config.Constants;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by X on 2016/9/8.
 */
public class CommParam {

    private Integer innId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用
    private Date to;
    private int pageNo = Constants.DEFAULT_PAGE_NO;
    private int pageSize = Constants.DEFAULT_PAGE_SIZE;
    private boolean isPage;

    public Integer getInnId() {
        return innId;
    }

    public void setInnId(Integer innId) {
        this.innId = innId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isPage() {
        return isPage;
    }

    public void setPage(boolean page) {
        isPage = page;
    }
}
