<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>商品購入履歴画面</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<P>商品購入履歴画面</P>
		</div>

		<div id="text-center">

			<s:if test="purchaseHistoryInfoDTOList.size() == 0">
				<s:property value="message"/>
			</s:if>


			<s:else>
				<table>
					<tbody>

						<tr>
							<th>商品名</th>
							<th>ふりがな</th>
							<th>商品画像</th>
							<th>発表会社名</th>
							<th>発売年月日</th>
							<th>値段</th>
							<th>個数</th>
							<th>合計金額</th>
							<th>宛先名前</th>
							<th>宛先住所</th>
						</tr>

						<s:iterator value="purchaseHistoryDTOList">
							<tr>
								<td><s:property value="purchaseHistoryDTO.productName"/></td>
								<td><s:property value="purchaseHistoryDTO.productNameKana"/></td>
								<td><s:property value="purchaseHistoryDTO.imageFilePath"/></td>
								<td><s:property value="purchaseHistoryDTO.releaseCompany"/></td>
								<td><s:property value="purchaseHistoryDTO.releaseDate"/></td>
								<td><s:property value="purchaseHistoryDTO.price"/>円</td>
								<td><s:property value="purchaseHistoryDTO.productCount"/></td>
								<td><s:property value="purchaseHistoryDTO.totalPrice"/>円</td>
								<td><s:property value="purchaseHistoryDTO.fitstName purchaseHistoryDTO.familyName"/></td>
								<td><s:property value="purchaseHistoryDTO.userAddess"/></td>
							</tr>
						</s:iterator>

					</tbody>
				</table>


				<s:form action="DeletePurchaseHistoryAction">
					<input type="hidden" value="<s:property value='userId'/>">
					<s:submit value="削除"/>
				</s:form>

			</s:else>




		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>