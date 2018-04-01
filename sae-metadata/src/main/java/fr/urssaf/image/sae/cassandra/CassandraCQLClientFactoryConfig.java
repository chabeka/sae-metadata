package fr.urssaf.image.sae.cassandra;

import fr.urssaf.image.sae.cassandra.common.CassandraCQLClientFactory;
import fr.urssaf.image.sae.cassandra.common.CassandraServerBean;

public class CassandraCQLClientFactoryConfig {

	private String keyspace;
	private String username;
	private String password;
	private CassandraServerBean cassandraBean;
	
	public CassandraCQLClientFactoryConfig(CassandraServerBean cassandra, String username, String password, String keyspace) {
		this.cassandraBean = cassandra;
		this.username = username;
		this.password = password;
		this.keyspace = keyspace;
	}

	  public CassandraCQLClientFactory getCQLCLient(final CassandraServerBeanConfig cassandraServerBeanConfig) {
		    CassandraCQLClientFactory cassandraCQLClientFactory = null;
		    try {
		      final CassandraServerBean cassandraBean = cassandraServerBeanConfig.getCassandraServerBean();
		      cassandraCQLClientFactory = new CassandraCQLClientFactory(cassandraBean, keyspace, username, password);

		    }
		    catch (final InterruptedException e) {
		      e.printStackTrace();
		    }
		    return cassandraCQLClientFactory;
		  }
	public String getKeyspace() {
		return keyspace;
	}

	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CassandraServerBean getCassandra() {
		return cassandraBean;
	}

	public void setCassandra(CassandraServerBean cassandra) {
		this.cassandraBean = cassandra;
	}
	
	
}
