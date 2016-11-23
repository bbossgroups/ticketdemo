# bboss group website:
http://www.bbossgroups.com

# bboss group project blog:
http://yin-bp.iteye.com/

# bboss 统一认证源码
github托管地址： 

https://github.com/bbossgroups/security 

svn下载地址 

https://github.com/bbossgroups/security/trunk 

# bboss 统一认证demo
github托管地址： 

https://github.com/bbossgroups/ticketdemo 

svn下载地址 

https://github.com/bbossgroups/ticketdemo/trunk 



# 统一认证获取用户凭证信息方法：

```
HttpSession session = request.getSession(false);//request.getSession(true)

AuthenticatedToken token = (AuthenticatedToken)session.getAttribute(TicketConsts.ticket_session_token_key);//获取用户会话对象，包含所有用户信息
String authcode = (String) session.getAttribute(TicketConsts.ticket_session_authenticatecode_key);	//获取用户授权码，可用于单点登录功能


```


## bboss项目特色特点介绍文档：
http://yin-bp.iteye.com/blog/1080824

## License

The BBoss Framework is released under version 2.0 of the [Apache License][].

[Apache License]: http://www.apache.org/licenses/LICENSE-2.0