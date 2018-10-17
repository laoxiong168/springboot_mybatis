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

        body {
            font-size: 20px;
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
            margin-bottom: 0;
            display: inline-block;
            border-radius: 8px;
        }

        .textModule {
            padding-left: 5px;
            margin-left: 0;
            height: 200px;
            width: 100%;
            border: solid 1px #d2cdde;
            outline: none;
            border-radius: 8px;
            resize: none;
        }

        input {
           margin-left: 8px;
        }
    </style>
</head>
<body>
<div class="main">
    <%--删除输入密码div--%>
    <div id="passwordDiv" style="display: none;width: 200px;height: 100px;position: fixed;left: 45%;top:35%;background-color: #d2cdde">
        <input id="password" type="password" placeholder="输入密码" />
        <input id="passwordConfirm" type="button" value="确定"/>
        <input id="passwordCancle" type="button" value="取消"/>
    </div>
    <%--新增木块的div--%>
    <div id="addModule" class="addModudle">

    </div>
    <div style="position: fixed;bottom: 2px;right:2px;margin-top: 1px;">
        <input type="button" value="新增" onclick="addModule()"/>
    </div>


    <script>
        function addModule(data, id) {
            if (data == undefined) {
                data = "";
            }
            var tempModule = " <div  class=\"childrenModule\">\n" +
                "            <textarea id='" + id + "' class=\"textModule\">\n" +
                data +
                "            </textarea>\n" +
                "            <input id=\"submmit\" type=\"button\" value=\"提交\" name=\"test\" onclick=\"ajaxSubmmit(this)\">\n" +
                "    <input id=\"deleteModule\" type=\"button\" value=\"删除\" name=\"test\" onclick=\"deleteModule(this)\">" +
                "        </div>";
            $("#addModule").append(tempModule);
        }

        // 删除模块
        function deleteModule(obj) {
            $("#passwordDiv").show();
            $("#passwordConfirm").click(function () {
                var password=    $("#password").val();
                alert(password);
                var data = "";
                ajaxTemplet('deleteModule', 'test');
                $(obj).parent().remove();
            });
            $("#passwordCancle").click(function () {
                $("#password").val("");
                $("#passwordDiv").hide();
            });

        }

        /**
         * 向后台提交content数据
         * @param obj
         */
        function ajaxSubmmit(obj) {
            var data = $(obj).parent().find("textarea").val();
            var id=$(obj).parent().find("textarea").attr("id");
            $.ajax({
                url: 'ajaxSubmmit',
                type: 'get',
                dataType: 'json',
                data: {"data": data,"id":id},
                success: function (data) {
                    alert("新增成功！" + data.success);
                },
                error: function (data) {
                    alert("error")
                }
            })
        }

        // ajax模板
        function ajaxTemplet(url, data) {
            $.ajax({
                url: url,
                type: 'get',
                dataType: 'json',
                data: {"data": data},
                success: function (data) {
                    alert("成功！");
                },
                error: function (data) {
                    alert("心情好的时候再完善这个功能")
                }
            })
        }

        /**
         * 页面加载完毕后获取后台数据至前台展现
         */
        $(function () {
            $.ajax({
                url: "/getAllContents",
                type: "get",
                dataType: "json",
                data: {},
                success: function (data) {
                    $.each(data, function (index, indexContent) {
                        addModule(indexContent.content, indexContent.id);
                    })
                },
                error: function (data) {
                    alert("error");
                }
            })
        })


    </script>

</div>
</body>
</html>