package likelion14th.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본생성자를 만들어줌.
@AllArgsConstructor // 모든 인자를 가진 생성자를 만들어줌.

public class ArticleRequest {
    private String title;
    private String content;
    private String author;
    private String password;

}

