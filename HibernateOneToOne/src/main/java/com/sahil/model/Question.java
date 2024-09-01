package com.sahil.model;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Question {
	@Id
	private int id;
	
	private String question;
	
//	@OneToOne(cascade = CascadeType.ALL) same thing happens 
//	with the answer as well or i need to save answer object separately
	@OneToOne
	private Answer answer;
	
	public Question() {
		System.out.println("Default Constructor of Question");
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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
}
