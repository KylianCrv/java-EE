<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <jsp:include page="/include/header.jsp">
        <jsp:param name="title" value="Distributeur"/>
    </jsp:include>
    <body>
        <h2>Crédit restant : ${credit}</h2>

        <table>
            <caption>Liste des produits</caption>
            <tr>
                <th>Numéro du produit</th>
                <th>Nom</th>
                <th>Quantité</th>
                <th>Prix</th>
            </tr>

            <c:forEach items="${stock}" var="product">
                <tr>
                    <td><c:out value="${product.getId()}"/></td>
                    <td><c:out value="${product.getNom()}"/></td>
                    <td><c:out value="${product.getQuantite()}"/></td>
                    <td><c:out value="${product.getPrix()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
