package mycrud.crud.controller;

import lombok.RequiredArgsConstructor;
import mycrud.crud.model.Post;
import mycrud.crud.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController // HTTP 메세지 바디에 직접 값을 넣고 싶을때(@Controller만 쓰면 뷰를 찾게 되니까),  @ResponseBody + @Controller 효과
@RequestMapping("/posts") // /posts가 모든 mapping에 들어가있으면 중복이 발생해서 클래스 레벨에 써놓음으로써 중복 제거
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 저장
    @PostMapping
    public Post save(@RequestBody Post post) {
        Long postId = postService.savePost(post);
        return post;
    }

    // 글 목록 보기
    @GetMapping
    public List<Post> posts() {
        List<Post> posts = postService.findAllPosts();
        return posts;
    }

    // 글 상세 보기
    @GetMapping("/{postId}")
    public Post post(@PathVariable Long postId) {
        return postService.findById(postId);
    }

    // 글 삭제
    @DeleteMapping("/{postId}")
    public Post deletePost(@PathVariable Long postId) {
        return postService.deletePost(postId);
    }

    // 글 수정
    @PutMapping("/{postId}")
    public Post editPost(@PathVariable Long postId, @RequestBody Post post) {
        return postService.editPost(postId, post.getTitle(), post.getContent());
    }

    @PostConstruct
    public void init() {
        postService.savePost(new Post("postA", "10000"));
        postService.savePost(new Post("postB", "20000"));
    }
}
