package com.jqt.oa.service.system.dict;

import java.util.Map;

import com.jqt.oa.entity.system.dict.DataDict;
import com.jqt.oa.service.base.BaseService;

public interface DataDictService extends BaseService<DataDict>{
	/**
	 * 查找数据字典
	 * @param ids  标签Id（多个可逗号隔开）
	 * @param keys 关键字（多个可逗号隔开）
	 * @return
	 */
   public Map<String,DataDict> findDatas(String ids,String keys);  
   /**
    * 新增数据字典
    * @param DataDict 数据字典类(包括数据字典字段类)
    * @return
    */
   public int insertDataDict(DataDict dataDict);
   /**
    * 修改数据字典
    * @param DataDict 数据字典类
    * @return
    */
   public int updateDataDict(DataDict dataDict);
}
