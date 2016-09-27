<#assign base = "${rc.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商城</title>
<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap.css">
<link href="${base}/css/common.css" rel="stylesheet" type="text/css">
<link href="${base}/css/table.css" rel="stylesheet" type="text/css">
<link href="${base}/css/details.css" rel="stylesheet" type="text/css">
<link href="${base}/css/showpic.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
<script type="text/javascript" src="${base}/js/layer/layer.js"></script>
<script type="text/javascript" src="${base}/js/jquery.fly.min.js"></script>
</head>

<body>
<#include "/common/header.ftl">
<@layout_header>
	<#include "/common/search.ftl">
</@layout_header>
<#include "/common/nav.ftl">
<div class="content">
  <div class="grayBg">
    <div class="w1000">
      <div class="Parth gray"><i class="icon"></i> 当前位置：<a href="../index.html">首页</a> &gt; <a href="list.html">购货积分礼品</a> &gt; 苹果iPad 2 WLAN 16G</div>
      <div class="productInfo">
        <div class="productPic">
          <div class="sec bnspic">
            <div class="big_pic">
              <ul>
                <li class="on"><img src="../images/pic-03.jpg" /></li>
                <li><img src="../images/pic-04.jpg" /></li>
                <li><img src="../images/personal05_01.jpg" /></li>
                <li><img src="../images/personal05_02.jpg" /></li>
                <li><img src="../images/personal05_04.jpg" /></li>
              </ul>
            </div>
            <!-- /big_pic -->
            <div class="small_pic clearfix">
              <ul>
                <li class="on"><img src="../images/pic-03.jpg" /></li>
                <li><img src="../images/pic-04.jpg" /></li>
                <li><img src="../images/personal05_01.jpg" /></li>
                <li><img src="../images/personal05_02.jpg" /></li>
                <li><img src="../images/personal05_04.jpg" /></li>
              </ul>
            </div>
            <!-- /small_pic --> 
          </div>
          <div class="moreLinks font12"> <span class="pull-right gray"><i class="icon"></i><a href="javascript:;">加入收藏夹</a></span> 
			<div class="jiathis_style">
				<a href="http://www.jiathis.com/share/" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank">分享到：</a>
				<a class="jiathis_button_qzone"></a>
				<a class="jiathis_button_tsina"></a>
				<a class="jiathis_button_tqq"></a>
				<a class="jiathis_button_weixin"></a>
				<a class="jiathis_button_renren"></a>
				
				<a class="jiathis_counter_style"></a>
			</div>
		  </div>
        </div>
        <div class="info">
          <form action="" method="post">
            <div class="mainInfo">
              <div class="itemName">
                <h2 class="font20">${sku.name}</h2>
                <span class="gray number font12"><font class="fonts">商品编号：</font>${sku.id}</span>
              </div>
              <div class="service"><span class="title"></span>
                <p class="gray font12">${product.description}</p>
              </div>
              <div class="buyNumber"><span class="title">价格：</span>
                <p class="red font16">￥${sku.stockLevel}</p>
              </div>
              <div class="charge grayBg"><span class="title">商品：</span>
                <ul>
                <#list skus as s>
                  <li <#if s.id == sku.id>class="active"</#if> ><a href="${base}/product/detail?productId=${product.id}&skuId=${s.id}">${s.name}</a></li>
                </#list>
                </ul>
              </div>
              <div class="addressInfo"><span class="title">提货地点：</span>
                <div class="address addressRight"><span class="fonts">广东省 广州市 专卖店</span>
                  <div class="subList"> <span class="closed" data="subList"><i class="icon"></i></span>
                    <div class="tags">
                      <ul>
                        <li>广东省</li>
                        <li>广州市</li>
                        <li>提货点</li>
                      </ul>
                    </div>
                    <div class="shown">
                      <div class="cont">
                        <ul class="areaList">
                          <li><a href="#none" data-value="1">北京</a></li>
                          
                        </ul>
                      </div>
                      <div class="cont">
                        <ul class="areaList">
                          <li><a href="#none" data-value="1601">广州市</a></li>
                          
                        </ul>
                      </div>
                      <div class="cont">
                        <ul class="areaList">
                          <li><a href="#none" data-value="1601">专卖店</a></li>
                          <li><a href="#none" data-value="1607">服务中心</a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <span class="font16"><#if (sku.stockLevel>0) >有货<#else>无货</#if></span> </div>
              <div class="buyNumber"><span class="title">兑换数量：</span>
                <div class="changeNumber" id="buyNumber">
                  <span class="reduceNumber">-</span>
                  <input name="buyNum" id="buyNum" type="text" class="text" value="1">
                  <span class="AddNumber">+</span> </div><font>有货</font>
              </div>
            </div>
            <div class="button"><a href="javascript:;" class="submit02 addBuycar">加入购物车</a></div>
            <div class="notice red">重要提示：礼品如有质量问题或使用咨询，请拨打售后服务热线：400-000-0000</div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="w1000">
    <div class="main marginTop">
      <div class="tags">
        <ul>
          <li class="active">礼品详情</li>
          <li>礼品评价</li>
        </ul>
      </div>
      <div class="shown">
        <div class="cont">
          <div class="pic center">
          	${product.longDescription}
          </div>
        </div>
        <div class="cont"><div class="guestBook">
            <div class="guestList font12">
              <ul>
                
                <li>
                  <div class="conts"> 不错，现场拆开看了一下才签收的，送货速度很快！礼品很漂亮，看得出来是运营人员用心挑选的，赞一个！ </div>
                  <div class="stars">
                    <p class="center"><span class="commstar showStar"> <span class="star star5"></span></span><br>
                      5分 </p>
                  </div>
                  <div class="users"><span class="font14">唐女士</span><span class="font12 gray">2016-03-03 16:36:34</span></div>
                </li>
              </ul>
            </div>
            <div class="pageList">
              <ul class="pagination">
                <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
              </ul>
            </div>
          </div></div>
      </div>
    </div>
    <div class="sidebar marginTop marginLeft">
      <div class="item productList">
        <h2 class="font16">同类推荐</h2>
        <div class="cont">
          <ul>
            <li>
              <div class="pic"> <a href="details.html" class="block"><img src="../images/pic-03.jpg" width="78" height="78"></a></div>
              <div class="info">
                <h3><a href="details.html">零点之约背光游戏键鼠套装</a> </h3>
              </div>
            </li>
            
          </ul>
        </div>
      </div>
      
      <div class="item productList marginTop">
        <h2 class="font16">你浏览过的礼品</h2>
        <div class="cont">
          <ul>
            <li>
              <div class="pic"> <a href="details.html" class="block"><img src="../images/pic-03.jpg" width="78" height="78"></a></div>
              <div class="info">
                <h3><a href="details.html">零点之约背光游戏键鼠套装</a> </h3>
              </div>
            </li>
            
          </ul>
        </div>
      </div>
    </div>
   <#include "/common/help.ftl">
  </div>
