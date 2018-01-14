<table border="0" cellspacing="0" cellpadding="0" style="max-width: 600px;">
	<tbody>
		<tr height="16"></tr>
		<tr>
			<td><table bgcolor="#4184F3" width="100%" border="0"
					cellspacing="0" cellpadding="0"
					style="min-width: 332px; max-width: 600px; border: 1px solid #E0E0E0; border-bottom: 0; border-top-left-radius: 3px; border-top-right-radius: 3px;">
					<tbody>
						<tr>
							<td height="72px" colspan="3"></td>
						</tr>
						<tr>
							<td width="32px"></td>
							<td style="font-family: Roboto-Regular, Helvetica, Arial, sans-serif; font-size: 24px; color: #FFFFFF; line-height: 1.25;">${sysName} 授权码</td>
							<td width="32px"></td>
						</tr>
						<tr>
							<td height="18px" colspan="3"></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td><table bgcolor="#FAFAFA" width="100%" border="0" cellspacing="0" cellpadding="0"
					style="min-width: 332px; max-width: 600px; border: 1px solid #F0F0F0; border-bottom: 1px solid #C0C0C0; border-top: 0; border-bottom-left-radius: 3px; border-bottom-right-radius: 3px;">
					<tbody>
						<tr height="16px">
							<td width="32px" rowspan="3"></td>
							<td></td>
							<td width="32px" rowspan="3"></td>
						</tr>
						<tr>
							<td><p>尊敬的 ${sysName} 用户：</p>
								<p>用户 <span style="color: #f44">${askforName}</span> 向您申请授权 “<span style="color: #f44" dir="ltr">对[${schemaName}] 应用 进行 [${action}] 操作： ${authTitle}</span>” 权限，此授权码3分钟后失效。</p>
								<p>验证码为：</p>
								<div style="text-align: center;">
									<p dir="ltr">
									<input style="width:500px;font-weight: bold;color:orange;padding:5px;" value="${authCode}"/>
									</p>
								</div>
								<p>此致</p>
								<p>${sysName} 开发团队敬上</p></td>
						</tr>
						<tr height="32px"></tr>
					</tbody>
				</table>
			</td>
		</tr>
	</tbody>
</table>