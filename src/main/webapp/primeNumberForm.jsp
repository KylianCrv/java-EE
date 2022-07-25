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

    </body>
</html>
