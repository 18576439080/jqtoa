package com.jqt.oa.repository.system.log;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jqt.oa.common.mybatis.Page;
import com.jqt.oa.entity.system.log.LoginLog;
import com.jqt.oa.repository.base.JYBatis;

@JYBatis
public interface LoginLogDao {

	public List<LoginLog> findByPage(@Param("param")LoginLog o,Page<LoginLog> page);
	
	public void insert(LoginLog o);
	
	public void deleteBatch(List<LoginLog> os);
}
