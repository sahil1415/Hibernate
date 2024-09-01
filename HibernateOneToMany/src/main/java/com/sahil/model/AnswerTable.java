package com.sahil.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AnswerTable {
    @Id
    private int id;

    private String answer;

    @ManyToOne(cascade = CascadeType.ALL)
    private QuestionTable questionTable;

    public AnswerTable() {
        System.out.println("Default Constructor of AnswerTable");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionTable getQuestionTable() {
        return questionTable;
    }

    public void setQuestionTable(QuestionTable questionTable) {
        this.questionTable = questionTable;
    }


    @Override
    public String toString() {
        return "AnswerTable [id=" + id + ", answer=" + answer + "]";
    }
}
