package com.jqt.oa.service.system.log;

import java.util.List;

import com.jqt.oa.common.mybatis.Page;
import com.jqt.oa.entity.system.log.LoginLog;

public interface LoginLogService {

	/**
	 * 分页日志
	 * @param o
	 */
	public Page<LoginLog> findByPage(LoginLog o,Page<LoginLog> page);	
	/**
	 * 记录日志
	 * @param o
	 */
	public void saveLoginLog(LoginLog o);
	/**
	 * 批量删除日志
	 * @param o
	 */
	public void deleteBatch(List<LoginLog> os);
}
