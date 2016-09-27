<#macro layout_store title charset="utf-8" lang="zh-CN">
<#assign base = "${rc.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap.css">
<link href="${base}/css/common.css" rel="stylesheet" type="text/css">
<link href="${base}/css/list.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/js/jquery.min.js"></script>
</head>

<body>
<#include "/common/header.ftl">
<@layout_header>
	<#include "/common/search.ftl">
</@layout_header>
<#include "/common/nav.ftl">
<#nested>
<#include "/common/footer.ftl">
</body>
</html>
</#macro>