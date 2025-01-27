package com.example.englevelup.dto.external;

import com.example.englevelup.model.gptapi.Choice;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatResponse {
    private List<Choice> choices;
}
