package com.app.dependency.qualifier.task;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vips")
public class Vips implements Resturant{
    private int steak = Resturant.steak + 10000;
    @Override
    public boolean selfbar() {
        return true;
    }
}
