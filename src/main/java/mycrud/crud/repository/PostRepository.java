package mycrud.crud.repository;

import mycrud.crud.model.Post;

import java.util.List;

public interface PostRepository {
    public Long save(Post post);
    public Post delete(Long id);
    public Post findById(Long id);
    public List<Post> findAll();
    public void clear();
}
