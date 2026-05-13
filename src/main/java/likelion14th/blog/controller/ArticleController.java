package likelion14th.blog.controller;

import likelion14th.blog.dto.request.ArticleRequest;
import likelion14th.blog.dto.response.ApiResponse;
import likelion14th.blog.dto.response.ArticleResponse;
import likelion14th.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Response body + Controller
@RequiredArgsConstructor
@RequestMapping("/articles")

public class ArticleController {
    private final ArticleService articleService;

    @PostMapping() //Post 요청을 매핑
    public ResponseEntity<ApiResponse<ArticleResponse>> addArticle(@RequestBody ArticleRequest request) {
        ArticleResponse articleResponse =
                articleService.addArticle(request.getTitle(), request.getContent(), request.getAuthor(), request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(201, "게시글 생성에 성공하였습니다.", articleResponse));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ArticleResponse>> getOneArticle(@PathVariable Long id) {
        ArticleResponse articleResponse = articleService.getOneArticle(id);
        return ResponseEntity.ok(ApiResponse.success(200, "게시글 개별 조회에 성공하였습니다.", articleResponse));
    }

}
