package com.example.englevelup.model.gptapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    private String role;
    private String content;
}
