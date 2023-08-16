<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // jsp
    String title = "페이지 제목";
    String content = "내용";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=title%>
    </title>
</head>
<body>
<%=content%>
<table>
    <tbody>
    <%-- jstl--%>
    <c:forEach var="city" items="${cities}">
        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
            <td>${city.countryCode}</td>
            <td>${city.district}</td>
            <td>${city.population}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>