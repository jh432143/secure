<%--
  Created by IntelliJ IDEA.
  User: KJH
  Date: 2019-06-13
  Time: 오후 3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>INDEX</title>
  </head>
  <body>
    <h1>INDEX!!</h1>
    <sec:authorize access="isAnonymous()">
      <p><a href="<c:url value="/login/loginForm" />">로그인</a></p>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
      <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="로그아웃" />
      </form:form>
    </sec:authorize>

    <h3>
      [<a href="<c:url value="/intro/introduction" />">소개 페이지</a>]
      [<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
    </h3>
  </body>
</html>
