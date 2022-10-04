import java.util.LinkedList;

public class Esteira {

    private LinkedList<Produto> esteira;
    int quantidadeElementos = 0;
    int tamanhoFila = 3;

    public Esteira(){
        this.esteira = new LinkedList<>();
    }

    public void inserirProduto(Produto produto) {
        this.esteira.add(produto);

        this.quantidadeElementos++;
    }

    public Produto removerProduto() {
        this.quantidadeElementos--;

        return this.esteira.removeFirst();
    }

    public boolean verificaEstaCheia(){
        if (this.quantidadeElementos == this.tamanhoFila) {
            return true;
        }
        return false;
    }

    public boolean verificaEstaVazia(){
        if (this.quantidadeElementos == 0) {
            return true;
        }
        return false;
    }
}