package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import connection.Connection;
import model.Movie;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Dao {

    private MongoCollection<Document> collection;

    public Dao(Connection connection){
        collection = connection.getCollection();
    }

    public void insertOneMovie(Movie movie){
        collection.insertOne(movie.toDocument());
    }

    //Busca documento por titulo
    public Movie readMovieByTitle(String title){
        Document document = collection.find(new Document("title", title)).first();
        if(document == null) return null; //Se não encontrar nada retorna null
        return new Movie(document); //Retorna objeto
    }

    public List<Movie> readAllMovies(){
        List<Movie> movieList = new ArrayList<>();
        //Busca todos os documento da coleção
        MongoCursor<Document> cursor = collection.find().iterator();
        //Insere na lista
        while(cursor.hasNext()){
               movieList.add(new Movie(cursor.next()));
        }
        return movieList;
    }

    //Deleta documento pelo titulo
    public void deleteOneMovie(String title){
        collection.deleteOne(new Document("title", title));
    }


}
