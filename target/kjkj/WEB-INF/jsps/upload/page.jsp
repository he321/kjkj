<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">

</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">上传管理</span>
		</div>
	</div>


	<div class="content-text">
		<div class="square-order">
			<form action="upload_execute" method="post" enctype="multipart/form-data">
				<div style="border:1px solid #cecece;">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr bgcolor="#FFFFFF">
							<td>&nbsp;</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr bgcolor="#FFFFFF">
							<td width="18%" height="30" align="center">用&nbsp;户&nbsp;名：</td>
							<td width="32%">
								<input type="text" name="usename"> <br/>
							</td>

						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="18%" height="30" align="center">上传文件：</td>
							<td width="32%">
								<input type="file" name="file1"><br/>
							</td>
						</tr>
					</table>
				</div>
				<div class="order-botton">
					<div style="margin:1px auto auto 1px;">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><a href="javascript:document.forms[0].submit()"><img
										src="images/order_tuo.gif" border="0" /></a></td>
								<td>&nbsp;</td>
								<td><a href="#"><img src="images/order_tuo.gif"
													 border="0" /></a></td>
								<td>&nbsp;</td>
								<td><a href="#"><img src="images/order_tuo.gif"
													 border="0" /></a></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<!--"square-order"end-->
	</div>

	<div class="content-bbg"></div>
</div>
