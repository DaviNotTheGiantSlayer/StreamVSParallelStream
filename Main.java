
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static Integer[] gerarNumerosAleatoriosInt(Integer quantidade) {
        Integer[] array = new Integer[quantidade];
        Random random = new Random();
        for (int i = 0; i < quantidade; i++) {
            array[i] = random.nextInt(100); 
        }
        return array;
    }

    // private static BigDecimal[] gerarNumerosAleatoriosBigDecimal(Integer quantidade) {
    //     BigDecimal[] array = new BigDecimal[quantidade];
    //     Random random = new Random();
    //     for (int i = 0; i < quantidade; i++) {
    //         array[i] = BigDecimal.valueOf(random.nextInt(100)); 
    //     }
    //     return array;
    // }

    public static void main(String[] args) {
        List<Integer> inteiros = Arrays.asList(gerarNumerosAleatoriosInt(5));
        // inteiros.forEach(inteiro -> System.out.println(inteiro));
        

        long inicioTempoParalello = System.nanoTime();
        int somaParalela = inteiros.parallelStream().mapToInt(Integer::intValue).sum();
        long fimTempoParalello = System.nanoTime();

        long inicioTempoSequencial = System.nanoTime();
        int soma = inteiros.stream().mapToInt(Integer::intValue).sum();
        long fimTempoSequencial = System.nanoTime();

        long tempoSequencial = (fimTempoSequencial - inicioTempoSequencial) / 1_000_000;
        long tempoParalelo = (fimTempoParalello - inicioTempoParalello) / 1_000_000;

        System.out.println("Tempo sequencial: " + tempoSequencial);
        System.out.println("Tempo paralelo: " + tempoParalelo);
    }
}