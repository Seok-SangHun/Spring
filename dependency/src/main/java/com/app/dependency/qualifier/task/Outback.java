package com.app.dependency.qualifier.task;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Outback implements Resturant{
    private int steak = Resturant.steak - 10000;

    @Override
    public boolean selfbar() {
        return false;
    }
}
