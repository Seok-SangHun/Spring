package com.app.superkey.mapper;

import com.app.superkey.domain.FileVO;
import com.app.superkey.domain.MemberFileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
//    파일 추가
    public void insert(FileVO fileVO);
}
