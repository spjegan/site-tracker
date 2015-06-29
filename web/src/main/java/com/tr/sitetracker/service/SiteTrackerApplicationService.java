package com.tr.sitetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tr.sitetracker.domain.IConnection;
import com.tr.sitetracker.domain.ISite;
import com.tr.sitetracker.domain.Site;
import com.tr.sitetracker.dto.ConnectionInfo;
import com.tr.sitetracker.dto.SiteInfo;
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
	public SiteInfo createSite(SiteInfo siteInfo) {
		ISite site = new Site(siteInfo.getSiteName());
		String siteId = siteTrackerDomainService.createSite(site);
		siteInfo.setSiteId(siteId);
		List<ConnectionInfo> connections = siteInfo.getConnections();
		if (null != connections) {
			for (ConnectionInfo connectionInfo : connections) {
				String id = addConnection(siteId, connectionInfo.getSiteName(),
						connectionInfo.getDistance());
				connectionInfo.setId(id);
			}
		}
		return siteInfo;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String addConnection(String fromSiteId, String toSiteName,
			double distance) {
		return siteTrackerDomainService.addConnection(fromSiteId, toSiteName,
				distance);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public SiteInfo getSite(String siteId) {
		ISite site = siteTrackerDomainService.getSite(siteId);
		SiteInfo siteInfo = new SiteInfo(site.getName());
		List<ConnectionInfo> connections = getConnections(siteId);
		siteInfo.addAllConnections(connections);
		return siteInfo;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ConnectionInfo> getConnections(String siteId) {
		List<IConnection> connections = siteTrackerDomainService
				.getConnections(siteId);
		List<ConnectionInfo> siteConnections = new ArrayList<>();
		if (null != connections) {
			for (IConnection connection : connections) {
				ConnectionInfo connectionInfo = new ConnectionInfo(connection
						.getToSite().getName(), connection.getDistance());
				siteConnections.add(connectionInfo);
			}
		}
		return siteConnections;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<SiteInfo> getAllSites() {
		List<ISite> sites = siteTrackerDomainService.getAllSites();
		List<SiteInfo> allSites = new ArrayList<>(); 
		if (null != sites) {
			for (ISite site : sites) {
				SiteInfo siteInfo = new SiteInfo(site.getName());
				allSites.add(siteInfo);
			}
		}
		return allSites;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateSite(String siteId, String newName) {
		siteTrackerDomainService.updateSite(siteId, newName);
	}
}
