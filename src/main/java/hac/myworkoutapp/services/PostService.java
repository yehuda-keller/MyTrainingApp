package hac.myworkoutapp.services;

import hac.myworkoutapp.repo.Post;
import hac.myworkoutapp.repo.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findByTitleOfPost(String titleOfPost) {
        return postRepository.findByTitleOfPost(titleOfPost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
