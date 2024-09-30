package com.app.threetier.controller.post;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import com.app.threetier.service.post.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post/*")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final HttpSession session;

    @GetMapping("write")
    public void goToWriteForm(PostDTO postDTO){;}

    @PostMapping("write")
    public void write(PostDTO postDTO){
//        작성자 ID 가져오기
        postDTO.setMemberId(((MemberVO) session.getAttribute("member")).getId());
        postService.write(postDTO.toVO());
    }

    @GetMapping("list")
    public void getList(Pagination pagination, String order, Model model){
        // 현재 로그인한 회원 정보를 세션에서 가져오기
        MemberVO memberVO = (MemberVO) session.getAttribute("member");

        if(order == null){
            order = "recent";
        }

        pagination.setTotal(postService.getTotal());

        pagination.progress();

        // 게시물 목록과 회원 정보를 모델에 추가
        model.addAttribute("posts", postService.getList(pagination, order));
        model.addAttribute("member", memberVO); // 세션에서 가져온 회원 정보를 모델에 추가
        model.addAttribute("order", order); // order 값을 모델에 추가
    }

}

















