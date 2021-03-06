package com.bulbul.examportal.service.impl.exam;

import com.bulbul.examportal.entity.exam.Quiz;
import com.bulbul.examportal.entity.exam.SubCategory;
import com.bulbul.examportal.entity.exam.Subject;
import com.bulbul.examportal.repository.exam.QuizRepository;
import com.bulbul.examportal.service.exam.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>( this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getQuizzesOfSubCategory(SubCategory subCategory) {
        return this.quizRepository.findBySubCategory(subCategory);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfSubCategory(SubCategory subCategory) {
        return this.quizRepository.findBySubCategoryAndActive(subCategory,true);
    }

    @Override
    public List<Quiz> getQuizBySubjectIdAndSubCategoryId(Subject subject, SubCategory subCategory) {
        return this.quizRepository.findBySubjectAndSubCategory(subject,subCategory);
    }

}
