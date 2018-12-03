package com.spring.xxx.dao;

import com.spring.xxx.model.domain.PhoneISP;

import java.util.List;
import java.util.Map;

public interface PhoneISPMapper {

    int insertSelective(PhoneISP record);
    
    int updateByPrimaryKeySelective(PhoneISP record);
    
    List<PhoneISP> selectList(Map<String, Object> map);
    
    List<PhoneISP> selectUnValidList(Map<String, Object> map);
    
    PhoneISP selectByNumber(Map<String, Object> map);
}