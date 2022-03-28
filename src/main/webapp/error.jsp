<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Fejlside
    </jsp:attribute>

    <jsp:attribute name="footer">
            Fejlside
    </jsp:attribute>

    <jsp:body>

        <p>UPS! Der er opstået en fejl. Her er den bedste besked vi kan give lige nu: </p>

        <c:if test="${pageContext.errorData.statusCode == 404 }">
            <p><b>Error code:</b> ${pageContext.errorData.statusCode}</p>
        </c:if>

        <c:if test="${pageContext.errorData.statusCode == 500 }">
            <p><b>Error code:</b> ${pageContext.errorData.statusCode}</p>
            <p>Der er sket en seriøs fejl på serveren.</p>
        </c:if>


        <c:if test="${requestScope.fejlbesked != null}">
            <p>${requestScope.fejlbesked}</p>
        </c:if>

        <c:if test="${requestScope.fejlbesked  == null}">
            <p>Den er helt gal. Vi ved ikke hvordan du er havnet her. Så kontakt bibliotekaren.</p>
        </c:if>

        <p>Hop tilbage til <a href="index.jsp">Forsiden</a> her,
            eller prøv at <a href="login.jsp">logge</a> på igen.</p>

    </jsp:body>
</t:pagetemplate>