package com.jqt.oa.repository.weixin.event;

import java.util.List;

import com.jqt.oa.entity.weixin.event.WxEventClick;
import com.jqt.oa.repository.base.BaseDao;
import com.jqt.oa.repository.base.JYBatis;
/**
 * 微信点击事件数据层
 */
@JYBatis
public interface WxEventClickDao  extends BaseDao<WxEventClick>{

	/**
	* 批量插入微信点击事件
	* @param o 微信点击事件集合
	*/
	public void insertItems(List<WxEventClick> o);
	
}
