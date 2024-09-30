package com.app.superkey.service;

import com.app.superkey.domain.FileVO;
import com.app.superkey.domain.MemberFileDTO;
import com.app.superkey.domain.MemberFileVO;
import com.app.superkey.repository.FileDAO;
import com.app.superkey.repository.MemberFileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberFileServiceImpl implements MemberFileService {
    private final FileDAO fileDAO;
    private final MemberFileDAO memberFileDAO;

    @Override
    public void attach(MemberFileDTO memberFileDTO) {
        FileVO fileVO = memberFileDTO.toFileVO();

        fileDAO.save(fileVO);
        memberFileDTO.setId(fileVO.getId());
        memberFileDAO.save(memberFileDTO.toVO());
    }
}













