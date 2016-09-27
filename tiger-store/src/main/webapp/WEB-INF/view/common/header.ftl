<#macro layout_header charset="utf-8" lang="zh-CN">
<div class="head">
  <div class="top font12">
    <div class="w1000">
      <div class="pull-left">欢迎来到XXX！ 客服热线：<font class="black">xxx-xxx-xxxx</font></div>
      <@shiro.guest>
      <div class="pull-right"><a href="${base}/login" class="black">请登录</a>|<a href="../personal/personal-4.html">我的订单</a>|<a href="help.html">常见问题</a>|<a href="#">积分规则</a></div>
      <!--未登录-->
      </@shiro.guest>
      <@shiro.user>
      <div class="pull-right"><span>你好，<a href="../personal/personal-1.html" class="black"> <@shiro.principal/></a><a href="${base}/logout">[安全退出]</a> <a href="${base}/account/myOrder">我的订单</a>|<a href="help.html">常见问题</a>|<a href="#">积分规则</a></div>
      <!--已登录--> 
      </@shiro.user>
      </div>
  </div>
<#nested>
</div>
<script>
$(function(){
	$.ajax({
		url:"${base}/cart/cartNum",
		async:false,
		success:function(resdata){
			$("#buycartNum").html(resdata.cartNum);
		}
	})
})
</script>
</#macro>