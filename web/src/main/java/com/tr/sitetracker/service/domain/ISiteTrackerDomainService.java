package com.tr.sitetracker.service.domain;

import java.util.List;

import com.tr.sitetracker.domain.IConnection;
import com.tr.sitetracker.domain.ISite;

/**
 * Created by Jegan on 6/18/2015.
 */
public interface ISiteTrackerDomainService {

	String createSite(ISite site);
	
	ISite getSite(String siteId);
	
	String addConnection(String fromSiteId, String toSiteName, double distance);

	List<IConnection> getConnections(String siteId);

	List<ISite> getAllSites();

	void updateSite(String siteId, String newName);
}
