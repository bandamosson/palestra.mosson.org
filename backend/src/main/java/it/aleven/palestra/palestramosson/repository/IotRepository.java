package it.aleven.palestra.palestramosson.repository;

import it.aleven.palestra.palestramosson.model.IotMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "iot", path = "iot")
//public interface IotRepository extends PagingAndSortingRepository<IotMessage, Long> {
public interface IotRepository extends JpaRepository<IotMessage, Long> {

    List<IotMessage> findByAction(@Param("action") String action);

}