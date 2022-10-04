import java.util.Random;

public class Produto {
    private String tipo, qualidade;

    public String getTipo() {
        return tipo;
    }

    public String getQualidade() {
        return qualidade;
    }

    public void defineProduto(Produto produto){
        Random valorAleatorio = new Random();
        int valorTipo = valorAleatorio.nextInt(3) + 1;

        if (valorTipo == 1 ){
            produto.tipo = "Fruta";
        } else if (valorTipo == 2) {
            produto.tipo = "Carne";
        } else {
            produto.tipo = "Frios";
        }

        Random outroValorAleatorio = new Random();
        int valorQualidade = outroValorAleatorio.nextInt(2) + 1;

        if (valorQualidade == 1 ){
            produto.qualidade = "Ma qualidade";
        } else {
            produto.qualidade = "Boa qualidade";
        }
    }
}
