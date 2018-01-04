$(function(){
    list();
})
function list(curr){
    $.ajax({
        type: 'POST',
        url: "/product/getList" ,
        data: {page:curr||1,rows:10},
        dataType: "json",
        success: function(resp){
            console.log(resp);
            if(resp.success){
                var htmlStr = "";
                $.each(resp.o,function(){
                    var ut = this;
                    htmlStr+="<dl>";
                    htmlStr += " <dt><img alt='"+ut.title+"' src='"+ut.picUrl+"'/></dt>";
                      htmlStr+="<dd>"+ut.title+"</dd>";
                      htmlStr+="</dl>"
                });
                $('.data').html(htmlStr);

                layui.use(['laypage', 'layer'], function(){
                    var laypage = layui.laypage
                        ,layer=layui.layer;
                    laypage.render({
                        elem: 'pagediv', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
                        count: resp.msg, //通过后台拿到的总页数
                        skip:true,
                        limit:10,
                        groups:5,
                        first:'首页',
                        curr: curr || 1, //当前页
                        jump: function(obj, first){ //触发分页后的回调
                            if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                                $('html, body').animate({
                                    scrollTop: $("dl").offset().top
                                }, 2000);
                                list(obj.curr);
                            }

                        }
                    });
                });
            }
        },
        error:function(resp){
            console.log(resp);
        }
    });
}
function modify(id){
    alert(id);
}