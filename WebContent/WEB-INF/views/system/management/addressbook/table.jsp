<%@ page contentType="text/html;charset=UTF-8" %>
<div id="auDiv" class="hide">
		<form id="auForm" method="POST" onsubmit="return false;" >
			<table id="printTable" class="table table-striped table-bordered table-hover" >
						<thead>
							<tr>
								<th style="width:3%" class="center">
									<label><input type="checkbox" class="ace" ><span class="lbl"></span></label>
								</th>
								<th style="width:5%"  class="center hidden-480">序号</th>
								<th style="width:10%" class="center">姓名</th>
								<th style="width:10%" class="center hidden-480">部门</th>
								<th style="width:8%"  class="center ">手机号码</th>
								<th style="width:15%" class="center hidden-480"><i class="icon-envelope-alt  bigger-110 hidden-480"></i>办公号码</th>
								<th style="width:15%" class="center hidden-480"><i class="icon-time bigger-110 hidden-480"></i>固定电话</th>
								<th style="width:15%" class="center hidden-480">传真</th>
								<th style="width:10%" class="center">操作</th>
							</tr>
						</thead>
						<tbody></tbody>
			</table>
		</form>
</div>