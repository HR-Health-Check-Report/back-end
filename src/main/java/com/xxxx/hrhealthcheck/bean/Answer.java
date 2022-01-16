package com.xxxx.hrhealthcheck.bean;
public class Answer{
    private int id;
    private int choose;

    public Answer() {
    }

    public Answer(int id, int choose) {
        this.id = id;
        this.choose = choose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", choose=" + choose +
                '}';
    }
}