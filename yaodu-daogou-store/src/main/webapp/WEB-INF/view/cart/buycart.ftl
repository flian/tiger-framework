<#assign base = "${rc.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商城</title>
<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap.css">
<link href="${base}/css/common.css" rel="stylesheet" type="text/css">
<link href="${base}/css/buychart.css" rel="stylesheet" type="text/css">
<link href="${base}/css/table.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
<script type="text/javascript" src="${base}/js/layer/layer.js"></script>
</head>

<body>
<#include "/common/header.ftl">
<@layout_header>
<div class="cont w1000">
    <#include "/common/log.ftl">
    <div class="stepflex fonts font12">
      <dl class="first doing">
        <dt class="s-num">1</dt>
        <dd class="s-text">1.我的购物车<s></s><b></b></dd>
      </dl>
      <dl class="normal">
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
<div class="content">
  <div class="w1000">
    <div class="item">
      <div class="title">
        <div class="pull-right"><span class="pull-left">配送至：</span>
          <div class="address addressLeft"><span class="fonts">广东省 广州市 专卖店</span>
            <div class="subList">
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
        </div>
        <span class="font16">商品列表</span></div>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table tableC owens">
        <tr class="titles">
          <th width="60"><label> <span>
              <input name="wxj" type="checkbox">
              </span> 全选</label></th>
          <th colspan="2">礼品信息</th>
          <th>单价</th>
          <th>数量</th>
          <th>金额小计</th>
          <th width="80">库存</th>
          <th width="140">操作</th>
        </tr>
        <#list carts as c>
        <tr class="select">
          <td><label> <span>
              <input name="wxj" type="checkbox" checked>
              </span> </label></td>
          <td width="70"><div class="pic"><a href="${base}/product/detail?productId=${c.sku.productId}&skuId=${c.sku.id}" target="_blank"><img src="../images/pic-03.jpg" width="58" height="58"></a></div></td>
          <td width="280"><span class="title"><a href="${base}/product/detail?productId=${c.sku.productId}&skuId=${c.sku.id}" target="_blank">${c.sku.name}</a></span><strong></strong></td>
          <td>${c.sku.salePrice}</td>
          <td><div class="changeNumber" id="changeNumber${c_index}"><!--此处需要独立命名ID-->
          	  <span class="reduceNumber">-</span>
              <input name="buyNum" id="buyNum" type="text" class="text" value="${c.buyNum}">
              <span class="AddNumber">+</span></div></td>
          <td><span class="bold">${c.buyNum*c.sku.salePrice}</span></td>
          <td><#if (c.sku.stockLevel>0) > 有货<#else>无货</#if></td>
          <td><p><a href="#" class="addCollect">加入收藏夹</a><br>
              <a href="#" class="isDelete">删除</a></p></td>
        </tr>
        </#list>
      </table>
    </div>
    
    <div class="item checkAll kuang">
      <ul>
        <li class="fonts font12">
          <label><span>
            <input name="" type="checkbox" value="">
            </span> 全选</label>
          <em></em>删除选中礼品</li>
        <li class="fonts font12">已选礼品<font class="red bold"> ${carts?size} </font>件</li>
        <li class="all">合计：<font class="red bold showWin" data="codeMobile">¥5.00</font> <a href="${base}/order/confirmOrder" class="btn font16 btn-danger">去结算</a> </li>
      </ul>
    </div>
  </div>
</div>
<#include "/common/footer.ftl">
</body>
</html>