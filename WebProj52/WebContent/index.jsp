<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
</head>
<body>
	<s:form action="HelloStrutsAction" method="post">
		<s:submit value="HelloStruts"/>
	</s:form>

	<s:form action="WelcomeAction" method="post">
		<s:submit value="Welcome"/>
	</s:form>

	<s:form action="InquiryAction" method="post">
		<s:submit value="問い合わせ"/>
	</s:form>

	<h3>新規ユーザー登録</h3>
	GET通信
	<s:form method="get" action="TestAction">
		<s:textfield type="text" name="name"/>
		<s:password name="password"/>
		<s:submit value="送信"/>
	</s:form>
	POST通信
	<s:form method="post" action="TestAction">
		<s:textfield type="text" name="name"/>
		<s:password name="password"/>
		<s:submit value="送信"/>
	</s:form>

</body>
</html>