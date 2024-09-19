package com.app.threetier.controller.member;

import com.app.threetier.domain.member.MemberDTO;
import com.app.threetier.service.member.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
// 최상위 경로를 설정하여 컨트롤러를 구분한다.
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    //    회원가입 페이지로 이동(GET)
    @GetMapping("join")
//    화면에 있는 input태그의 속성을 채울 때,
//    해당 객체의 필드명과 동일하게 맞춰야 한다.
//    이를 위해 비어있는 객체를 화면으로 전달해준다.
    public void goToJoinForm(MemberDTO memberDTO){;}

    //    회원가입 완료(POST)
//    경로가 같아도 REQUEST METHOD가 다르면 구분할 수 있다.
    @PostMapping("join")
//    화면에서 작성된 input태그의 name과 MemberDTO 필드명이 mapping된다.
    public RedirectView join(MemberDTO memberDTO){
//        전달받은 정보를 테이블에 INSERT한다.
        memberService.join(memberDTO.toVO());
//        redirect방식을 사용해서 member/login 컨트롤러로 이동한다.
//        만약 forward방식을 사용해서 login.html로 이동하게 되면,
//        화면은 로그인 페이지가 나오겠지만, 경로는 member/join(POST)이기 때문에
//        새로고침 할 때마다 현재 메소드가 계속 실행되면서 INSERT쿼리 또한 매번 발생한다.
//        이는 심각한 문제이다.
        return new RedirectView( "/member/login");
    }

    @GetMapping("login")
    public void goToLoginForm(MemberDTO memberDTO){;}

    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO){
        memberService.login(memberDTO.toVO())
                .ifPresentOrElse(
                        (member) -> {
                            log.info(member.toString());
                            log.info("로그인 성공");
                        },
                        () -> {
                            log.info("로그인 실패");
                        });

        return new RedirectView( "/post/list");
    }

    //    회원 정보 조회
//    회원 정보 수정
    @GetMapping(value = {"read", "update"})
    public void goToReadForm(Long id, Model model){
//        memberService.getMember(id).ifPresent((member) -> {
//            log.info(member.toString());
//        });
        model.addAttribute("memberDTO", memberService.getMember(id).get().toDTO());
    }

//    회원 정보 수정
//    @GetMapping("update")
//    public void goToUpdateForm(Long id){
//
//    }

    @PostMapping("update")
    public RedirectView update(MemberDTO memberDTO){
        log.info(memberDTO.toString());
        memberService.update(memberDTO.toVO());
        return new RedirectView("/member/read?id=" + memberDTO.getId());
    }

    //    회원 탈퇴(delete 진행)
    @GetMapping("delete")
    public RedirectView delete(Long id){
    //    쿼리 발생
        memberService.delete(id);
        return new RedirectView("/member/login");
    }
}















