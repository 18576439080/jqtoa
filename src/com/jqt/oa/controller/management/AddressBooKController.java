package com.jqt.oa.controller.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jqt.oa.common.ajax.AjaxRes;
import com.jqt.oa.common.annotation.ControllerOptLog;
import com.jqt.oa.common.mybatis.Page;
import com.jqt.oa.common.utils.base.Const;
import com.jqt.oa.common.utils.poi.ObjectExcelView;
import com.jqt.oa.controller.base.BaseController;
import com.jqt.oa.entity.system.addressbook.AddressBook;
import com.jqt.oa.service.management.addressbook.AddressBookService;

@Controller
@RequestMapping("/backstage/management/")
public class AddressBooKController extends BaseController<AddressBook>{

	@Autowired
	private AddressBookService service;
	
	/**
	 * 通讯录列表
	 * @param model
	 * @return
	 */
	@RequestMapping("index")	
	public String index(Model model){
		if(doSecurityIntercept(Const.RESOURCES_TYPE_MENU)){
			model.addAttribute("permitBtn", getPermitBtn(Const.RESOURCES_TYPE_FUNCTION));	
			return "/system/management/addressbook/list";
		}
		return Const.NO_AUTHORIZED_URL;
	}
	
	/**
	 * 通讯录分页查询
	 * @param page
	 * @param o
	 * @return
	 */
	@RequestMapping(value="findByPage", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes findByPage(Page<AddressBook> page,AddressBook o){
		AjaxRes ar=getAjaxRes();
		if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_MENU,"/backstage/management/index"))){
			try {
				Page<AddressBook> addressBooks=service.findByPage(o, page);
				Map<String, Object> p=new HashMap<String, Object>();
				p.put("permitBtn",getPermitBtn(Const.RESOURCES_TYPE_BUTTON));
				p.put("list",addressBooks);		
				ar.setSucceed(p);
			} catch (Exception e) {
				logger.error(e.toString(),e);
				ar.setFailMsg(Const.DATA_FAIL);
			}
		}	
		return ar;
	}
	
	/**
	 * 新增通讯录方法
	 * @param o
	 * @return
	 */
	@ControllerOptLog(desc="新增通讯录")
	@RequestMapping(value="add", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes add(AddressBook o){
		AjaxRes ar=getAjaxRes();
		if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_FUNCTION))){			
			try {	
				int res=service.insertAddressBook(o);
				if(res==1)ar.setSucceedMsg(Const.SAVE_SUCCEED);
				else ar.setFailMsg("通讯录已存在");	
			} catch (Exception e) {
				logger.error(e.toString(),e);
				ar.setFailMsg(Const.SAVE_FAIL);
			}
		}
		return ar;
	}
	
	/**
	 * 查询单个通讯录
	 * @param o
	 * @return
	 */
	@RequestMapping(value="find", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes find(AddressBook o){
		AjaxRes ar=getAjaxRes();
		if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_BUTTON))){	
			try {
				List<AddressBook> list=service.find(o);
				AddressBook addressBook =list.get(0);
				ar.setSucceed(addressBook);
			} catch (Exception e) {
				logger.error(e.toString(),e);
				ar.setFailMsg(Const.DATA_FAIL);
			}
		}
		return ar;
	}
	
	/**
	 * 更新通讯录
	 * @param o
	 * @return
	 */
	@ControllerOptLog(desc="更新通讯录")
	@RequestMapping(value="update", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes update(AddressBook o){
		AjaxRes ar=getAjaxRes();
		if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_BUTTON))){
			try {
				service.update(o);
				ar.setSucceedMsg(Const.UPDATE_SUCCEED);
			} catch (Exception e) {
				logger.error(e.toString(),e);
				ar.setFailMsg(Const.UPDATE_FAIL);
			}
		}	
		return ar;
	}
	
	/**
	 * 删除通讯录
	 * @param o
	 * @return
	 */
	@ControllerOptLog(desc="删除通讯录")
	@RequestMapping(value="del", method=RequestMethod.POST)
	@ResponseBody
	public AjaxRes del(AddressBook o){
		AjaxRes ar=getAjaxRes();
		if(ar.setNoAuth(doSecurityIntercept(Const.RESOURCES_TYPE_BUTTON))){
			try {
				service.delete(o);
				ar.setSucceedMsg(Const.DEL_SUCCEED);
			} catch (Exception e) {
				logger.error(e.toString(),e);
				ar.setFailMsg(Const.DEL_FAIL);
			}
		}	
		return ar;
	}
	
	@RequestMapping(value = "export")
	public ModelAndView exportXls(AddressBook o) {
		ModelAndView mv = this.getModelAndView();
		if (doSecurityIntercept(Const.RESOURCES_TYPE_FUNCTION)) {
			try {
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("fileName", "tongxunlu");// 设置文件名

				List<String> titles = new ArrayList<String>();
				titles.add("任务对象"); // 1
				titles.add("任务类"); // 2
				titles.add("日志类型"); // 3
				titles.add("任务类描述"); // 4
				titles.add("记录时间"); // 5
				titles.add("记录时间"); // 5
				titles.add("记录时间"); // 5
				titles.add("记录时间"); // 5
				model.put("titles", titles);// 设置标题们

				List<AddressBook> taskLogs = service.find(o);
				List<Map<String, String>> varList = new ArrayList<Map<String, String>>();
				for (AddressBook t : taskLogs) {
					Map<String, String> vpd = new HashMap<String, String>();
					vpd.put("var1", t.getName()); // 1
					vpd.put("var2", t.getDeptname()); // 2
					vpd.put("var3", t.getPhone()); // 3
					vpd.put("var4", t.getWorkphone()); // 4
					vpd.put("var5", t.getFixedphone()); // 5
					vpd.put("var6", t.getFax()); // 6
					vpd.put("var7", t.getEmail()); // 7
					vpd.put("var8", t.getRemark()); // 8
					varList.add(vpd);
				}
				model.put("varList", varList);// 设置内容们
				ObjectExcelView erv = new ObjectExcelView(); // 执行excel操作
				mv = new ModelAndView(erv, model);
			} catch (Exception e) {
				logger.error(e.toString(), e);
			}
		} else {
			mv.setViewName(Const.NO_AUTHORIZED_URL);
		}
		return mv;
	}
}
