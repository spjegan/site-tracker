package com.tr.sitetracker.service.domain

import com.tr.sitetracker.domain.Connection
import com.tr.sitetracker.domain.Site
import com.tr.sitetracker.repository.ISiteTrackerRepository
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

/**
 * Created by Jegan on 6/21/2015.
 */
@ContextConfiguration(locations = "classpath:spring/test-context.xml")
@Transactional
class SiteTrackerDomainServiceImplTest extends Specification {

    @Autowired
    def ISiteTrackerDomainService siteTrackerDomainService

    @Autowired
    ISiteTrackerRepository siteTrackerRepository

    def "createSite should create the site in DB"() {
        def site = new Site(name: "test")

        def newSite
        when:
        def id = siteTrackerDomainService.createSite(site)
        newSite = siteTrackerRepository.findById(id)

        then:
        null != id
        null != newSite
        "test" == newSite.name
    }

    def "addConnection should add connections to the site"() {
        def site1 = new Site(name: "A")
        def siteId = siteTrackerDomainService.createSite(site1)

        def site2 = new Site(name: "B")
        siteTrackerDomainService.createSite(site2)

        def conn
        when:
        def id = siteTrackerDomainService.addConnection(siteId, "B", 10)
        conn = siteTrackerRepository.findById(Connection.class, id)

        then:
        null != id
        null != conn
        10 == conn.distance
    }

    def "getConnections should get all connections to the site"() {
        def site1 = new Site(name: "site1")
        def siteId = siteTrackerDomainService.createSite(site1)

        def site2 = new Site(name: "site2")
        siteTrackerDomainService.createSite(site2)

        def site3 = new Site(name: "site3")
        siteTrackerDomainService.createSite(site3)

        siteTrackerDomainService.addConnection(siteId, "site2", 5)
        siteTrackerDomainService.addConnection(siteId, "site3", 10)

        def conns
        when:
        conns = siteTrackerDomainService.getConnections(siteId)

        then:
        null != conns
        2 == conns.size()
    }

    def "getAllSites should get all sites to the site"() {

        def site1 = new Site(name: "site1")
        siteTrackerDomainService.createSite(site1)

        def site2 = new Site(name: "site2")
        siteTrackerDomainService.createSite(site2)

        def site3 = new Site(name: "site3")
        siteTrackerDomainService.createSite(site3)

        def sites
        when:
        sites = siteTrackerDomainService.getAllSites()

        then:
        null != sites
        3 == sites.size()
    }

    def "updateSite should update the name of the site"() {
        def site1 = new Site(name: "site1")
        def id = siteTrackerDomainService.createSite(site1)

        when:
        siteTrackerDomainService.updateSite(id, "site2")

        then:
        "site2" == siteTrackerRepository.findById(id).name
    }
}
