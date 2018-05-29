<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎【<shiro:principal property="username"/>】光临
<a href="/logout">注销</a>
<br/>
<shiro:hasPermission name="employee:list">
    <a href="/employee">员工列表</a><br>
</shiro:hasPermission>

<shiro:hasPermission name="department:list">
    <a href="/department">部门列表</a><br>
</shiro:hasPermission>
</body>
</html>
