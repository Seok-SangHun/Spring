package com.app.threetier.service.post;

import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import com.app.threetier.repository.post.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public void create(PostVO postVO) {
        postDAO.save(postVO);
    }

    @Override
    public PostDTO findById(Long id) {
        return postDAO.find(id);
    }

    @Override
    public List<PostDTO> findAll() {
        return postDAO.findAll();
    }

    @Override
    public void update(PostDTO postDTO) {
        postDAO.update(postDTO);
    }

    @Override
    public void increaseReadCount(Long id) {
        postDAO.increaseReadCount(id);
    }

    @Override
    public void delete(Long id) {
        postDAO.delete(id);
    }
}