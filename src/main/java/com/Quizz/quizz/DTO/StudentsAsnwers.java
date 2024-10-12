package com.Quizz.quizz.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Data
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentsAsnwers {
   private Map<Integer,String> answer;
}
