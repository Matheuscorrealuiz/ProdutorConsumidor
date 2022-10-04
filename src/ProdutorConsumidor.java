public class ProdutorConsumidor {
    Esteira esteira;

    public ProdutorConsumidor(Esteira esteira)
    {
        this.esteira = esteira;
    }

    public void produzir() {
        Produto produto = new Produto();

        while(true){
            synchronized(this)
            {
                produto.defineProduto(produto);

                while(esteira.verificaEstaCheia())
                {
                    System.out.println("Produtores aguardando mais espaco na esteira...");
                    try
                    {
                        wait();
                        Thread.sleep(3000);
                    }

                    catch (InterruptedException e){}
                }
                esteira.inserirProduto(produto);

                System.out.println("Produto produzido: "+produto.getTipo());

                notify();
            }
        }
    }

    public void consumir()
    {
        while(true)
        {
            synchronized (this)
            {
                while(esteira.verificaEstaVazia())
                {
                    System.out.println("Consumidores esperando por mais produtos...");

                    try{
                        wait();
                    }
                    catch (InterruptedException e){}
                }
                Produto produto = esteira.removerProduto();
                System.out.println(produto.getTipo()+" consumido(a)");

                notify();
            }
        }
    }
}
