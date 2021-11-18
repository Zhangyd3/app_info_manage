package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {
    List<DataDictionary> findByTypeCode(String typeCode);
}