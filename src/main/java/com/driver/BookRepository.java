package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    int id = 1;
    HashMap<Integer, Book> db = new HashMap<>();
    public BookRepository(){

    }

    public Book save(Book book){
        book.setId(id);
        db.put(id, book);
        id++;
        return book;
    }

    public Book findBookById(int id){
        return db.get(id);
    }

    public List<Book> findAll(){
        return new ArrayList<>(db.values());
    }

    public void deleteBookById(int id){
        if(!db.containsKey(id))
            return;
        db.remove(id);
    }

    public void deleteAll(){
        db.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> ans = new ArrayList<>();
        for(int id : db.keySet()){
            if(db.get(id).getAuthor().equals(author)){
                ans.add(db.get(id));
            }
        }
        return ans;
    }

    public List<Book> findBooksByGenre(String genre){

        List<Book> ans = new ArrayList<>();
        for(int id : db.keySet()){
            if(db.get(id).getGenre().equals(genre)){
                ans.add(db.get(id));
            }
        }
        return ans;
    }
}
