package fr.urssaf.image.sae.cassandra.queryutils;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import org.springframework.util.Assert;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

public class QueryUtils {
	
	private String keyspace;
	private String columnFamily;
	private ConsistencyLevel consistency;
	
	
    public QueryUtils(String keyspace, String columnFamily, ConsistencyLevel consistency) {
		this.keyspace = keyspace;
		this.columnFamily = columnFamily;
		this.consistency = consistency;
	}

    /**
     * 
     * @param bean
     * @param consistency
     * @return
     */
	public <T> CRUDBean createCRUDBean(Class<T> bean) {
        //ClassInformation classInformation = ClassInformations.INSTACE.getClass(bean);
        CRUDBean byKeyBean = prepare(bean, new CRUDBean());
        //KeySpaceInformation keySpaceInformation = classInformation.getKeySpace(keySpace);
        Select select = QueryBuilder.select(byKeyBean.getArray()).from(
        		keyspace, columnFamily);
        byKeyBean.setSelect(select);
        byKeyBean.getSelect().setConsistencyLevel(consistency);
        return byKeyBean;
    }
    
	/**
	 * 
	 * @param className
	 * @return
	 */
    public List<String> getClassCloumnsName(Class className){
    	List<String> columns = new LinkedList<String>();
    	Assert.notNull(className, "Le nom de la classe ne peut etre null");
    	for (Field field : className.getDeclaredFields()) {
    		columns.add(field.getName());
    	}
		return columns;	
    }
    
    /**
     * ajout les colonne d'une classe (les colonnes de la column familly) pour la 
     * construction de la requete 
     * @param className
     * @param crudbean
     * @return
     */
    public CRUDBean prepare(Class className, CRUDBean crudbean) {
    	crudbean.getColumns().addAll(getClassCloumnsName(className));
    	return crudbean;
    }
}
