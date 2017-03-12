/**
 * 
 */
package org.frameworkset.web.ticketserver;

import org.frameworkset.web.token.AppValidateResult;
import org.frameworkset.web.token.Application;
import org.frameworkset.web.token.BaseValidateApplication;
import org.frameworkset.web.token.TokenException;
import org.frameworkset.web.token.TokenHelper;
import org.frameworkset.web.token.ValidateApplicationException;

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
		Application app = getApplication( appid);
		 
		app.setSecret(secret);
		 
		result.setApplication(app);
		result.setResult(true);
		 
		return result;
	}

	@Override
	public Application getApplication(String appid) throws ValidateApplicationException {
		Application app = new Application();
		app.setAppid(appid);
//		app.setSecret(secret);
		app.setSign(true);
		app.setCertAlgorithm("RSA");
		app.setTicketlivetime(-2);
		return app;
	}

}
