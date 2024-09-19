package com.app.threetier.mapper;

import com.app.threetier.domain.member.MemberDTO;
import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.repository.member.MemberDAO;
import com.app.threetier.service.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MemberServiceTests {
    @Autowired
    private MemberServiceImpl memberService;

    // 회원가입 테스트
    @Test
    public void testJoin(){
        MemberVO memberVO = new MemberVO(null, "hds1234@gmail.com", "1234", "한동석");
        memberService.join(memberVO);
        log.info("회원 가입 완료: {}", memberVO);
    }

    // 회원 조회 테스트
//    @Test
//    public void testFindById(){
//        Long id = 1L; // 테스트할 ID
//        MemberDTO memberDTO = memberService.findById(id);
//        log.info("회원 조회 성공: {}", memberDTO);
//    }

    // 전체 회원 조회 테스트
    @Test
    public void testFindAll(){
        List<MemberDTO> members = memberService.findAll();
        if (!members.isEmpty()) {
            members.forEach(member -> log.info("회원 정보: {}", member));
        } else {
            log.info("조회된 회원이 없습니다.");
        }
    }

    // 회원 정보 수정 테스트
//    @Test
//    public void testUpdate(){
//        Long id = 1L; // 테스트할 ID
//        MemberDTO memberDTO = memberService.findById(id);
//        if (memberDTO != null) {
//            memberDTO.setMemberEmail("updated_email@gmail.com");
//            memberDTO.setMemberPassword("updated_password");
//            memberDTO.setMemberName("업데이트된 이름");
//            memberService.update(memberDTO);
//            log.info("회원 정보 수정 완료: {}", memberDTO);
//        } else {
//            log.info("해당 ID의 회원을 찾을 수 없습니다.");
//        }
//    }

    // 회원 삭제 테스트
    @Test
    public void testDelete(){
        Long id = 1L; // 테스트할 ID
        memberService.delete(id);
        log.info("회원 삭제 완료: ID = {}", id);
    }
}
