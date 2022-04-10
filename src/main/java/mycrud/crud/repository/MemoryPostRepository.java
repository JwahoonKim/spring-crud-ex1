package mycrud.crud.repository;

import lombok.RequiredArgsConstructor;
import mycrud.crud.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemoryPostRepository implements PostRepository{

    private static final Map<Long, Post> store = new HashMap<>();
    // 싱글톤 패턴으로 대체할 수 있을까?
    // 추가로 이걸 싱글톤으로 하는게 맞을까? static으로 하는 게 나을까?
    // repository가 빈으로 올라가면 싱글톤으로 관리될텐데 전부 의미가 없는 행동인가?
    private static Long sequence = 0L;

    // 리턴값 고민.. Long(id), Post 중 고르는 기준..?
    public Long save(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post.getId();
    }

    @Override
    public Post delete(Long id) {
        return store.remove(id);
    }

    public Post findById(Long id) {
        return store.get(id);
    }

    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clear() {
        store.clear();
    }
}
