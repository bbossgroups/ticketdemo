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

 
HttpSession se = request.getSession(false);
if(se != null)
{
AuthenticatedToken token = (AuthenticatedToken)se.getAttribute(TicketConsts.ticket_session_token_key);
String authcode = (String)se.getAttribute(TicketConsts.ticket_session_authenticatecode_key);	

		 %>
		 <span>
	<%=token.getSubject()%>登陆成功！</span>
	<span>
	
		<a href="appbwork.jsp" target="_appwork"> 访问appbwork</a></span>
	<%} 	
else{
	out.print("没有登录系统");
	
}
	%>



