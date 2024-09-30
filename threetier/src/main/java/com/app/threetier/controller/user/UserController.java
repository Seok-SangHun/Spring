package com.app.threetier.controller.user;


import com.app.threetier.domain.member.MemberDTO;
import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.domain.user.UserDTO;
import com.app.threetier.domain.user.UserVO;
import com.app.threetier.exception.LoginFailException;
import com.app.threetier.service.user.UserService;
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
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;
import java.util.Optional;


@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("join")
    public void goToJoinForm(UserDTO userDTO ,HttpSession session) {;}

    @PostMapping("join")
    public RedirectView join(UserDTO userDTO){
        userService.join(userDTO.toVO());
        return new RedirectView("/user/login");
    }

    @GetMapping("login")
    public void goTOLoginForm(UserDTO userDTO, HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("save")){
                    model.addAttribute("save", cookie.getValue());
                }

                if(cookie.getName().equals("userEmail")) {
                    userDTO.setUserEmail(cookie.getValue());
                }
            }
        }
    }

    @PostMapping("login")
    public RedirectView login(UserDTO userDTO, HttpServletResponse response, Model model, String save, HttpSession session){
        Optional<UserVO> foundUser = userService.login(userDTO.toVO());

        UserVO userVO = foundUser.orElseThrow(
                () -> {throw new LoginFailException("("+(LocalTime.now()+")로그인 실패"));
        });

        //        전체 정보를 담아놓기 때문에 쿼리를 따로 발생시킬 필요 없다(좋아!)
        session.setAttribute("user", userVO); // user는 session에 저장할 속성의 이름

//        화면에서 아이디 저장을 선택했다면 null이 아니다.
        if(save != null){
//            쿠키 생성, 저장
            Cookie saveCookie = new Cookie("save", save);
            Cookie userEmailCookie = new Cookie("userEmail", userDTO.getUserEmail());

//            -1: 쿠키 계속 유지
            saveCookie.setMaxAge(-1);
            userEmailCookie.setMaxAge(-1);

            response.addCookie(saveCookie);
            response.addCookie(userEmailCookie);

        }else{
//            쿠키 삭제
            Cookie saveCookie = new Cookie("save", null);
            Cookie userEmailCookie = new Cookie("userEmail", null);

            saveCookie.setMaxAge(0);
            userEmailCookie.setMaxAge(0);

            response.addCookie(saveCookie);
            response.addCookie(userEmailCookie);
        }
        return new RedirectView( "/user/read");
    }

    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/user/login");
    }

    //    회원 정보 조회
//    회원 정보 수정
    @GetMapping(value = {"read", "update"})
    public void goToReadForm(Model model, HttpSession session){
        UserVO userVO = (UserVO) session.getAttribute("user");
        model.addAttribute("user", userVO); //화면에서
//        Long id = (Long) session.getAttribute("memberId");
//        model.addAttribute("memberDTO", memberService.getMember(id).get().toDTO());
    }


    @PostMapping("update")
    public RedirectView update(UserDTO userDTO, HttpSession session){
        userService.update(userDTO.toVO());
        session.setAttribute("user", userDTO.toVO());
        return new RedirectView("/user/read?id=" + userDTO.getId());
    }

    //    회원 탈퇴(delete 진행)
    @GetMapping("delete")
    public RedirectView delete(Long id){
//        쿼리 발생
        userService.delete(id);
        return new RedirectView("/user/login");
    }


}
