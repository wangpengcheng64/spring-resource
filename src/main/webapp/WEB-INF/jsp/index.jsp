<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ModelAndView测试</title>
</head>
<body>
    <h1>
        ModelAndView测试，视图渲染
    </h1>
    <table style="border: 2px red">
        <tr>
            <td style="width: 100px">编号</td>
            <td style="width: 100px">姓名</td>
            <td style="width: 300px">创建时间</td>
        </tr>
        <tr>
            <td style="width: 100px">${user.id}</td>
            <td style="width: 100px">${user.name}</td>
            <td style="width: 300px">${user.createTime}</td>
        </tr>
    </table>
</body>
</html>
