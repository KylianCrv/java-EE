<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="my first JSP Page"/>
    </jsp:include>

    <body>
        <c:set var = "name" value="Kylian"/>


<!--        <p>Bonjour <b><%= request.getParameter("name")%>  </b>!</p>
        -->        <p>Bonjour <b><c:out value="${name}"/> </b>!</p>

    </body>
</html>
