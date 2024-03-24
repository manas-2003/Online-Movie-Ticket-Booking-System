package P1;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Movies_5 {

	JFrame frame;
	private String x=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies_5 window = new Movies_5(null,null,null,null,null);
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
	public Movies_5(String name,String phone,String movie,String time,List<String> list) {
		initialize(name,phone,movie,time,list);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String name,String phone,String movie,String time,List<String> list) {
		frame = new JFrame();
		frame.setBounds(100, 100, 631, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Confirmation Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(158, 21, 291, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel d1 = new JLabel("New label");
		d1.setHorizontalAlignment(SwingConstants.CENTER);
		d1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		d1.setBounds(63, 87, 427, 38);
		frame.getContentPane().add(d1);
		d1.setText("Movie name = "+movie);
		
		JLabel d2 = new JLabel("New label");
		d2.setHorizontalAlignment(SwingConstants.CENTER);
		d2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		d2.setBounds(73, 136, 427, 38);
		frame.getContentPane().add(d2);
		d2.setText("Show Time = "+time);
		
		JLabel d3 = new JLabel("New label");
		d3.setHorizontalAlignment(SwingConstants.CENTER);
		d3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		d3.setBounds(63, 185, 427, 44);
		frame.getContentPane().add(d3);
		d3.setText("Tickets = "+Integer.toString(list.size()));
		
		JLabel d4 = new JLabel("New label");
		d4.setHorizontalAlignment(SwingConstants.CENTER);
		d4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		d4.setBounds(63, 240, 427, 44);
		frame.getContentPane().add(d4);
		d4.setText("Booker Name = "+name);
		
		JLabel d5 = new JLabel("New label");
		d5.setHorizontalAlignment(SwingConstants.CENTER);
		d5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		d5.setBounds(73, 295, 427, 44);
		frame.getContentPane().add(d5);
		d5.setText("Phone Number = "+phone);
		
		
		JButton change = new JButton("Change");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movies_2 m2=new Movies_2();
				m2.frame.setVisible(true);
				frame.dispose();
			}
		});
		change.setFont(new Font("Tahoma", Font.PLAIN, 22));
		change.setBounds(72, 425, 141, 44);
		frame.getContentPane().add(change);
		
		JButton book = new JButton("Book");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					FileWriter fw=new FileWriter("D:\\SEMESTER 2\\Files\\Ctod_Projects\\q18_movie.txt");
					fw.write(movie);
					fw.write(","+time);
					fw.write(","+Integer.toString(list.size()));
					fw.write(","+name);
					fw.write(","+phone);
					fw.write(","+x);
					fw.flush();
					fw.close();
				}
				catch(IOException E)
				{
					
				}
				JOptionPane.showMessageDialog(book, "Tickets booked\nTo cancel run Movies_1 again and click cancel");
				frame.dispose();
			}
		});
		book.setFont(new Font("Tahoma", Font.PLAIN, 22));
		book.setBounds(359, 425, 141, 44);
		frame.getContentPane().add(book);
		
		JLabel d6 = new JLabel("Phone Number = <dynamic>");
		d6.setHorizontalAlignment(SwingConstants.CENTER);
		d6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		d6.setBounds(73, 350, 427, 44);
		frame.getContentPane().add(d6);
		for(String a:list)
		{
			if(x==null)
			x=a;
			else
				x=x+","+a;
		}
		d6.setText("Seat Numbers = "+x);
	}
	
}
