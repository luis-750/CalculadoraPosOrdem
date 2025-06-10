package CalculadorPosOrdem;

public class Calculo {
    public double calculate(Fila fila) throws Exception {
        Pilha pilha = new Pilha();

        while (!fila.isEmpty()) {
            String token = fila.dequeue(); // Pega o próximo item

            if (isNumber(token)) {
                pilha.push(Double.parseDouble(token)); // Se é número, empilha
            } else if (isOperator(token)) {
                // Precisa de dois números para fazer a operação
                if (pilha.size() < 2) throw new Exception("Faltam operandos");

                double b = pilha.pop(); // Último número
                double a = pilha.pop(); // Penúltimo número

                double resultado;
                switch (token) {
                    case "+" -> resultado = a + b;
                    case "-" -> resultado = a - b;
                    case "*" -> resultado = a * b;
                    case "/" -> {
                        if (b == 0) throw new Exception("Divisão por zero");
                        resultado = a / b;
                    }
                    case "%" -> {
                        if (b == 0) throw new Exception("Divisão por zero");
                        resultado = a % b;
                    }
                    default -> throw new Exception("Operador inválido: " + token);
                }

                pilha.push(resultado); // Coloca o resultado na pilha
            } else {
                throw new Exception("Valor inválido: " + token);
            }
        }

        // Ao final, a pilha deve conter apenas o resultado
        if (pilha.size() != 1) {
            throw new Exception("Expressão malformada");
        }

        return pilha.pop(); // Retorna o resultado final
    }

    // Verifica se o token é um número
    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Verifica se é um dos operadores válidos
    private boolean isOperator(String s) {
        return s.matches("[+\\-*/%]");
    }
}

