package com.app.threetier.mapper;

import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    //    게시물 생성
    public void insert(PostVO postVO);

    // 게시물 조회 (DTO 사용)
    public PostDTO findById(Long id);

    // 게시물 전체 조회 (DTO 사용)
    public List<PostDTO> findAll();

    // 게시물 수정
    public void update(PostDTO postDTO);

    // 조회수 증가
    public void increaseReadCount(Long id);

    // 게시물 삭제
    public void delete(Long id);
}
