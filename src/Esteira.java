import java.util.LinkedList;
import java.util.Queue;

public class Esteira {

    private Queue<Produto> esteira;

    int quantidadeElementos = 0;
    private final int tamanhoEsteira = 1;

    public Esteira() {
        this.esteira = new LinkedList<>();
    }

    public void inserirProduto(Produto produto) {
        synchronized (esteira) {
            esteira.add(produto);
            this.quantidadeElementos++;
        }
    }

    public Produto removerProduto() {
        synchronized (esteira) {
            this.quantidadeElementos--;

            return esteira.poll();
        }
    }

    public boolean verificaEstaCheia() {
        if (this.quantidadeElementos == this.tamanhoEsteira) {
            return true;
        }
        return false;
    }

    public boolean verificaEstaVazia() {
        if (this.quantidadeElementos == 0) {
            return true;
        }
        return false;
    }
}