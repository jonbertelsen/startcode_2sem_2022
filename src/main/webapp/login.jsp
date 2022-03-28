<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Login
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login
    </jsp:attribute>

    <jsp:body>

        <h3>Her kan du logge ind</h3>

        <form action="login" method="post">
            <label for="email">Brugernavn: </label>
            <input type="text" id="email" name="email"/>
            <label for="kodeord">Kodeord: </label>
            <input type="password" id="kodeord" name="kodeord"/>
            <input type="submit"  value="Log ind"/>
        </form>

    </jsp:body>
</t:pagetemplate>