package com.app.threetier.mapper;

import com.app.threetier.domain.member.MemberDTO;
import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.repository.member.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberDAOTests {
    @Autowired
    private MemberDAO memberDAO;

    // 회원 가입 테스트
    @Test
    public void testSave(){
        MemberVO memberVO = new MemberVO(null, "hds1234@gmail.com", "1234", "한동석");
        memberDAO.save(memberVO);
        log.info("회원 가입 완료: {}", memberVO);
    }

//    로그인 테스트
//    @Test
//    public void testLogin(){
//        MemberVO memberVO = new MemberVO(null, null, "1234", "한동석");
//        memberDAO.find(memberVO);
//        log.info("로그인 완료: {}", memberVO.getId());
//    }
    // 회원 조회 테스트
//    @Test
//    public void testFind(){
//        Long id = 1L; // 테스트할 ID
//        MemberDTO member = memberDAO.find(id);
//        log.info("회원 조회 성공: {}", member);
//    }

    // 전체 회원 조회 테스트
    @Test
    public void testFindAll(){
        List<MemberDTO> members = memberDAO.findAll();
        if (!members.isEmpty()) {
            members.forEach(member -> log.info("회원 정보: {}", member));
        } else {
            log.info("조회된 회원이 없습니다.");
        }
    }

    // 회원 정보 수정 테스트
//    @Test
//    public void testSetMember(){
//        Long id = 1L; // 테스트할 ID
//        MemberDTO memberDTO = memberDAO.find(id);
//        if (memberDTO != null) {
//            memberDTO.setMemberEmail("test_email@gmail.com");
//            memberDTO.setMemberPassword("test_password");
//            memberDTO.setMemberName("test 이름");
//            memberDAO.setMember(memberDTO);
//            log.info("회원 정보 수정 완료: {}", memberDTO);
//        } else {
//            log.info("해당 ID의 회원을 찾을 수 없습니다.");
//        }
//    }

    // 회원 삭제 테스트
    @Test
    public void testDelete(){
        Long id = 1L; // 테스트할 ID
        memberDAO.delete(id);
        log.info("회원 삭제 완료: ID = {}", id);
    }
}
