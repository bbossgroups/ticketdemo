package org.frameworkset.ticket;

import java.util.HashMap;
import java.util.Map;

import org.frameworkset.web.auth.AppAuthenticate;
import org.frameworkset.web.auth.AuthenticatedToken;
import org.frameworkset.web.token.ws.CheckTokenService;
import org.frameworkset.web.token.ws.TicketGetResponse;
import org.frameworkset.web.token.ws.TokenCheckResponse;
import org.frameworkset.web.token.ws.TokenService;
import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;

public class TicketClientTest {
	private String account = "yinbp";
	private String worknumber = "10006673";
	private String appid = "test";
	private String secret = "76252a20-b171-4796-a4a4-c89149b725a2";
//	 String server = "http://10.0.15.223/SanyToken";
	String server = "http://localhost:90/ticketserver";
	private String encryptKey = "5e74d37d000000c0";
	private String  signKey = "5e74d37d000001c0";
	
	
 
	 @org.junit.Test
	    public void testServiceticket() throws Exception
	    {
		    String ticket = genTicket();
		    System.out.println(ticket);
	    	TokenCheckResponse response = checkTicket(ticket);
	    	
//	    	refreshTicket(ticket) ;
//	    	destroyTicket(ticket);
	    	checkTicket(ticket);
//	    	refreshTicket(ticket) ;
	    }
	 
	 @org.junit.Test
	    public void testHRMticket() throws Exception
	    {
		    String ticket ="656a868f-2ee5-4d15-af84-8009b8d5cf85";
	    	TokenCheckResponse response = checkTicket(ticket);
//	    	refreshTicket(ticket) ;
//	    	destroyTicket(ticket);
//	    	checkTicket(ticket);
//	    	refreshTicket(ticket) ;
	    }
	    //656a868f-2ee5-4d15-af84-8009b8d5cf85
	    public String genTicket() throws Exception

	    {

//	         String appid = "pdp";
//
//	         String secret = "ED6F601E3ABC7BA35836C56141AF8351";
//
//	         String account = "marc";//如果使用工号则loginType为2，否则为1
//
//	         String worknumber = "10006857";

	         //hessian服务方式申请token

	         HessianProxyFactory factory = new HessianProxyFactory();

	         //String url = "http://localhost:8080/context/hessian?service=tokenService";

	         String url = server + "/hessian/tokenService";

	         TokenService tokenService = (TokenService) factory.create(TokenService.class, url);

	         //通过hessian根据账号或者工号获取ticket



	         String ticket = tokenService.genTicket(account, worknumber, appid, secret);

	         return ticket;

	    }
	    
	    @Test
	    public void gentmpandchecktmpTicket() throws Exception

	    {

//	         String appid = "pdp";
//
//	         String secret = "ED6F601E3ABC7BA35836C56141AF8351";
//
//	         String account = "marc";//如果使用工号则loginType为2，否则为1
//
//	         String worknumber = "10006857";

	         //hessian服务方式申请token
	    	
	    	

	         HessianProxyFactory factory = new HessianProxyFactory();

	         //String url = "http://localhost:8080/context/hessian?service=tokenService";

	         String url = server + "/hessian/v2tokenService";

	         org.frameworkset.web.token.ws.v2.TokenService tokenService = (org.frameworkset.web.token.ws.v2.TokenService) factory.create(org.frameworkset.web.token.ws.v2.TokenService.class, url);

	         //通过hessian根据账号或者工号获取ticket



	         org.frameworkset.web.token.ws.v2.TicketGetResponse ticket = tokenService.getTempTicket(account, worknumber, appid, secret);

	         url = server + "/hessian/v2checktokenService";

	         org.frameworkset.web.token.ws.v2.CheckTokenService checkTokenService = (org.frameworkset.web.token.ws.v2.CheckTokenService) factory.create(org.frameworkset.web.token.ws.v2.CheckTokenService.class, url);

	         org.frameworkset.web.token.ws.v2.TokenCheckResponse tokenCheckResponse = checkTokenService.checkTicket(appid, secret, ticket.getTicket());

	         System.out.println(tokenCheckResponse.getResultcode());

	         System.out.println(tokenCheckResponse.getUserAccount());

	         System.out.println(tokenCheckResponse.getWorknumber());
	         
	         tokenCheckResponse = checkTokenService.checkTicket(appid, secret, ticket.getTicket());

	         System.out.println(tokenCheckResponse.getResultcode());

	         System.out.println(tokenCheckResponse.getUserAccount());

	         System.out.println(tokenCheckResponse.getWorknumber());

	    }


	    

	    public TokenCheckResponse checkTicket(String ticket) throws Exception

	    {

//	         String appid = "tas";
//
//	         String secret = "ED6F601E3ABC7BA35836C56141AF8351";

	         //hessian服务方式申请token

	         HessianProxyFactory factory = new HessianProxyFactory();

	         //String url = "http://localhost:8080/context/hessian?service=tokenService";

	         String url = server + "/hessian/checktokenService";

	         org.frameworkset.web.token.ws.CheckTokenService  checkTokenService = (CheckTokenService) factory.create(org.frameworkset.web.token.ws.CheckTokenService.class, url);

	         org.frameworkset.web.token.ws.TokenCheckResponse tokenCheckResponse = checkTokenService.checkTicket(appid, secret, ticket);

	         System.out.println(tokenCheckResponse.getResultcode());

	         System.out.println(tokenCheckResponse.getUserAccount());

	         System.out.println(tokenCheckResponse.getWorknumber());

	         return tokenCheckResponse;

	    }
	    
	    
	    public void refreshTicket(String ticket) throws Exception

	    {

	    	  HessianProxyFactory factory = new HessianProxyFactory();

		         //String url = "http://localhost:8080/context/hessian?service=tokenService";

		         String url = server + "/hessian/tokenService";

		         TokenService tokenService = (TokenService) factory.create(TokenService.class, url);

		         //通过hessian根据账号或者工号获取ticket



	         TicketGetResponse tokenCheckResponse = tokenService.refreshTicket(ticket,appid, secret );

	         System.out.println("refresh result:"+tokenCheckResponse.getResultcode());


	    }
	    
	    public void destroyTicket(String ticket) throws Exception

	    {

	    	  HessianProxyFactory factory = new HessianProxyFactory();

		         //String url = "http://localhost:8080/context/hessian?service=tokenService";

		         String url = server + "/hessian/tokenService";

		         TokenService tokenService = (TokenService) factory.create(TokenService.class, url);

		         //通过hessian根据账号或者工号获取ticket



	         TicketGetResponse tokenCheckResponse = tokenService.destroyTicket(ticket,appid, secret );

	         System.out.println("destroyTicket:"+tokenCheckResponse.getResultcode());


	    }
	    @Test
	    public void auth() throws Exception
	    {
	    	
	       

	         //构建一个待验证的token
	         Map<String,Object> extendAttributes = new HashMap<String,Object>();

	        
	         String account = "yinbp", password="123456";
	         
	         AppAuthenticate appAutheticate = new AppAuthenticate( null, account,  password,  extendAttributes);
	         AuthenticatedToken token = appAutheticate.login();
	         System.out.println("getAppcode:"+token.getAppcode());
	         System.out.println("getSubject:"+token.getSubject());
	         
	    }

}
