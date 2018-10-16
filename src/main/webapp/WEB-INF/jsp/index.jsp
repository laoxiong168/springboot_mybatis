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
    <%--<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>--%>
    <title></title>
    <style>
        .main {
            margin: 0 2%;
        }

        .common_div {
            width: 200px;
            height: 200px;
            background-color: antiquewhite;
        }

        .inline_div {
            display: inline-block;
        }

        .addModudle {
            height: 400px;
        }

        .childrenModule {
            height: 200px;
            width: 49%;
            background-color: azure;
            margin-top: 4px;
            margin-left: 4px;
            display: inline-block;
            border-radius: 8px;
        }

        .textModule {
            padding: 0;
            margin: 0;
            height: 200px;
            width: 100%;
            border: solid 1px;
            border-radius: 8px;
            resize: none;
        }
    </style>
</head>
<body>
<div class="main">
    <%--新增木块的div--%>
    <div id="addModule" class="addModudle">
        <div class="childrenModule">
            <textarea class="textModule">
            </textarea>
            <input id="test" type="button" value="提交" name="test" onclick="ajaxSubmmit(this)">
        </div>
    </div>
    <div>
        <input type="button" value="新增" onclick="addModule()"/>
    </div>


    <script>
        function addModule() {
            var tempModule = " <div  class=\"childrenModule\">\n" +
                "            <textarea class=\"textModule\">\n" +
                "            </textarea>\n" +
                "            <input id=\"test\" type=\"button\" value=\"提交\" name=\"test\" onclick=\"ajaxSubmmit(this)\">\n" +
                "        </div>";
            $("#addModule").append(tempModule);
        }

        function ajaxSubmmit(obj) {
            var data = $(obj).parent().find("textarea").val();
            $.ajax({
                url: 'ajaxTest',
                type: 'get',
                dataType: 'json',
                data: {"data": data},
                success: function (data) {
                    alert("新增成功！" + data.success);
                },
                error: function (data) {
                    alert("error")
                }
            })
        }


            $("textarea").keyup(function (e) {
                console.info($(this).val());

            })
    </script>

</div>
</body>
</html>