<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Persons</title>
</head>
<body>
<h1>Persons</h1>
<table border="1">
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <img src="${user.getThumbnailPicture()}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/details?id=${user.getId()}"> "${user.getName()}" </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
