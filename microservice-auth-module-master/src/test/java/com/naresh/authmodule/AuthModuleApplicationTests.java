package com.naresh.authmodule;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthModuleApplicationTests {

	@Test
	public void contextLoads() {

		/*ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setUsername("guest");
		resource.setPassword("guest123");
		resource.setAccessTokenUri("http://localhost:8080/oauth/token");
		resource.setClientId("trustedclient");
		resource.setClientSecret("trustedclient123");
		resource.setGrantType("password");
		
		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource, clientContext);
		RestTemplate rest = new RestTemplate();
		List<String> greet = rest.getForObject("http://localhost:8080/users", List.class);
		System.out.println(greet);

*/		
		
	}

}
