import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

    public class LotoFacil {

        public static void main(String[] args) throws IOException {

            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int opcao;

            do {
                System.out.println("**************************");
                System.out.println("Menu LOTOFÁCIL:");
                System.out.println("1) Apostar de 0 a 100");
                System.out.println("2) Apostar de A à Z");
                System.out.println("3) Apostar em par ou ímpar");
                System.out.println("0) Sair");
                System.out.println("**************************");

                System.out.print("Digite a opção desejada: ");
                opcao = scanner.nextInt();

                switch(opcao) {
                    case 1:
                        aposta0a100(random);
                        break;
                    case 2:
                        apostaAZ(scanner);
                        break;
                    case 3:
                        apostaParOuImpar(scanner);
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            } while(opcao != 0);

            scanner.close();
        }

        public static void aposta0a100(Random random) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite um número de 0 a 100: ");
            int aposta = scanner.nextInt();

            if(aposta < 0 || aposta > 100) {
                System.out.println("Aposta inválida!");
                return;
            }

            int numeroSorteado = random.nextInt(101);

            if(aposta == numeroSorteado) {
                System.out.println("Você ganhou R$ 1.000,00 reais.");
            } else {
                System.out.println("Que pena! O número sorteado foi: " + numeroSorteado);
            }
        }

        public static void apostaAZ(Scanner scanner) throws IOException {

            System.out.print("Digite uma letra de A a Z: ");
            char letra = (char)System.in.read();

            if(!Character.isLetter(letra)) {
                System.out.println("Aposta inválida!");
                return;
            }

            letra = Character.toUpperCase(letra);

            char letraPremiada = 'J';

            if(letra == letraPremiada) {
                System.out.println("Você ganhou R$ 500,00 reais.");
            } else {
                System.out.println("Que pena! A letra sorteada foi: " + letraPremiada);
            }
        }

        public static void apostaParOuImpar(Scanner scanner) {

            System.out.print("Digite um número: ");
            int numero = scanner.nextInt();

            if(numero % 2 == 0) {
                System.out.println("Você ganhou R$ 100,00 reais.");
            } else {
                System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        }

    }
