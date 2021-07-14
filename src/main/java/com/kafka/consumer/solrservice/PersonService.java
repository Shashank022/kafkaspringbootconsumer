package com.kafka.consumer.solrservice;

import com.kafka.consumer.listener.KafkaConsumer;
import com.kafka.consumer.model.Person;
import com.kafka.consumer.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class PersonService {

    private static final Logger LOGGER = LogManager.getLogger(PersonService.class);

    @Autowired
    private SolrClient solrClient;

    public void savePersonsData(Person data){
        try{
            SolrInputDocument personDoc = new SolrInputDocument();
            personDoc.addField("id", data.getId());
            personDoc.addField("firstname", data.getFirst_name());
            personDoc.addField("lastname",data.getLast_name());
            personDoc.addField("gender",data.getGender());
            personDoc.addField("address",data.getAddress());
            personDoc.addField("email",data.getEmail());
            personDoc.addField("country",data.getCountry());
            personDoc.addField("timezone",data.getTimezone());
            personDoc.addField("zipcode",data.getZipcode());
            solrClient.add(personDoc);
            solrClient.commit();
            LOGGER.info("Successfully save the Solr doc...");
        }catch (Exception e){
            LOGGER.error("Exception occurred at this..", e.getMessage());
        }
        LOGGER.info("Consumed JSON Message: " + data);
    }

}
