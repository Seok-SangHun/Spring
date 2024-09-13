package com.app.threetier.domain.member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public MemberVO toVO(){
        return new MemberVO(id, memberEmail, memberPassword, memberName);
    }
}
