package com.example.Test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class News {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть больше",min = 3,max = 100)
    String title;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(message = "Строка не может быть больше",min = 3,max = 1000)
    String body_text;
    @NotNull(message = "Впишите, пожалуйста, автора")
    String author;
    @Min(message = "Количество не может быть отрицательным",value = 0)
    @Max(message = "Количество не должно превышать 100000",value = 100000)
    @NotNull(message = "Число не должно быть пустым")
    Integer views , likes;

    //@NotBlank
    //@DecimalMax()
    //@DecimalMin()
    //@Digits()
    //@Negative
    //@NegativeOrZero
    //@Positive
    //@PositiveOrZero

    //@Future
    //@FutureOrPresent
    //@Past
    //@PastOrPresent

    //@Email

    //@AssertFalse
    //@AssertTrue


    public News(String title, String body_text, String author, Integer views, Integer likes) {
        this.title = title;
        this.body_text = body_text;
        this.author = author;
        this.views = views;
        this.likes = likes;
    }

    public News() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody_text() {
        return body_text;
    }

    public void setBody_text(String body_text) {
        this.body_text = body_text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}


