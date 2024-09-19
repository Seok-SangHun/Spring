package com.app.threetier.controller.post;

import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import com.app.threetier.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시물 생성 폼 이동
    @GetMapping("create")
    public String goToCreateForm() {
        return "post/create";
    }

    // 게시물 생성
    @PostMapping("create")
    public RedirectView createPost(PostVO postVO) {
        postService.create(postVO);
        return new RedirectView("/post/list");
    }

    // 게시물 조회 (DTO 사용)
    @GetMapping("detail")
    public String getPost(Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post/detail";
    }

    // 게시물 전체 조회 (DTO 사용)
    @GetMapping("list")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "post/list";
    }

    // 게시물 수정 폼 이동
    @GetMapping("edit")
    public String goToUpdateForm(Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post/edit";
    }

    // 게시물 수정
    @PostMapping("edit")
    public RedirectView updatePost(PostDTO postDTO) {
        postService.update(postDTO);
        return new RedirectView("/post/detail?id=" + postDTO.getId());
    }

    // 게시물 삭제
    @PostMapping("delete")
    public RedirectView deletePost(Long id) {
        postService.delete(id);
        return new RedirectView("/post/list");
    }
}
