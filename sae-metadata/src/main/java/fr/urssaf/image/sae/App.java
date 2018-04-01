package fr.urssaf.image.sae;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.datastax.driver.core.Session;

import fr.urssaf.image.sae.cassandra.CassandraCQLClientFactoryConfig;
import fr.urssaf.image.sae.cassandra.CassandraServerBeanConfig;
import fr.urssaf.image.sae.cassandra.common.CassandraCQLClientFactory;
import fr.urssaf.image.sae.cassandra.common.CassandraServerBean;

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
	     session.execute(
	             "CREATE TABLE cassandrademocql.metadata (" +
	                   "id uuid PRIMARY KEY," + 
	                   "title text," + 
	                   "album text," + 
	                   "artist text," + 
	                   "tags set<text>," + 
	                   "data blob" + 
	               ");");
	    
	    System.out.println("Hello World!");
    }
}
