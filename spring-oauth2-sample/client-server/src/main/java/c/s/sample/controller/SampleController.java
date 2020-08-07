package c.s.sample.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author chineshine
 * @date 2019年12月5日
 *
 */
@SuppressWarnings({ "all" })
@RestController
public class SampleController {
	private @Autowired RestTemplate restTemplate;
//	private @Autowired @Qualifier("client1RestTemplate") OAuth2RestTemplate client1RestTemplate;

	@GetMapping("/")
	public String index(String code, String state
//			,@RegisteredOAuth2AuthorizedClient("client1") OAuth2AuthorizedClient authorizedClient
//			@AuthenticationPrincipal OAuth2User oauth2User
	) {
		if (StringUtils.hasText(code)) {
//			RequestEntity<?> entity = RequestEntity.post(URI.create("http://localhost:8080/oauth/token"))
//					.contentType(MediaType.APPLICATION_FORM_URLENCODED).body("grant_type=authorization_code&code="
//							+ code + "&redirect_uri=http://localhost:11001/&scope=write$state=" + state);
//			ResponseEntity<Map> response = restTemplate.exchange(entity,Map.class);
//			return response.getBody().toString();
			return code;
		}
		return "index";
	}

//	@GetMapping("/authorize")
//	public JsonNode authorize() {
//		JsonNode json = client1RestTemplate.getForObject("http://localhost:8080/api/users/me", JsonNode.class);
//		return json;
//	}

	@GetMapping("/index")
	public String index(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
			@AuthenticationPrincipal OAuth2User oauth2User) {
		return oauth2User.getName() + authorizedClient.getClientRegistration().getClientName()
				+ oauth2User.getAttributes().toString();
	}
}
