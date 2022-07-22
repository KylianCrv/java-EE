<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="include/header.jsp">
        <jsp:param name="title" value="my second JSP Page"/>
    </jsp:include>
    <body>
        <h2>Ceci est ma deuxième page JSP</h2>
<!--        <p>Au revoir <b><%= request.getParameter("name")%>  </b>!</p>-->
        <p>Au revoir <b> ${name}  </b>!</p>

    </body>
</html>
