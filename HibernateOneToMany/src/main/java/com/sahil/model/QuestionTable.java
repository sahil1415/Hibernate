package com.sahil.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class QuestionTable {

    @Id
    private int id;

    private String question;

    @OneToMany(mappedBy = "questionTable", cascade = CascadeType.ALL)
    private List<AnswerTable> answerList;

    public QuestionTable() {
        System.out.println("Default constructor of QuestionTable");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerTable> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AnswerTable> answerList) {
        this.answerList = answerList;
    }



    @Override
    public String toString() {
        return "QuestionTable [id=" + id + ", Question=" + question + "]";
    }
    
}
