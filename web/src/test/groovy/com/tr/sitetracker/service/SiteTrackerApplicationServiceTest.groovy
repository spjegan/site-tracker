package com.tr.sitetracker.service

import com.tr.sitetracker.domain.Connection
import com.tr.sitetracker.domain.ISite
import com.tr.sitetracker.domain.Site
import com.tr.sitetracker.dto.ConnectionInfo
import com.tr.sitetracker.dto.SiteInfo
import com.tr.sitetracker.service.domain.SiteTrackerDomainServiceImpl
import spock.lang.Specification

/**
 * Created by Jegan on 6/21/2015.
 */
class SiteTrackerApplicationServiceTest extends Specification {

    def domainService, applicationService

    def setup() {
        domainService = Mock(SiteTrackerDomainServiceImpl)
        applicationService = new SiteTrackerApplicationService(domainService)
    }

    def "createSite should use domain service to create site and connections"() {

        def conns = [new ConnectionInfo(siteName: "A", distance: 2), new ConnectionInfo(siteName: "B", distance: 3)] as List
        def siteInfo = new SiteInfo(siteName: "test", connections: conns)

        when:
        applicationService.createSite(siteInfo)

        then:
        1 * domainService.createSite(_ as Site) >> 1
        1 * domainService.addConnection("1", "A", 2) >> 1
        1 * domainService.addConnection("1", "B", 3) >> 2
    }

    def "addConnection test"() {
        when:
        applicationService.addConnection("1", "test", 10)

        then:
        1 * domainService.addConnection("1", "test", 10)
    }

    def "getSite should get site from domain service and convert to SiteInfo"() {

        def site = Mock(ISite)
        site.siteName >> "test"
        site.id >> "1"

        when:
        applicationService.getSite("1")

        then:
        1 * domainService.getSite("1") >> site
        1 * domainService.getConnections("1")
    }

    def "getAllSites test"() {

        when:
        applicationService.getAllSites()

        then:
        1 * domainService.getAllSites()
    }

    def "updateSite test"() {

        when:
        applicationService.updateSite("1", "test")

        then:
        1 * domainService.updateSite("1", "test")
    }
}
