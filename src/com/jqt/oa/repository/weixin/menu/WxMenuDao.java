package com.jqt.oa.repository.weixin.menu;

import org.apache.ibatis.annotations.Param;

import com.jqt.oa.entity.weixin.menu.WxMenu;
import com.jqt.oa.repository.base.BaseDao;
import com.jqt.oa.repository.base.JYBatis;

/**
 * 微信菜单数据层
 */
@JYBatis
public interface WxMenuDao  extends BaseDao<WxMenu>{
	/**
	 * 统计菜单数目
	 * @param o 对象      
	 * @return long
	 */
	public int menuCount(WxMenu o);
	
	public WxMenu getWxMenuByKeyId(@Param("keyId")String keyId);
}
