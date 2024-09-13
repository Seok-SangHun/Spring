package com.app.threetier.repository.member;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//    회원가입
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }
}
