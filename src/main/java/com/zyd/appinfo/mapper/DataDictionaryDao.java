package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.DataDictionary;

public interface DataDictionaryDao {
    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);
}