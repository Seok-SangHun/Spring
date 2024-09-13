package com.app.threetier.mapper;

import com.app.threetier.domain.member.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("hds1234@gmail.com");
        memberDTO.setMemberPassword("1234");
        memberDTO.setMemberName("한동석");

        memberMapper.insert(memberDTO.toVO());
    }
}
