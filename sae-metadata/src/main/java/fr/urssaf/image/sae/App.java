package fr.urssaf.image.sae;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.InsertOptions;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;

import fr.urssaf.image.sae.cassandra.common.CassandraCQLClientFactory;
import fr.urssaf.image.sae.dao.impl.DictionaryDAOImpl;
import fr.urssaf.image.sae.model.Dictionary;

/**
 * Hello world!
 */
public class App {

  public static void main(final String[] args) {

    final String[] springConfig = {"applicationContext-commons-cassandra.xml"};
    final ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

    final CassandraCQLClientFactory ccf = (CassandraCQLClientFactory) context.getBean("cassandraCQLClientFactory");
    final DictionaryDAOImpl dicodao = (DictionaryDAOImpl) context.getBean("dictionaryDAOImpl");

    final Dictionary dicoo = new Dictionary();
    dicoo.setId(java.util.UUID.fromString(UUID.randomUUID().toString()));
    dicoo.setValue("dicodao");
    dicodao.save(dicoo);

    final Session session = ccf.getSession();
    final CassandraOperations template = new CassandraTemplate(session);
    final List<Dictionary> dicos = findAllDictionaryCql(template, "cassandrademocql");
    // insert(session);
    // createTableDictionary(session);
    // template.truncate(Dictionary.class);
    final InsertOptions options = InsertOptions.builder()
                                               .consistencyLevel(ConsistencyLevel.ONE)
                                               .ttl(Duration.ofMinutes(1L))
                                               .build();

    final Dictionary dico = new Dictionary();
    dico.setId(java.util.UUID.fromString(UUID.randomUUID().toString()));
    dico.setValue("ttl");
    template.insert(dico, options);

    for (final Dictionary dic : dicos) {
      System.out.println(dic.toString());
    }
  }

  public static List<Dictionary> findAllDictionaryCql(final CassandraOperations template, final String keyspace) {
    return template.select("SELECT * FROM " + keyspace + ".dictionary", Dictionary.class);
  }

  public static void insert(final Session session) {
    session.execute(
                    "INSERT INTO SAE.testMetadata (id, title, descr, search, type, hasDict) " +
                        "VALUES (" +
                        "756716f7-2e54-4715-9f00-91dcbea6cf50," +
                        "'La Petite Tonkinoise'," +
                        "'Bye Bye Blackbird'," +
                        "'Joséphine Baker'," +
                        "'blabla'," +
                        "'blabla'" +
                        ");");

  }

  public static void createTableMetadata(final Session session) {
    session.execute(
                    "CREATE TABLE SAE.testMetadata (" +
                        "id uuid PRIMARY KEY," +
                        "title text," +
                        "descr text," +
                        "search text," +
                        "type text," +
                        "hasDict text" +
                        ");");
  }

  public static void createTableDictionary(final Session session) {
    session.execute(
                    "CREATE TABLE SAE.dictionary (" +
                        "id uuid PRIMARY KEY," +
                        "value text" +
                        ");");
  }

  public void createKeyspace(final Session session) {

  }
}
