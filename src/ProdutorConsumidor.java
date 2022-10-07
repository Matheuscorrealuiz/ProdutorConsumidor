import java.util.Random;

public class ProdutorConsumidor {
    Esteira esteira;

    public ProdutorConsumidor(Esteira esteira) {
        this.esteira = esteira;
    }

    public void produzir() {
        while (true) {
            synchronized (this) {
                Produto produto = new Produto();
                produto.defineProduto(produto);

                while (esteira.verificaEstaCheia()) {
                    try {
                        wait();
                        Random random = new Random();
                        Thread.sleep(random.nextInt(2000));
                    } catch (InterruptedException e) {}
                }

                esteira.inserirProduto(produto);

                produto.esperaTempoAleatorioProdutor();

                System.out.println("------------");
                System.out.println(Thread.currentThread().getName() + " produziu: "
                        + produto.getTipo() + " " + "(" + produto.getSimbolo() + ")" + " Qualidade: " + produto.getQualidade() + " Tempo: " + produto.getTempo());

                notifyAll();
            }
        }
    }

    public void consumir() {
        while (true) {
            synchronized (this) {
                Produto produto;

                while (esteira.verificaEstaVazia()) {
                    try {
                        wait();
                        Random random = new Random();
                        Thread.sleep(random.nextInt(2000));
                    } catch (InterruptedException e) {}
                }

                produto = esteira.removerProduto();

                produto.esperaTempoAleatorioConsumidor();

                System.out.println("------------");
                System.out.println(Thread.currentThread().getName() + " consumiu: "
                        + produto.getTipo() + " " + "(" + produto.getSimbolo() + ")" + " Qualidade: " + produto.getQualidade() + " Tempo: " + produto.getTempo());

                notifyAll();
            }
        }
    }
}


