package com.jqt.oa.repository.system.log;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jqt.oa.common.mybatis.Page;
import com.jqt.oa.entity.system.log.OptLog;
import com.jqt.oa.repository.base.JYBatis;
@JYBatis
public interface OptLogDao {

	public List<OptLog> findByPage(@Param("param")OptLog o,Page<OptLog> page);
	
	public void insert(OptLog o);
	
	public void deleteBatch(List<String> os);
}
