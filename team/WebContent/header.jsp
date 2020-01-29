<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<ul>
		<form action="SerchItemAction">
			<li><s:select name="categoryId" list="session.categoryDTOList"/></li>
			<li><s:textfield name="serchWord" value="{%serchWord}" placeholder="検索ワード"/></li>
			<li><s:submit name="serchvalue" value="商品検索"/></li>
		</form>

		<s:if test="session.logined == 1">
		<form action="goLoginAction">
			<li><s:submit name="login" value="ログイン"/></li>
		</form>
		</s:if>

		<s:else>
		<form action="logoutAction">
			<li><s:submit name="logout" value="ログアウト"/></li>
		</form>
		</s:else>

		<form action="cartAction">
			<li><s:submit name="cart" value="カート"/></li>
		</form>

		<form action="SerchItemAction">
			<li><s:submit name="serch" value="商品一覧"/></li>
		</form>

		<s:if test="session.logined == 1">
		<form action="MyPageAction">
			<li><s:submit name="mypage" value="マイページ"/></li>
		</form>
		</s:if>
	</ul>

</body>
</html>