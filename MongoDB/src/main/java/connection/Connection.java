package connection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Connection {

    private String uri = "mongodb://localhost:27017";
    private MongoClient mongoClient;
    private MongoCollection<Document> collection;

    public Connection(){
        //Inicia conexão
        mongoClient = MongoClients.create(uri);
        MongoDatabase database = mongoClient.getDatabase("mongo_db");
        collection = database.getCollection("collection");
    }

    //Retorna coleção
    public MongoCollection<Document> getCollection(){
        return collection;
    }

    //Fecha conexão
    public void close(){
        if(mongoClient != null){
            mongoClient.close();
        }
    }

}
