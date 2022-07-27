<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Page d'accueil" />
    </jsp:include>
    <body>
        <h3 style="color : red">Veuillez vérifier vos identifiants</h3>

        <br>

        <a href="LoginServlet" > Vers page de connexion </a>
    </body>
</html>
