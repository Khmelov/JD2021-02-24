package by.it.kishkar.jd02_06;


public class Runner {

    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Runner.OneThread("th" + i).start();
        }
    }
}
