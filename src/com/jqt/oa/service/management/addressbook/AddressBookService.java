package com.jqt.oa.service.management.addressbook;

import java.util.List;

import com.jqt.oa.common.utils.tree.entity.ZNodes;
import com.jqt.oa.entity.system.addressbook.AddressBook;
import com.jqt.oa.service.base.BaseService;


public interface AddressBookService extends BaseService<AddressBook>{

  
    /**
     * 根据登录帐号查找loginName和accountType，正常只有一条数据
     * and a.isvalid='1' and a.account_type='1'需要该条件
     * @param loginName
     * @return
     */
    public AddressBook findFormatByLoginName(String loginName);
   
    /**
     * 获取个人资料，需要登录状态
     * @return
     */
    public AddressBook getPerData();
    /**
     * 设置头像
     * @param account
     * @return
     */
    public void setHeadpic(AddressBook addressBook);
    /**
     * 设置个人资料
     * @param account
     * @return
     */
    public void setPerData(AddressBook addressBook);
    
    /**
     * 新增通讯录
     * @param addressBook
     * @return
     * @throws Exception
     */
    public int insertAddressBook(AddressBook addressBook) throws Exception;
    /**
     * 获得角色树
     * @return
     */
    public List<ZNodes> getRoles();
}
