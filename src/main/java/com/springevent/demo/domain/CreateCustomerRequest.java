package com.springevent.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {
    private String email;
    private String name;
}
