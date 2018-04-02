package fr.urssaf.image.sae.cassandra.queryutils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.Assert;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import fr.urssaf.image.sae.cassandra.utils.ReflectionUtil;


public class QueryUtils {
	
	private String keyspace;
	private String columnFamily;
	private ConsistencyLevel consistency;
	private Session session;
	
	
    public QueryUtils(String keyspace, String columnFamily, ConsistencyLevel consistency, Session session) {
		this.keyspace = keyspace;
		this.columnFamily = columnFamily;
		this.consistency = consistency;
		this.session = session;
	}

    
    public <T> List<T> listAll(Class<T> bean) {
    	
    	CRUDBean crudbean = createCRUDBean(bean);
    	ResultSet result = session.execute(crudbean.getSelect());
    	// construire la liste d'objet T à partir du resultset
        return new ArrayList<T>();
    }
    
    public <T> T save(Class<T> bean) {

		Insert insert = createInsertStatement(bean);
		ResultSet result =  session.execute(insert);
		return null;
	}
    /**
     * 
     * @param bean
     * @param consistency
     * @return
     */
	public <T> CRUDBean createCRUDBean(Class<T> bean) {
        CRUDBean byKeyBean = prepare(bean, new CRUDBean());
        Select select = QueryBuilder.select(byKeyBean.getArray()).from(
        		keyspace, columnFamily);
        byKeyBean.setSelect(select);
        byKeyBean.getSelect().setConsistencyLevel(consistency);
        return byKeyBean;
    }
    
	/**
	 * 
	 * @param clazz
	 * @return
	 */
    public List<String> getClassColumnsName(Class clazz){
    	List<String> columns = new LinkedList<String>();
    	Assert.notNull(clazz, "Le nom de la classe ne peut etre null");
    	for (Field field : clazz.getDeclaredFields()) {
    		columns.add(field.getName());
    	}
		return columns;	
    }
    
    /**
     * ajout les colonne d'une classe (les colonnes de la column familly) pour la 
     * construction de la requete 
     * @param clazz
     * @param crudbean
     * @return
     */
    public CRUDBean prepare(Class clazz, CRUDBean crudbean) {
    	crudbean.getColumns().addAll(getClassColumnsName(clazz));
    	return crudbean;
    }
    
    private <T> Insert createInsertStatement(Class<T> bean) {
		Insert insert = QueryBuilder.insertInto(keyspace, columnFamily);
		insert = createInsert(bean, insert);
		insert.setConsistencyLevel(consistency);
	    return insert;
	}
    
    private <T> Insert createInsert(Class<T> bean, Insert insert) {

        for (Field field : bean.getDeclaredFields()) {
        	
            Object fieldValue = ReflectionUtil.getMethod(bean, field);
			if (fieldValue != null) {
            	insert.value(field.getName(), fieldValue);
            }
        }
        return insert;
    }
}
