<#include "/layout/store.ftl">
<@layout_store title="">
<div class="content">
  <div class="w1000">
    <div class="sidebar">
      <div class="prodectType marginTop">
        <div class="title font18 bold white"><i class="icon"></i>商品分类</div>
       <#include "/common/category.ftl">
      </div>
      <div class="item productList marginTop">
        <h2 class="font16">热门商品</h2>
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
        <h2 class="font16">你浏览过的商品</h2>
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
    <div class="main marginTop marginLeft">
      <div class="Parth gray"><i class="icon"></i> 当前位置：<a href="#">首页</a> &gt; 商品</div>
      <div class="typeSelect">
        <h2 class="font16">商品筛选</h2>
        <div class="cont">
          <ul>
            <li><span class="title">礼品类型：</span> <a href="#" class="active">不限</a><a href="#">礼品</a><a href="#">京东礼品</a></li>
            <li><span class="title">支付方式：</span> <a href="#" class="active">不限</a><a href="#">纯积分兑换</a><a href="#">积分+现金兑换</a></li>
            <li>
              <div class="pull-right">
                <form action="" method="post">
                  <input name="" type="text" class="text">
                  -
                  <input name="" type="text" class="text">
                  <input type="button" class="submit" value="确定">
                </form>
              </div>
              <span class="title">价格范围：</span> <a href="#">不限</a><a href="#" class="active">1-1000</a><a href="#">1000-3000</a><a href="#">3000-5000</a><a href="#">5000以上</a></li>
          </ul>
        </div>
      </div>
      <div class="prodectList marginTop">
        <div class="listSelect">
          <div class="ranking">
          	排序方式：<a href="javascript:;" class="active">销量</a>
          	<a href="javascript:;">价格</a>
          	<a href="javascript:;">评论数</a>
          	<a href="javascript:;">上架时间</a>
          </div>
          <div class="pull-right"><span class="pull-left">配送区域：</span>
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
            <span>
            <input name="" type="checkbox" value="" checked>
            </span> 仅显示有货
            </label>
          </div>
        </div>
        <div class="cont">
        
        <#list sku as p>
          <div class="item">
            <div class="pic"> <a href="${base}/product/detail?productId=${p.productId}&skuId=${p.id}" class="black"><img src="${p.img}" width="158" height="158"></a></div>
            <div class="info">
              <h2><a href="${base}/product/detail?productId=${p.productId}&skuId=${p.id}">${p.name}</a> </h2>
              <p class="font12">价格：<span class="orange" title="${p.price}">${p.price}</span></p>
            </div>
          </div>
        </#list>
        
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
      </div>
    </div>
    <#include "/common/help.ftl">
  </div>
</div>
</@layout_store>