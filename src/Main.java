public class Main {
    public static void main(String[] args) throws InterruptedException {
        Esteira esteira = new Esteira();
        Produto produto = new Produto();

        ProdutorConsumidor produtorConsumidor = new ProdutorConsumidor(esteira);

        Thread produtor1 = new Thread
                (
                        new Runnable() {
                            public void run() {
                                produtorConsumidor.produzir();
                            }
                        }
                );

        Thread produtor2 = new Thread
                (
                        new Runnable() {
                            public void run() {
                                produtorConsumidor.produzir();
                            }
                        }
                );

        Thread produtor3 = new Thread
                (
                        new Runnable() {
                            public void run() {
                                produtorConsumidor.produzir();
                            }
                        }
                );

        Thread consumidor1 = new Thread
                (
                        new Runnable() {
                            public void run() {
                                produtorConsumidor.consumir();
                            }
                        }
                );

        Thread consumidor2 = new Thread
                (
                        new Runnable() {
                            public void run() {
                                produtorConsumidor.consumir();
                            }
                        }
                );

        produtor1.start();
        /*produtor2.start();
        produtor3.start();
         */
        consumidor1.start();
        //consumidor2.start();

        produtor1.join();
        /*produtor2.join();
        produtor3.join();
         */
        consumidor1.join();
        //consumidor2.join();

    }
}
