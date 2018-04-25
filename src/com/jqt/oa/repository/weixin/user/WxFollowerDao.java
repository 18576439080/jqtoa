package com.jqt.oa.repository.weixin.user;

import java.util.List;

import com.jqt.oa.entity.weixin.user.WxFollower;
import com.jqt.oa.repository.base.BaseDao;
import com.jqt.oa.repository.base.JYBatis;


/**
 * 微信关注者数据层
 */
@JYBatis
public interface WxFollowerDao  extends BaseDao<WxFollower>{
 
    public void clearFollower();
    
    public void insertFollowers(List<WxFollower> o);
}
