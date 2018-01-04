<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
	<meta charset="UTF-8">
</head>
<script src="http://gosspublic.alicdn.com/aliyun-oss-sdk-4.4.4.min.js"></script>
<script type="text/javascript">
    function upload() {
        var stokeUrl = "http://bucket.oss.aliyuncs.com/pictureserver/img.jpg"; //阿里云地址
        var accessKeyId = 'LTAIRtI3emeL5ibi',
            accessKeySecret = 'VtSIO4VZnSrWn67PLBRoc5PWlc6DCQ',
            stsToken = 'pictureserver';

        ajax("GET", stokeUrl, function(res) {
            var str = JSON.parse(res);
            accessKeyId = str.data.accessKeyId,
                accessKeySecret = str.data.accessKeySecret,
                stsToken = str.data.securityToken;
            //获得权限
            var client = new OSS.Wrapper({
                region: 'oss-cn-beijing.aliyuncs.com',//你自己的地址
                accessKeyId: accessKeyId,
                accessKeySecret: accessKeySecret,
                stsToken: stsToken,
                bucket: 'img'//文件名称
            });

            document.getElementById('file').addEventListener('change', function(e) {
                var file = e.target.files[0];
                console.log(e);
                var storeAs = 'upload-file';
                //图片名
                storeAs = 'test/'+file.name //所要上传的文件名拼接 (test/)
                console.log(storeAs);
                client.multipartUpload(storeAs, file).then(function(result) {
                    console.log("上传成功");
                    console.log(result);
                    //获得图片地址
                    var src = 'https://www.treeholeapp.com/' + result.name;
                    $("#img").attr('src', src);//赋值给img元素

                }).catch(function(err) {
                    console.log("上传失败");
                    console.log(err);
                });
            });

        })
    }

    function ajax(type, url, fnSucc, fnFaild) {
        //1.创建Ajax对象
        var oAjax = null;
        if(window.XMLHttpRequest) {
            oAjax = new XMLHttpRequest();
        } else {
            oAjax = new ActiveXObject("Microsoft.XMLHTTP");
        }

        //2.连接服务器
        oAjax.open(type, url, true);

        //3.发送请求
        oAjax.send();

        //4.接收服务器的返回
        oAjax.onreadystatechange = function() {
            if(oAjax.readyState == 4) //完成
            {
                if(oAjax.status == 200) //成功
                {
                    fnSucc(oAjax.responseText);
                } else {
                    if(fnFaild)
                        fnFaild(oAjax.status);
                }
            }
        };
    }
</script>
<body>

<form action="#" method="post" enctype="multipart/form-data">
	<input type="file" id="file" />
	<input  type="button" onclick="upload()">
</form>

</body>
</html>