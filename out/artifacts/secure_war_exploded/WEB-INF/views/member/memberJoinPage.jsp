<%--
  Created by IntelliJ IDEA.
  User: KJH
  Date: 2019-06-18
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>회원가입 페이지</title>
</head>
<body onload="document.f.id.focus();">
<h3>사용할 아이디와 비밀번호를 입력해주세요.</h3>
<form:form name="f" action="/member/memberJoin" method="POST">
    <p>
        <label for="id">아이디</label>
        <input type="text" id="id" name="id" />
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password"/>
    </p>
    <button type="submit" class="btn">가입</button>
</form:form>
</body>
</html>