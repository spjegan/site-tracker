package com.tr.sitetracker.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.tr.persistence.jpa.JpaRepositoryImpl;

/**
 * Created by Jegan on 6/19/2015.
 */
@Repository
public class ConnectionRepositoryImpl extends JpaRepositoryImpl
		implements IConnectionRepository {

	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}
}
