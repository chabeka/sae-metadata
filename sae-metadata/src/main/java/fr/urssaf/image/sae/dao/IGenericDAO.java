/**
 *  TODO (AC75095028) Description du fichier
 */
package fr.urssaf.image.sae.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * TODO (AC75095028) Description du type
 */

/**
 * Classe abstraite pour les DAO CASSANDRA
 *
 * @param <T>
 * @param <ID>
 */
public interface IGenericDAO<T, ID> extends CassandraRepository<T, ID> {

}
