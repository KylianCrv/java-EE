<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="my first JSP Page"/>
    </jsp:include>

    <body>
        <h2>Ceci est ma première page JSP</h2>
<!--        <p>Bonjour <b><%= request.getParameter("name")%>  </b>!</p>-->
        <p>Bonjour <b>${name} </b>!</p>

    </body>
</html>
