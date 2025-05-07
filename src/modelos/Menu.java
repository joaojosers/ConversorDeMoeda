package modelos;

import java.util.Scanner;

public class Menu {

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Conversor de Moedas =====");
        System.out.println("1. Dólar (USD) → Peso Argentino (ARS)");
        System.out.println("2. Peso Argentino (ARS) → Dólar (USD)");
        System.out.println("3. Dólar (USD) → Real Brasileiro (BRL)");
        System.out.println("4. Real Brasileiro (BRL) → Dólar (USD)");
        System.out.println("5. Dólar (USD) → Peso Colombiano (COP)");
        System.out.println("6. Peso Colombiano (COP) → Dólar (USD)");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        if (opcao >= 1 && opcao <= 6) {
            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            switch (opcao) {
                case 1 -> ConsultaMoeda.executaConsulta("USD", "ARS", valor);
                case 2 -> ConsultaMoeda.executaConsulta("ARS", "USD", valor);
                case 3 -> ConsultaMoeda.executaConsulta("USD", "BRL", valor);
                case 4 -> ConsultaMoeda.executaConsulta("BRL", "USD", valor);
                case 5 -> ConsultaMoeda.executaConsulta("USD", "COP", valor);
                case 6 -> ConsultaMoeda.executaConsulta("COP", "USD", valor);
            }
        } else if (opcao == 7) {
            System.out.println("Encerrando o programa.");
        } else {
            System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}


