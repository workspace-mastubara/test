<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>header</title>
</head>
<body>

	<s:form action="SearchItemAction">
		<select name="category">
			<option value="0" selected="selected">全てのカテゴリー</option>
			<option value="1">本</option>
			<option value="2">家電</option>
			<option value="3">おもちゃ</option>
			<option value="4">CD</option>
		</select>

		<s:textfield name="key" placeholder="検索ワード" maxlength="50"/>

		<s:submit value="商品検索" />
	</s:form>

<s:form action="GoLoginAction">
<s:if test="loginFlg == 0">
	<input type="button" value="ログイン" />
</s:if>
</s:form>

<s:form action ="LogoutAction">
<s:elseif test="loginFlg == 1">
	<input type="button" value="ログアウト" />
</s:elseif>
</s:form>

<s:form action="CartAction">
	<input type="button" value="カート" />
</s:form>

<s:form action="SearchItemAction">
	<input type="button" value="商品一覧" />
	</s:form>

<s:form action="MyPageAction">
<input type="hidden" name="userId" value="hanako"/>
	<input type="button" value="マイページ" />
</s:form>

</body>
</html>