//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.glu.GLU;


public class Engine extends JFrame implements GLEventListener {

	//scene
	//control
	//view
	
	 private Controls control;
	 private View view;
	 private Scene scene;
	 public static final float FPS = 60;
    /**
     * Create a new game by loading the world level
     * 
     * @param s
     */
    public Engine() {
    	super("tester");	
    }
   
    /**
     * Make a new game with the level file in arg 0
     * 
     * @param args - The first argument is a level file in JSON format
     * @throws FileNotFoundException
     */
    public static void main(){
    	Engine Engine = new Engine();
        Engine.run();
    }
 
    /** 
     * Run the game.
     *
     */
    public void run() {
    	// OpenGL stuff
    	  GLProfile glp = GLProfile.getDefault();
          GLCapabilities caps = new GLCapabilities(glp);
          GLJPanel panel = new GLJPanel();
          panel.addGLEventListener(this);
          
          this.scene = new Scene();
          
          // Control and key listeners
          control = new Controls();
          control.setScene(this.scene);
          control.start();
 
          panel.addKeyListener(control.getKeyboard());
          
          // Add an animator to call 'display' at 60fps        
          FPSAnimator animator = new FPSAnimator(60);
          animator.add(panel);
          animator.start();

          // Window stuff
          getContentPane().add(panel);
          setSize(800, 800);        
          setVisible(true);
          setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
    
    /**
     * Enable OpenGL stuff such as lighting and back face culling
     */
	@Override
	public void init(GLAutoDrawable drawable) {
		
		 GL2 gl = drawable.getGL().getGL2();
		 gl.glEnable(GL2.GL_DEPTH_TEST);  
		 gl.glEnable(GL2.GL_NORMALIZE);	
		 gl.glEnable(GL2.GL_TEXTURE_2D);
		 gl.glEnable(GL2.GL_LIGHTING);
		 gl.glEnable(GL2.GL_CULL_FACE);
		 gl.glCullFace(GL2.GL_BACK);
		
	}

	/**
	 * Called 60 times a second (theoretically) to draw everything
	 */
	@Override
	public void display(GLAutoDrawable drawable) {
		
		  GL2 gl = drawable.getGL().getGL2(); 
		  
		  	  
		 gl.glClear(GL.GL_COLOR_BUFFER_BIT |GL.GL_DEPTH_BUFFER_BIT);
		 
		 System.out.println("Main engine thread");
		// Scene.draw(gl);
	}

	/**
	 * Change the shape of the pane when the window size changes
	 */
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		
		GL2 gl = drawable.getGL().getGL2();	
		// Set the camera perspective
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU glu = new GLU();
        glu.gluPerspective(60.0, (float)getWidth()/(float)getHeight(), 0.1, 60.0);
		
	}
	
	@Override
	public void dispose(GLAutoDrawable drawable) {
	}
	
	@SuppressWarnings("static-access")
	public GL2 getGL2(){
		GLU glu = new GLU();
		return glu.getCurrentGL().getGL2();	
	} 
	
	
}