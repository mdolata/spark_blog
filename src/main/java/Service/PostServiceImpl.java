/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Post;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mdolat
 */
public class PostServiceImpl implements PostService{

    private Map<Long, Post> postMap;

    public PostServiceImpl() {
        postMap = new HashMap<>();
    }
    
    
    @Override
    public void addPost(Post post) {
        postMap.put(post.getId(), post);
    }

    @Override
    public Collection<Post> getPosts() {
        return postMap.values();
    }

    @Override
    public Post getPost(Long id) {
        return postMap.get(id);
    }

    @Override
    public boolean postExist(Long id) {
        return postMap.containsKey(id);
    }
    
}
