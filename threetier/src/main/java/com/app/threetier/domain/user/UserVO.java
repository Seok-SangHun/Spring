package com.app.threetier.domain.user;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
}
