package com.example.englevelup.model.gptapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Choice {
    private int index;
    private Message message;
}
