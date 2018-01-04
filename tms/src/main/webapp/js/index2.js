jQuery(function(){
    //新闻轮播
    jQuery(window).load(function() {
        jQuery('.flexslider').flexslider();
    });
    jQuery(document).ready(function() {
        jQuery('.flexslider').hover(function() {
            jQuery('.flex-direction-nav li a.prev').css('display', 'block');
            jQuery('.flex-direction-nav li a.next').css('display', 'block');
        }, function() {
            jQuery('.flex-direction-nav li a.prev').css('display', 'none');
            jQuery('.flex-direction-nav li a.next').css('display', 'none');
        });
    });
    //供求信息
    jQuery('.supply_nav a').click(function(){
        jQuery(this).addClass('hover').siblings().removeClass('hover');
        jQuery('.supply_box>div:eq('+jQuery(this).index()+')').show().siblings().hide();
    });
    //右侧留言
    jQuery('.liu_touch').mouseover(function(){
        jQuery(this).addClass('hover');
        jQuery('.liu_box').show();
    });
    jQuery('.liu_touch').mouseleave(function(){
        jQuery(this).removeClass('hover');
        jQuery('.liu_box').hide();
    });
    /*首页海关数据*/
    jQuery('.customs_nav span').click(function(){
        jQuery(this).addClass('hover').siblings().removeClass('hover');
        jQuery('.customs_box>div:eq('+jQuery(this).index()+')').show().siblings().hide();
    });

    //新闻资讯
    jQuery('.news_left2_nav span').click(function(){
        jQuery(this).addClass('hover').siblings().removeClass('hover');
        jQuery('.news_left2_box>div:eq('+jQuery(this).index()+')').show().siblings().hide();
    });
    //市场价格
    jQuery('.price_nav span').click(function(){
        jQuery(this).addClass('hover').siblings().removeClass('hover');
        jQuery('.price_list>div:eq('+jQuery(this).index()+')').show().siblings().hide();
    });
    //订购，定制-详情页
    jQuery('.ding_xiang_xx2_nav h2').click(function(){
        jQuery(this).addClass('hover').siblings().removeClass('hover');
        jQuery('.ding_xiang_xx2_box>div:eq('+jQuery(this).index()+')').show().siblings().hide();
    });

    jQuery('.trade_left1_li_list1 span').click(function(){
        jQuery(this).addClass('hover').siblings().removeClass('hover');
    });
    //bannerlunbo
    /*jQuery(".slides1").poposlides();*/
    //支付
    //jQuery('.pay2 li').click(function(){
    //	jQuery(this).find('.pay_con').slideDown().parents('.pay2 li').siblings('.pay2 li').find('.pay_con').slideUp();
    //});
});