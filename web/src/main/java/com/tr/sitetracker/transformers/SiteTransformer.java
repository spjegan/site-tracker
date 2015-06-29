package com.tr.sitetracker.transformers;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;
import com.tr.sitetracker.cache.ISiteCache;
import com.tr.sitetracker.domain.ISite;
import com.tr.sitetracker.domain.Site;
import com.tr.sitetracker.dto.ConnectionInfo;
import com.tr.sitetracker.dto.SiteInfo;
import com.tr.sitetracker.exception.ValidationException;
import com.tr.sitetracker.repository.ISiteTrackerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jegan on 6/19/2015.
 */
@Component
public class SiteTransformer {

    private ISiteCache siteCache;
    
    private ISiteTrackerRepository siteRepository;

    private static final ILogger logger = LoggerFactory.getLogger(SiteTransformer.class);

    @Autowired
    public SiteTransformer(ISiteCache siteCache, ISiteTrackerRepository siteRepository) {
        this.siteCache = siteCache;
        this.siteRepository = siteRepository;
    }

    public ISite from(SiteInfo siteInfo) {
        ISite site = new Site(siteInfo.getSiteName());
/*        List<ConnectionInfo> connections = siteInfo.getConnections();
        if (null != connections) {
            for (ConnectionInfo connectionInfo : connections) {
            	ISite toSite = siteRepository.findByName(connectionInfo.getSiteName());
                if (null == toSite) {
                    logger.error("Could not find site. Unknown site {}", connectionInfo.getSiteName());
                    throw new ValidationException("No such site exists. Unknown site " + connectionInfo.getSiteName());
                }
                site.addConnection(toSite, connectionInfo.getDistance());
            }
        }*/
        return site;
    }

    public SiteInfo to(ISite site) {
        return null;
    }
}
