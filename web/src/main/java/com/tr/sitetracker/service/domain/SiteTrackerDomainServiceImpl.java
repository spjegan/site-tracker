package com.tr.sitetracker.service.domain;

import static com.tr.commons.utils.AssertUtils.assertNotNullOrEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;
import com.tr.sitetracker.domain.Connection;
import com.tr.sitetracker.domain.IConnection;
import com.tr.sitetracker.domain.ISite;
import com.tr.sitetracker.exception.ValidationException;
import com.tr.sitetracker.repository.IConnectionRepository;
import com.tr.sitetracker.repository.ISiteRepository;

/**
 * Created by Jegan on 6/18/2015.
 */
@Service
public class SiteTrackerDomainServiceImpl implements ISiteTrackerDomainService {

	private ISiteRepository siteRepository;

	private IConnectionRepository connectionRepository;
	
	private static final ILogger logger = LoggerFactory.getLogger(SiteTrackerDomainServiceImpl.class);

	@Autowired
	public SiteTrackerDomainServiceImpl(ISiteRepository siteRepository,
			IConnectionRepository connectionRepository) {
		this.siteRepository = siteRepository;
		this.connectionRepository = connectionRepository;
	}

	@Override
	public String createSite(ISite site) {
		siteRepository.save(site);
		return site.getId();
	}

	@Override
	public String addConnection(String fromSiteId, String toSiteId,
			double distance) {
		assertNotNullOrEmpty(fromSiteId, "From site id cannot be null or empty", fromSiteId);
		assertNotNullOrEmpty(toSiteId, "To site id cannot be null or empty", toSiteId);
		
		ISite fromSite = siteRepository.findById(fromSiteId);
		if (null == fromSite) {
			logger.error("Unknown from site {}", fromSiteId);
			throw new ValidationException("Unknown site with id " + fromSiteId);
		}
		ISite toSite = siteRepository.findById(toSiteId);
		if (null == toSite) {
			logger.error("Unknown to site {}", toSiteId);
			throw new ValidationException("Unknown site with id " + toSiteId);
		}		

		IConnection connection = new Connection(fromSite, toSite, distance);
		connectionRepository.save(connection);
		return connection.getId();
	}
}
