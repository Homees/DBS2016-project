/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeRegExp.test;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import static org.elasticsearch.common.xcontent.XContentFactory.*;	//V tomto je jsonBuilder ak ho neviete najst
import org.elasticsearch.index.query.QueryBuilder;
import static org.elasticsearch.index.query.QueryBuilders.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.FieldSortBuilder;
import static org.elasticsearch.search.sort.SortBuilders.fieldSort;
import org.elasticsearch.search.sort.SortOrder;
import static org.elasticsearch.search.sort.SortOrder.ASC;

/**
 *
 * @author Filip
 */
public class Maven_database {
    Connection connection = null;
    Statement statement = null;
    private Client client;
    private ArrayList<String> zoznam_retazcov = new ArrayList<>();
    
    public void maven_connect() throws Exception{
        // on startup

        client = TransportClient.builder().build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));        
    
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "databazy2016");
            connection.setAutoCommit(false);
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            System.exit(0);
        }
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM krmivo;");
        
        int i = 1;
        while (rs.next()){
            IndexResponse vytvorenie = client.prepareIndex("postgres", "krmivo", new StringBuilder().append(i).toString())
            .setSource(jsonBuilder()
                .startObject()
                    .field("nazov", rs.getString("nazov"))
                    .field("hmotnost", rs.getInt("hmotnost"))
                    .field("typ", rs.getString("typ"))
                    .field("zlozenie", rs.getString("zlozenie"))
                .endObject()).get();
            
            //String json = vytvorenie.toString();
            //System.out.println(json.toCharArray());
            i++;
        }
        search_response();
    }
        
        /*IndexResponse one_response = client.prepareIndex("facebook", "sprava", "12")
        .setSource(jsonBuilder()
            .startObject()
                .field("user", "Peter")
                .field("age", 20)
                .field("postDate", new Date())
                .field("message", "Aspon vlastna elasticsearch")
            .endObject()).get();
        String json = one_response.toString();
        System.out.println(json);
        
        //CreateIndexResponse createResponse = client.admin().indices().create(Requests.createIndexRequest("twitter")).actionGet();
        
        IndexResponse two_response = client.prepareIndex("facebook", "sprava", "13")
        .setSource(jsonBuilder()
            .startObject()
                .field("user", "Debil")
                .field("age", 25)
                .field("postDate", new Date())
                .field("message", "databaza funguje")
            .endObject()).get();
        
        // Index name
        String _index = one_response.getIndex();
        // Type name
        String _type = one_response.getType();
        // Document ID (generated or not)
        String _id = one_response.getId();
        // Version (if it's the first time you index this document, you will get: 1)
        long _version = one_response.getVersion();
        // isCreated() is true if the document is a new one, false if it has been updated
        boolean created = one_response.isCreated();*/
        
    public void search_response() throws Exception{
        Main_screen jpanel_zobrazenie = new Main_screen();
        
        SearchResponse response = client.prepareSearch("postgres")
            .setTypes("krmivo")
            //.addSort(fieldSort("activity").order(ASC))
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
            //.setQuery("where hmotnost > 30")
            .setQuery(QueryBuilders.termQuery("nazov", "pedigri"))                          // Query
            .addAggregation(AggregationBuilders.avg("priem_hmotnost").field("hmotnost"))
            .setPostFilter(QueryBuilders.rangeQuery("hmotnost").from(20).to(80))           // Filter
            .setFrom(0).setSize(60).setExplain(true)
            .execute()
            .actionGet();
        System.out.println(response.toString());
        
        System.out.println();
        System.out.println("Zoznam vyhovujucich zaznamov:");
        SearchHit[] results = response.getHits().getHits();
        for(SearchHit hit : results){
            String sourceAsString = hit.getSourceAsString();
            zoznam_retazcov.add(sourceAsString);
            System.out.println(sourceAsString);
        }
        jpanel_zobrazenie.string_list = zoznam_retazcov;
        //System.out.println(zoznam_retazcov);
        
        MultiGetResponse multiGetItemResponses = client.prepareMultiGet()
            .add("postgres", "krmivo", "4", "5", "6", "7")
            .add("postgres", "krmivo", "10", "11", "3", "8", "9")
            .add("postgres", "zviera", "1", "2")
            .get();

        for (MultiGetItemResponse itemResponse : multiGetItemResponses) { 
            GetResponse getresponse = itemResponse.getResponse();
            //System.out.println(getresponse.getId() + getresponse.getSourceAsString());
            if (getresponse.isExists()) {                      
                String json = response.toString();
            }
        }

        client.close();
    }
}
