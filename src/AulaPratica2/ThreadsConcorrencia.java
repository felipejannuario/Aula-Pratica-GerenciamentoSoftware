package AulaPratica2;

class Processo extends Thread {
    private String nome;
    private int delay;

    public Processo(String nome, int delay) {
        this.nome = nome;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(nome + " - Etapa " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(nome + " foi interrompido!");
            }
        }
        System.out.println(nome + " finalizado!");
    }
}

public class ThreadsConcorrencia {
    public static void main(String[] args) {
        Processo numeros = new Processo("Contador", 1000); // 1s
        Processo mensagens = new Processo("Mensagens", 2000); // 2s

        numeros.start();
        mensagens.start();
    }
}
