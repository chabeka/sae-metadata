package fr.urssaf.image.sae.cassandra.dao;

import java.util.List;

import com.datastax.driver.core.ConsistencyLevel;

/**
 * Classe abstraite pour les DAO CASSANDRA
 * 
 * @param <CFT>
 *           Type de la clé de ligne
 * @param <CT>
 *           Type du nom de colonne
 * 
 */
public interface GenericDAO<CFT, CT> {
	
    public CT save(CT entity) ;
    public CT update(CT entity) ;
    public CT find(CFT key);
    public CT getById( CFT id );
    public List<CT> getAll() ;
    public void remove(CT entity);
    
}
