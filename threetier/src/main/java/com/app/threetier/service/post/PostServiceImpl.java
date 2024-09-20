package com.app.threetier.service.post;

import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import com.app.threetier.repository.post.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
    }

    @Override
    public List<PostDTO> getList(Pagination pagination, String order) {
        return postDAO.findAll(pagination, order);
    }

    @Override
    public int getTotal() {
        return postDAO.getTotal();
    }
}















