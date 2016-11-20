/**
 * 
 */
package org.frameworkset.security.auth.restful;

import org.frameworkset.util.annotations.ResponseBody;
import org.frameworkset.web.auth.AuthenticateException;
import org.frameworkset.web.auth.AuthenticateMessages;
import org.frameworkset.web.auth.AuthenticatedToken;
import org.frameworkset.web.auth.AuthorHelper;

import com.frameworkset.util.SimpleStringUtil;

/**
 * 测试restful服务的sso安全认证功能
 * @author yinbp
 *
 * @Date:2016-11-19 11:48:44
 */
public class AuthRestfulDemo implements AuthRestfulDemoInf{

	/**
	 * 
	 */
	public AuthRestfulDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public @ResponseBody String getData(String authtoken,String queryId)
	{
		try {
			AuthenticatedToken token = AuthorHelper.decodeMessageResponse(authtoken);
			
			String json = SimpleStringUtil.object2json(token);
			return json;
		} catch (AuthenticateException e) {
			return AuthenticateMessages.getMessage(e.getMessage()); 
		}
	}

}
