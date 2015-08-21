package com.nitish.mapper;

public interface GreetingMapper<L, R> {

    public R createMorphia(L l);

    public L createGreeting(R r);
}