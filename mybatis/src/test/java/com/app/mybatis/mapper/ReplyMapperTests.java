package com.app.mybatis.mapper;

import com.app.mybatis.domain.ReplyDTO;
import com.app.mybatis.domain.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {

    @Autowired
    private ReplyMapper replyMapper;

//    댓글 작성
    @Test
    public void testInsertReply() {
        ReplyVO replyVO = new ReplyVO(
                null, "테스트 댓글4", null, 0,
                null, null, true, 29L
        );
        replyMapper.insertReply(replyVO);
    }

//    대댓글 작성
    @Test
    public void testInsertReplyToComment() {
        ReplyVO replyVO = new ReplyVO(
                null, "테스트 대댓글1", 1L, 2,
                null, null, true, 30L
        );
        replyMapper.insertReplyToComment(replyVO);
        log.info("Inserted Reply ID: {}", replyVO.getId());
    }

//    댓글 조회
    @Test
    public void testSelectById(){
        log.info("{}", replyMapper.selectById(1L).toString());
    }
//    댓글 목록
    @Test
    public void testSelectAllComments() {
        replyMapper.selectAllComments().stream().map(ReplyDTO::toString).forEach(log::info);
//        List<ReplyVO> comments = replyMapper.selectAllComments();
//        comments.forEach(comment -> log.info("Comment: {}", comment.toString()));
    }

//    대댓글 목록
    @Test
    public void testSelectRepliesByGroupId() {
        replyMapper.selectRepliesByGroupId(1L).stream().map(ReplyDTO::toString).forEach(log::info);
//        Long groupId = 1L;  // 예시로 사용한 댓글 ID
//        List<ReplyDTO> replies = replyMapper.selectRepliesByGroupId(groupId);
//        replies.forEach(reply -> log.info("Reply: {}", reply.toString()));
    }

//    댓글 수정
    @Test
    public void testUpdateReply() {
        ReplyDTO replyDTO = replyMapper.selectById(1L);  // 예시로 사용한 댓글 ID
        replyDTO.setReplyContent("이 댓글은 수정되었습니다.");
        replyMapper.updateReply(replyDTO.toVO());
        log.info("Updated Reply: {}", replyMapper.selectById(1L).toString());
    }

//    댓글 삭제
    @Test
    public void testDeleteReply() {
        replyMapper.deleteReply(1L);
    }
}
