package com.example.geo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.geo.jpa.StoreRepository;
import com.example.geo.model.Store;

@Service
public class StoreService {

	@Autowired
	private StoreRepository repo;
	
	
	public Store saveStore(Store store) {
		repo.save(store);
		return store;
	}
	
	public Optional<Store> getStore(String id) {
		return repo.findById(id);
	}
	
	public List<Store> getStores(double lat,double lng, int radius){
		return repo.search(lat, lng, radius);
	}
	
	public List<Store> getStores(){
		Iterator<Store> iterator = repo.findAll().iterator();
		List<Store> stores=new ArrayList<>();
		while(iterator.hasNext()) {
			stores.add(iterator.next());
		}
		return stores;
			
	}
	
}
