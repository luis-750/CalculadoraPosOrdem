package CalculadorPosOrdem;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Para ler do teclado

        System.out.println("Digite a expressão:");
        String input = scanner.nextLine(); // Ex: "3 4 +"

        Fila fila = new Fila(); //Criamos a fila

        //Colocamos cada item da expressão (número ou operador) na fila
        for (String token : input.trim().split("\\s+")) {
            fila.enqueue(token);
        }

        Calculo calculadora = new Calculo(); //Calculadora que vai resolver

        try {
            double resultado = calculadora.calculate(fila); //Faz o cálculo
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        scanner.close(); //Fecha a leitura do teclado
    }
}

