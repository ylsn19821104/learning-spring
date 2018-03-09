package com.hongxp.demo.dubbo.provider.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 分类对象
 */
@ApiModel(value = "分类对象")
public class Category implements Serializable {
    private static final long serialVersionUID = -7249070760839820235L;
    //流化对象
    //Id
    @ApiModelProperty(value = "ID", example = "")

    @Id
    private Long id;
    //父级Id
    @ApiModelProperty(value = "父级Id", example = "")
    private Long parentId;
    //类型： 1为小区巡查分类，2为电子巡更分类 3为设备巡查分类
    @ApiModelProperty(value = "类型", example = "1为小区巡查分类，2为电子巡更分类 3为设备巡查分类")
    private Integer type;
    //分类名称
    @ApiModelProperty(value = "分类名称", example = "")
    private String name;
    //分类级别
    @ApiModelProperty(value = "分类级别", example = "")
    private Integer categoryLevel;
    //状态
    @ApiModelProperty(value = "状态", example = "")
    private Integer status;
    //备注
    @ApiModelProperty(value = "备注", example = "")
    private String remark;
    //小区Id
    @ApiModelProperty(value = "小区Id", example = "")
    private Long villageId;
    //服务中心Id
    @ApiModelProperty(value = "服务中心Id", example = "")
    private Long serviceId;
    //渠道Id
    @ApiModelProperty(value = "渠道Id", example = "")
    private Long channelId;
    //创建人Id
    @ApiModelProperty(value = "创建人Id", example = "")
    private Long createId;
    //创建时间
    @ApiModelProperty(value = "创建时间", example = "1503008203899")
    private Long createTime;
    //更新人Id
    @ApiModelProperty(value = "更新人Id", example = "")
    private Long updateId;
    //更新时间
    @ApiModelProperty(value = "更新时间", example = "1503008203899")
    private Long updateTime;
    //创建人名字
    @ApiModelProperty(value = "创建人名字", example = "")
    private String createName = "";
    //更新人名字
    @ApiModelProperty(value = "更新人名字", example = "")
    private String updateName = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "parentId=" + parentId +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", categoryLevel=" + categoryLevel +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", villageId=" + villageId +
                ", serviceId=" + serviceId +
                ", channelId=" + channelId +
                ", createId=" + createId +
                ", updateId=" + updateId +
                ", createName='" + createName + '\'' +
                ", updateName='" + updateName + '\'' +
                '}';
    }
}
