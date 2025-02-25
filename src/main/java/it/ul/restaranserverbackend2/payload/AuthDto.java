package it.ul.restaranserverbackend2.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {
    private String name;
    private String surName;
    private String phoneNumber;
}
