package com.company.Summative.Assessment.model;

import java.util.Objects;

public class Magic_8_Ball {
    private String question;
    private String answer;
    private int id;

    public Magic_8_Ball() {

    }

    public Magic_8_Ball(String question, String answer, int id) {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }
//
//    public Magic_8_Ball(String question){
//        this.question = question;
//    }
//    public Magic_8_Ball(String answer, int id) {
//        this.answer = answer;
//        this.id = id;
//    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer ;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magic_8_Ball that = (Magic_8_Ball) o;
        return id == that.id && Objects.equals(question, that.question) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer, id);
    }

    @Override
    public String toString() {
        return "Magic_8_Ball{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", id=" + id +
                '}';
    }
}
