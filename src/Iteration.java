public class Iteration {
    static int currentNumber = 0;
    static int size = 3;
    public static int i;

    public static void main(String[] args) throws InterruptedException {

        for(int j=1;j<=size;j++){
            new ThreadF(j).start();
        }
    }
    public static class ThreadF extends Thread{
        private final int number;

        public ThreadF(int number) {
            this.number = number;
        }
        public  void run(){
            while(i!=100) {

                if (number - currentNumber == 1) {
                    if (i != 100) {
                        Resourse.iterI();
                        System.out.println(getName() + " " + i);
                        currentNumber++;
                    } else {
                        return;
                    }
                    if (currentNumber == size) {
                        currentNumber = 0;
                    }
                }
            }


        }
    }
    public static class Resourse{
        public static synchronized void iterI(){
            i++;
            return;
        }
    }
}
