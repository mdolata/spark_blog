/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Post;
import java.util.Collection;

/**
 *
 * @author mdolat
 */
public interface PostService {
    public void addPost(Post post);
    public Collection<Post> getPosts();
    public Post getPost(Long id);
    public boolean postExist(Long id);
    
}
