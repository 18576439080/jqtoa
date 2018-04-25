package com.jqt.oa.service.weixin.user;

import com.jqt.oa.entity.weixin.user.WxFollower;
import com.jqt.oa.service.weixin.base.WxBaseService;

public interface WxFollowerService extends WxBaseService<WxFollower>{

	/**
	 * 同步微信服务器关注者数据
	 */
	public void syncFollower();
}
