package com.app.threetier.mapper;

import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostMapperTests {

    @Autowired
    private PostMapper postMapper;

    // 게시물 생성 테스트
    @Test
    public void testInsert() {
        PostVO postVO = new PostVO(null, "Test Title3", "Test Content3", 0, 1, null, null, 3L);
        postMapper.insert(postVO);
        log.info("게시물 생성 완료: {}", postVO);
    }

    // 게시물 조회 테스트
    @Test
    public void testSelectById() {
        Long id = 2L; // 테스트를 위한 기본 ID
        PostDTO postDTO = postMapper.findById(id);
        log.info("조회된 게시물: {}", postDTO);
    }

    // 게시물 전체 조회 테스트
    @Test
    public void testSelectAll() {
        List<PostDTO> posts = postMapper.findAll();
        posts.forEach(post -> log.info("게시물 목록: {}", post));
    }

    // 게시물 수정 테스트
    @Test
    public void testUpdate() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(2L); // 기존 게시물 ID
        postDTO.setPostTitle("Updated Title");
        postDTO.setPostContent("Updated Content");

        postMapper.update(postDTO);
        log.info("게시물 수정 완료: {}", postDTO);
    }

    // 조회수 증가 테스트
    @Test
    public void testIncreaseReadCount() {
        Long id = 2L; // 테스트를 위한 기본 ID
        postMapper.increaseReadCount(id);
        PostDTO postDTO = postMapper.findById(id);
        log.info("조회수 증가 완료: ID = {}, 조회수 = {}", id, postDTO.getPostReadCount());
    }

    // 게시물 삭제 테스트
    @Test
    public void testDelete() {
        Long id = 2L; // 테스트를 위한 기본 ID
        postMapper.delete(id);
        log.info("게시물 삭제 완료: ID = {}", id);
    }
}
