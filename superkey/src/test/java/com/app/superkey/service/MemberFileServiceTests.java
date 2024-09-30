package com.app.superkey.service;

import com.app.superkey.domain.MemberFileDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberFileServiceTests {
    @Autowired
    private MemberFileService memberFileService;

    @Test
    public void testAttach() {
        MemberFileDTO memberFileDTO = new MemberFileDTO();
        memberFileDTO.setFileName("셀카.png");
        memberFileDTO.setFilePath("myprofile/picture");
        memberFileDTO.setMemberId(43L);

        memberFileService.attach(memberFileDTO);
    }
}
