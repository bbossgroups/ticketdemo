<%@page import="org.frameworkset.web.auth.AuthenticateException"%>
<%@page import="org.frameworkset.web.auth.AuthenticateMessages"%>
<%@page import="org.frameworkset.web.auth.AuthenticatedToken"%>
<%@page import="org.frameworkset.web.auth.AuthorHelper"%>
<%@page session="false" contentType="text/html; charset=UTF-8"%>
<%@page import="org.frameworkset.web.auth.AuthenticateResponse"%>
<%@page import="org.frameworkset.web.auth.WebAuthenticate"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
//构建一个待验证的token
Map<String,Object> extendAttributes = new HashMap<String,Object>();
extendAttributes.put("frommobile", true);
extendAttributes.put("fromremember", true);

String account = "yinbp", password="123456";
WebAuthenticate auth = new WebAuthenticate(  request,  account,  password, extendAttributes);
AuthenticateResponse ar = auth.ssologin();
String appburl = "http://localhost:92/ticketappB/appb.jsp";
String outstr = "";
if(ar.isValidateResult())
{
	try
	{
		AuthenticatedToken token = AuthorHelper.decodeMessageResponse(ar.getAuthorization());
	
	 	 appburl = "http://localhost:92/ticketappB/appb.jsp?author="+ar.getAuthorization();
	 %>
	 <span>
<%=token.getSubject()%>登陆成功！</span>
<span>
<a href="<%=appburl%>" target="_appb"> 单点访问appb</a></span>
	 <% 
	}
	catch(AuthenticateException e)
	{
		outstr = AuthenticateMessages.getMessage(e.getMessage());
	}
}
else
{
	 outstr = ar.getError();
	 
}
if(outstr != null && !outstr.equals(""))
{
%>

	 <span>
<%=account %>登陆失败：<%=outstr%></span>
<%} %>
	 
<br/><br/>
<%
//构建一个待验证的token
extendAttributes = new HashMap<String,Object>();
extendAttributes.put("frommobile", true);
extendAttributes.put("fromremember", true);

  account = "zhangsan";password="123456";
auth = new WebAuthenticate(  request,  account,  password, extendAttributes);
ar = auth.ssologin();

if(ar.isValidateResult())
{
	AuthenticatedToken token = AuthorHelper.decodeMessageResponse(ar.getAuthorization());
	
	  appburl = "http://localhost:92/ticketappB/appb.jsp?author="+ar.getAuthorization();
	 %>
	 <span>
<%=token.getSubject()%>登陆成功！</span>
<span>
<a href="<%=appburl%>" target="_appb"> 单点访问appb</a></span>
	 <% 
}
else
{
	 %>
	 <span>
<%=account %>登陆失败：<%=ar.getError()%></span>
	 <% 
	 
}

%>
<br/><br/>
<%
//构建一个待验证的token
extendAttributes = new HashMap<String,Object>();
extendAttributes.put("frommobile", true);
extendAttributes.put("fromremember", true);

  account = "lisi";password="www";
auth = new WebAuthenticate(  request,  account,  password, extendAttributes);
ar = auth.ssologin();

if(ar.isValidateResult())
{
	AuthenticatedToken token = AuthorHelper.decodeMessageResponse(ar.getAuthorization());
	
	  appburl = "http://localhost:92/ticketappB/appb.jsp?author="+ar.getAuthorization();
	 %>
	 <span>
<%=token.getSubject()%>登陆成功！</span>
<span>
<a href="<%=appburl%>" target="_appb"> 单点访问appb</a></span>
	 <% 
}
else
{
	 %>
	 <span>
<%=account %>登陆失败：<%=ar.getError()%></span>
	 <% 
	 
}

%>
<br/><br/>
<%
//构建一个待验证的token
extendAttributes = new HashMap<String,Object>();
extendAttributes.put("frommobile", true);
extendAttributes.put("fromremember", true);

  account = "zhangsan";password="123456";
auth = new WebAuthenticate(  request,  account,  password, extendAttributes);
ar = auth.ssologin();
String restful = "http://localhost:93/ticketrestful/authdemo/getData.page?authtoken="+ar.getAuthorization()+"&queryId=1";

%>

<span>
<a href="<%=restful%>" target="ticketrestful"> restful sso演示</a></span>


