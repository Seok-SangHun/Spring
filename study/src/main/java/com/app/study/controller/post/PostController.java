package com.app.study.controller.post;

import com.app.study.domain.member.MemberVO;
import com.app.study.domain.post.*;
import com.app.study.service.post.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final HttpSession session;


    @PostMapping("write")
    @ResponseBody
    public void writePost(PostVO postVO) {
        postService.write(postVO);
    }

    @GetMapping("list/{page}")
    @ResponseBody
    public List<PostDTO> getList(@PathVariable int page, Pagination pagination, Search search) {
        pagination.setPage(page);
        if(pagination.getOrder() == null){
            pagination.setOrder("recent");
        }
        if(search.getKeyword() != null || search.getTypes() != null) {
            pagination.setTotal(postService.getTotalWithSearch(search));
        }else{
            pagination.setTotal(postService.getTotal());
        }
        pagination.progress();
        return postService.getList(pagination, search);
    }

    @GetMapping("list")
    public void getList(Pagination pagination, Search search, Model model){
        if(pagination.getOrder() == null){
            pagination.setOrder("recent");
        }
        if(search.getKeyword() != null || search.getTypes() != null) {
            pagination.setTotal(postService.getTotalWithSearch(search));
        }else{
            pagination.setTotal(postService.getTotal());
        }
        pagination.progress();
        model.addAttribute("posts", postService.getList(pagination, search));
    }

    @GetMapping("read")
    public void read(Long id, Model model){
        PostDTO postDTO = postService.getPost(id).orElseThrow();
        model.addAttribute("post", postDTO);
    }

    @GetMapping("test")
    public void test(String[] tests){
        Arrays.stream(tests).forEach(log::info);
    }

    @PostMapping("test")
    public void test(TestDTO testDTO){
        log.info(testDTO.toString());
    }
}

















