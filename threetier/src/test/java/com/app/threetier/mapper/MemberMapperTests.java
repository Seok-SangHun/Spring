package com.app.threetier.mapper;

import com.app.threetier.domain.member.MemberDTO;
import com.app.threetier.domain.member.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Member;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    // 회원가입 테스트
    @Test
    public void testInsert(){
        MemberVO memberVO = new MemberVO(null, "gildong11@gmail.com", "1111", "홍길동");
        memberMapper.insert(memberVO);
        log.info("회원 가입 성공: {}", memberVO);
    }

    @Test
    public void testSelectByMemberEmailAndMemberPassword(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("test@gmail.com");
        memberDTO.setMemberPassword("222");

        Optional<MemberVO> foundMember =
                memberMapper.selectByMemberEmailAndMemberPassword(memberDTO.toVO());

//        테이블에서 조회된 회원 정보가 null이 아니라면, 전체 정보 출력
        foundMember.map(MemberVO::toString).ifPresent(log::info);
    }
    // 회원 조회 테스트
//    @Test
//    public void testSelectById(){
//        Long id = 1L; // 테스트를 위한 기본 ID
//        MemberDTO foundMember = memberMapper.findById(id);
//        log.info("조회된 회원: {}", foundMember);
//    }

    // 회원 전체 조회 테스트
    @Test
    public void testSelectAll(){
        memberMapper.findAll().forEach(member -> log.info("회원 목록: {}", member));
    }

    // 회원 정보 수정 테스트
//    @Test
//    public void testUpdate(){
//        MemberDTO memberDTO = new MemberDTO();
//        memberDTO.setId(1L); // 기존 회원 ID
//        memberDTO.setMemberEmail("updated_email@gmail.com");
//        memberDTO.setMemberPassword("updated_password");
//        memberDTO.setMemberName("업데이트된 이름");
//
//        memberMapper.update(memberDTO);
//        log.info("회원 정보 수정 완료: {}", memberDTO);
//    }

    // 회원 삭제 테스트
    @Test
    public void testDelete(){
        Long id = 1L; // 테스트를 위한 기본 ID
        memberMapper.delete(id);
        log.info("회원 삭제 완료: ID = {}", id);
    }
}
//
//package com.app.threetier.mapper;
//
//import com.app.threetier.domain.member.MemberDTO;
//import com.app.threetier.domain.member.MemberVO;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//@SpringBootTest
//@Slf4j
//public class MemberMapperTests {
//    @Autowired
//    private MemberMapper memberMapper;
//
//    @Test
//    public void testInsert(){
//        MemberDTO memberDTO = new MemberDTO();
//        memberDTO.setMemberEmail("hds1234@gmail.com");
//        memberDTO.setMemberPassword("1234");
//        memberDTO.setMemberName("한동석");
//
//        memberMapper.insert(memberDTO.toVO());
//    }
//
//    @Test
//    public void testSelectByMemberEmailAndMemberPassword(){
//        MemberDTO memberDTO = new MemberDTO();
//        memberDTO.setMemberEmail("test@gmail.com");
//        memberDTO.setMemberPassword("222");
//
//        Optional<MemberVO> foundMember =
//                memberMapper.selectByMemberEmailAndMemberPassword(memberDTO.toVO());
//
////        테이블에서 조회된 회원 정보가 null이 아니라면, 전체 정보 출력
//        foundMember.map(MemberVO::toString).ifPresent(log::info);
//    }
//}















