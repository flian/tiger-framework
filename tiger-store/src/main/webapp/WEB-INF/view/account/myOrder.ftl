<#assign base = "${rc.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商城</title>
<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap.css">
<link href="${base}/css/datepicker.css" rel="stylesheet" type="text/css">
<link href="${base}/css/common.css" rel="stylesheet" type="text/css">
<link href="${base}/css/personal.css" rel="stylesheet" type="text/css">
<link href="${base}/css/table.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
<script type="text/javascript" src="${base}/js/bootstrap-datepicker.js"></script>
</head>

<body>
<#include "/common/header.ftl">
<@layout_header>
	<#include "/common/search.ftl">
</@layout_header>
<#include "/common/nav.ftl">
<div class="content">
  <div class="w1000">
    <div class="sidebar">
      <div class="item subLinks">
        <h2 class="font18">个人中心</h2>
       
        <ul>
          <ol>
            <i class="icon icon02"></i>订单信息
          </ol>
          <li class="active"><a href="${base}/account/myOrder">我的订单</a></li>
        </ul>
               
      </div>
    </div>
    <div class="main marginLeft">
      <div class="item marginTop">
        <h2><span class="title font16">我的订单</span><span class="red font12">未支付订单30分钟内完成支付，否者会失效！</span></h2>
        <div class="cont orderList pickingManager">
        <div class="pickingSearch marginTop font12">
            <form action="" class="tableForm" method="post">
              <ul>
                <li>
                <span class="title">订单号：</span> <label><input class="text" type="text"/></label>
                  <button class="btn btn-green">查询</button>
                </li>
                
              </ul>
            </form>
            <div class="clearAll"></div>
          </div>
          <#list list as order>
          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table tableB">
            <tr class="title">
              <th colspan="3">&nbsp; &nbsp;订单号：${order.master.orderId}</th>
              <th colspan="2">日期：</th>
              <th colspan="2"></th>
            </tr>
            <#list order.details as detail>
            <tr class="list">
              <td width="60" class="none"><div class="pic"><a href="${base}/product/detail?productId=${detail.productId}&skuId=${detail.skuId}" target="_blank"><img src="../images/pic-03.jpg" width="58" height="58"></a></div></td>
              <td width="200" class="none"><span class="title"><a href="${base}/product/detail?productId=${detail.productId}&skuId=${detail.skuId}" target="_blank">${detail.name}</a></span></td>
              <td width="50"><span class="gray">×${detail.buyNum}</span></td>
              <#if detail_index==0>
              <td rowspan="${order.details?size}" width="100">${order.address.name}</td>
              <td rowspan="${order.details?size}" width="140">￥${order.master.totalMoney}</td>
              <td rowspan="${order.details?size}" width="100">
              	<#list orderStatus as status>
              		<#if status.index == order.master.orderStatus>
              			${status.value}
              		</#if>
              	</#list>
              </td>
              <td rowspan="${order.details?size}">
              	<#if order.master.orderStatus == '01'>
                <div class="marginBottom5"><button class="btn mini-btn btn-red">立即支付</button></div>
                </#if>
                <div><span class="blueLine"><a href="${base}/account/orderinfo?orderId=${order.master.orderId}">查看详情</a></span></div>
              </td>
              </#if>
            </tr>
            </#list>
          </table>
          </#list>
          
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
          
        </div>
      </div>
    </div>
  </div>
</div>
<#include "/common/footer.ftl">
</body>
</html>