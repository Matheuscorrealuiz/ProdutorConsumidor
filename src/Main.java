public class Main {
    public static void main(String[] args) {
        Esteira esteira = new Esteira();

        ProdutorConsumidor produtorConsumidor = new ProdutorConsumidor(esteira);

        Thread produtor1 = new Thread
                (
                        () -> produtorConsumidor.produzir()
                );
        produtor1.setName("Produtor 1");

        Thread produtor2 = new Thread
                (
                        () -> produtorConsumidor.produzir()
                );

        produtor2.setName("Produtor 2");

        Thread produtor3 = new Thread
                (
                        () -> produtorConsumidor.produzir()
                );

        produtor3.setName("Produtor 3");

        Thread consumidor1 = new Thread
                (
                        () -> produtorConsumidor.consumir()
                );
        consumidor1.setName("Consumidor 1");

        Thread consumidor2 = new Thread
                (
                        () -> produtorConsumidor.consumir()
                );

        consumidor2.setName("Consumidor 2");

        produtor1.start();
        produtor2.start();
        produtor3.start();

        consumidor1.start();
        consumidor2.start();
    }
}
