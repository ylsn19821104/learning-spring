package com.hongxp.demo.dubbo.provider.vo;

import com.hongxp.demo.dubbo.provider.po.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分类搜索对象
 */
@ApiModel(value = "分类搜索对象")
@Data
public class CategorySearchVo extends Category {
    //流化对象
    private static final long serialVersionUID = 204383322407355668L;
    //开始时间begin_time
    @ApiModelProperty(value = "开始时间", example = "1503008203899")
    private Long beginTime;
    //结束时间end_time
    @ApiModelProperty(value = "结束时间", example = "1503008203899")
    private Long endTime;
    //页数
    @ApiModelProperty(value = "页数", example = "1")
    private Integer page = 1;
    //多少条
    @ApiModelProperty(value = "每页多少条数据", example = "10")
    private Integer size = 20;
    //需要排序按更新时间
    private Boolean needOrderbyTime;

    /**
     * 配合JS框架,将分页参数改为pageSize
     */
    @ApiModelProperty(value = "每页多少条数据", example = "10")
    private Integer pageSize = 20;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getNeedOrderbyTime() {
        return needOrderbyTime;
    }

    public void setNeedOrderbyTime(Boolean needOrderbyTime) {
        this.needOrderbyTime = needOrderbyTime;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
