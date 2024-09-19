package com.app.threetier.domain.post;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter @ToString
public class PostDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private int status;
    private String createdDate;
    private String updatedDate;
    private Long memberId;
    private String memberEmail;
    private String memberName;

    public PostVO toVO(){
        return new PostVO(id, postTitle, postContent, postReadCount, status, createdDate, updatedDate, memberId);
    }
}
