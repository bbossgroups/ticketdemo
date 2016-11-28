<%@page import="org.frameworkset.web.auth.TicketConsts"%>
<%@page import="org.frameworkset.web.auth.AuthenticatedToken"%>
<%@page import="org.frameworkset.web.auth.AuthenticateException"%>
<%@page import="org.frameworkset.web.auth.AuthenticateMessages"%>
<%@page import="org.frameworkset.web.auth.AuthorHelper"%>
<%@page session="false" contentType="text/html; charset=UTF-8"%>
<%@page import="org.frameworkset.web.auth.AuthenticateResponse"%>
<%@page import="org.frameworkset.web.auth.WebAuthenticate"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%
//构建一个待验证的token
//设置额外的用户信息
Map<String,Object> extendAttributes = new HashMap<String,Object>();
extendAttributes.put("frommobile", true);
extendAttributes.put("fromremember", true);
//定义用户账号和口令
String account = "yinbp", password="123456";
//构建用户登录组件
WebAuthenticate auth = new WebAuthenticate(  request, response, account,  password, extendAttributes);
String outstr = "";  
String appburl = "http://localhost:92/ticketappB/appb.jsp";
try
{
	//执行登陆操作
	AuthenticatedToken token = auth.login();
	
	
	 		//认证成功后通过参数方法传递用户凭证码单点登录到其他应用
		 	 appburl = "http://localhost:92/ticketappB/appb.jsp?author="+request.getSession().getAttribute(TicketConsts.ticket_session_authenticatecode_key);
		 %>
		 <!-- 输出成功登陆后的内容 -->
		 <span>
	<%=token.getSubject()%>登陆成功！</span>
	<span>
	<a href="<%=appburl%>" target="_appb"> 单点访问appb</a></span>
	<a href="appaindex.jsp" target="_appa"> appaindex.jsp</a></span>
	
		 <% 
	
 }
catch(AuthenticateException e)
{
	//登陆失败，获取登陆失败的信息
	outstr = AuthenticateMessages.getMessage(e.getMessage());
}
//登陆失败，在界面上输出登陆失败的信息
if(outstr != null && !outstr.equals(""))
{
%>

	 <span>
<%=account %>登陆失败：<%=outstr%></span>
<%} %>
	 



