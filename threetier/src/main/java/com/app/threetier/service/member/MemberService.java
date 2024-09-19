package com.app.threetier.service.member;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.domain.member.MemberDTO;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    public void join(MemberVO memberVO);
    public Optional<MemberVO> login(MemberVO memberVO);
    public Optional<MemberVO> getMember(Long id);
    public void update(MemberVO memberVO);


    // 회원 탈퇴
    public void delete(Long id);
    // 회원 전체 조회 (DTO 사용)
    public List<MemberDTO> findAll();
}
