/**
 * 
 */
package org.frameworkset.security.auth.mobile;

import java.util.HashMap;
import java.util.Map;

import org.frameworkset.web.auth.AppAuthenticate;
import org.frameworkset.web.auth.AuthenticateException;
import org.frameworkset.web.auth.AuthenticateMessages;
import org.frameworkset.web.auth.AuthenticatedToken;

/**
 * @author yinbp
 *
 * @Date:2016-11-19 13:39:56
 */
public class LoginUtil {
	private static AuthenticatedToken token ;
	private static String authenticatecode;
	private static String error ;
	/**
	 * 
	 */
	public LoginUtil() {
		// TODO Auto-generated constructor stub
	}
	public static String getAuthenticateCode()
	{
		return authenticatecode;
	}
	public static void login(String account,String password)
	{
		if(token != null || error != null)
			return ;
		  Map<String,Object> extendAttributes = new HashMap<String,Object>();

	        
	        
	         
	         try {
				AppAuthenticate appAutheticate = new AppAuthenticate( null, account,  password,  extendAttributes);
				 token = appAutheticate.login();
				 authenticatecode = appAutheticate.getAuthenticatecode();
			} catch (AuthenticateException e) {
				error = AuthenticateMessages.getMessage(e.getMessage()); 
			}
	         
	}
	
	public static void relogin(String account,String password)
	{
		 
		  Map<String,Object> extendAttributes = new HashMap<String,Object>();

	        
	        
	         
	         try {
				AppAuthenticate appAutheticate = new AppAuthenticate( null, account,  password,  extendAttributes);
				 token = appAutheticate.login();
				 
			} catch (AuthenticateException e) {
				error = AuthenticateMessages.getMessage(e.getMessage()); 
			}
	         
	}
	
	public static AuthenticatedToken getAuthenticatedToken()
	{
		return token;
	}
	
	public static String getLoginError()
	{
		return error;
	}

}
