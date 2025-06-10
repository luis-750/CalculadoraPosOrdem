package CalculadorPosOrdem;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    private Queue<String> fila = new LinkedList<>();

    // Adiciona na fila
    public void enqueue(String token) {
        fila.offer(token);
    }

    // Remove o primeiro da fila
    public String dequeue() {
        return fila.poll();
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return fila.isEmpty();
    }
}
