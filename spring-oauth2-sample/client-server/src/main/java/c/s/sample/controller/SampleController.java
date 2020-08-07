package c.s.sample.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author chineshine
 * @date 2019年12月5日
 *
 */
@SuppressWarnings({ "deprecation" })
@RestController
public class SampleController {

//	private @Autowired @Qualifier("client1RestTemplate") OAuth2RestTemplate client1RestTemplate;

	@GetMapping("/")
	public String index(String code) {
		if (StringUtils.hasText(code)) {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("grant_type", "authorization_code");
//			map.put("code", code);
//			map.put("redirect_uri", "http://localhost:11001/");
//			map.put("scope", "write");
//			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//			headers.add("Content-Type", "application/x-www-form-urlencoded");
//			HttpEntity<Map> requestEntity = new HttpEntity<Map>(map, headers);
//			ResponseEntity<Map> response = client1RestTemplate.exchange("http://localhost:8080/oauth/token",
//					HttpMethod.POST, requestEntity, Map.class);
//			return response.getBody().toString();
//			JsonNode json = client1RestTemplate.getForObject("http://localhost:8080/api/users/me", JsonNode.class);
//			return json.asText();
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
