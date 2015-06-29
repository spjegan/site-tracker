package com.tr.sitetracker.cache;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tr.sitetracker.domain.ISite;
import com.tr.sitetracker.repository.ISiteRepository;

/**
 * Created by Jegan on 6/19/2015.
 */
@Component
public class SiteCache implements ISiteCache {
	
	private ConcurrentMap<String, ISite> nameToSite;
	
	private ConcurrentMap<String, ISite> idToSite;
	
	@Autowired
	private ISiteRepository siteRepository;

    private static final ISiteCache INSTANCE = new SiteCache();
    
    public SiteCache() {
    	this.nameToSite = new ConcurrentHashMap<>();
    	this.idToSite = new ConcurrentHashMap<>();
    }

    public static ISiteCache getInstance() {
        return INSTANCE;
    }

/*    public void init() {
    	Collection<ISite> sites = siteRepository.getAllSites();
    	if (null != sites) {
    		for (ISite site : sites) {
    			nameToSite.putIfAbsent(site.getName(), site);
    			idToSite.putIfAbsent(site.getId(), site);
    		}
    	}
	}*/

	@Override
    public ISite getSiteByName(String name) {
        return nameToSite.get(name);
    }

    @Override
    public ISite getSiteById(String id) {
        return idToSite.get(id);
    }
}
