<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>ログインに失敗しました</h3>

	【入力内容を確認してください】
	ユーザー名：<s:iterator value="session.name"/>
	パスワード：<s:iterator value="session.pass"/>

</body>
</html>