package fr.ursaf.image.sae;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.urssaf.image.sae.cassandra.dao.IDictionaryDAO;
import fr.urssaf.image.sae.cassandra.dao.IUsersDAO;
import fr.urssaf.image.sae.model.Dictionary;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-commons-cassandra.xml")
public class DictionaryTest {

	//@Autowired
	//IDictionaryDAO dictionnary;
	
	@Autowired
	IUsersDAO userdao;
	
	@Test
	public void test() {
		
	    final Dictionary dico = new Dictionary();
	    dico.setId("aszqedzqsaed");
	    dico.setValue("aaaa");
	    
	   // dictionnary.save(dico);
		fail("Not yet implemented");
	}

}
