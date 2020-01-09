<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Login画面</title>
</head>
<body>
	<div id="header">

	</div>

	<div id="main">
		<div id="top">
			<P>Login</P>
		</div>

		<s:form action="LoginCheckAction">
			<s:textfield type="text" value="loginId"/>
			<s:password value="password"/>
			<s:submit value="ログイン"/>
		</s:form>

	</div>
	<div id="footer">
	</div>

</body>
</html>