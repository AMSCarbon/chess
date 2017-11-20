



public class Controls implements Runnable {
	
	private Thread ControlThread;
	private Scene scene;
	private Keyboard keyboard;
	private double timer = 0 ;
	
	Controls(){
		this.keyboard = new Keyboard();
	}
	
	public Keyboard getKeyboard(){
		return this.keyboard;
	}
	public void setScene(Scene s) {
		this.scene = s;
	}

	@Override
	public void run() {
		//run continuously and check the user input ever 60th of a sescond.
		System.out.printf("Control Thread\n");
		timer++;
		
		//if timer = 1000/60; 
		
			
	}
	
	public void start() {

	  ControlThread = new Thread (this, "ControlThread");
	  ControlThread.start ();
	}
	
}
