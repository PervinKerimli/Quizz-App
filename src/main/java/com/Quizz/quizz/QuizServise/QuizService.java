package com.Quizz.quizz.QuizServise;

import com.Quizz.quizz.DTO.QuizRequestDTO;
import com.Quizz.quizz.DTO.QuizResponsDto;
import com.Quizz.quizz.DTO.StudentsAsnwers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class QuizService {
    List<QuizRequestDTO> quizRequestDTOS = new ArrayList<>();
    public QuizResponsDto createQuiz(QuizRequestDTO quizRequestDTO){
        QuizRequestDTO requestDTO = QuizRequestDTO.builder()
                .id(quizRequestDTO.getId())
                .question(quizRequestDTO.getQuestion())
                .answers(quizRequestDTO.getAnswers())
                .category(quizRequestDTO.getCategory())
                .respons(quizRequestDTO.getRespons())
                .build();
        QuizResponsDto responsDto = QuizResponsDto.builder()
                .id(requestDTO.getId())
                .question(requestDTO.getQuestion())
                .answers(requestDTO.getAnswers())
                .category(requestDTO.getCategory())
                .build();
        quizRequestDTOS.add(requestDTO);
        return responsDto;
    }
    public List<QuizResponsDto> allQuiz(String category){
        List<QuizResponsDto> responsDtos = new ArrayList<>();
        for(QuizRequestDTO requestDTO : quizRequestDTOS){
            if (requestDTO.getCategory().equals(category)){
                QuizResponsDto responsDto = QuizResponsDto.builder()
                        .id(requestDTO.getId())
                        .answers(requestDTO.getAnswers())
                        .category(requestDTO.getCategory())
                        .question(requestDTO.getQuestion())
                        .build();
                responsDtos.add(responsDto);
            }
        }
        return responsDtos;
    }

    public int studentsAnswer(StudentsAsnwers studentsAsnwers) {
        int count =0;
        StudentsAsnwers studentsAsnwers1 = StudentsAsnwers.builder()
                .answer(studentsAsnwers.getAnswer())
                .build();
        Map<Integer, String> studentAnswerMap = studentsAsnwers1.getAnswer();
        for (QuizRequestDTO quizRequestDTO : quizRequestDTOS) {
            if (studentsAsnwers.getAnswer().containsKey(quizRequestDTO.getId())) {
                String studentAnswer = studentsAsnwers.getAnswer().get(quizRequestDTO.getId());

                String correctAnswer = quizRequestDTO.getRespons();
                if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                    count++;
                }
            }
        }
        return count;  // Returns the number of correct answers
    }
}
