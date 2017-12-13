<span style="font-weight: normal;"><%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
    <!-- Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!--<script type="text/javascript" src="js/jquery-1.7.2.js"></script>-->
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>webSocket测试</title>
    <script type="text/javascript">
        $(function(){
            var websocket;
            if ('WebSocket' in window) {
                alert("WebSocket");
                /*ws表明协议使用的是WebSocket协议*/
                websocket = new WebSocket("ws://localhost:8080/websocket");
            } else if ('MozWebSocket' in window) {
                alert("MozWebSocket");
                websocket = new MozWebSocket("ws://echo");
            } else {
                alert("SockJS");
                websocket = new SockJS("http://localhost:8080/sockjs/websocket")
            }
            /*如果成功连接，就会执行onopen；如果连接失败，就会执行onerror；
            如果连接断开，就会执行onclose，如果服务器有消息发送过来，就会执行onmessage。*/
            websocket.onopen = function (evnt) {
                $("#tou").html("链接服务器成功!")
            };
            websocket.onmessage = function (evnt) {
                $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
            };
            websocket.onerror = function (evnt) {
            };
            websocket.onclose = function (evnt) {
                $("#tou").html("与服务器断开了链接!")
            }
            $('#send').bind('click', function() {
                alert("send");
                send();
            });
            function send(){
                if (websocket != null) {
                    var message = document.getElementById('message').value;
                    websocket.send(message);
                } else {
                    alert('未与服务器链接.');
                }
            }
        });
    </script>

</head>
<body>

<div class="page-header" id="tou">
    webSocketDemo程序
</div>
<div class="well" id="msg">
</div>
<div class="col-lg">
    <div class="input-group">
        <input type="text" class="form-control" placeholder="发送信息..." id="message">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button" id="send" >发送</button>
      </span>
    </div><!-- /input-group -->
</div><!-- /.col-lg-6 -->
</div><!-- /.row -->
</body>

</html></span>