<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="my first JSP Page"/>
    </jsp:include>
    <body>
        <form method="GET" action="CountWordsServlet">
            <label> Insérer une phrase : </label>
            <input type="text" name="sentence" value=""/>
            <input type="submit" value="Nombre de mots" />
            <br>
        </form>

        <c:if test="${number != null}">
            <p><c:out value="${number}"/></p>
        </c:if>
    </body>
</html>
