package com.app.threetier.repository.post;

import com.app.threetier.domain.post.Pagination;
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

//    게시글 작성
    public void save(PostVO postVO) {
        postMapper.insert(postVO);
    }

//    게시글 전체 조회
    public List<PostDTO> findAll(Pagination pagination, String order){
        return postMapper.selectAll(pagination, order);
    }

//    게시글 전체 개수 조회
    public int getTotal(){
        return postMapper.selectTotal();
    }
}



















