<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Home画面</title>
</head>
<body>
	<div id="header">
		<table>
			<tbody>
				<tr>
					<th>
						<s:form action="LoginAction">
							<s:submit value="ログイン"/>
						</s:form>
					</th>
					<th>
						<s:form action="MyPageAction">
							<s:submit value="マイページ"/>
						</s:form>
					</th>
					<th>
						<s:form action="CartAction">
							<s:submit value="カート"/>
						</s:form>
					</th>
					<th>
						<s:form action="ItemListAction">
							<s:submit value="商品一覧"/>
						</s:form>
					</th>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="main">
		<div id="top">
			<P>Home</P>
		</div>

	</div>
	<div id="footer">
	</div>
</body>
</html>