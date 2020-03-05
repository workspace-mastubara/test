<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/latte.css">
<link rel="stylesheet" type="text/css" href="./css/input.css">
<link rel="stylesheet" type="text/css" href="./css/message.css">
<title>ログイン画面</title>
</head>
<body>
	<!--ヘッダー-->
	<div id="header">
		<img src="/tc/images/TClogo.jpg"/>
		<div id="system">
			<label>RecruitSystem</label>
		</div>
	</div>

	<!-- コンテンツ -->
	<div id="contents">

		<!-- エラーメッセージ -->
		<s:if
			test="userIdErrorMessageList!=null && userIdErrorMessageList.size()>0">
			<div class="error-message">
				<s:iterator value="userIdErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if
			test="passwordErrorMessageList!=null && passwordErrorMessageList.size()>0">
			<div class="error-message">
				<s:iterator value="passwordErrorMessageList">
					<s:property />
					<br>
				</s:iterator>
			</div>
		</s:if>
		<s:if
			test="isNotUserInfoMessage!=null && !isNotUserInfoMessage.isEmpty()">
			<div class="error-message">
				<s:property value="isNotUserInfoMessage" />
			</div>
		</s:if>

		<!-- 入力テーブル -->
		<s:form action="LoginAction">
			<div class="input_txt">
					<s:if test="#session.savedUserIdFlg==true">
						<s:textfield name="userId" class="txt"
								placeholder="UserId" value='%{#session.userId}'
								autocomplete="off" />
					</s:if>
					<s:else>
						<s:textfield name="userId" class="txt"
								placeholder="UserID" value='%{userId}' autocomplete="off" />
					</s:else>

					<s:password name="password" class="txt"
							placeholder="Password" autocomplete="off" />
			</div>

			<!-- フォームボタン -->
			<div class="submit_btn_box">
				<div>
					<s:submit value="Sign In" class="submit_btn" />
				</div>
			</div>
		</s:form>

	</div>

</body>
</html>
