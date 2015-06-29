package com.tr.sitetracker.cache;

import com.tr.sitetracker.domain.ISite;

/**
 * Created by Jegan on 6/19/2015.
 */
public interface ISiteCache {

    ISite getSiteByName(String name);

    ISite getSiteById(String id);
}
