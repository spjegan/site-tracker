package com.tr.sitetracker.dto;

/**
 * Created by Jegan on 6/19/2015.
 */
public class ConnectionInfo {

    private String siteName;

    private double distance;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionInfo that = (ConnectionInfo) o;

        if (Double.compare(that.distance, distance) != 0) return false;
        return !(siteName != null ? !siteName.equals(that.siteName) : that.siteName != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = siteName != null ? siteName.hashCode() : 0;
        temp = Double.doubleToLongBits(distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConnectionInfo{");
        sb.append("siteName='").append(siteName).append('\'');
        sb.append(", distance=").append(distance);
        sb.append('}');
        return sb.toString();
    }
}
