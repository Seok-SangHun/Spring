package com.app.threetier.domain.user;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;

    public UserVO toVO(){
        return new UserVO(id, userName, userPassword, userEmail);
    }
}
