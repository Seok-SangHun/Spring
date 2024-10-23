package com.app.study.controller.member;

import com.app.study.domain.member.MemberDTO;
import com.app.study.domain.member.MemberVO;
import com.app.study.exception.LoginFailException;
import com.app.study.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;
import java.util.Optional;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

//    회원가입 페이지로 이동(GET)
    @GetMapping("join")
    public void goToJoinForm(MemberDTO memberDTO, HttpSession session){;}

//    회원가입 완료(POST)
    @PostMapping("join")
//    화면에서 작성된 input태그의 name과 MemberDTO 필드명이 mapping된다.
    public RedirectView join(MemberDTO memberDTO){
        memberService.join(memberDTO.toVO());
        return new RedirectView( "/member/login");
    }

    @GetMapping("login")
    public void goToLoginForm(MemberDTO memberDTO, HttpServletRequest request, Model model){

//        쿠키 조회
        Cookie[] cookies = request.getCookies();

        for(int i = 0; i < cookies.length; i++){
            log.info(cookies[i].getName());
//            save라는 key가 있다면,
            if(cookies[i].getName().equals("save")){
//                해당 value를 화면으로 보낸다.
                model.addAttribute("save", cookies[i].getValue());

            }
            if(cookies[i].getName().equals("memberEmail")){
                memberDTO.setMemberEmail(cookies[i].getValue());
            }

        }
    }

    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO, String save, HttpSession session, HttpServletResponse response){

        Optional<MemberVO> foundMember = memberService.login(memberDTO.toVO());

//        null이 아니면 단일 객체 리턴, null이면 예외 발생
        MemberVO memberVO = foundMember.orElseThrow(() -> {throw new LoginFailException("(" + LocalTime.now() + ")로그인 실패");});

        session.setAttribute("member", memberVO);

//        화면에서 아이디 저장을 선택했다면 null이 아니다.
        if(save != null){
//            쿠키 생성, 저장
            Cookie saveCookie = new Cookie("save", save);
            Cookie memberEmailCookie = new Cookie("memberEmail", memberDTO.getMemberEmail());

//            -1: 쿠키 계속 유지
            saveCookie.setMaxAge(-1);
            memberEmailCookie.setMaxAge(-1);

            response.addCookie(saveCookie);
            response.addCookie(memberEmailCookie);

        }else{
//            쿠키 삭제
            Cookie saveCookie = new Cookie("save", null);
            Cookie memberEmailCookie = new Cookie("memberEmail", null);

            saveCookie.setMaxAge(0);
            memberEmailCookie.setMaxAge(0);

            response.addCookie(saveCookie);
            response.addCookie(memberEmailCookie);
        }


        return new RedirectView( "/post/list");
    }

//    로그 아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/member/login");
    }

//    회원 정보 조회
//    회원 정보 수정
    @GetMapping(value = {"read", "update"})
    public void goToReadForm(Model model, HttpSession session){
        MemberVO memberVO = (MemberVO) session.getAttribute("member");
        model.addAttribute("member", memberVO);
    }

    @PostMapping("update")
    public RedirectView update(MemberDTO memberDTO){
        log.info(memberDTO.toString());
        memberService.update(memberDTO.toVO());
        return new RedirectView("/member/read?id=" + memberDTO.getId());
    }

//    회원 탈퇴(delete 진행)
    @GetMapping("delete")
    public RedirectView delete(Long id){
//        쿼리 발생
        memberService.delete(id);
        return new RedirectView("/member/login");
    }
}















