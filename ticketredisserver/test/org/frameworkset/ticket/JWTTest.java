package org.frameworkset.ticket;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.frameworkset.security.KeyCacheUtil;
import org.frameworkset.security.ecc.SimpleKeyPair;
import org.frameworkset.web.token.TokenHelper;
import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJws;

/**
 * @author yinbp
 *
 * @Date:2016-11-14 10:40:27
 */
public class JWTTest {

	/**
	 * 
	 */
	public JWTTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void test()
	{
		String key = "123456";
		String compactJws =  Jwts.builder()
			    .setSubject("Joe")
			    //.compressWith(CompressionCodecs.GZIP)
			    .signWith(SignatureAlgorithm.HS512, "123456")
			    .compact();
		System.out.println(compactJws);
		Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);
		System.out.println(claims.getBody().getSubject());
		System.out.println(claims.getHeader());
		System.out.println(claims.getSignature());
		
	}
	
	@Test
	public void testrsa()
	{
		String appid = "test";
		SimpleKeyPair  skey = TokenHelper.getTokenService().getServerSimpleKey(appid,"RSA");
		Key privateKey = skey.getPriKey();
		Map infos = new HashMap();
		infos.put("admin", true);
		String compactJws =  Jwts.builder().setHeaderParam("account", "yinbp").setClaims(infos)
			    .setSubject("Joe")
//			    .compressWith(CompressionCodecs.GZIP)
			    .signWith(SignatureAlgorithm.RS512, privateKey)
			    .compact();
		System.out.println(compactJws);
		Key publicKey = skey.getPubKey();
		Jws<Claims> claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(compactJws);
		DefaultJws s;
		DefaultClaims dd;
		System.out.println(claims.getBody().getSubject());
		System.out.println(claims.getBody().get("admin"));
		System.out.println(claims.getHeader());
		System.out.println(claims.getSignature());
		
	}
	private String privateKey_ = "30820277020100300d06092a864886f70d0101010500048202613082025d02010002818100c89d1942a7392519ab33cee113c26b4c030e49b07eb478d37757876302b4e8fa4d6253f7e5b349b522dcd91e49ea8e64e6c8d3c676114e29361d5eacfe85f42b0116fddb66e2b2ddf82c4728bc85e28e2a731ce979716e939c88ee2b7098e697dbf7edd70c05ec3d760bfa3194c801658b9a7b0e20666080fc5e1ca7f1561345020301000102818023aa222a82561b6d63cd53131a932ec615a8fd9abdfbd19b2e9546016922c664714b70c81a72f4409a910e9c5ee1af2ceb067af7c657af408e594c528ef13b85f49dc198512c29b7ebf301f63a10d4379a3cad943d48ac9aa70f4232756a3b4e1e99b94e0d7a395fc40ac57c801fafc0de5970eaeab0694ddecffce42c07ab65024100fcc39a369512fbcb12e48cfe4df71d3895a94a870e898ff5473886e5c1cce96043821092993bba95a0dc7475576b31bb4f52325dcc4bf4454e45f72e0301c38f024100cb2e94b4dd5079bf410f6f9bbe23ef5ba2b6723c35eea959ad50ba33bd6a4e6017ba4f70d0bcd0e9585eed59db24584c85664ad58ef0204a5ae35a72b9cc01eb024040441f76974a9f588fb22aa31201ad9d50781da9df295cbfd95ee6f58de3e2c6860390e12532c98af7be75a1cc1b4626c0d13e5b18f18ae70032cbd9180c9fc3024100b931b8fb6dea073e6af7bddbf02062f05c4bfdada1deea5f41d91e0f40ebdf8a38b669e8436a86e4d9d69472dd8ab02cf73e78a1550acbf3da09f68c318ba087024100d61fa289eb536386e2a353a0e10bf2c56b5c80dc25c368c340dc70de13e160f5eeeefb1821874df5549a115e18acfe2e68b753ed88f56943f619253f6386c7c9";
	private String publicKey_ = "30819f300d06092a864886f70d010101050003818d0030818902818100c89d1942a7392519ab33cee113c26b4c030e49b07eb478d37757876302b4e8fa4d6253f7e5b349b522dcd91e49ea8e64e6c8d3c676114e29361d5eacfe85f42b0116fddb66e2b2ddf82c4728bc85e28e2a731ce979716e939c88ee2b7098e697dbf7edd70c05ec3d760bfa3194c801658b9a7b0e20666080fc5e1ca7f15613450203010001";
	
	@Test
	public void testrsawithkeytext()
	{
		String appid = "test";
		Key privateKey = KeyCacheUtil.getPrivateKey(privateKey_);
		Map infos = new HashMap();
		infos.put("admin", true);
		String compactJws =  Jwts.builder().setHeaderParam("account", "yinbp").setClaims(infos)
			    .setSubject("Joe")
//			    .compressWith(CompressionCodecs.GZIP)
			    .signWith(SignatureAlgorithm.RS512, privateKey)
			    .compact();
		System.out.println(compactJws);
		Key publicKey = KeyCacheUtil.getPublicKey(publicKey_);
		Jws<Claims> claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(compactJws);
		System.out.println(claims.getBody().getSubject());
		System.out.println(claims.getBody().get("admin"));
		System.out.println(claims.getHeader());
		System.out.println(claims.getSignature());
		System.out.println(claims);
		
	}
	
	//Key key = MacProvider.generateKey();

}
