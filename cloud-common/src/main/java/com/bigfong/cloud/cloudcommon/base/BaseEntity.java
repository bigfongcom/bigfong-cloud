package com.bigfong.cloud.cloudcommon.base;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

public abstract class BaseEntity<T extends BaseEntity> extends Model<BaseEntity> implements Serializable {
    protected long currentPage = 1;
    protected long pageSize = 10;

    /**
     * 结束时间
     */
    protected String startTime;

    /**
     * 开始时间
     */
    protected String endTime;



    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}