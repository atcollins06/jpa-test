package dbtest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParentEntityRepository extends CrudRepository<ParentEntity, String> {

  @Query(
    value = "select pe from dbtest.ParentEntity as pe where ?1 member of pe.subEntities"
  )
  @EntityGraph("parentWithSubs")
  List<ParentEntity> findWithSubEntity(SubEntity subEntity);
}
