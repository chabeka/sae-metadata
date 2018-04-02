package fr.urssaf.image.sae.cassandra.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;

import fr.urssaf.image.sae.cassandra.common.CassandraCQLClientFactory;
import fr.urssaf.image.sae.cassandra.dao.GenericDAO;

@Repository
public class GenericDAOImpl<CFT, CT> implements GenericDAO<CFT, CT> {
	
	@Autowired
	CassandraCQLClientFactory ccf;
	
	private Class<CT> beanClass;
	
	private String keyspace;
	private String columnFamily;
	private ConsistencyLevel consistency;
	
	public CT save(CT entity) {
		// TODO Auto-generated method stub
		return null;
	}
	public CT update(CT entity) {
		// TODO Auto-generated method stub
		return null;
	}
	public CT find(CFT key) {
		// TODO Auto-generated method stub
		return null;
	}
	public CT getById(CFT id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<CT> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public void remove(CT entity) {
		// TODO Auto-generated method stub
		
	}
	
	protected Session currentSession() {
        return ccf.getSession();
    }
	
	 @SuppressWarnings("unchecked")
	public GenericDAOImpl() {
	 ParameterizedType genericType = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        this.beanClass = (Class<CT>) genericType.getActualTypeArguments()[0];
    }
}
