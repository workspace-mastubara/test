<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>header</title>
</head>
<body>

	<s:form action="SearchItemAction">
		<select name="category">
			<option value="" selected="selected">全てのカテゴリー</option>
			<option value="0">本</option>
			<option value="1">家電</option>
			<option value="2">おもちゃ</option>
			<option value="3">CD</option>
		</select>

		<input type="text" name="" value="検索ワード" />

		<s:submit value="商品検索" />
	</s:form>

<s:if test="LoginFlg == null">
	<input type="button" value="ログイン"
		onclick="submitAction('GoLoginAction')" />
</s:if>

<s:elseif test="LoginFlg != null">
	<input type="button" value="ログアウト"
		onclick="submitAction('LogoutAction')" />
</s:elseif>

	<input type="button" value="カート"
		onclick="submitAction('CartAction')" />

	<input type="button" value="商品一覧"
		onclick="submitAction('SearchItemAction')" />

<s:if test="LoginFlg == null">
	<input type="button" value="マイページ"
		onclick="submitAction('MyPageAction')" />
</s:if>

</body>
</html>