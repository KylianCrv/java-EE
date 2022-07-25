<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="my first JSP Page"/>
    </jsp:include>
    <body>
        <c:forEach var="i" begin="1" end="30" step="1">
            <c:if test="${i % 2 == 0}">
                <span><c:out value="${i}"/><br>
                </c:if>
            </c:forEach>
            </body>
            </html>
