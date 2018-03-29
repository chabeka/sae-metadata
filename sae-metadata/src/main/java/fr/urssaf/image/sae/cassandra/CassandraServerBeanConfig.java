package fr.urssaf.image.sae.cassandra;

import fr.urssaf.image.commons.cassandra.helper.CassandraServerBean;

public class CassandraServerBeanConfig {

	private String startLocal;
	private String hosts;
	private String dataSet;
	CassandraServerBean cassandraBean;
	
	public CassandraServerBean getCassandraServerBean() {
		cassandraBean = new CassandraServerBean();
		cassandraBean.setDataSet(dataSet);
		cassandraBean.setHosts(hosts);
		cassandraBean.setStartLocal(Boolean.getBoolean(startLocal));
		return cassandraBean;
	}
	
	public String getStartLocal() {
		return startLocal;
	}
	public void setStartLocal(String startLocal) {
		this.startLocal = startLocal;
	}
	public String getHosts() {
		return hosts;
	}
	public void setHosts(String hosts) {
		this.hosts = hosts;
	}
	public String getDataSet() {
		return dataSet;
	}
	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}
	
	
}
