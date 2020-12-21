package com.kafka.consumer.solrservice;

import com.kafka.consumer.model.Person;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private SolrClient solrClient;

    public void savePersonsData(Person data){
        System.out.println("Consumed JSON Message: " + data);
    }

}
