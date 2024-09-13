package com.app.threetier.mapper;

import com.app.threetier.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
//    회원가입
    public void insert(MemberVO memberVO);
}
