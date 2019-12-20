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
	<table>
		<tbody>
			<tr>
				<th>商品</th>
				<th>ユーザー</th>
			</tr>

			<tr>
				<s:form action="ItemCreateAction">
					<td><s:submit value="新規登録"/></td>
				</s:form>
				<s:form action="ItemListAction">
					<td><s:submit value="一覧"/></td>
				</s:form>
			</tr>

			<tr>
				<td><s:submit value="新規登録"/></td>
				<td><s:submit value="一覧"/></td>
			</tr>
		</tbody>
	</table>


</body>
</html>