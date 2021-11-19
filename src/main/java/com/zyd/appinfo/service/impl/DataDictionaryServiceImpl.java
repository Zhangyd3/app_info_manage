package com.zyd.appinfo.service.impl;

import com.zyd.appinfo.mapper.DataDictionaryMapper;
import com.zyd.appinfo.pojo.DataDictionary;
import com.zyd.appinfo.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/19 14:44
 */
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;
    @Override
    public List<DataDictionary> findByTypeCode(String typeCode) {
        return dataDictionaryMapper.findByTypeCode(typeCode);
    }
}
