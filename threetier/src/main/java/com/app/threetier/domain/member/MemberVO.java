package com.app.threetier.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
