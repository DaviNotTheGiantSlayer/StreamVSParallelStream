package com.mycompany.app;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Benchmark)
public class StreamBenchmarkMapping {

    private List<Pessoa> pessoas;

    @Param({"10", "100", "1000", "10000", "100000", "1000000", "10000000", "100000000"})
    private int tamanho;

    @Setup(Level.Trial)
    public void setup() {
        pessoas = IntStream.range(0, tamanho)
                .mapToObj(i ->
                        new Pessoa(
                                i,
                                i * 1.5f,
                                "Pessoa_" + i,

                                20 + (i % 50),      
                                1.60f + (i % 40) / 100f,
                                "Cidade_" + (i % 100),

                                i * 10,            
                                60f + (i % 40), 
                                "pessoa" + i + "@mail.com",
                                i % 5
                        )
                )
                .toList();
    }

    private PessoaDTO mapear(Pessoa p) {
        return new PessoaDTO(
                p.getId(),
                p.getSalario(),
                p.getNome(),

                p.getIdade(),
                p.getAltura(),
                p.getCidade(),
                p.getPontos(),
                p.getPeso(),
                p.getEmail(),
                p.getNivel()
        );
    }

    @Benchmark
    public List<PessoaDTO> mapeamentoSequencial() {
        return pessoas.stream()
                .map(this::mapear)
                .toList();
    }

    @Benchmark
    public List<PessoaDTO> mapeamentoParalelo() {
        return pessoas.parallelStream()
                .map(this::mapear)
                .toList();
    }
}