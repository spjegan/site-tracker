package com.tr.sitetracker.service.domain;

import static com.tr.commons.utils.AssertUtils.assertNotNullOrEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;
import com.tr.sitetracker.domain.Connection;
import com.tr.sitetracker.domain.IConnection;
import com.tr.sitetracker.domain.ISite;
import com.tr.sitetracker.domain.Site;
import com.tr.sitetracker.exception.ResourceNotFoundException;
import com.tr.sitetracker.exception.ValidationException;
import com.tr.sitetracker.repository.ISiteTrackerRepository;

/**
 * Created by Jegan on 6/18/2015.
 */
@Service
public class SiteTrackerDomainServiceImpl implements ISiteTrackerDomainService {

	private ISiteTrackerRepository siteTrackerRepository;

	private static final ILogger logger = LoggerFactory
			.getLogger(SiteTrackerDomainServiceImpl.class);

	@Autowired
	public SiteTrackerDomainServiceImpl(ISiteTrackerRepository siteRepository) {
		this.siteTrackerRepository = siteRepository;
	}

	@Override
	public String createSite(ISite site) {
		checkDuplicateName(site.getName());
		siteTrackerRepository.save(site);

		return site.getId();
	}

	@Override
	public String addConnection(String fromSiteId, String toSiteName,
			double distance) {
		assertNotNullOrEmpty(fromSiteId,
				"From site id cannot be null or empty", fromSiteId);
		assertNotNullOrEmpty(toSiteName,
				"To site name cannot be null or empty", toSiteName);

		ISite fromSite = nullSafeGet(fromSiteId);

		ISite toSite = siteTrackerRepository.findByIdOrName(toSiteName);
		if (null == toSite) {
			logger.error("Unknown to site {}", toSiteName);
			throw new ResourceNotFoundException("Unknown site with name "
					+ toSiteName);
		}

		IConnection connection = new Connection(fromSite, toSite, distance);
		siteTrackerRepository.save(connection);
		return connection.getId();
	}

	@Override
	public ISite getSite(String siteId) {
		assertNotNullOrEmpty(siteId, "Site id cannot be null or empty", siteId);
		return nullSafeGet(siteId);
	}

	@Override
	public List<IConnection> getConnections(String siteId) {
		assertNotNullOrEmpty(siteId, "Site id cannot be null or empty", siteId);
		return siteTrackerRepository.getSiteConnections(siteId);
	}

	@Override
	public List<ISite> getAllSites() {
		return siteTrackerRepository.getAllSites();
	}

	@Override
	public void updateSite(String siteId, String newName) {
		assertNotNullOrEmpty(siteId,
				"Site id cannot be null or empty", siteId);
		assertNotNullOrEmpty(newName,
				"Site new name cannot be null or empty", newName);
		
		Site site = (Site) siteTrackerRepository.findById(siteId);
		if (null == site) {
			logger.error("Unknown from site {}", siteId);
			throw new ResourceNotFoundException("Unknown site with id "
					+ siteId);
		}

		checkDuplicateName(newName);
		
		site.setName(newName);
		siteTrackerRepository.merge(site);
	}

	private void checkDuplicateName(String siteName) {
		if (null != siteTrackerRepository.findByName(siteName)) {
			logger.error("Site with the name {} already exists", siteName);
			throw new ValidationException("Duplicate site name " + siteName);
		}
	}

	private ISite nullSafeGet(String siteId) {
		ISite fromSite = siteTrackerRepository.findById(siteId);
		if (null == fromSite) {
			logger.error("Unknown from site {}", siteId);
			throw new ResourceNotFoundException("Unknown site with id "
					+ siteId);
		}
		return fromSite;
	}
}
