class runnableClass implements Runnable{
    String threadName;
    runnableClass(String name){
        this.threadName=name;
    }
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println(threadName + " is running " + i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println("Execution Completed");
    }
}
class MulitThreading{
    public static void main(String[] args) {
//        runnableClass t1=new runnableClass("Thread 1");
//        runnableClass t2=new runnableClass("Thread 2");
//        Thread th=new Thread(t1);
//        Thread th2=new Thread(t2);
//        th.start();
//        th2.start();
//        System.out.println(args[0]);
        String c="computer";
        System.out.println(c.indexOf('m'));

    }

}