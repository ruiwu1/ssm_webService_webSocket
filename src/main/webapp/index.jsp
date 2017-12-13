<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<c:set var="contextpath" value="${pageContext.request.contextPath}"
       scope="page" />
<html>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#butt").click(function () {
            alert("点击了");
        })
    })
</script>
<body>
<h2>Hello World!</h2>
<input type="button" value="thanks" id="butt">
</body>
</html>
