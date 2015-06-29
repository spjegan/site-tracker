package com.tr.persistence.jpa;

import java.util.List;
import java.util.Map;

/**
 * Created by Jegan on 6/18/2015.
 */
public interface IJpaRepository {

	<E> void save(E entity);

	<E> void update(E entity);

	<E> void merge(E entity);

	<E> E findById(Class<E> clazz, Object id);

	Object queryUnique(String queryName, Map<String, Object> params);

	<E> List<E> query(String queryName, Map<String, Object> params);

	void update(String queryName, Map<String, Object> params);
}
