package mycrud.crud.repository;

import mycrud.crud.model.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryPostRepositoryTest {

    PostRepository postRepository = new MemoryPostRepository();

    @AfterEach
    void afterEach() {
        postRepository.clear();
    }

    @Test
    void save() {
        //given
        Post post = new Post("title1", "hihi");

        //when
        Long saveId = postRepository.save(post);

        //then
        Post findPost = postRepository.findById(saveId);
        assertThat(post).isEqualTo(findPost);
    }

    @Test
    void findAll() {
        //given
        Post post1 = new Post("title1", "hihi1");
        Post post2 = new Post("title2", "hihi2");

        postRepository.save(post1);
        postRepository.save(post2);

        //when
        List<Post> posts = postRepository.findAll();

        //then
        assertThat(posts.size()).isEqualTo(2);
        assertThat(posts).contains(post1, post2);
    }
}