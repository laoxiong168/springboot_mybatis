<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <script type="text/javascript" src="../../static/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../static/bootstrap.css">
    <link href="../../static/summernote.css" rel="stylesheet">
    <script src="../../static/bootstrap.min.js"></script>
    <script src="../../static/summernote.js"></script>
    <script src="../../static/summernote-zh-CN.js"></script>
    <script src="../../static/my.css"></script>
    <title></title>
</head>
<body>
<div class="m">
    <div id="div1" class="summernote"></div>
    <input id="btn" type="button" value="提交" style="position: fixed;bottom: 10px;right: 10px;"  />
</div>
<div class="main">
    <%--Tip提示框--%>
    <div id="tips" style="display: none;width: 80px;height: 20px;position: fixed;left: 48%;top:25%;background-color: antiquewhite">
        <span id="tipsContent"></span>
    </div>
    <%--删除输入密码div--%>
    <div id="passwordDiv"
         style="border-radius: 5px; display: none;width: 200px;height: 100px;position: fixed;left: 45%;top:35%;background-color: #d2cdde">
        <input id="password" type="password" placeholder="输入密码"/>
        <input id="passwordConfirm" type="button" value="确定"/>
        <input id="passwordCancle" type="button" value="取消"/>
    </div>


    <script>

        var id="";
        $("#btn").click(function () {
           var contents= $('.summernote').summernote('code');
                    //向后台发送数据
            $.ajax({
                url: 'addContent',
                type: 'post',
                dataType: 'json',
                data: {"data": contents,"id":id},
                success: function (data) {
                    showTips("新增成功!");
                },
                error: function (data) {
                    showTips("错误!");
                }
            })

            // $('.summernote').summernote('code','-------------->');
        });

       function showTips(msg) {
           $("#tips").show();
           $("#tipsContent").text(msg);
           setTimeout(function () {
               $("#tips").hide();
               $("#tipsContent").text("");
           },3000);
       }

        /**
         * 页面加载完毕后获取后台数据至前台展现
         */
        $(function () {
            $('.summernote').summernote({
                height:600,
                tabsize: 2,
                lang: 'zh-CN'
            });

        // 页面加载时获取初始的后台数据
            $.ajax({
                url: "/getAllContents",
                type: "get",
                dataType: "json",
                data: {},
                success: function (data) {
                    $.each(data, function (index, indexContent) {
                        if (index==0) {
                            id=indexContent.id;
                            $('.summernote').summernote('code',indexContent.content);
                        }
                    })
                },
                error: function (data) {
                    alert("error");
                }
            });

        })



        //监听删除弹框的确定和取消按钮
        $("#passwordConfirm").click(function () {
            var password = $("#password").val();
            ajaxTemplet('deleteModule', password, id);
            $(obj).parent().remove();
        });
        $("#passwordCancle").click(function () {
            $("#password").val("");
            $("#passwordDiv").hide();
        });
    </script>

</div>
</body>
</html>