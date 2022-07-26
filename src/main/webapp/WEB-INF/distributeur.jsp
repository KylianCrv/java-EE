<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Distributeur"/>
    </jsp:include>
    <body>
        <h1>Crédit restant : ${credit}"</h1>

        <table>
            <thead>
            <th colspan="4">Liste des produits</th>
        </thead>
        <tbody>
        <td>Numéro de produit</td>
        <td>Nom</td>
        <td>Quantité</td>
        <td>Prix</td>

        <c:forEach var="stock" begin="" end="">

        </c:forEach>
    </tbody>
</table>
</body>
</html>
