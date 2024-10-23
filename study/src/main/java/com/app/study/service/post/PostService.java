package com.app.study.service.post;

import com.app.study.domain.post.Pagination;
import com.app.study.domain.post.PostDTO;
import com.app.study.domain.post.PostVO;
import com.app.study.domain.post.Search;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public void write(PostVO postVO);
    public List<PostDTO> getList(Pagination pagination, Search search);
    public int getTotal();
    public int getTotalWithSearch(Search search);
    public Optional<PostDTO> getPost(Long id);
}
