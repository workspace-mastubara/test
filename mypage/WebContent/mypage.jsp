<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>マイページ画面</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp"/>
	</div>
	<div id="main">
		<div id="top">
			<P>マイページ画面</P>
		</div>

		<div id="text-center">

			<table>
				<tbody>


						<tr>
							<th>姓</th>
							<s:iterator value="userInfoDTO">
								<td><s:property value="familyName"/></td>
							</s:iterator>
						</tr>

						<tr>
							<th>名</th>
							<s:iterator value="userInfoDTO">
								<td><s:property value="firstName"/></td>
							</s:iterator>
						</tr>

						<tr>
							<th>ふりがな</th>
							<s:iterator value="userInfoDTO">
								<td><s:property value="familyNameKana"/> <s:property value="firstNameKana"/></td>
							</s:iterator>
						</tr>

						<tr>
							<th>性別</th>
							<s:iterator value="userInfoDTO">
								<s:if test="sex == 0">
									<td>男性</td>
								</s:if>

								<s:if test="sex == 1">
									<td>女性</td>
								</s:if>
							</s:iterator>
						</tr>

						<tr>
							<th>メールアドレス</th>
							<s:iterator value="userInfoDTO">
								<td><s:property value="email"/></td>
							</s:iterator>
						</tr>


				</tbody>
			</table>

			<s:form action="PurchaseHistoryAction">
				<input type="hidden" name="userId" value="<s:property value='userId'/>">
				<s:submit value="購入履歴"/>
			</s:form>




		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>