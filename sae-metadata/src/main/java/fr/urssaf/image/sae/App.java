package fr.urssaf.image.sae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.Session;

import fr.urssaf.image.sae.cassandra.common.CassandraCQLClientFactory;
import fr.urssaf.image.sae.cassandra.common.CassandraServerBean;
import fr.urssaf.image.sae.cassandra.dao.IDictionaryDAO;
import fr.urssaf.image.sae.model.Dictionary;

/**
 * Hello world!
 *
 */

@Component
public class App 
{
	//@Autowired
	//IDictionaryDAO dictionnary;
	
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        String[] springConfig  = {"applicationContext-sae-metadata.xml" };
		
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	    final CassandraServerBean cassandraServerBean = (CassandraServerBean) context.getBean("cassandraServerBean");
	    final CassandraCQLClientFactory ccf = (CassandraCQLClientFactory) context.getBean("cassandraCQLClientFactory");
	    final Session session = ccf.getSession();
	    CassandraOperations template = new CassandraTemplate(ccf.getSession());
	    
	    
	    //App app = context.getBean(App.class);
	    //DictionaryDAOImpl dictionnary = new DictionaryDAOImpl(ccf);
	    
	    
	    
	    //createTableDictionary(session);
	    
	    final Dictionary dico = new Dictionary();
	    dico.setId("aszqedzqsaed");
	    dico.setValue("aaaa");
	    template.insert(dico);
	    //app.dictionnary.save(dico);
	    
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
	    /*QueryUtils qu = new QueryUtils("cassandrademocql", "users", ConsistencyLevel.ONE, session);
	    CRUDBean crudbean = qu.createCRUDBean(Users.class);
	    //System.out.println(columnName.toArray(new String[0]));
	    ResultSet result = session.execute(crudbean.getSelect());
	    */
	    
	    System.out.println("Hello World!");
	    
    }
    
    public static void createTableDictionary(final Session session) {
        session.execute(
                        "CREATE TABLE cassandrademocql.testMetadata (" +
                            "id uuid PRIMARY KEY," +
                            "title text," +
                            "descr text," +
                            "search text," +
                            "type text," +
                            "hasDict text" +
                            ");");
      }

}
