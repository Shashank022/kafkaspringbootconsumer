package com.kafka.consumer.repository;
import com.kafka.consumer.model.Person;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends SolrCrudRepository<Person, Integer> {
}
