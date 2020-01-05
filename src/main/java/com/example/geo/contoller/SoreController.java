package com.example.geo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.geo.client.GeoCodesClient;
import com.example.geo.client.pojo.GeoCodes;
import com.example.geo.model.Store;
import com.example.geo.service.StoreService;

@RestController
@RequestMapping(value = "/stores")
public class SoreController {

	@Autowired
	private StoreService service;
	@Autowired
	private GeoCodesClient client;

	@RequestMapping(value = "")
	public List<Store> getAllStores(@RequestParam String address, @RequestParam int radius) {
		GeoCodes geoCodes = client.getGeoCodes(address);
		double lat = geoCodes.getResults().get(0).getGeometry().getLat();
		double lng = geoCodes.getResults().get(0).getGeometry().getLng();
		System.out.println("Geo Codes from map lat="+lat+" lan"+lng);
		return service.getStores(lat, lng, radius);
	}
	
//	@RequestMapping(value = "")
//	public List<Store> getAllStores() {
//		return service.getStores();
//	}

	@RequestMapping(value = "/{id}")
	public Store getCourse(@PathVariable String id) {
		return service.getStore(id).get();
	}

	@RequestMapping(method = RequestMethod.POST, value = "")
	public Store saveCourse(@RequestBody Store store) {
		return service.saveStore(store);
	}

}
