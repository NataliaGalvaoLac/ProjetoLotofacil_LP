import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LotoFacilGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("LOTOFÁCIL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        JButton btnAposta0a100 = new JButton("Apostar de 0 a 100");
        btnAposta0a100.setBounds(50, 30, 200, 30);
        btnAposta0a100.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
                try {
                    int numero = Integer.parseInt(input);
                    if (numero >= 0 && numero <= 100) {
                        realizarAposta0a100(numero);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aposta inválida!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido!");
                }
            }
        });
        frame.add(btnAposta0a100);

        JButton btnApostaAZ = new JButton("Apostar de A à Z");
        btnApostaAZ.setBounds(50, 70, 200, 30);
        btnApostaAZ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite uma letra de A à Z:");
                if (input != null && input.length() == 1) {
                    char letra = input.toUpperCase().charAt(0);
                    if (letra >= 'A' && letra <= 'Z') {
                        realizarApostaAZ(letra);
                    } else {
                        JOptionPane.showMessageDialog(null, "Aposta inválida!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Valor inválido!");
                }
            }
        });
        frame.add(btnApostaAZ);

        JButton btnApostaParImpar = new JButton("Apostar em Par ou Ímpar");
        btnApostaParImpar.setBounds(50, 110, 200, 30);
        btnApostaParImpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Digite um número:");
                try {
                    int numero = Integer.parseInt(input);
                    realizarApostaParImpar(numero);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor inválido!");
                }
            }
        });
        frame.add(btnApostaParImpar);

        frame.setVisible(true);
    }

    public static void realizarAposta0a100(int aposta) {
        int numeroSorteado = (int) (Math.random() * 101);
        if (aposta == numeroSorteado) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numeroSorteado);
        }
    }

    public static void realizarApostaAZ(char letra) {
        char letraPremiada = 'J';
        if (letra == letraPremiada) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada);
        }
    }

    public static void realizarApostaParImpar(int numero) {
        if (numero % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}
