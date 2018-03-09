package com.hongxp.demo.dubbo.provider.service;


import com.hongxp.demo.dubbo.provider.po.Category;
import com.hongxp.demo.dubbo.provider.vo.CategorySearchVo;

import java.util.List;

/**
 * 巡查点接口
 */
public interface CategoryService {
    /**
     * 保存
     *
     * @return
     */
    int save(Category category);

    /**
     * 更新
     *
     * @return
     */
    int update(Category category);

    /**
     * @return
     */
    Category selectCategory(Long id);

    /**
     * 批量查询支持分页 对象里 PAGE SIZE两个属性支持分页，不需要分页时，两个为NULL
     *
     * @param categorySearchVo 查询条件为对象
     * @return
     */
    List<Category> selectCategoryList(CategorySearchVo categorySearchVo);

    /**
     * 获取当前分类绑定的巡更点数量
     *
     * @param id 分类ID
     * @return
     */
    Integer refKeepWatchPointCount(Long id);

    /**
     * 校验名字重复
     *
     * @param id       主键
     * @param name     名称
     * @param channel  渠道ID
     * @param isUpdate 是否更新的时候使用
     * @return
     */
    Boolean checkDoubleNameError(Long id, String name, Long channel, Integer type, Boolean isUpdate);

    /**
     * 获取当前1级分类 是否有二级分类引用
     *
     * @param id 主键
     * @return
     */
    Boolean checkHadSecondCategory(Long id);

    /**
     * 获取当前分类是否有巡查点引用
     *
     * @param id 主键
     * @return
     */
    Boolean checkHadKeepWatchPoint(Long id);

    /**
     * 根据TYPE获取所有分类条数
     *
     * @param categorySearchVo 搜索对象
     * @return
     */
    Integer getCategoryCountByParam(CategorySearchVo categorySearchVo);

    /**
     * 作废，删除
     *
     * @return
     */
    int delete(Long id);

    /**
     * 获取当前分类绑定的设备数量
     *
     * @param id 分类ID
     * @return
     */
    Integer refEquipmentCount(Long id);
}
