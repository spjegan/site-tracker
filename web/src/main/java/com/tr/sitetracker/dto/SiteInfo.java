package com.tr.sitetracker.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Jegan on 6/18/2015.
 */
public class SiteInfo {
	
	private String siteId;

    private String siteName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ConnectionInfo> connections;
    
    public SiteInfo() {
    	this.connections = new ArrayList<>();
    }
    
    public SiteInfo(String name) {
    	this();
    	this.siteName = name;
    }
    
	/**
	 * @return the siteId
	 */
	public String getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}    

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String name) {
        this.siteName = name;
    }
    
    public void addConnection(ConnectionInfo connectionInfo) {
    	if (null != connectionInfo) {
    		this.connections.add(connectionInfo);
    	}
    }
    
    public void addAllConnections(List<ConnectionInfo> connections) {
    	if (null != connections) {
    		this.connections.addAll(connections);
    	}
    }

    public List<ConnectionInfo> getConnections() {
        return Collections.unmodifiableList(connections);
    }

    public void setConnections(List<ConnectionInfo> connections) {
        this.connections = connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteInfo siteInfo = (SiteInfo) o;

        if (siteName != null ? !siteName.equals(siteInfo.siteName) : siteInfo.siteName != null) return false;
        return !(connections != null ? !connections.equals(siteInfo.connections) : siteInfo.connections != null);

    }

    @Override
    public int hashCode() {
        int result = siteName != null ? siteName.hashCode() : 0;
        result = 31 * result + (connections != null ? connections.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SiteInfo{");
        sb.append("name='").append(siteName).append('\'');
        sb.append(", connections=").append(connections);
        sb.append('}');
        return sb.toString();
    }

}
