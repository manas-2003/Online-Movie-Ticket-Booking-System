package P1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Movies_6 {

	JFrame frame;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies_6 window = new Movies_6();
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
	public Movies_6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANCEL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(154, 23, 191, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Phone Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(34, 96, 161, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		phone = new JTextField();
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
					e.consume();
			}
		});
		phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		phone.setBounds(236, 96, 245, 39);
		frame.getContentPane().add(phone);
		phone.setColumns(10);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] data;
				String x;
				int flag=0;
				try
				{
					FileReader fr=new FileReader("D:\\SEMESTER 2\\Files\\Ctod_Projects\\q18_movie.txt");
					BufferedReader br=new BufferedReader(fr);
					data=br.readLine().split(",");
					for(int i=0;i<data.length;i++)
					{
						if(data[i].equals(phone.getText()))
						{
							flag=1;
							break;
						}
					}
					/*while((x=br.readLine())!=null)
					{
						data=x.split(",");
						
					}*/
					fr.close();
				}
				catch(IOException E)
				{
					
				}
				if(flag==1)
				{
					FileWriter fw;
					try {
						fw = new FileWriter("D:\\SEMESTER 2\\Files\\Ctod_Projects\\q18_movie.txt");
						fw.write("");
						fw.flush();
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(cancel, "Movie Tickets Has Been Cancelled");
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(cancel, "You Didnot book movie tickets");
					frame.dispose();
				}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancel.setBounds(176, 197, 117, 39);
		frame.getContentPane().add(cancel);
	}
}
