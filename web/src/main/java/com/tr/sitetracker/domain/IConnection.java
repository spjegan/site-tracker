package com.tr.sitetracker.domain;

import java.io.Serializable;

/**
 * Created by Jegan on 6/18/2015.
 */
public interface IConnection extends Serializable {
	
	String getId();

    ISite getFromSite();

    ISite getToSite();

    double getDistance();
}
