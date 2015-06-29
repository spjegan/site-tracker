package com.tr.sitetracker.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;
import com.tr.commons.utils.Constants;
import com.tr.persistence.jpa.JpaRepositoryImpl;
import com.tr.sitetracker.domain.IConnection;
import com.tr.sitetracker.domain.ISite;
import com.tr.sitetracker.domain.Site;

/**
 * Created by Jegan on 6/18/2015.
 */
@Repository
public class SiteTrackerRepositoryImpl extends JpaRepositoryImpl implements
		ISiteTrackerRepository {
	
	private static final ILogger logger = LoggerFactory.getLogger(SiteTrackerRepositoryImpl.class);

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
		ISite site = null;
		try {
			site = (ISite) super.queryUnique(Constants.QUERY_FIND_SITE_BY_NAME,
					params);
		} catch (NoResultException ex) {
			// Just log and ignore.
			logger.error("No site found with name {}", ex, name);
		}
		return site;
	}

	@Override
	public List<IConnection> getSiteConnections(String siteId) {
		Map<String, Object> params = new HashMap<>();
		params.put("fromSiteId", siteId);
		return super.query(Constants.QUERY_GET_SITE_CONNECTIONS, params);
	}

	@Override
	public ISite findByIdOrName(String fromSiteId) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", fromSiteId);
		params.put("name", fromSiteId);
		ISite site = null;
		try {
			site = (ISite) super.queryUnique(Constants.QUERY_FIND_SITE_BY_NAME_OR_ID,
					params);
		} catch (NoResultException ex) {
			// Just log and ignore.
			logger.error("No site found with name or id {}", ex, fromSiteId);
		}
		return site;
	}
	
	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}	
}
