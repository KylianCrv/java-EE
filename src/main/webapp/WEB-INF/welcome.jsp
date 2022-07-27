<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Welcome" />
    </jsp:include>
    <body>
        <h3>Bonjour <c:out value="${sessionScope.user.email}"/> vous êtes un <c:out value="${sessionScope.user.role}"/></h3>
    </body>
</html>
