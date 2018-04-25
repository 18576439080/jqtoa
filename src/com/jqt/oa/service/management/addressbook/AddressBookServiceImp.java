package com.jqt.oa.service.management.addressbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jqt.oa.common.utils.tree.entity.ZNodes;
import com.jqt.oa.entity.system.addressbook.AddressBook;
import com.jqt.oa.repository.management.addressbook.AddressBookDao;
import com.jqt.oa.service.base.BaseServiceImp;



@Service("AddressBookService")
public class AddressBookServiceImp extends BaseServiceImp<AddressBook> implements AddressBookService {

	@Autowired
	private AddressBookDao addressBookDao;
	
	@Override
    public AddressBook findFormatByLoginName(String loginName){
		
		return null;
	}
 
	public AddressBook getPerData(){
		return null;	 
	}
	 
	public void setPerData(AddressBook addressBook){
		
	}
	
	public void setHeadpic (AddressBook addressBook){
		
	}
	
	@Override
	public int insertAddressBook(AddressBook o) throws Exception {
		addressBookDao.insert(o);
		return 1;
	}

	@Override
	public List<ZNodes> getRoles() {
		return null;
	}
}
