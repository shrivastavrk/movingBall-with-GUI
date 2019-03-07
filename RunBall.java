import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.Window.Type;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RunBall {

	private JFrame frmJumpingBall;
	private int CANVAS_HEIGHT=200;
	private int CANVAS_WIDTH=200;
	private int x= CANVAS_HEIGHT/2;
	private int y=CANVAS_WIDTH/2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunBall window = new RunBall();
					window.frmJumpingBall.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RunBall() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJumpingBall = new JFrame();
		frmJumpingBall.setType(Type.POPUP);
		frmJumpingBall.setTitle("JUMPING BALL");
		frmJumpingBall.getContentPane().setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(106, 42, 212, 166);
		canvas.setSize(CANVAS_WIDTH,CANVAS_HEIGHT);
		frmJumpingBall.getContentPane().add(canvas);
		
		Button DOWNbutton = new Button("DOWN");
		DOWNbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y+=30;
				canvas.repaint();
			}
		});
		DOWNbutton.setBounds(173, 321, 58, 50);
		frmJumpingBall.getContentPane().add(DOWNbutton);
		
		Button UPbutton
		= new Button("UP");
		UPbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				y-=30;
				canvas.repaint();
			}
		});
		UPbutton.setBounds(173, 265, 58, 50);
		frmJumpingBall.getContentPane().add(UPbutton);
		
		Button RIGHTbutton = new Button("-- >");
		RIGHTbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x+=10;
				canvas.repaint();
			}
		});
		RIGHTbutton.setBounds(235, 321, 70, 50);
		frmJumpingBall.getContentPane().add(RIGHTbutton);
		
		Button LEFTbutton = new Button("< --");
		LEFTbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x-=10;
				canvas.repaint();
			}
		});
		LEFTbutton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				x-=10;
			
			}
		});
		LEFTbutton.setBounds(97, 321, 70, 50);
		frmJumpingBall.getContentPane().add(LEFTbutton);
		
	}
	
	class Canvas extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.black);
			g.setColor(Color.gray);
			g.fillOval(x,y,40,40); // Draw the line
		}
	}
}
