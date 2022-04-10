package mycrud.crud.service;

import lombok.RequiredArgsConstructor;
import mycrud.crud.model.Post;
import mycrud.crud.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Long savePost(Post post) {
        return postRepository.save(post);
    }

    public Post deletePost(Long id) {
        return postRepository.delete(id);
    }

    public Post editPost(Long id, String title, String content) {
        Post findPost = postRepository.findById(id);
        findPost.setTitle(title);
        findPost.setContent(content);
        return findPost;
    }

    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
