<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-13
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/post_code.css" />
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <title>아이디/비밀번호 찾기</title>
</head>
<body>
<div id="warp">
    <!--헤더파일 들어가는 곳-->
    <%@ include file="../../include/header.jsp"%>

    <!--그림파일 들어가는 곳 없어도 되지만 한번 넣어보자-->
    <div id="sub_img">
    </div>
    <!--왼쪽의 서브메뉴가 들어가는 곳-->
    <%@ include file="../../include/left.jsp"%>

    <!--실제 내용 콘텐츠가 들어가는 곳-->
    <article id="contents">
        <div id="post_code_wrap">
            <h1>인증번호 확인</h1>
            <form class="post_code_form" method="post" action="main.do?cmd=confirmEmailCode">
                <div class="post_code">
                    <label>인증번호 : </label><input type="text" name="confirmCode" required autofocus size="30">
                    <input type="hidden" name="email" value="${requestScope.email}">
                    <input type="hidden" name="code" value="${requestScope.code}">
                    <input type="submit" value="확인" class="btn">
                </div>
            </form>
        </div>

        <div class="clear"></div>

    </article>



    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp"%>

</div><!--warp 끝나는 부분-->
</body>
</html>
