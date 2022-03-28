<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Startcode
    </jsp:attribute>

    <jsp:attribute name="footer">
        Hej fra forsiden
    </jsp:attribute>

    <jsp:body>

        <p>Velkommen til 2. semesters startkode. </p>

        <c:if test="${sessionScope.bruger != null}">
            <p>Du er nu logget på med rollen "${sessionScope.bruger.rolle}".</p>
        </c:if>

        <c:if test="${sessionScope.bruger == null}">
            <p>Du er ikke logget på endnu. Du kan gøre det her: <a
                    href="login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>