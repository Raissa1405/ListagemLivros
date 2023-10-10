package com.example.listagemlivros.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class Livro {
    private String title;
    private String author;
    private String category;

    public Livro(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
}
