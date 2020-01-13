<nav id="sub_menu">
    <ul>
        <c:if test="${sessionScope.id eq null}">
            <li><a href="/mvc2/main.do?cmd=login">Login</a></li>
            <li><a href="/mvc2">Join Us</a></li>
        </c:if>
        <c:if test="${sessionScope.id ne null}">
            <li><a href="/mvc2">Logout</a></li>
        </c:if>
        <li><a href="/mvc2">Board</a></li>
        <li><a href="#">Ajax Board</a></li>
    </ul>
</nav>
