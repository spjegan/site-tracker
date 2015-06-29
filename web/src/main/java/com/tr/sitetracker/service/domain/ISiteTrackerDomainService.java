package com.tr.sitetracker.service.domain;

import com.tr.sitetracker.domain.ISite;

/**
 * Created by Jegan on 6/18/2015.
 */
public interface ISiteTrackerDomainService {

	String createSite(ISite site);

	String addConnection(String fromSiteName, String toSiteName, double distance);
}
