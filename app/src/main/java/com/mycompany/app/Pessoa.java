package com.mycompany.app;

public class Pessoa {

    private int id;
    private float salario;
    private String nome;
    private int idade;
    private float altura;
    private String cidade;
    private int pontos;
    private float peso;
    private String email;
    private int nivel;

     public Pessoa(int id, float salario, String nome,
                   int idade, float altura, String cidade,
                   int pontos, float peso, String email, int nivel) {

        this.id = id;
        this.salario = salario;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.cidade = cidade;
        this.pontos = pontos;
        this.peso = peso;
        this.email = email;
        this.nivel = nivel;
    }

    public int getId() { return id; }
    public float getSalario() { return salario; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public float getAltura() { return altura; }
    public String getCidade() { return cidade; }
    public int getPontos() { return pontos; }
    public float getPeso() { return peso; }
    public String getEmail() { return email; }
    public int getNivel() { return nivel; }


}