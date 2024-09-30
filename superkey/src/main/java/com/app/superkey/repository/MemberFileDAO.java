package com.app.superkey.repository;

import com.app.superkey.domain.MemberFileVO;
import com.app.superkey.mapper.MemberFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberFileDAO {
    private final MemberFileMapper memberFileMapper;

    public void save(MemberFileVO memberFileVO){
        memberFileMapper.insert(memberFileVO);
    }
}
