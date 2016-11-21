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
Map<String,Object> extendAttributes = new HashMap<String,Object>();
extendAttributes.put("frommobile", true);
extendAttributes.put("fromremember", true);

String account = "yinbp", password="123456";
WebAuthenticate auth = new WebAuthenticate(  request, response, account,  password, extendAttributes);
String outstr = "";  
String appburl = "http://localhost:92/ticketappB/appb.jsp";
try
{
	AuthenticatedToken token = auth.login();
	
	
	 
		 	 appburl = "http://localhost:92/ticketappB/appb.jsp?author="+request.getSession().getAttribute(TicketConsts.ticket_session_authenticatecode_key);
		 %>
		 <span>
	<%=token.getSubject()%>登陆成功！</span>
	<span>
	<a href="<%=appburl%>" target="_appb"> 单点访问appb</a></span>
	<a href="appaindex.jsp" target="_appa"> appaindex.jsp</a></span>
	
		 <% 
	
 }
catch(AuthenticateException e)
{
	outstr = AuthenticateMessages.getMessage(e.getMessage());
}
 
if(outstr != null && !outstr.equals(""))
{
%>

	 <span>
<%=account %>登陆失败：<%=outstr%></span>
<%} %>
	 



