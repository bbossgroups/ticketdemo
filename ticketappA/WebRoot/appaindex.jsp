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

 

AuthenticatedToken token = (AuthenticatedToken)request.getSession().getAttribute(TicketConsts.ticket_session_token_key);
String authcode = (String)request.getSession().getAttribute(TicketConsts.ticket_session_authenticatecode_key);	
String appburl = "http://localhost:92/ticketappB/appbindex.jsp?"+TicketConsts.ticket_authenticatecode_parameter_name+"="+authcode;
		 %>
		 <span>
	<%=token.getSubject()%>登陆成功！</span>
	<span>
	<a href="<%=appburl%>" target="_appb"> 单点访问appbindex</a></span>
		



