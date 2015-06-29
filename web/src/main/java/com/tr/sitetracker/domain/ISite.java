package com.tr.sitetracker.domain;

import java.io.Serializable;

/**
 * Created by Jegan on 6/18/2015.
 */
public interface ISite extends Serializable {

    String getId();

    String getName();

/*    void addConnection(ISite to, double distance);

    Set<IConnection> getConnections();

    boolean isConnectedTo(String siteName);

    double getDistanceTo(String siteName);*/
}
