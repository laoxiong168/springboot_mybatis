<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <script type="text/javascript" src="../../static/jquery-3.3.1.min.js" ></script>
    <%--联网的jquery--%>
    <%--<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>--%>
    <title></title>
    <style>
        .main {
        }
        .common_div {
            width: 200px;
            height: 200px;
            background-color: antiquewhite;
        }

        .inline_div {
            display: inline-block;
        }
    </style>
    <script>
        $(function () {
        })
    </script>
</head>
<body>
<div class="main">
    <div class=" common_div inline_div"></div>
    <div class=" common_div inline_div"></div>
    <div class=" common_div inline_div"></div>
    <div>
        <input type="button" value="tes1t"/>
        <input type="button" value="发送" onclick="alert('%=basePath% ')"/>
    </div>


    <script>
        $(function () {
            alert("jquery success");
        })

    </script>
</div>
</body>
</html>