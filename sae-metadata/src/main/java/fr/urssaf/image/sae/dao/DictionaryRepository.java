package fr.urssaf.image.sae.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import fr.urssaf.image.sae.model.Dictionary;

@Repository
public interface DictionaryRepository extends CassandraRepository<Dictionary, String> {

}
