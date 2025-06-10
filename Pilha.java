package CalculadorPosOrdem;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {
    private Deque<Double> pilha = new ArrayDeque<>();

    //Empilha um número
    public void push(double valor) {
        pilha.push(valor);
    }

    //Desempilha e retorna o último número
    public double pop() {
        return pilha.pop();
    }

    //Quantidades de Numeros na pilha
    public int size() {
        return pilha.size();
    }

    //Verifica se a pilha esta vazia
    public boolean isEmpty() {
        return pilha.isEmpty();
    }
}
