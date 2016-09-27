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
        <dd class="s-text">3.提交订单错误<s></s><b></b></dd>
      </dl>
    </div>
  </div>
</@layout_header>

<div class="content">
  <div class="w1000">
    <div class="success">
      <div class="pull-left"><i class="icon"></i></div>
      <div class="pull-right">
        <h2 class="green">提交订单出现错误！</h2>
        
        <p class="black">${errMsg}</p>
        
        <div class="button marginTop font12"><a href="${base}/cart/buycart" class="btn btn-red">返回修改购物车</a></div>
      </div>
    </div>
  </div>
</div>
<#include "/common/footer.ftl">
</body>
</html>