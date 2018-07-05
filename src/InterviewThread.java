/**
 * 测试此程序，在m1()中锁定时，
 * 1000
 * b = 1000
 */
public class InterviewThread implements Runnable{
     int b = 100;

     public synchronized void m1() throws Exception{
         b = 1000;
         Thread.sleep(5000);
         System.out.println("b = " + b);
     }
     public void m2(){
         System.out.println(b);
     }
     public void run(){
         try{
             m1();
         } catch ( Exception e){
             e.printStackTrace();
         }
     }

     public static void main(String[] args) throws Exception{
         InterviewThread  it = new InterviewThread();
         Thread t = new Thread(it);
         t.start(); // Output: b = 1000
     //    Thread.sleep(1000); //主线程休眠一秒，确保t.start()执行后（五秒），再执行it.m2()；
         //测试目的
         it.m2();// 先Output:1000
     }
}

