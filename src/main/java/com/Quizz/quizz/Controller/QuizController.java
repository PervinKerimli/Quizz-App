package com.Quizz.quizz.Controller;

import com.Quizz.quizz.DTO.QuizRequestDTO;
import com.Quizz.quizz.DTO.QuizResponsDto;
import com.Quizz.quizz.DTO.StudentsAsnwers;
import com.Quizz.quizz.QuizServise.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/create")
    public QuizResponsDto createQuiz(@RequestBody QuizRequestDTO quizRequestDTO){
        return quizService.createQuiz(quizRequestDTO);
    }
    @GetMapping("/all/{category}")
    public List<QuizResponsDto> allQuiz(@PathVariable String category){
        return quizService.allQuiz(category);
    }
    @PostMapping("/studentsAnswer")
    public int studentsAnswer(@RequestBody StudentsAsnwers studentsAsnwers){
        return quizService.studentsAnswer(studentsAsnwers);
    }

}
