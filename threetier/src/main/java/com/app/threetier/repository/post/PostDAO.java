package com.app.threetier.repository.post;

import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import com.app.threetier.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }

    public PostDTO find(Long id) {
        return postMapper.findById(id);
    }

    public List<PostDTO> findAll() {
        return postMapper.findAll();
    }

    public void update(PostDTO postDTO) {
        postMapper.update(postDTO);
    }

    public void increaseReadCount(Long id) {
        postMapper.increaseReadCount(id);
    }

    public void delete(Long id) {
        postMapper.delete(id);
    }
}
