

import java.awt.event.*;
import java.util.HashMap;

/**
 * Key listener to listen to all the keys we care about
 * Functions should be self explanatory
 *
 */
public class Keyboard implements KeyListener {
	
	private HashMap<Integer, Boolean> keys = new  HashMap<Integer, Boolean>(4);
	private int X_UP = KeyEvent.VK_UP, X_DOWN = KeyEvent.VK_DOWN, 
			Y_UP = KeyEvent.VK_LEFT, Y_DOWN = KeyEvent.VK_RIGHT, 
			Z_UP = KeyEvent.VK_A, Z_DOWN = KeyEvent.VK_S, 
			SWITCH_VIEW = KeyEvent.VK_Q;
	int keysDown;	
	
	Keyboard(){
		//set the hash codes for the hashMap	
		keys.put(X_UP, false); //vertical
		keys.put(X_DOWN , false);		
		keys.put(Y_UP, false); //horizontal
		keys.put(Y_DOWN , false);
		keys.put(Z_UP, false);
		keys.put(Z_DOWN , false);
		keys.put(SWITCH_VIEW, false);
		keysDown = 0;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(this.keys.containsKey(key)){			
			this.keys.put(key, true);
			keysDown++;
		}
		
	}

	public void keyReleased(KeyEvent e) {	
		int key = e.getKeyCode();
		if(this.keys.containsKey(key)){
			this.keys.put(key, false);
			keysDown--;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
				
	}
	
	public int[] getInputVector(){	
		int[] ret =  {getX(), getY(), getZ(), getViewSwitch()};
		return ret;	
	}
	
	
	public int getY(){
		int ret = 0;
		if(keys.get(Y_UP )){
			ret--;
		}
		if(keys.get(Y_DOWN )){
			ret++;
		}
		return ret;
	}
	
	public int getX(){
		int ret = 0;
		if(keys.get(X_UP )){
			ret--;
		}
		if(keys.get(X_DOWN )){
			ret++;
		}
		return ret;
	}
	
	public int getZ(){
		int ret = 0;
		if(keys.get(Z_UP )){
			ret--;
		}
		if(keys.get(Z_DOWN )){
			ret++;
		}
		return ret;
	}
	
	public int getViewSwitch(){
		if (keys.get(SWITCH_VIEW)){
			return 1;
		}
		return 0;
	}
	
	public Boolean keyPressed(){
		return (keysDown > 0);
	}
}
