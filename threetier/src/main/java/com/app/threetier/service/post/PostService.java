package com.app.threetier.service.post;

import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;

import java.util.List;

public interface PostService {
    public void write(PostVO postVO);
    public List<PostDTO> getList(Pagination pagination, String order);
    public int getTotal();
}
