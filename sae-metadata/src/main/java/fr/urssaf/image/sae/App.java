package fr.urssaf.image.sae;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Update;

import fr.urssaf.image.sae.cassandra.CassandraCQLClientFactoryConfig;
import fr.urssaf.image.sae.cassandra.CassandraServerBeanConfig;
import fr.urssaf.image.sae.cassandra.common.CassandraCQLClientFactory;
import fr.urssaf.image.sae.cassandra.common.CassandraServerBean;
import fr.urssaf.image.sae.cassandra.queryutils.CRUDBean;
import fr.urssaf.image.sae.cassandra.queryutils.QueryUtils;
import fr.urssaf.image.sae.model.MetadataReference;
import fr.urssaf.image.sae.model.Users;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String[] springConfig  = {"applicationContext-sae-metadata.xml" };
		
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	    // final CassandraServerBean cs = new CassandraServerBean();
	    final CassandraServerBean cassandraServerBean = (CassandraServerBean) context.getBean("cassandraServerBean");
	    final CassandraCQLClientFactory ccf = (CassandraCQLClientFactory) context.getBean("cassandraCQLClientFactory");
	    //final CassandraCQLClientFactory ccf = cassandraCQLClientFactoryConfig.getCQLCLient(cassandraServerBean);
	    final Session session = ccf.getSession();
	    /*session.execute(
	            "INSERT INTO cassandrademocql.songs (id, title, album, artist, tags) " +
	            "VALUES (" +
	                "756716f7-2e54-4715-9f00-91dcbea6cf50," +
	                "'La Petite Tonkinoise'," +
	                "'Bye Bye Blackbird'," +
	                "'Joséphine Baker'," +
	                "{'jazz', '2013'})" +
	            ";");
	    */
	    /* session.execute(
	             "CREATE TABLE cassandrademocql.metadata (" +
	                   "id uuid PRIMARY KEY," + 
	                   "title text," + 
	                   "album text," + 
	                   "artist text," + 
	                   "tags set<text>," + 
	                   "data blob" + 
	               ");");
	    */
	    QueryUtils qu = new QueryUtils("cassandrademocql", "users", ConsistencyLevel.ONE, session);
	    CRUDBean crudbean = qu.createCRUDBean(Users.class);
	    //System.out.println(columnName.toArray(new String[0]));
	    ResultSet result = session.execute(crudbean.getSelect());
	    
	    System.out.println("Hello World!");
	    
    }
}
