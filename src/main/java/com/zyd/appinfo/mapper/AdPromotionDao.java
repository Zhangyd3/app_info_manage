package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.AdPromotion;

public interface AdPromotionDao {
    int deleteByPrimaryKey(Long id);

    int insert(AdPromotion record);

    int insertSelective(AdPromotion record);

    AdPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdPromotion record);

    int updateByPrimaryKey(AdPromotion record);
}