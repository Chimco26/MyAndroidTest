package com.example.myandroidtest.models;

public class LessonModel {
    private String title;
    private String subTitle;
    private int imageRessource;
    private String descriptionLesson;
    private int score;



    public LessonModel(String title, String subTitle, String descriptionLesson, int imageRessource) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageRessource = imageRessource;
        this.descriptionLesson = descriptionLesson;
        this.score = 1;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getTitle() {
        return title;
    }

    public int getImageRessource() {
        return imageRessource;
    }

    public String getDescriptionLesson() {
        return descriptionLesson;
    }
    public int getScore() {
        return score;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageRessource(int imageRessource) {
        this.imageRessource = imageRessource;
    }

    public void setDescriptionLesson(String descriptionLesson) {
        this.descriptionLesson = descriptionLesson;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
