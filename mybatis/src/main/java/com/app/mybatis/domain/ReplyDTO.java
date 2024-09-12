package com.app.mybatis.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long id;  // 댓글/대댓글 ID
    private String replyContent;  // 댓글/대댓글 내용
    private Long groupId;  // 최상위 댓글은 NULL, 대댓글은 상위 댓글의 ID
    private int replyDepth;  // 깊이 수준 (0: 댓글, 1 이상: 대댓글)
    private String createdDate;  // 작성일자
    private String updatedDate;  // 수정일자
    private boolean status;  // 댓글 상태 (1: 활성, 0: 삭제)
    private Long memberId;  // 작성자 ID (TBL_MEMBER의 FK)
    private String memberName;
    private int memberAge;
    private String memberEmail;

    public ReplyVO toVO(){
        return new ReplyVO(id, replyContent, groupId, replyDepth, createdDate, updatedDate, status, memberId);
    }
}
