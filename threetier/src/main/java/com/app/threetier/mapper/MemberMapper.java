package com.app.threetier.mapper;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.domain.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    // 회원가입 (VO 사용)
    public void insert(MemberVO memberVO);

//    로그인
//    optional -> 단일 객체를 감싸기, list는 optional로 감싸면 안됨
//    NPE(NullPointException) 방지
//    Optional<T>
//    제네릭에 전달된 타입의 객체가 null인 상황을 처리하기 위해 사용한다.
//    NPE 발생으로 인해 여러 이슈가 생긴다.
//    Optional 객체를 사용함으로써 NPE 방지를 할 수 있고 항상 단일 객체에만 사용해야 한다.
    public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO);

    //    회원 정보 조회
    public Optional<MemberVO> selectById(Long id);

    //  회원 전체 조회 (DTO 사용)
    public List<MemberDTO> findAll();

    //    회원 정보 수정
    public void update(MemberVO memberVO);

    // 회원 탈퇴
    public void delete(Long id);
}
