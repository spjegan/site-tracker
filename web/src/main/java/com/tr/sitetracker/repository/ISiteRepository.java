package com.tr.sitetracker.repository;

import java.util.List;

import com.tr.persistence.jpa.IJpaRepository;
import com.tr.sitetracker.domain.ISite;

/**
 * Created by Jegan on 6/18/2015.
 */
public interface ISiteRepository extends IJpaRepository {
	
	ISite findById(String id);
	
	ISite findByName(String name);
	
	List<ISite> getAllSites();

}
