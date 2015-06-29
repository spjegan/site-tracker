package com.tr.sitetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tr.sitetracker.domain.ISite;
import com.tr.sitetracker.domain.Site;
import com.tr.sitetracker.dto.ConnectionInfo;
import com.tr.sitetracker.dto.SiteInfo;
import com.tr.sitetracker.repository.ISiteRepository;
import com.tr.sitetracker.repository.SiteRepositoryImpl;
import com.tr.sitetracker.service.domain.ISiteTrackerDomainService;

/**
 * Created by Jegan on 6/19/2015.
 */
@Service
public class SiteTrackerApplicationService {

	private ISiteTrackerDomainService siteTrackerDomainService;
	
	@Autowired
	public SiteTrackerApplicationService(
			ISiteTrackerDomainService siteTrackerDomainService) {
		this.siteTrackerDomainService = siteTrackerDomainService;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String createSite(SiteInfo siteInfo) {
		ISite site = new Site(siteInfo.getName());		
		siteTrackerDomainService.createSite(site);
		List<ConnectionInfo> connections = siteInfo.getConnections();
		if (null != connections) {
			for (ConnectionInfo connectionInfo : connections) {
				siteTrackerDomainService.addConnection(siteInfo.getName(),
						connectionInfo.getSiteName(),
						connectionInfo.getDistance());
			}
		}
		return site.getId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String addConnection(String fromSiteId, String toSiteId,
			double distance) {
		return siteTrackerDomainService.addConnection(fromSiteId, toSiteId,
				distance);
	}
}
