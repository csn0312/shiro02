<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
    <h1>主界面,ts=<%=System.currentTimeMillis()%>，<a href="${ctx}/user/logout">退出</a>系统</h1>
    <h1>欢迎您：[${user.username}]</h1>
    <ul>
        用户权限一览
        <li>
            <s:hasPermission name="system:user:*">用户管理</s:hasPermission>
            <ul>
                <li><s:hasPermission name="system:user:updatePassword">个人密码修改</s:hasPermission></li>
                <li><s:hasPermission name="system:user:doResetPassword">重置用户密码</s:hasPermission></li>
            </ul>
        </li>
        <li>
            <s:hasPermission name="system:dict:*">数据字典管理</s:hasPermission>
            <ul>
                <li><s:hasPermission name="system:dict:add">数据字典新增</s:hasPermission></li>
                <li><s:hasPermission name="system:dict:edit">数据字典修改</s:hasPermission></li>
                <li><s:hasPermission name="system:dict:del">数据字典删除</s:hasPermission></li>
                <li><s:hasPermission name="system:dict:view">数据字典查询</s:hasPermission></li>
            </ul>
        </li>
    </ul>
    <hr>
    <ul>
        系统功能一览
        <li>
            用户管理
            <ul>
                <li><a href="${ctx}/userInfo/updatePassword">个人密码修改</a></li>
                <li><a href="${ctx}/userInfo/doResetPassword">重置用户密码</a></li>
            </ul>
        </li>
        <li>
            数据字典管理
            <ul>
                <li><a href="${ctx}/dict/add">数据字典新增</a></li>
                <li><a href="${ctx}/dict/edit">数据字典修改</a></li>
                <li><a href="${ctx}/dict/del">数据字典删除</a></li>
                <li><a href="${ctx}/dict/load">数据字典查单个</a></li>
                <li><a href="${ctx}/dict/list">数据字典查全部</a></li>
            </ul>
        </li>
    </ul>
</body>
</html>