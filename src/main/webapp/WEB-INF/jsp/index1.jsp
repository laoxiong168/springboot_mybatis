<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <script type="text/javascript" src="../../static/jquery-3.3.1.min.js"></script>
    <%--联网的jquery--%>
    <title>咱的笔记</title>


    <link rel="stylesheet" type="text/css" href="../../static/bootstrap.css">
    <link href="../../static/summernote.css" rel="stylesheet">

    <script src="../../static/bootstrap.min.js"></script>
    <script src="../../static/summernote.js"></script>
    <script src="../../static/summernote-zh-CN.js"></script>
    <!-- 中文-->

    <style>
        .m {
            width: 800px;
            margin-left: auto;
            margin-right: auto;
        }
    </style>

    <script>
        $(function() {
            $('.summernote').summernote({
                height: 200,
                tabsize: 2,
                lang: 'zh-CN'
            });

            //文本内容获取
            $("#btn").click(function() {
                alert($('.summernote').summernote('code'));
            });




        });
    </script>
</head>
<body>
<div class="m">
    <div id="div1" class="summernote">输入文本</div>
    <input id="btn" type="button" value="submmit" />
</div>
</body>
</html>