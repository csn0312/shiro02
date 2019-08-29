<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<h1>用户登陆[${user.username}],ts=<%=System.currentTimeMillis()%></h1>
<div style="color:red">${message}</div>
<f:form method="post" action="${ctx}/user/login" modelAttribute="user">
    username:<f:input path="username"/><br>
    password:<f:input path="password"/><br>
    <input type="submit" value="ok">
</f:form>
</body>
</html>
