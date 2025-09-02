<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>簡易Twitter</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="header">
		    <c:if test="${ empty loginUser }">
		        <a href="login">ログイン</a>
		        <a href="signup">登録する</a>
		    </c:if>
		    <c:if test="${ not empty loginUser }">
		        <a href="./">ホーム</a>
		        <a href="setting">設定</a>
		        <a href="logout">ログアウト</a>
		    </c:if>
		</div>
		<c:if test="${ not empty loginUser }">
	    <div class="profile">
	        <div class="name"><h2><c:out value="${loginUser.name}" /></h2></div>
	        <div class="account">@<c:out value="${loginUser.account}" /></div>
	        <div class="description"><c:out value="${loginUser.description}" /></div>
	    </div>
		</c:if>
		<c:if test="${ not empty errorMessages }">
	    <div class="errorMessages">
	        <ul>
	            <c:forEach items="${errorMessages}" var="errorMessage">
	                <li><c:out value="${errorMessage}" />
	            </c:forEach>
	        </ul>
	    </div>
	    <c:remove var="errorMessages" scope="session" />
		</c:if>
		<div class="form-area">
		    <form action="edit" method="post">
		        つぶやき<br />
		    <pre><textarea name="text" cols="100" rows="5" class="tweet-box">${message.text}</textarea></pre>
		    <input type="hidden" name="messageId" value="${message.id}" />
		    <input type="submit" value="更新">（140文字まで）
		    </form>
		    <br /><a href="./">戻る</a><br>
		</div>
	</body>
</html>