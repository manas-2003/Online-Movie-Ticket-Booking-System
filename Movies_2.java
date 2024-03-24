package P1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Movies_2 {

	JFrame frame;
	private JTextField textField;
	private JLabel pic;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies_2 window = new Movies_2();
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
	public Movies_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Movie");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(179, 29, 249, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedIndex()==0)
					setimage("rrr.jpg","9am - 12pm");
				else if(list.getSelectedIndex()==1)
					setimage("kgf2.jpg","12pm - 3pm");
				else if(list.getSelectedIndex()==2)
					setimage("pushpa.jpg","3pm - 6pm");
				else if(list.getSelectedIndex()==3)
					setimage("jaibhim.jpg","6pm - 9pm");
				else if(list.getSelectedIndex()==4)
					setimage("bheemlanayak.jpg","9pm - 12pm");
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"RRR", "KGF-2", "PUSHPA", "JAI BHIM", "BHEEMLA NAYAK"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		list.setBounds(24, 158, 179, 145);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Select");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(24, 122, 179, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		pic = new JLabel("");
		pic.setBounds(247, 104, 334, 263);
		frame.getContentPane().add(pic);
		
		JLabel lblNewLabel_2 = new JLabel("Timings");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(82, 419, 115, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(207, 419, 269, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton book = new JButton("Book");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movies_3 m3=new Movies_3(list.getSelectedValue().toString(),textField.getText());
				m3.frame.setVisible(true);
				frame.dispose();
			}
		});
		book.setFont(new Font("Tahoma", Font.PLAIN, 20));
		book.setBounds(247, 540, 127, 39);
		frame.getContentPane().add(book);
	}
	public void setimage(String s,String x)
    {
    	ImageIcon icon=new ImageIcon("D:\\SEMESTER 2\\Images\\"+s);
		Image imgscale=icon.getImage().getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledicon=new ImageIcon(imgscale);
		pic.setIcon(scaledicon);
		textField.setText(x);
    }
}
