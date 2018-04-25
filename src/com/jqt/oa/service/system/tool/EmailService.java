package com.jqt.oa.service.system.tool;

import com.jqt.oa.entity.system.tool.Email;
import com.jqt.oa.service.base.BaseService;

public interface EmailService extends BaseService<Email>{
	
	/**发送邮件（简单版）
     * @param o
     * @return
     */
	public boolean sentEmailSimple(Email o);

}
