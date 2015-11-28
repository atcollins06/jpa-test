package dbtest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@NamedEntityGraphs(
  @NamedEntityGraph(name = "parentWithSubs",
    attributeNodes = {
      @NamedAttributeNode(value = "subEntities")
    })
)
@Table(name = "parent_entity")
public class ParentEntity implements Serializable {
  private static final long serialVersionUID = 7769491712388898030L;

  @Id
  private String id;

  @Column(name = "entity_field1")
  private String field1;

  @OneToMany
  @JoinTable(
    name = "parent_entity_sub_entity",
    joinColumns = @JoinColumn(name = "parent_entity_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "sub_entity_id", referencedColumnName = "id")
  )
  private Set<SubEntity> subEntities;

  public ParentEntity() {
  }

  public String getId() {
    return id;
  }

  public String getField1() {
    return field1;
  }
}
