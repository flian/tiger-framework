<#assign base = "${rc.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商城</title>
<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap.css">
<link href="${base}/css/common.css" rel="stylesheet" type="text/css">
<link href="${base}/css/table.css" rel="stylesheet" type="text/css">
<link href="${base}/css/orderinfo.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
</head>

<body>
<#include "/common/header.ftl">
<@layout_header>
<div class="cont w1000">
    <#include "/common/log.ftl">
    <div class="stepflex fonts font12">
      <dl class="first done">
        <dt class="s-num">1</dt>
        <dd class="s-text">1.我的购物车<s></s><b></b></dd>
      </dl>
      <dl class="normal doing">
        <dt class="s-num">2</dt>
        <dd class="s-text">2.填写核对订单信息<s></s><b></b></dd>
      </dl>
      <dl class="normal last">
        <dt class="s-num">3</dt>
        <dd class="s-text">3.成功提交订单<s></s><b></b></dd>
      </dl>
    </div>
  </div>
</@layout_header>
<form action="${base}/order/submitOrder" method="POST" >
<div class="content">
  <div class="w1000">
    <div class="item">
      <h2><span class="font16 pull-left white">配送商品订单信息</span><span class="more pull-right font12"><a href="${base}/cart/buycart">返回购物车</a></span></h2>
      <div class="cont">
        <div class="row">
          <h3 class="font14">配送方式和收货信息：</h3>
          <div class="myAddress font12 marginBottom grayBg"><span class="pull-right editAddress blueLine"><a href="javascript:;" class="showWin" data="changeAddress">修改收货地址</a></span><span>收货人姓名：${address.name}</span><span>手机：${address.phone}</span><span>电话：${address.telephone}</span><span>地址：${address.province}${address.city}${address.country}${address.content}</span></div>
        </div>
        <div class="row">
          <h3 class="font14">商品清单：</h3>
          <table border="0" cellspacing="0" cellpadding="0" class="table tableD">
            <tr class="title font14">
              <th>商品名称</th>
              <th>单价</th>
              <th>数量</th>
              <th>小计</th>
              <th>是否有货</th>
            </tr>
            <#list list as c>
            <tr>
              <td><p>${c.sku.name}</p></td>
              <td>${c.sku.salePrice}</td>
              <td>${c.buyNum}</td>
              <td>${c.buyNum*c.sku.salePrice}</td>
              <td><#if (c.sku.stockLevel>0) > 有货<#else>无货</#if></td>
            </tr>
            </#list>
          </table>
        </div>
      </div>
    </div>
    
    <input name="addressId" value="${address.id}" type="hidden" />
    
    <div class="item money">
      <h2><span class="font16 pull-left white">合计支付信息</span><span class="more pull-right font12"><a href="${base}/cart/buycart">返回购物车</a></span></h2>
      <div class="cont">
        <p><span>订单总额：</span><font class="red bold">¥20.00</font></p>
        <div class="button"><input type="submit" value="提交订单" class="btn font16 btn-danger" /></div>
      </div>
    </div>
  </div>
</div>
</form>
<#include "/common/footer.ftl">
</body>
</html>