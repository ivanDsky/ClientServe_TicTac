public class Worker extends Thread {

    private final int id;
    private final Data data;
    public Worker(int id, Data d) {
        this.id = id;
        data = d;
        start();
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            synchronized (data) {
                try {
                    if (id != data.getState()) {
                        data.wait();
                    }
                    if (id == 2) data.Toe();
                    else if (id == 3) data.Tic();
                    else data.Tac();

                    data.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
