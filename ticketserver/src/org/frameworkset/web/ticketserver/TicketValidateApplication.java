/**
 * 
 */
package org.frameworkset.web.ticketserver;

import org.frameworkset.web.token.AppValidateResult;
import org.frameworkset.web.token.Application;
import org.frameworkset.web.token.BaseValidateApplication;
import org.frameworkset.web.token.TokenException;
import org.frameworkset.web.token.TokenHelper;

/**
 * @author yinbp
 *
 * @Date:2016-11-13 12:37:37
 */
public class TicketValidateApplication extends BaseValidateApplication {

	/**
	 * 
	 */
	public TicketValidateApplication() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.frameworkset.web.token.BaseValidateApplication#validateApp(java.lang.String, java.lang.String)
	 */
	@Override
	public AppValidateResult validateApp(String appid, String secret) throws TokenException {
		AppValidateResult result = new AppValidateResult();
		Application app = new Application();
		app.setAppid(appid);
		app.setSecret(secret);
		app.setSign(true);
		
		app.setTicketlivetime(-2);
		result.setApplication(app);
		result.setResult(true);
		 
		return result;
	}

}
