package fr.urssaf.image.sae;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.urssaf.image.commons.cassandra.helper.CassandraCQLClientFactory;

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
    }
}
