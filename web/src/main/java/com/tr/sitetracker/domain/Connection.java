package com.tr.sitetracker.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jegan on 6/18/2015.
 */
@Entity
@Table(name = "site_connection_t")
public class Connection implements Serializable, IConnection {

	private static final long serialVersionUID = 1100796287664020244L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Site.class)
    @JoinColumn(name = "from_site", nullable = false)
    private ISite fromSite;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Site.class)
    @JoinColumn(name = "to_site", nullable = false)
    private ISite toSite;

    @Column(name = "distance")
    private double distance;

    public Connection() {}

    public Connection(ISite fromSite, ISite toSite, double distance) {
        this.fromSite = fromSite;
        this.toSite = toSite;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ISite getFromSite() {
        return fromSite;
    }

    public void setFromSite(Site fromSite) {
        this.fromSite = fromSite;
    }

    public void setToSite(ISite toSite) {
        this.toSite = toSite;
    }

    @Override
    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public ISite getToSite() {
        return toSite;
    }
}
