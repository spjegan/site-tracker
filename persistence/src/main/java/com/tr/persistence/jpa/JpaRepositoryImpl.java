package com.tr.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by Jegan on 6/18/2015.
 */
public class JpaRepositoryImpl implements IJpaRepository {

	private EntityManager entityManager;

	@Override
	public <E> void save(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public <E> void update(E entity) {
		entityManager.persist(entity);
	}

	@Override
	public <E> void merge(E entity) {
		entityManager.merge(entity);
	}

	@Override
	public <E> E findById(Class<E> clazz, Object id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public void update(String queryName, Map<String, Object> params) {
		Query query = prepareQuery(queryName, params);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <E> List<E> query(String queryName, Map<String, Object> params) {
		Query query = prepareQuery(queryName, params);
		List<Object> results = query.getResultList();
		return (List<E>) results;
	}

	@Override
	public Object queryUnique(String queryName, Map<String, Object> params) {
		Query query = prepareQuery(queryName, params);
		Object result = query.getSingleResult();
		return result;
	}

	private Query prepareQuery(String queryName, Map<String, Object> params) {
		Query query = entityManager.createNamedQuery(queryName);
		if (null != params) {
			for (Map.Entry<String, Object> paramEntry : params.entrySet()) {
				query.setParameter(paramEntry.getKey(), paramEntry.getValue());
			}
		}
		return query;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
