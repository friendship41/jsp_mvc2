<%--
  Created by IntelliJ IDEA.
  User: stage41
  Date: 2020-01-13
  Time: 오후 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/mvc2/css/join_us.css" />
    <script type="text/javascript" src="/mvc2/js/script.js"></script>
    <title>회원정보수정</title>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        function phone1(inp) {
            for(i=0 ; i<7; i++){
                if(document.join.tel1.options[i].value === inp)
                {
                    document.join.tel1.options[i].selected = true;
                    break;
                }
            }
        }
    </script>
</head>
<body onload="phone1('${requestScope.memberVO.tel1}')">
<div id="warp">
    <!--헤더파일 들어가는 곳-->
    <%@ include file="../../include/header.jsp" %>

    <!--그림파일 들어가는 곳 없어도 되지만 한번 넣어보자-->
    <div id="sub_img">
    </div>
    <!--왼쪽의 서브메뉴가 들어가는 곳-->
    <%@ include file="../../include/left.jsp" %>

    <!--실제 내용 콘텐츠가 들어가는 곳-->

    <article id="contents">
        <h1>정보수정</h1>
        <form name="join" id="join" method="post" action="main.do?cmd=memberModProc">
            <fieldset><legend>Basic Infomation</legend>
                <ul>
                    <li><label>User ID　</label><input type="text" id="id" name="id" class="id" value="${requestScope.memberVO.id}" readonly/></li>
                    <li><label>Password　</label><input type="password" id="pw" name="pw" class="pass"/></li>
                    <li><label>Retype Password　</label><input type="password" id="repw" class="pass"/></li>
                    <li><label>Name　</label><input type="text" id="name" name="name" class="nick" value="${requestScope.memberVO.name}" READONLY/></li>
                    <li><label>Email　</label><input type="text" id="email" name="email" class="email" value="${requestScope.memberVO.email}"/></li>

                </ul>
            </fieldset>
            <fieldset><legend>Optional</legend>

                <ul>
                    <li><label>Phone Number　</label>
                        <select name="tel1" id="tel1">
                            <option value="02" >02</option>
                            <option value="010">010</option>
                            <option value="011">011</option>
                            <option value="016">016</option>
                            <option value="017">017</option>
                            <option value="018">018</option>
                            <option value="019">019</option>
                        </select>-
                        <input type="text" id="tel2" name="tel2" class="tel" maxlength="4" size="5" value="${requestScope.memberVO.tel2}"/>-
                        <input type="text" id="tel3" name="tel3" class="tel" maxlength="4" size="5" value="${requestScope.memberVO.tel3}"/></li>

                    <li><label>Postal Code　</label>
                        <input type="text" id="postcode" name="postcode" class="" value="${requestScope.memberVO.postcode}" readOnly/>
                        <input type="button" value="찾기" onClick="sample6_execDaumPostcode()"/></li>
                    <li><label>Address1　</label>
                        <input type="text" id="address1" name="address1" class="address" value="${requestScope.memberVO.address1}" readonly/></li>
                    <li><label>Address2　</label>
                        <input type="text" id="address2" name="address2" class="address" value="${requestScope.memberVO.address2}"/></li>
                </ul>
            </fieldset>
            <div class="clear"></div>
            <div id="buttons">
                <input type="button" value="Submit" class="btn" onclick="checkmodForm()">
                <input type="button" value="Cancel" id="cancel" class="btn" onclick="goToHome()">
            </div>
        </form>


    </article>
    <div class="clear"></div>
    <!-- 푸터가 들어가는 곳 -->
    <%@ include file="../../include/footer.jsp" %>

</div><!--warp 끝나는 부분-->
</body>
</html>
