<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <c:if test="${sessionScope.id eq null}">
        <div id="login"><a href="/mvc2/main.do?cmd=login">Login</a> | <a href="/mvc2/main.do?cmd=join">Join</a></div>
    </c:if>
    <c:if test="${sessionScope.id ne null}">
        <div id="login">${sessionScope.id}님 환영합니다!  |  <a href="/mvc2/main.do?cmd=logout">Logout</a></div>
    </c:if>
    <div class="clear"></div>
    <div id="logo">
        <img src="/mvc2/images/logo.png" width="265" height="62" alt="Javaline Web"></div>
    <nav id="top_menu">
        <ul>
            <li><a href="/mvc2/main.do?cmd=index">Home</a></li>
            <li><a href="#">Who is Tommy.Lee?</a></li>
            <li><a href="/mvc2/main.do?cmd=login">Member</a></li>
            <li><a href="/mvc2">Board</a></li>
            <li><a href="#">Ajax Board</a></li>
        </ul>
    </nav>

</header>
