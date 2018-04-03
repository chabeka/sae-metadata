/**
 *  TODO (AC75095028) Description du fichier
 */
package fr.urssaf.image.sae.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * TODO (AC75095028) Description du type
 */

@Table
public class Dictionary {

  @PrimaryKey
  private String id;

  private String value;

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id
   *          the id to set
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value
   *          the value to set
   */
  public void setValue(final String value) {
    this.value = value;
  }

}
