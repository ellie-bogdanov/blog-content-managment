package dev.ellie.blogcontentmanagmentsystem.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.ellie.blogcontentmanagmentsystem.models.Post;

@Repository
public class PostRepository {
    private final List<Post> postRepository;

    public PostRepository() {
        postRepository = new ArrayList<Post>();
    }

    public List<Post> findAll() {
        return postRepository;
    }

    public Optional<Post> findById(Integer id) {
        return postRepository.stream().filter(p -> p.id().equals(id)).findFirst();
    }

    public void insertPost(Post post) {
        postRepository.add(post);
    }

    public int addLike(Integer id, String sentimentType) throws Exception {
        for(int i = 0; i < postRepository.size(); i++) {
            if(postRepository.get(i).id().equals(id)) {
                Post temp = postRepository.get(i);
                Post updatedPost;
                if(sentimentType.equals("like")) {
                    updatedPost = new Post(id, temp.creatorName(), temp.postName(), temp.content(), temp.likes() + 1, temp.dislikes());
                }

                else if(sentimentType.equals("dislike")){
                    updatedPost = new Post(id, temp.creatorName(), temp.postName(), temp.content(), temp.likes(), temp.dislikes() + 1);
                }
                else {
                    throw new Exception("wrong path", new Throwable("path name is wrong"));

                }
                
                postRepository.set(i, updatedPost);
                return 1;
            }
        }

        return 0;
    }

    
}
