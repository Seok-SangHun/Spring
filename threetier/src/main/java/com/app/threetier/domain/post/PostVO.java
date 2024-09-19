package com.app.threetier.domain.post;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PostVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String postTitle;
    private String postContent;
    private int postReadCount;
    private int status;
    private String createdDate;
    private String updatedDate;
    private Long memberId;
}
