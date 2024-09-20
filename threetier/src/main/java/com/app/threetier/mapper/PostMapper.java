package com.app.threetier.mapper;

import com.app.threetier.domain.post.Pagination;
import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
//    게시글 작성
    public void insert(PostVO postVO);
//    게시글 전체 조회
    public List<PostDTO> selectAll(@Param("pagination") Pagination pagination, @Param("order") String order);
//    게시글 전체 개수 조회
    public int selectTotal();

}
