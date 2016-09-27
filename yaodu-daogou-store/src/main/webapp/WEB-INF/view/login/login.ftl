<#assign base = "${rc.contextPath}" />
<html>
<title>
    Login Page
</title>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="${base}/doLogin" method="post">
    username:<input name="username" id="username" type="text" />
    password:<input name="password" id="password" type="text" />
    kaptchaCode:<input name="kaptchaCode" id="kaptchaCode" type="text" />
    <img src="${base}/kaptchaImage" width="80" height="40" />
    <input type="submit" value="submit" />
</form>
</body>
</html>