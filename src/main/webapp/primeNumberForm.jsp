<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="Formulaire prime number"/>
    </jsp:include>
    <body>
        <form method="GET" >
            <label> Insérer un nombre : </label>
            <input type="number" name="number" value=""/>
            <input type="submit" value="Nombre premier ? " />
            <br>
        </form>
        <c:if test="${param.number != null}">
            <c:set var="nbPremier" value="1"/>
            <c:forEach var="j" begin="2" end="${param.number - 1}" step="1">
                <c:if test="${number % j == 0 }">
                    <c:set var="nbPremier" value="0"/>
                </c:if>
            </c:forEach>

            <c:if test="${nbPremier == 1} ">
                <p><c:out value="${param.number}"/> nombre premier</p>
            </c:if>
            <c:if test="${nbPremier == 0} ">
                <p><c:out value="${param.number}"/> nombre non premier</p>
            </c:if>
        </c:if>
    </body>
</html>
