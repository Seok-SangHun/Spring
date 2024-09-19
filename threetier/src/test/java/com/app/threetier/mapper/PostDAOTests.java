package com.app.threetier.mapper;

import com.app.threetier.domain.post.PostDTO;
import com.app.threetier.domain.post.PostVO;
import com.app.threetier.repository.post.PostDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostDAOTests {
    @Autowired
    private PostDAO postDAO;

    // 게시물 생성 테스트
    @Test
    public void testSave() {
        PostVO postVO = new PostVO(null, "게시물 제목", "게시물 내용", 0, 1, null, null, 4L);
        postDAO.save(postVO);
        log.info("게시물 생성 완료: {}", postVO);
    }

    // 게시물 조회 테스트
    @Test
    public void testFind() {
        Long id = 1L; // 테스트할 ID
        PostDTO post = postDAO.find(id);
        log.info("게시물 조회 성공: {}", post);
    }

    // 전체 게시물 조회 테스트
    @Test
    public void testFindAll() {
        List<PostDTO> posts = postDAO.findAll();
        if (!posts.isEmpty()) {
            posts.forEach(post -> log.info("게시물 정보: {}", post));
        } else {
            log.info("조회된 게시물이 없습니다.");
        }
    }

    // 게시물 수정 테스트
    @Test
    public void testUpdate() {
        Long id = 1L; // 테스트할 ID
        PostDTO postDTO = postDAO.find(id);
        if (postDTO != null) {
            postDTO.setPostTitle("수정된 제목");
            postDTO.setPostContent("수정된 내용");
            postDAO.update(postDTO);
            log.info("게시물 수정 완료: {}", postDTO);
        } else {
            log.info("해당 ID의 게시물을 찾을 수 없습니다.");
        }
    }

    // 조회수 증가 테스트
    @Test
    public void testIncreaseReadCount() {
        Long id = 1L; // 테스트할 ID
        postDAO.increaseReadCount(id);
        log.info("게시물 조회수 증가 완료: ID = {}", id);
    }

    // 게시물 삭제 테스트
    @Test
    public void testDelete() {
        Long id = 1L; // 테스트할 ID
        postDAO.delete(id);
        log.info("게시물 삭제 완료: ID = {}", id);
    }
}
