package com.paulneville.challenge2;

public record AccountRequest(
        String accountType,
        String accountNumber,
        String accountName,
        String balance,
        String date) {
}

