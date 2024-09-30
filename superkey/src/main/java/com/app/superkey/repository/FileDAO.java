package com.app.superkey.repository;

import com.app.superkey.domain.FileVO;
import com.app.superkey.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    public void save(FileVO fileVO) {
        fileMapper.insert(fileVO);
    }
}
