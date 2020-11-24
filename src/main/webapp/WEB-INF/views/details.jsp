<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<h1>${user.getName()}</h1>
<table border="0">
        <tr>
            <td>
                <img src="${user.getLargePicture()}"/>
            </td>
        </tr>
</table>
<h2>gender: ${user.getGender()}</h2>
<h2>email: ${user.getEmail()}</h2>
<h2>phone: ${user.getPhone()}</h2>
<h2>address: ${user.getAddress()}</h2>
<h2>nat: ${user.getNat()}</h2>
</body>
</html>
