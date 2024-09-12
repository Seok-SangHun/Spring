package com.app.dependency.qualifier.task;

import com.app.dependency.qualifier.Computer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ResturantTests {
    @Autowired
    @Qualifier("vips")
    private Resturant resturant;

    @Test
    public void testResturant(){
        log.info("{}", resturant);
    }
}
