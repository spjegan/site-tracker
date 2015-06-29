package com.tr.sitetracker.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tr.commons.utils.Constants;
import com.tr.persistence.jpa.JpaRepositoryImpl;
import com.tr.sitetracker.domain.ISite;
import com.tr.sitetracker.domain.Site;

/**
 * Created by Jegan on 6/18/2015.
 */
@Repository
public class SiteRepositoryImpl extends JpaRepositoryImpl implements ISiteRepository {

	@Override
	public List<ISite> getAllSites() {
		return super.query(Constants.QUERY_GET_ALL_SITES, null);
	}
	
	@Override
	public ISite findById(String id) {
		return super.findById(Site.class, id);
	}	

	@Override
	public ISite findByName(String name) {		
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		return (ISite) super.queryUnique(Constants.QUERY_FIND_SITE_BY_NAME, params);
	}
	
	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}
}
