<%@page import="org.frameworkset.web.auth.AuthenticateException"%>
<%@page import="org.frameworkset.web.auth.AuthenticateMessages"%>
<%@page import="com.frameworkset.util.SimpleStringUtil"%>
<%@page import="org.frameworkset.web.auth.AuthenticatedToken"%>
<%@page import="org.frameworkset.web.auth.AuthorHelper"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<%
	String author = request.getParameter("author");
	String error = request.getParameter("error");
	String outstr = "";
	if(author != null)
	{
		System.out.println("------------------------author------------------:"+author);
		try{
			AuthenticatedToken token = AuthorHelper.decodeMessageResponse(author);
			
			String json = SimpleStringUtil.object2json(token);
			outstr = json;
		}
		catch(AuthenticateException e)
		{
			outstr = AuthenticateMessages.getMessage(e.getMessage());
		}
	}
	if(error != null)
		outstr = error;
%>
<textarea cols="200" rows="20"><%=outstr %></textarea>