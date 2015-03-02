WxChat
========

An Open Source Java SDK for WeChat Open Platform

WxChat是为腾讯微信公众平台制作的一个Java版本的SDK，旨在快速建立开发模式的微信公众账号。
目前WxChat处于1.0版本

<h3>主要功能</h3>
1.一站式微信请求处理<br>
2.微信请求的算法验证<br>
3.消息类型的封装和处理接口实现<br>
4、自定义菜单处理的实现<br>

<h3>如何使用</h3>
1、这是一个Java Web项目，可以直接部署在tomcat等web容器上<br>
2、微信公众账号中，接口配置以以下形式设置<br>
	URL: http://[host]/WxChat/wxMsgCollection?token=[tokenValue]<br>
	Token: [tokenValue]<br>
3、部署和配置成功之后，就可以测试消息的收发了<br>

<h3>关键部分解释</h3>
1、项目通过servlet的形式来接受http响应，具体类在org.poorzerg.weixin.WxMsgCollectionServlet<br>
2、信息处理接口为org.poorzerg.weixin.process.MsgProcess<br>
3、默认的信息处理接口为：org.poorzerg.weixin.process.DefaultMsgProcess<br>
4、默认的信息处理接口中，内置了默认的event处理实现：org.poorzerg.weixin.process.DefaultEventProcess<br>
5、appid、appsecret等配置文件是src/main/resources/config.properties，其中的tokenkey用于验证接入的token是否合法<br>

邮箱地址：poorzerg@gmail.com<br>
博客地址：http://my.oschina.net/poorzerg/blog<br>