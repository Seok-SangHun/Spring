package com.app.threetier.service.user;


import com.app.threetier.domain.user.UserVO;

import java.util.Optional;

public interface UserService {
    public void join(UserVO userVO);
    public Optional<UserVO> login(UserVO userVO);
    public Optional<UserVO> getUser(Long id);
    public void update(UserVO userVO);
    public void delete(Long id);
}
