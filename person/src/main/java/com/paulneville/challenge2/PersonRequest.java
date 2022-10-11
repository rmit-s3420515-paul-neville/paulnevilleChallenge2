package com.paulneville.challenge2;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public record PersonRequest(
        String name,
        String address,
        String postcode,
        String age,
        String job,
        String email,
        String phoneNumber) {
}

