$(function () {
	//下拉框
	JY.Dict.setSelect("selectisValid","isValid",2,"全部");
	getbaseList();
	//增加回车事件
	$("#baseForm").keydown(function(e){
		 keycode = e.which || e.keyCode;
		 if (keycode==13) {
			 search();
		 } 
	});
	//新加
	$('#addBtn').on('click', function(e) {
		//通知浏览器不要执行与事件关联的默认动作		
		e.preventDefault();
		cleanForm();	
		loadRoleTree();
		JY.Model.edit("auDiv","新增",function(){
			 if(JY.Validate.form("auForm")){
				 var that =$(this);
				 JY.Ajax.doRequest("auForm",jypath +'/backstage/management/add',null,function(data){
				     that.dialog("close");      
				     JY.Model.info(data.resMsg,function(){search();});
				 });
			 }	
		});
	});
	//批量删除
	$('#delBatchBtn').on('click', function(e) {
		//通知浏览器不要执行与事件关联的默认动作		
		e.preventDefault();
		var chks =[];    
		$('#baseTable input[name="ids"]:checked').each(function(){    
			chks.push($(this).val());    
		});     
		if(chks.length==0) {
			JY.Model.info("您没有选择任何内容!"); 
		}else{
			JY.Model.confirm("确认要删除选中的数据吗?",function(){	
				JY.Ajax.doRequest(null,jypath +'/backstage/account/delBatch',{chks:chks.toString()},function(data){
					JY.Model.info(data.resMsg,function(){search();});
				});
			});		
		}		
	});
	
	$('#exportXls').on('click', function(e) {
		//通知浏览器不要执行与事件关联的默认动作		
		e.preventDefault();
		JY.Model.confirm("确认要导出数据吗?",function(){	
			window.location.href=jypath+"/backstage/management/export";
		});	
	});
	
	$('#print').on('click', function(e) {
		window.print();
	});
	
});
function search(){
	$("#searchBtn").trigger("click");
}
function loadRoleTree(){
	JY.Ajax.doRequest(null,jypath +'/backstage/account/roleTree',null,function(data){
		$.fn.zTree.init($("#roleTree"),{view:{dblClickExpand:false,selectedMulti:false,nameIsHTML:true},data:{simpleData:{enable: true}},callback:{onClick:clickRole}},data.obj);
	});
}
function emptyRole(){
	$("#roleName").prop("value","");
	$("#auForm input[name$='roleId']").prop("value","0");
}
var preisShow=false;//窗口是否显示
function showRole() {
	if(preisShow){
		hideRole();
	}else{
		var obj = $("#roleName");
		var offpos = $("#roleName").position();
		$("#roleContent").css({left:offpos.left+"px",top:offpos.top+obj.heith+"px"}).slideDown("fast");	
		preisShow=true;
	}
}
function clickRole(e, treeId, treeNode) {
	var check = (treeNode && !treeNode.isParent);
	if(check){
		var zTree = $.fn.zTree.getZTreeObj("roleTree"),
		nodes = zTree.getSelectedNodes(),v ="",n ="",o="",p="";	
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";//获取name值
			n += nodes[i].id + ",";//获取id值
			o += nodes[i].other + ",";//获取自定义值
			var pathNodes=nodes[i].getPath();
			for(var y=0;y<pathNodes.length;y++){
				p+=pathNodes[y].name+"/";//获取path/name值
			}
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);	
		if (n.length > 0 ) n = n.substring(0, n.length-1);
		if (o.length > 0 ) o = o.substring(0, o.length-1);
		if (p.length > 0 ) p = p.substring(0, p.length-1);
		if(o=='r'){//判断是否角色	
			$("#roleName").val(p);
			n=n.replace("role","");
			$("#auForm input[name$='roleId']").prop("value",n);
			//因为单选选择后直接关闭，如果多选请另外写关闭方法
			hideRole();
		}	
	}
}
function hideRole(){
	$("#roleContent").fadeOut("fast");
	preisShow=false;
}
function getbaseList(init){
	if(init==1)$("#baseForm .pageNum").val(1);	
	JY.Model.loading();
	JY.Ajax.doRequest("baseForm",jypath +'/backstage/management/findByPage',null,function(data){
		 $("#baseTable tbody").empty();
        	 var obj=data.obj;
        	 var list=obj.list;
        	 var results=list.results;
        	 var permitBtn=obj.permitBtn;
         	 var pageNum=list.pageNum,pageSize=list.pageSize,totalRecord=list.totalRecord;
        	 var html="";
    		 if(results!=null&&results.length>0){
        		 var leng=(pageNum-1)*pageSize;//计算序号
        		 for(var i = 0;i<results.length;i++){
            		 var l=results[i];
            		 html+="<tr>";
            		 html+="<td class='center'><label> <input type='checkbox' name='ids' value='"+l.id+"' class='ace' /> <span class='lbl'></span></label></td>";
            		 html+="<td class='center hidden-480'>"+(i+leng+1)+"</td>";
            		 html+="<td class='center'>"+JY.Object.notEmpty(l.name)+"</td>";
            		 html+="<td class='center hidden-480' >"+JY.Object.notEmpty(l.deptname)+"</td>";
            		 html+="<td class='center '>"+JY.Object.notEmpty(l.phone)+"</td>";
            		 html+="<td class='center hidden-480'>"+JY.Object.notEmpty(l.workphone)+"</td>";
            		 html+="<td class='center hidden-480'>"+JY.Date.Default(l.fixedphone)+"</td>";
            		 html+="<td class='center hidden-480'>"+JY.Object.notEmpty(l.fax)+"</td>";
            		 html+=JY.Tags.setFunction(l.id,permitBtn);
            		 html+="</tr>";		 
            	 } 
        		 $("#baseTable tbody").append(html);
        		 JY.Page.setPage("baseForm","pageing",pageSize,pageNum,totalRecord,"getbaseList");
        	 }else{
        		html+="<tr><td colspan='10' class='center'>没有相关数据</td></tr>";
        		$("#baseTable tbody").append(html);
        		$("#pageing ul").empty();//清空分页
        	 }	
 	 
    	 JY.Model.loadingClose();
	 });
}
function check(id){
	cleanForm();
	JY.Ajax.doRequest(null,jypath +'/backstage/management/find',{id:id},function(data){
	    setForm(data);
	    JY.Model.check("auDiv");       
	});
}
function del(id){
	JY.Model.confirm("确认删除吗？",function(){	
		JY.Ajax.doRequest(null,jypath +'/backstage/management/del',{id:id},function(data){
			JY.Model.info(data.resMsg,function(){search();});
		});
	});
}
function edit(id){
	cleanForm();
	JY.Ajax.doRequest(null,jypath +'/backstage/management/find',{id:id},function(data){
	    setForm(data);   
	    JY.Model.edit("auDiv","修改",function(){
	    	if(JY.Validate.form("auForm")){
				var that =$(this);
				JY.Ajax.doRequest("auForm",jypath +'/backstage/management/update',null,function(data){
				    that.dialog("close");
				    JY.Model.info(data.resMsg,function(){search();});	
				});
			}	
	    });
	});
}
function resetPwd(accountId){
	$("#resetPwdFrom input[name$='accountId']").val(accountId);//类型
	$("#resetPwdFrom input[name$='pwd']").val('');//类型
	$("#resetPwdDiv").removeClass('hide').dialog({resizable: false,modal:true,title:"<div class='widget-header'><h4 class='smaller'>密码重置</h4></div>",title_html: true,
		buttons: [
		  {  
			 html: "<i class='icon-ok bigger-110'></i>&nbsp;保存","class" : "btn btn-primary btn-xs",
			 click: function() {
				 if(JY.Validate.form("resetPwdFrom")){
					 var that =$(this);
					 JY.Ajax.doRequest("resetPwdFrom",jypath +'/backstage/account/resetPwd',null,function(data){
						 that.dialog("close");
			        	JY.Model.info(data.resMsg,function(){search();});		
					 });
				 }		
			}
		  },
		   {
			 html: "<i class='icon-remove bigger-110'></i>&nbsp;取消","class":"btn btn-xs",
			 click: function() {
				$(this).dialog("close");
			 }
		   }
		]
	});
}
function cleanForm(){
	JY.Tags.isValid("auForm","1");
	JY.Tags.cleanForm("auForm");
	$("#auForm input[name$='roleId']").val('0');//上级资源
	$("#auForm input[name$='loginName']").prop("disabled",false); 
	hideRole();
}
function setForm(data){
	var l=data.obj;
	$("#auForm input[name$='id']").val(l.id);
	JY.Tags.isValid("auForm",(JY.Object.notNull(l.isValid)?l.isValid:"0"));
	$("#auForm input[name$='name']").val(JY.Object.notEmpty(l.name));
	$("#auForm input[name$='deptname']").val(JY.Object.notEmpty(l.deptname)); 
	$("#auForm input[name$='phone']").val(JY.Object.notEmpty(l.phone));
	$("#auForm input[name$='workphone']").val(JY.Object.notEmpty(l.workphone));
	$("#auForm textarea[name$='fixedphone']").val(JY.Object.notEmpty(l.fixedphone));//描述
	$("#auForm textarea[name$='fax']").val(JY.Object.notEmpty(l.fax));//描述
	$("#auForm textarea[name$='email']").val(JY.Object.notEmpty(l.email));//描述
	$("#auForm textarea[name$='remark']").val(JY.Object.notEmpty(l.remark));//描述
}
