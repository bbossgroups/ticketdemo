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
HttpSession se = request.getSession(false);
if(se != null)
	se.invalidate();
out.print("退出成功");
%>
<span>
	<a href="appalogin.jsp" target="_self"> 重新登录</a></span>
	



