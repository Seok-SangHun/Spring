package com.app.threetier.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

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

    public MemberDTO toDTO(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(id);
        memberDTO.setMemberEmail(memberEmail);
        memberDTO.setMemberPassword(memberPassword);
        memberDTO.setMemberName(memberName);
        return memberDTO;
    }
}
