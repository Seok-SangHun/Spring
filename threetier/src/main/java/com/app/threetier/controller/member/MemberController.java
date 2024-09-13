package com.app.threetier.controller.member;

import com.app.threetier.domain.member.MemberDTO;
import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

//    회원가입
    @GetMapping("join")
    public void goToJoinForm(MemberDTO memberDTO){;}

    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        memberService.join(memberDTO.toVO());
        return new RedirectView( "/member/login");
    }
}
