<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="show adresse ip"/>
    </jsp:include>
    <body>
        <h2>Ceci est ma deuxième page JSP</h2>
        <p>Bonjour <b> ${nameClient}  </b>! <br>
            Votre adresse ip est : ${clientIP}</p>

    </body>
</html>

