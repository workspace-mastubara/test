<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/latte.css">
<link rel="stylesheet" href="./css/table.css">
<link rel="stylesheet" href="./css/input.css">

<title>ユーザー情報確認</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>ユーザー情報入力確認画面</h1>
		<table class="c-table">
			<tr>
				<th scope="row"><s:label value="性" /></th>
				<td><s:property value="familyName" /></td>
			</tr>

			<tr>
				<th scope="row"><s:label value="名" /></th>
				<td><s:property value="firstName" /></td>
			</tr>

			<tr>
				<th scope="row"><s:label value="性ふりがな" /></th>
				<td><s:property value="familyNameKana" /></td>
			</tr>

			<tr>
				<th scope="row"><s:label value="名ふりがな" /></th>
				<td><s:property value="firstNameKana" /></td>
			</tr>

			<tr>
				<th scope="row"><s:label value="性別" /></th>
				<td><s:property value="sex" /></td>
			</tr>

			<tr>
				<th scope="row"><s:label value="メールアドレス" /></th>
				<td><s:property value="email" /></td>
			</tr>

			<tr>
				<th scope="row"><s:label value="ユーザーID" /></th>
				<td><s:property value="userId" /></td>
			</tr>

			<tr>
				<th scope="row"><s:label value="パスワード" /></th>
				<td><s:property value="password" /></td>
			</tr>

		</table>

		<s:form action="CreateUserCompleteAction">
			<div class="submit_btn_box">
				<s:submit value="登録" class="submit_btn" />
			</div>
		</s:form>

		<s:form action="CreateUserAction">
			<div class="submit_btn_box">
				<s:submit value="戻る" class="submit_btn" />
			</div>
			<s:hidden id="backFlag" name="backFlag" value="1" />
		</s:form>

	</div>

</body>
</html>