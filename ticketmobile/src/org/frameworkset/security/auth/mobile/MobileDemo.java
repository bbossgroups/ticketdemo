/**
 * 
 */
package org.frameworkset.security.auth.mobile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author yinbp
 *
 * @Date:2016-11-19 13:39:33
 */
public class MobileDemo {

	/**
	 * 
	 */
	public MobileDemo() {
		
		
	}
	
	public static void main(String args[]) throws Exception
	{
		LoginUtil.login("yinbp", "123456");
		MobileDemo mobileDemo = new MobileDemo();
		mobileDemo.queryData();
		
	}
	public void queryData() throws Exception
	{
		

         //String url = "http://localhost:8080/context/hessian?service=tokenService";

         String restful = "http://localhost:93/ticketrestful/authdemo/getData.page?authtoken="+LoginUtil.getAuthenticateCode()+"&queryId=1";

        String result = org.frameworkset.spi.remote.http.HttpReqeust.httpPostforString(restful);  
         

 

     System.out.println("result:"+result);

	}
	@Test
	public void uploadFile() throws Exception
	{
		String url = "http://localhost:8080/bbossupload/upload/uploaddownFileWithMultipartFile.page";
		Map<String,File> files = new HashMap<String,File>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", "dudou多多");
		files.put("upload1", new File("E:\\workspace\\bbossgroups\\ticketdemo\\ticketmobile\\src\\org\\frameworkset\\security\\auth\\mobile\\MobileDemo.java"));
		String result = org.frameworkset.spi.remote.http.HttpReqeust.httpPostforString(url, params,files);
		 System.out.println("result:"+result);
	}
	
	

}
