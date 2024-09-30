package com.app.superkey.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberFileDTO {
    private Long id;
    private String fileName;
    private String filePath;
    private Long memberId;

    public FileVO toFileVO(){
        return new FileVO(id, fileName, filePath);
    }

    public MemberFileVO toVO() {
        return new MemberFileVO(id, memberId);
    }
}




















