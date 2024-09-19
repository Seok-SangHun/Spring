package com.app.threetier.service.post;

import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;

import java.util.List;

public interface PostService {
    // 게시물 생성
    public void create(PostVO postVO);

    // 게시물 조회
    public PostDTO findById(Long id);

    // 게시물 전체 조회
    public List<PostDTO> findAll();

    // 게시물 수정
    public void update(PostDTO postDTO);

//    조회수 증가
    public void increaseReadCount(Long id);

    // 게시물 삭제
    public void delete(Long id);
}
