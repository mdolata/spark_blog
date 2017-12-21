/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mdolat.spark_blog;

import Model.Post;
import Service.PostService;
import Service.PostServiceImpl;
import com.google.gson.Gson;

import static spark.Spark.*;
/**
 *
 * @author mdolat
 */
public class Main {
    public static void main(String[] args){
        final PostService postService = new PostServiceImpl();
        
        post("/posts", (req, res)->{
           res.type("application/json"); 
           Post post = new Gson().fromJson(req.body(), Post.class);
           postService.addPost(post);
                  
           return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
        
        get("/posts", (req, res) -> {
            res.type("application/json"); 
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(postService.getPosts())));
        });
        
        get("/posts/:id", (req, res) -> {
            res.type("application/json");
            try{
                Long id = Long.parseLong(req.params(":id"));
                if (postService.postExist(id))
                    return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(postService.getPost(id))));
            } catch(NumberFormatException e){
                e.printStackTrace();
            }
            return new Gson().toJson(new StandardResponse(StatusResponse.ERROR));
        });
        
    }
    
}
