package dbtest;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sub_entity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class SubEntity implements Serializable {
  private static final long serialVersionUID = -6538558790198990268L;

  @Id
  private String id;

  protected SubEntity() {
  }

  protected SubEntity(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public abstract String getLabel();
}
