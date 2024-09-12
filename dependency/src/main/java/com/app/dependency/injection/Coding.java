package com.app.dependency.injection;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.zip.CheckedOutputStream;
// @Data
// lombok 라이브러리에서 getter, setter, constructor, toString, equals, hashCode를 자동으로 생성해준다.

// @NoArgsConstructor
// 기본 생성자를 만들어준다.

// @RequiredArgsConstructor
// final 키워드가 붙어있거나 @NonNull 키워드가 붙어있는 필드를 대상으로
// 초기화 생성자를 만들어준다.
@Component
@Data
@RequiredArgsConstructor
public class Coding {
//    필드주입 (생성 후 주입)
//    사용 방법이 매우 편하다.
//    주입된 객체를 불변(immutable) 상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있다.
//    생성 시점에서는 순환 참조 발생 여부를 알 수 없다.
//    @Autowired
//    private Computer computer;

//    Setter 주입 (생성 후 주입), (alt + insert)누르면 setter 만들 수 있음
//    주입된 객체를 불변(immutable) 상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있다.
//    OCP(Open-Closed Principle, 개방-폐쇄 원칙)를 위반하기 때문에 변경 가능성을 배제하고 불변성을 보장하는 것이 좋다.
//    매개변수에 주입할 경우 setter 주입은 필수이다.
//    private Computer computer;
//
//    @Autowired
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

//    생성자 주입
    private final Computer computer;

//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}
