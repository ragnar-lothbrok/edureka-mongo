package com.edureka.mongo.db.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.edureka.mongo.db.dao.MongoDAO;

/**
 * 
 * @author raghunandan.gupta
 *
 */
@Service
public class CommonService {

	@Autowired
	private MongoDAO mongoDAO;

	public long countCollectionRecord(Class<?> entityClass) {
		return mongoDAO.count(entityClass);
	}

	public void insert(Object object) {
		mongoDAO.insert(object);
	}

	public <T> T findOne(Query query, Class<T> entityClass) {
		return mongoDAO.findOne(query, entityClass);
	}

	public <T> boolean deleteOne(Map<String, Object> params, Class<T> entityClass) {
		return mongoDAO.deleteOne(params, entityClass);
	}

	public <T> T findOne(Map<String, Object> params, Class<T> entityClass) {
		return mongoDAO.findOne(params, entityClass);
	}

	public <T> List<T> findAllWithParams(Map<String, Object> params, Class<T> entityClass) {
		return mongoDAO.findAll(params, entityClass);
	}

	public <T> Optional<List<T>> findAll(Class<T> entityClass) {
		List<T> list = mongoDAO.findAll(entityClass);
		if (list == null) {
			return Optional.empty();
		}
		return Optional.of(list);
	}

	public <T> Optional<List<T>> findAll(Map<String, Object> params, Class<T> entityClass) {
		List<T> list = mongoDAO.findAll(params, entityClass);
		if (list == null) {
			return Optional.empty();
		}
		return Optional.of(list);
	}

	public <T> List<T> findAll(Query query, Class<T> entityClass) {
		return mongoDAO.findAll(query, entityClass);
	}

	/**
	 * Checks if indexedColumn data is present. Will return only indexedColumn value
	 * in T.
	 * 
	 * @param indexedColumn
	 * @param indexedIds
	 * @param entityClass
	 * @param collectionName
	 * @return
	 */
	public <T> List<T> findAllBatchExists(String indexedColumn, Set<Object> indexedIds, Class<T> entityClass,
			String collectionName) {
		return mongoDAO.findAllBatchExists(indexedColumn, indexedIds, entityClass, collectionName);
	}

	public <T> List<T> findLastN(Map<String, Object> params, String sortingField, int limit, Class<T> entityClass) {
		return mongoDAO.findLastN(params, sortingField, limit, entityClass);
	}

	public <T, K> List<T> findAllInIds(Map<String, List<K>> params, Class<T> entityClass) {
		return mongoDAO.findAllInIds(params, entityClass);
	}

	public <T> void save(T entityToSave) {
		if (entityToSave == null) {
			return;
		} else {
			mongoDAO.save(entityToSave);
		}
	}

	public <T> void save(T entityToSave, String collectionName) {
		if (entityToSave == null) {
			return;
		} else {
			mongoDAO.save(entityToSave, collectionName);
		}
	}

	public <T> void save(List<T> entityList) {
		if (entityList == null || entityList.isEmpty()) {
			return;
		} else {
			mongoDAO.save(entityList);
		}
	}

	public <T> Optional<List<T>> findAll(String columnName, List<String> ids, Class<T> class1) {
		Query query = new Query();
		query.addCriteria(Criteria.where(columnName).in(ids));
		List<T> list = mongoDAO.findAll(query, class1);
		if (list == null || list.size() == 0) {
			return Optional.empty();
		}
		return Optional.of(list);
	}

}
