package com.tr.sitetracker.domain;

import static com.tr.commons.utils.AssertUtils.assertNotNull;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.tr.commons.utils.Constants;

/**
 * Created by Jegan on 6/18/2015.
 */
@Entity
@Table(name = "site_t")
@NamedQueries({
		@NamedQuery(name = Constants.QUERY_GET_ALL_SITES, query = "from Site site"),
		@NamedQuery(name = Constants.QUERY_FIND_SITE_BY_NAME, query = "from Site where name = :name") })
public class Site implements Serializable, ISite {

	private static final long serialVersionUID = -5317057584625311533L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "name")
	private String name;

	public Site() {
	}

	public Site(String name) {
		this();
		this.name = name;
	}

	public Site(ISite site) {
		assertNotNull(site, "Site cannot be null");
		this.id = site.getId();
		this.name = site.getName();
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public Set<IConnection> getConnections() {
		return Collections.unmodifiableSet(connections);
	}

	public void setConnections(Set<IConnection> connections) {
		this.connections = connections;
	}

	@Override
	public void addConnection(ISite toSite, double distance) {
		assertNotNull(toSite, ErrorConstants.NULL_OR_EMPTY_SITE_NAME);
		IConnection connection = new Connection(this, toSite, distance);
		this.connections.add(connection);
	}

	@Override
	public boolean isConnectedTo(String siteName) {
		assertNotNullOrEmpty(siteName, ErrorConstants.NULL_OR_EMPTY_SITE_NAME);
		return false;
	}

	@Override
	public double getDistanceTo(String siteName) {
		assertNotNullOrEmpty(siteName, ErrorConstants.NULL_OR_EMPTY_SITE_NAME);
		return 0;
	}*/
}
