package com.app.threetier.repository.user;

import com.app.threetier.domain.user.UserVO;
import com.app.threetier.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    public void save(UserVO userVO) {
        userMapper.insert(userVO);
    }

    public Optional<UserVO> findByUserEmailAndUserPassword(UserVO userVO) {
       return userMapper.selectByUserEmailAndUserPassword(userVO);
    }

    public Optional<UserVO> findByUserId(Long id){
       return userMapper.selectById(id);
    }

    public void setUser(UserVO userVO) {
        userMapper.update(userVO);
    }

    public void delete(Long id){
        userMapper.delete(id);
    }
}
