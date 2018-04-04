/**
 *  TODO (AC75095028) Description du fichier
 */
package fr.urssaf.image.sae.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.CqlOperations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.Insert;

import fr.urssaf.image.sae.cassandra.common.CassandraCQLClientFactory;
import fr.urssaf.image.sae.dao.IGenericDAO;
import fr.urssaf.image.sae.queryutils.QueryUtils;

/**
 * TODO (AC75095028) Description du type
 */
@Repository
public class GenericDAOImpl<T, ID> implements IGenericDAO<T, ID> {

  @Autowired
  CassandraCQLClientFactory ccf;

  protected Class<? extends T> daoType;

  @SuppressWarnings("unchecked")
  public GenericDAOImpl() {
    final Type returnType = getClass().getGenericSuperclass();
    if (returnType instanceof ParameterizedType) {
      final ParameterizedType pt = (ParameterizedType) returnType;
      this.daoType = (Class<T>) pt.getActualTypeArguments()[0];
    }
  }

  public CassandraOperations getTemplate() {
    final CassandraOperations template = new CassandraTemplate(ccf.getSession());
    return template;
  }

  private CqlOperations getCqlOperations() {
    return getTemplate().getCqlOperations();
  }

  /**
   * {@inheritDoc}
   */
  public <S extends T> List<S> saveAll(final Iterable<S> entites) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findAllById(final Iterable<ID> ids) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public Slice<T> findAll(final Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <S extends T> S insert(final S entity) {
    final Insert insert = QueryUtils.createInsertStatement(ccf.getKeyspace(), daoType);
    getCqlOperations().execute(insert);
    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public <S extends T> List<S> insert(final Iterable<S> entities) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <S extends T> S save(final S entity) {
    // TODO Auto-generated method stub
    return insert(entity);
  }

  /**
   * {@inheritDoc}
   */
  public Optional<T> findById(final ID id) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public boolean existsById(final ID id) {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * {@inheritDoc}
   */
  public long count() {
    // TODO Auto-generated method stub
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  public void deleteById(final ID id) {
    // TODO Auto-generated method stub

  }

  /**
   * {@inheritDoc}
   */
  public void delete(final T entity) {
    // TODO Auto-generated method stub

  }

  /**
   * {@inheritDoc}
   */
  public void deleteAll(final Iterable<? extends T> entities) {
    // TODO Auto-generated method stub

  }

  /**
   * {@inheritDoc}
   */
  public void deleteAll() {
    // TODO Auto-generated method stub

  }

}
