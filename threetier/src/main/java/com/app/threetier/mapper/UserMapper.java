package com.app.threetier.mapper;

import com.app.threetier.domain.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
//    회원가입
    public void insert(UserVO userVO);
//    로그인
    public Optional<UserVO> selectByUserEmailAndUserPassword(UserVO userVO);
//    조회
    public Optional<UserVO> selectById(Long id);
//    수정
    public void update(UserVO userVO);
//    삭제
    public void delete(Long id);
}
