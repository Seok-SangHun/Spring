package com.app.threetier.service.user;

import com.app.threetier.domain.user.UserVO;
import com.app.threetier.repository.user.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    @Override
    public void join(UserVO userVO) {
        userDAO.save(userVO);
    }

    @Override
    public Optional<UserVO> login(UserVO userVO) {

        return userDAO.findByUserEmailAndUserPassword(userVO);
    }

    @Override
    public Optional<UserVO> getUser(Long id) {

        return userDAO.findByUserId(id);
    }

    @Override
    public void update(UserVO userVO) {
        userDAO.setUser(userVO);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
