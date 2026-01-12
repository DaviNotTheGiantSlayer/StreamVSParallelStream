package com.mycompany.app;

public class PessoaDTO {

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

    public PessoaDTO(int id, float salario, String nome,
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
}