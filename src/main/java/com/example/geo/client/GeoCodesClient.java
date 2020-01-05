package com.example.geo.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.geo.client.pojo.GeoCodes;
@Component
public class GeoCodesClient {

	public GeoCodes getGeoCodes(String address) {
		String url="https://api.opencagedata.com/geocode/v1/json?key=4095fa288b024e3ab4cb7b474a5ae4b0";
		Map<String, String> urlParams = new HashMap<String, String>();
		urlParams.put("address", address);
		
		RestTemplate template=new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		HttpEntity entity = new HttpEntity(headers);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("q", address);
		
		ResponseEntity<GeoCodes> response=template.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET,entity,GeoCodes.class);
		
		return response.getBody();
	}
	
	
}
