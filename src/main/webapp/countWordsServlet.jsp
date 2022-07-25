<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="my first JSP Page"/>
    </jsp:include>
    <body>
        <form>
            <input type="text" value="${phrase}"/>
            <input type="button" value="Nombre de mots" onclick=""/>
            <br>
            <c:out value="${count}"/>
        </form>
    </body>
</html>
