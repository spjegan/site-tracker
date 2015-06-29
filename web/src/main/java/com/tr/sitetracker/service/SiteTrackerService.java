package com.tr.sitetracker.service;

import static com.tr.commons.utils.AssertUtils.assertNotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tr.commons.logging.ILogger;
import com.tr.commons.logging.LoggerFactory;
import com.tr.commons.utils.Constants;
import com.tr.sitetracker.dto.SiteInfo;

/**
 * Created by Jegan on 6/18/2015.
 */
@Component
@Path(Constants.SITE_TRACKER_SERVICE_ROOT_URI)
public class SiteTrackerService {

    @Autowired
    private SiteTrackerApplicationService siteTrackerApplicationService;

    private static final ILogger logger = LoggerFactory.getLogger(SiteTrackerService.class);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(Constants.CREATE_SITE_PATH)
    public String create(SiteInfo siteInfo) {
        assertNotNull(siteInfo, "Site to be created cannot be null");
        logger.debug("Creating site {}", siteInfo.getName());
        String id = siteTrackerApplicationService.createSite(siteInfo);
        logger.debug("Site {} is created successfully. Id is {}", siteInfo.getName(), id);
        return id;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(Constants.CREATE_SITE_PATH + "/{fromSite}/{toSite}/{distance}")
	public String  addConnection(@PathParam("fromSite") String fromSite,
			@PathParam("toSite") String toSite,
			@PathParam("distance") double distance) {
		return siteTrackerApplicationService.addConnection(fromSite, toSite, distance);
	}
}
