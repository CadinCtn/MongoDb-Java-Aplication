package main;

import connection.Connection;
import dao.Dao;
import model.Movie;

import java.util.Scanner;


public class Main {

    public static void main( String[] args ) {
        Scanner le = new Scanner(System.in);
        Connection connection = new Connection();
        Dao dao = new Dao(connection);
        int opcao = 0;
        do{
            System.out.println("==========================");
            System.out.println("    MongoDb Aplication");
            System.out.println("==========================");
            System.out.println("Escolha uma opçao:");
            System.out.println("1- Inserir filme");
            System.out.println("2- Deletar filme");
            System.out.println("3- Listar filmes");
            System.out.println("4- Buscar filme");
            System.out.println("0- Sair");
            opcao = le.nextInt();
            //le.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Digite:");
                    System.out.print(" - Titulo: ");
                    String titulo = le.next();
                    le.nextLine();

                    System.out.print("\n - Descrição: ");
                    String descricao = le.next();
                    le.nextLine();

                    //Insere documento
                    dao.insertOneMovie(new Movie(titulo, descricao));
                    break;

                case 2:
                    System.out.println("Digite o titulo: ");
                    String filme = le.next();
                    le.nextLine();

                    //Remove documento
                    dao.deleteOneMovie(filme);
                    break;

                case 3:
                    System.out.println("Filmes:");
                    for(Movie movie : dao.readAllMovies()){
                        System.out.println(movie.getTitle());
                    }
                    break;
                case 4:
                    System.out.println("Digite o titulo do filme: ");
                    String tituloFilme = le.next();
                    le.nextLine();
                    Movie movie = dao.readMovieByTitle(tituloFilme);
                    if(movie != null){
                        System.out.println("Titulo: "+movie.getTitle());
                        System.out.println("Descrição: "+movie.getDescription());
                    } else {
                        System.out.println("Nenhum filme encontrado com esse titulo!");
                    }
            }

        }while(opcao != 0);
        //Encerra conexão
        connection.close();

    }


}
