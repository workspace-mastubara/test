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
			<s:if test='session.categoryId != NULL'>
				<option value="<s:property value='session.categoryId'/>" selected="selected">
				<s:property value="session.categoryName" />
				</option>
			</s:if>
			<option value="1"
				selected=<s:if test='session.categoryId == NULL'>"selected" </s:if>>全てのカテゴリー</option>
			<option value="2">本</option>
			<option value="3">家電</option>
			<option value="4">おもちゃ</option>
			<option value="5">CD</option>
		</select>

		<s:textfield name="searchWord" placeholder="検索ワード"
			value='<s:if test="#session.searchWord != NULL"><s:property value="#session.searchWord"/></s:if>'
			maxlength="50" />

		<s:submit value="商品検索" />
	</s:form>

	<s:if test="#session.logined == 0">
		<s:form action="GoLoginAction">
			<s:submit value="ログイン" />
		</s:form>
	</s:if>

	<s:else>
		<s:form action="LogoutAction">
			<s:submit value="ログアウト" />
		</s:form>
	</s:else>


	<s:form action="CartAction">
		<s:submit value="カート" />
	</s:form>

	<s:form action="SearchItemAction">
		<s:submit value="商品一覧" />
		<s:hidden name="category" value= "1"/>
	</s:form>


		<s:form action="MyPageAction">
		<input type="hidden" name="userId" value="guest">
		<input type="hidden" name="loginFlg" value="1">
			<s:submit value="マイページ" />
		</s:form>



</body>
</html>