<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Login page" />
    </jsp:include>
    <body>
        <form method="POST">
            <fieldset>
                <legend>Formulaire d'authentification : </legend>
                <p>
                    <label>Email : </label>
                    <input type="email" name="email" required/>
                </p>
                <p>
                    <label>Mot de passe : </label>
                    <input type="password" name="password" required/>
                </p>
                <input type="submit" value="Connexion" />
                <c:if test="${error != null}">
                    <p style="color:red;"><c:out value="${error}" /></p>
                </c:if>
            </fieldset>
        </form>

    </body>
</html>
