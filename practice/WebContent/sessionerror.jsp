<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 3秒後に遷移 -->
<meta http-equiv="refresh" content="3;URL='HomeAction'" />
<link rel="stylesheet" type="text/css" href="./css/latte.css">
<link rel="stylesheet" type="text/css" href="./css/message.css">
<title>sessionerror画面</title>
</head>
<body>

	<div id="header"></div>

	<div id="contents">
		<div id="top">
			<h1>セッションエラー画面</h1>
		</div>

		<div class="error">
			<h3>ログインしていないか、タイムアウトしました。</h3>
		</div>
	</div>
</body>
</html>