</div>
<#include "/common/footer.ftl">
<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	//产品大图切换
	$(".small_pic li").click(function(){
		$(this).siblings().removeClass("on");
		$(this).addClass("on");
		var preNumber=$(this).prevAll().size()+1;
		$(".big_pic li").removeClass("on");
		$(".big_pic li:nth-child("+preNumber+")").addClass("on");
	});
	//购物车动画
	var offset = $("#end").offset();
	$(".addBuycar").click(function(event){
		var buyNum = $("#buyNum").val();
		var msg = '已成功加入购物车！';
		$.ajax({
			url:"${base}/cart/addcart?skuId="+${sku.id}+"&buyNum="+buyNum,
			async:false,
			success:function(resdata){
				$("#buycartNum").html(resdata);
			},
			error:function(resdata){
				msg = '加入购物车失败!';
			}
		})
		var addcar = $(this);
		var img = addcar.parents(".productInfo").find('.big_pic .on img').attr('src');
		var flyer = $('<img class="u-flyer" src="'+img+'" style="z-index:3;">');
		flyer.fly({
			start: {left: event.pageX-616,top: event.pageY-354},
			end: {left:offset.left+10,top:offset.top+10,width:0,height:0},
			onEnd: function(){layer.msg(msg,{time:1000});this.destory();}
		});
	});
});
</script>
</body>
</html>
