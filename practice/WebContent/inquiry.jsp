<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/latte.css">
<title>問い合わせ画面</title>
</head>
<div id="header">
		<jsp:include page="header.jsp" />
</div>

<div id="contents">
		<h1>問い合わせ画面</h1>
</div>

<s:form action="InquiryConfirmAction">
	<!-- 質問タイプ選択 -->
	<p>問い合わせの種類：<p>
	<s:select name="qType" list="inquiryDTOList" listValue="qType"/>

	<!-- 問い合わせ内容入力 -->
	<p>問い合わせ内容：<p>
	<s:textarea name="contents"/>
	<br>
	<s:submit value="登録"/>
</s:form>


	<!-- 検索窓valueは記述無しでも構わないが表示するものを明確にするため -->
	<s:textfield name="searchQuestion" value="%{searchWord}" placeholder="検索ワード"/>
	<s:submit value="検索"/>

	<s:iterator value="askQuestionDTOList">
		<table>
				<tr>
					<td><s:property value="question"/></td>
				</tr>
				<tr>
					<td><s:property value="answer"/></td>
				</tr>
		</table>
	<s:property value=""/><br></s:iterator>

</html>



