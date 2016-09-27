<#assign base = "${rc.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商城</title>
<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap.css">
<link href="${base}/css/common.css" rel="stylesheet" type="text/css">
<link href="${base}/css/orderinfo.css" rel="stylesheet" type="text/css">
<link href="${base}/css/table.css" rel="stylesheet" type="text/css">
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
      <dl class="normal done">
        <dt class="s-num">2</dt>
        <dd class="s-text">2.填写核对订单信息<s></s><b></b></dd>
      </dl>
      <dl class="normal last doing">
        <dt class="s-num"></dt>
        <dd class="s-text">3.成功提交订单<s></s><b></b></dd>
      </dl>
    </div>
  </div>
</@layout_header>

<div class="content">
  <div class="w1000">
    <div class="success">
      <div class="pull-left"><i class="icon"></i></div>
      <div class="pull-right">
        <h2 class="green">订单已提交，请您尽快完成支付！</h2>
        
        <p class="black">共需支付金额：<font class="red bold">￥${order.master.totalMoney}元</font></p>
        
        <p class="font12">订单号：<font class="red bold">${order.master.orderId}</font></p>        
        <div class="button marginTop font12"><a href="###" class="btn btn-red">立即支付</a> <font class="font14">请不要关闭该页面，<font class="red bold">3</font> 秒钟后将会自动跳转至支付页面...</font></div>
        <p class="font12 yellow">友情提示：请在30分钟内完成支付，否则订单会被自动取消。</p>
      </div>
    </div>
  </div>
</div>
<#include "/common/footer.ftl">
</body>
</html>