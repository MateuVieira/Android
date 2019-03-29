package br.com.alura.example.agenda.models;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {
    private Integer id = 0;
    private String nome;
    private String telefone;
    private String email;


    public Aluno(String nome, String telefone, String email) {

        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Aluno() {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public boolean temIdValido() {
        return this.id>0;
    }
}
