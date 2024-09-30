package com.app.superkey.mapper;

import com.app.superkey.domain.MemberFileDTO;
import com.app.superkey.domain.MemberFileVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberFileMapper {
//    회원 파일 추가
    public void insert(MemberFileVO memberFileVO);
}
