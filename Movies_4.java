package P1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Movies_4 {

	JFrame frame;
	private JTextField name;
	private JTextField phone;
	private JTextField tickets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies_4 window = new Movies_4(null, null, null);
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
	public Movies_4(String movie,String time,List<String> list) {
		initialize(movie,time,list);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String movie,String time,List<String> list) {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(134, 23, 238, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(39, 105, 149, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone Number");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(39, 188, 149, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("No Of Tickets");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(39, 266, 149, 37);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!(e.getKeyChar()>='a' && e.getKeyChar()<='z') && !(e.getKeyChar()>='A' && e.getKeyChar()<='Z'))
					e.consume();
			}
		});
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setBounds(262, 105, 218, 37);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
					e.consume();
			}
		});
		phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(262, 188, 218, 37);
		frame.getContentPane().add(phone);
		
		tickets = new JTextField();
		tickets.setEditable(false);
		tickets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tickets.setColumns(10);
		tickets.setBounds(262, 266, 87, 37);
		frame.getContentPane().add(tickets);
		tickets.setText(Integer.toString(list.size()));
		
		JButton book = new JButton("Book");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().length()==0)
					JOptionPane.showMessageDialog(book, "Please Enter name");
				else if(phone.getText().length()<10 || phone.getText().length()>10)
					JOptionPane.showMessageDialog(book, "Phone Number must be a 10 digit Number");
				else
				{
					Movies_5 m5=new Movies_5(name.getText(),phone.getText(),movie,time,list);
					m5.frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		book.setFont(new Font("Tahoma", Font.PLAIN, 18));
		book.setBounds(210, 345, 106, 37);
		frame.getContentPane().add(book);
	}

}
