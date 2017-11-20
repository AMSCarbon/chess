import com.jogamp.opengl.GL2;

public class Scene {

	private static SceneObject ROOT;
	
	
	public static void draw(GL2 gl) {
		
		ROOT.draw();
	}

}
