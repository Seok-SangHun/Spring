package com.app.mybatis.mapper;

import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.ReplyDTO;
import com.app.mybatis.domain.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReplyMapper {
    // 댓글 작성
    void insertReply(ReplyVO reply);

    // 대댓글 작성
    void insertReplyToComment(ReplyVO reply);

    // 댓글 조회
    public ReplyDTO selectById(Long id);

    // 댓글 목록 (최상위 댓글만 조회)
    List<ReplyDTO> selectAllComments();

    // 대댓글 목록 (특정 댓글에 대한 대댓글 조회)
    List<ReplyDTO> selectRepliesByGroupId(Long groupId);

    // 댓글 삭제 (STATUS 값을 0으로 변경)
    void deleteReply(Long id);

    // 댓글 수정
    void updateReply(ReplyVO reply);
}
