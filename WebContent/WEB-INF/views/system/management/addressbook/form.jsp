<%@ page contentType="text/html;charset=UTF-8" %>
<div id="auDiv" class="hide">
		<form id="auForm" method="POST" onsubmit="return false;" >
			<table cellspacing="0" cellpadding="0" border="0" class="customTable">
				<tbody>
					<tr style="display:none">
						<td colspan="2" class="ui-state-error"><input type="hidden" name="id" ></td>
					</tr>		
					<tr class="FormData">
						<td class="CaptionTD"><font color="red">*</font>姓名：</td>
						<td class="DataTD">&nbsp;
						<input type="text" jyValidate="required"  maxlength="16" name="name" class="FormElement ui-widget-content ui-corner-all"></td>
					</tr>	
					<tr class="FormData">
						<td class="CaptionTD">部门名称：</td>
						<td class="DataTD">&nbsp;
						<input type="text" maxlength="32" name="deptname" class="FormElement ui-widget-content ui-corner-all"></td>
					</tr>	
					<tr class="FormData">
						<td class="CaptionTD">手机号码：</td>
						<td class="DataTD">&nbsp;
						<input type="text" maxlength="32" name="phone" class="FormElement ui-widget-content ui-corner-all"></td>
					</tr>
					<tr class="FormData">
						<td class="CaptionTD">办公电话：</td>
						<td class="DataTD">&nbsp;
						<input type="text" maxlength="32" name="workphone" class="FormElement ui-widget-content ui-corner-all"></td>
					</tr>
					<tr class="FormData">
						<td class="CaptionTD">固定电话：</td>
						<td class="DataTD">&nbsp;
						<input type="text" maxlength="32" name="fixedphone" class="FormElement ui-widget-content ui-corner-all"></td>
					</tr>
					<tr class="FormData">
						<td class="CaptionTD">传真：</td>
						<td class="DataTD">&nbsp;
						<input type="text"  maxlength="32" name="fax" class="FormElement ui-widget-content ui-corner-all"></td>
					</tr>
					<tr class="FormData">
						<td class="CaptionTD">电子邮箱：</td>
						<td class="DataTD">&nbsp;
						<input type="text" maxlength="32" name="email" class="FormElement ui-widget-content ui-corner-all"></td>
					</tr>
					<tr class="FormData">
						<td class="CaptionTD">描述：</td>
						<td class="DataTD">&nbsp;
						<textarea rows="2" cols="10" maxlength="100" name="remark" multiline="true" class="FormElement ui-widget-content ui-corner-all isSelect147"></textarea>
						</td>
					</tr> 
				</tbody>
			</table>
		</form>
</div>
<div id="resetPwdDiv" class="hide">
	<form id="resetPwdFrom" method="POST" onsubmit="return false;" >
		<table cellspacing="0" cellpadding="0" border="0" class="customTable">
			<tbody>
				<tr style="display:none">
					<td colspan="2" class="ui-state-error"><input type="hidden" name="accountId" ></td>
				</tr>
				<tr class="FormData">
					<td class="CaptionTD">重置密码：</td>
					<td class="DataTD">&nbsp;
						<input type="password" jyValidate="required"  maxlength="16" name="pwd" class="FormElement ui-widget-content ui-corner-all">
					</td>
				</tr> 
			</tbody>
		</table>
	</form>		
</div>