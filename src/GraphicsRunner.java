import java.awt.Color;

import javax.swing.JFrame;
public class GraphicsRunner extends JFrame{
	public GraphicsRunner(String s){
		super(s);
		setVisible(true);
		getContentPane().add( new Panel() );
		setSize(1100,1000);
		pack();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	public static void main(String[] args) {
		GraphicsRunner game = new GraphicsRunner("Camel Up");
	}
}