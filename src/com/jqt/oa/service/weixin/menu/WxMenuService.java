package com.jqt.oa.service.weixin.menu;

import com.jqt.oa.entity.weixin.menu.WxMenu;
import com.jqt.oa.service.weixin.base.WxBaseService;

public interface WxMenuService extends WxBaseService<WxMenu>{
	/**
	 * 增加菜单
	 */
	public int insertMenu(WxMenu wxMenu);
	/**
	 * 更新菜单
	 */
	public int updateMenu(WxMenu wxMenu);
	/**
	 * 删除菜单
	 */
	public int deleteMenu(WxMenu wxMenu);
	/**
	 * 向微信平台同步菜单
	 */
	public int syncMenu();
	/**
	 * 通过key获取菜单和事件列表
	 * @param keyId key值Id
	 */
	public WxMenu getWxMenuByKeyId(String keyId);
}
