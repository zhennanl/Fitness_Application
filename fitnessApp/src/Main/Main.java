package Main;

import jframe.Mainjframe;
import jframe.Welcome;

public class Main {
	
	public static void main(String[] args) {
		
		Welcome welcome= new Welcome();
		
		new Thread(){
            public void run(){
               try {
                  Thread.sleep(3000);
                  welcome.setVisible(false);
                  Mainjframe mainjframe = new Mainjframe();
               } catch (InterruptedException e) { }
            }
         }.start();
	}

}
