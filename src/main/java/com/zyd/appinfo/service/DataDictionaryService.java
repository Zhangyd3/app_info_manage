package com.zyd.appinfo.service;

import com.zyd.appinfo.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryService {
    List<DataDictionary> findByTypeCode(String typeCode);
}
