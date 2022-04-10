package mycrud.crud.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Post {
    Long id;
    String title;
    String content;

    // 기본 생성자가 없으니 JSON 요청 받는 과정에서 문제가 생기네?
    public Post() {}

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
