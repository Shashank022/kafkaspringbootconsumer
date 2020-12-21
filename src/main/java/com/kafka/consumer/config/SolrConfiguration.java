package com.kafka.consumer.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@ConfigurationProperties(prefix = "spring.data.solr")
@EnableSolrRepositories(basePackages ={"com.kafka.consumer.solr"} )
public class SolrConfiguration {

    @Value("${solr.host}")
    private String solrHost;

    @Value("${solr.core}")
    private String solrCore;


    @Bean
    public  SolrClient solrClient(){
        return new HttpSolrClient.Builder().withBaseSolrUrl(solrHost +"/"+ solrCore).build();
    }
}
