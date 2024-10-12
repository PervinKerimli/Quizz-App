package com.Quizz.quizz.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Data
@Builder
public class QuizRequestDTO {
private int id;
    private Map<String, String> answers;
    private String question;
    private String respons;
    private String category;
}
