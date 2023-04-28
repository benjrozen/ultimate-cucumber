package com.benjrozen.bookcartDemo.restAssured;


import lombok.Value;


public class Payload<T> {
    T body;

    public Payload(T body) {
        this.body = body;
    }
}
