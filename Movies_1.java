package P1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Movies_1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies_1 window = new Movies_1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Movies_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 625, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(35, 32, 529, 406);
		frame.getContentPane().add(lblNewLabel);
		
		ImageIcon icon=new ImageIcon("D:\\Work folders\\Desktop\\movie.jpg");
		Image imgscale=icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledicon=new ImageIcon(imgscale);
		lblNewLabel.setIcon(scaledicon);
		
		JButton book = new JButton("Book");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movies_2 m2=new Movies_2();
				m2.frame.setVisible(true);
				frame.dispose();
			}
		});
		book.setFont(new Font("Tahoma", Font.PLAIN, 20));
		book.setBounds(367, 487, 127, 39);
		frame.getContentPane().add(book);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movies_6 m6=new Movies_6();
				m6.frame.setVisible(true);
				frame.dispose();
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancel.setBounds(123, 487, 127, 39);
		frame.getContentPane().add(cancel);
	}
}
