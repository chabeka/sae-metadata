/**
 *  TODO (AC75095028) Description du fichier
 */
package fr.urssaf.image.sae.queryutils;

import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

/**
 * TODO (AC75095028) Description du type
 */
public class QueryUtils {

  public static <T> Insert createInsertStatement(final String keyspace, final Class<T> bean) {
    final String name = bean.getClass().getName();
    final String className = bean.getClass().getSimpleName();
    final Insert insert = QueryBuilder.insertInto(keyspace, bean.getClass().getName());
    return insert;
  }

}
