package dbtest;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ENTITY1")
public class SubEntity1 extends SubEntity {

  @Column(name = "entity1_label")
  private String entity1Label;

  protected SubEntity1() {
  }

  public SubEntity1(String id) {
    super(id);
  }

  @Override
  public String getLabel() {
    return entity1Label;
  }
}
