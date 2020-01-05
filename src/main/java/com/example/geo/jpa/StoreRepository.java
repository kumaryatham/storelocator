package com.example.geo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.geo.model.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, String> {
	
   @Query(value="SELECT\n" + 
   		"  id,name,lat,lng, (\n" + 
   		"    6371 * acos (\n" + 
   		"      cos ( radians(:latitude) )\n" + 
   		"      * cos( radians( lat ) )\n" + 
   		"      * cos( radians( lng ) - radians(:longitued) )\n" + 
   		"      + sin ( radians(:latitude) )\n" + 
   		"      * sin( radians( lat ) )\n" + 
   		"    )\n" + 
   		"  ) AS distance\n" + 
   		"FROM store\n" + 
   		"HAVING distance < :distance\n" + 
   		"ORDER BY distance\n" + 
   		"LIMIT 0 , 20", nativeQuery=true)
   public List<Store> search(@Param("latitude") double lat, @Param("longitued") double lng, @Param("distance") int radius);
}
