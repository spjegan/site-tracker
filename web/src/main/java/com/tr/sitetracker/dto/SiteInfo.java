package com.tr.sitetracker.dto;

import java.util.List;

/**
 * Created by Jegan on 6/18/2015.
 */
public class SiteInfo {

    private String name;

    private List<ConnectionInfo> connections;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConnectionInfo> getConnections() {
        return connections;
    }

    public void setConnections(List<ConnectionInfo> connections) {
        this.connections = connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteInfo siteInfo = (SiteInfo) o;

        if (name != null ? !name.equals(siteInfo.name) : siteInfo.name != null) return false;
        return !(connections != null ? !connections.equals(siteInfo.connections) : siteInfo.connections != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (connections != null ? connections.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SiteInfo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", connections=").append(connections);
        sb.append('}');
        return sb.toString();
    }
}
