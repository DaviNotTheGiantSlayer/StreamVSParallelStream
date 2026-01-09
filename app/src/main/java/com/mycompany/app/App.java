package com.mycompany.app;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class App 
{

    public static void main( String[] args )
    {
        Options opt = new OptionsBuilder()
                .include(StreamBenchmark.class.getSimpleName())
                .build();

        try {
            new Runner(opt).run();
        } catch (Exception excecao) {

        }
    }
}
