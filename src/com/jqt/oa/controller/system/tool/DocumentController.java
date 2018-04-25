package com.jqt.oa.controller.system.tool;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jqt.oa.common.utils.base.Const;
import com.jqt.oa.controller.base.BaseController;

@Controller
@RequestMapping("/backstage/tool/document/")
public class DocumentController extends BaseController<Object>{

	@RequestMapping("index")	
	public String index(Model model){
		if(doSecurityIntercept(Const.RESOURCES_TYPE_MENU)){
			return "/system/tool/document/list";
		}
		return Const.NO_AUTHORIZED_URL;	
	}
}
