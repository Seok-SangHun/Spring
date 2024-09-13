package com.app.threetier.service.member;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }
}
