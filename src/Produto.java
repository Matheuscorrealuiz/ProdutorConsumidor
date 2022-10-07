import java.util.Random;

public class Produto {
    private String tipo, qualidade;

    private int tempo;

    private String simbolo;

    public String getTipo() {
        return tipo;
    }

    public String getQualidade() {
        return qualidade;
    }

    public int getTempo() { return tempo; }

    public String getSimbolo() { return simbolo; }

    public void defineProduto(Produto produto){
        Random valorAleatorio = new Random();
        int valorTipo = valorAleatorio.nextInt(3) + 1;

        if (valorTipo == 1 ){
            produto.tipo = "Fruta";
            produto.simbolo = "*";
        } else if (valorTipo == 2) {
            produto.tipo = "Carne";
            produto.simbolo = "#";
        } else {
            produto.tipo = "Frios";
            produto.simbolo = "$";
        }

        Random outroValorAleatorio = new Random();
        int valorQualidade = outroValorAleatorio.nextInt(2) + 1;

        if (valorQualidade == 1 ){
            produto.qualidade = "Ma qualidade";
        } else {
            produto.qualidade = "Boa qualidade";
        }
    }

    public int esperaTempoAleatorioConsumidor()  {
        Random random = new Random();

        return tempo = random.nextInt(4) + 1;
    }

    public int esperaTempoAleatorioProdutor()  {
        Random random = new Random();

        return tempo = random.nextInt(10) + 5;
    }
}