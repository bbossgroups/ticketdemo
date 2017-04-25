/**
 * 
 */
package org.frameworkset.web.ticketserver;

import org.frameworkset.web.auth.AuthenticateException;
import org.frameworkset.web.auth.AuthenticateToken;
import org.frameworkset.web.auth.AuthenticatedToken;
import org.frameworkset.web.auth.BaseAuthenticatePlugin;

/**
 * @author yinbp
 *
 * @Date:2016-11-16 16:10:39
 */
public class TicketAuthenticatePlugin extends BaseAuthenticatePlugin {
	private String[][] users = new String[][]{
		{"yinbp","123456","尹标平"},
		{"zhangsan","123456","张三"},
		{"lisi","123456","李四"},
		{"wangwu","123456","王五"}
	};

	/**
	 * 
	 */
	public TicketAuthenticatePlugin() {
		// TODO Auto-generated constructor stub
	}
	
	private String[] getUser(String account)
	{
		for(int i = 0; i < users.length; i ++)
		{
			String[] user = users[i];
			if(user[0].equals(account))
				return user;
			
		}
		return null;
	}

	/** (non-Javadoc)
	 * @see org.frameworkset.web.auth.AuthenticatePlugin#login(org.frameworkset.web.auth.AuthenticateToken)
	 */
	@Override
	public AuthenticatedToken login(AuthenticateToken authenticateToken) throws AuthenticateException {
		AuthenticatedToken ret = new AuthenticatedToken();
		String[] user = this.getUser(authenticateToken.getAccount());
		if(user == null)
			throw new AuthenticateException("用户["+authenticateToken.getAccount()+"]不存在!");
		boolean fromqq = (Boolean)authenticateToken.getAttribute("fromqq");
		if(!fromqq){
			if(!user[1].equals(authenticateToken.getPassword()))
				throw new AuthenticateException("密码不正确!");
		}
		ret.setAudience("audience");
		ret.setCnname(user[2]);
		ret.setSessionid(authenticateToken.getSessionid());
		ret.setSubject(authenticateToken.getAccount());
		ret.setAppcode(authenticateToken.getAppcode());
		ret.setExtendAttributes(authenticateToken.getExtendAttributes());
		
		return ret;
	}

	
}
