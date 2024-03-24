package P1;

import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Movies_3 {

	JFrame frame;
	JPanel contentPane;
	  String Sel="";
	  int x=16,y=20,count=0;
	  JLabel[] lbl = new JLabel[y];
	  JCheckBox[][] ChkArr= new JCheckBox[x][y];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies_3 window = new Movies_3(null,null);
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
	public Movies_3(String movie,String time) {
		initialize(movie,time);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String movie,String time) {
		frame = new JFrame();
		frame.setBounds(100, 100, 883, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		for(int z=0;z<y;z++)
	    {
	      int n=z+1;
	      lbl[z] = new JLabel();
	      lbl[z].setBounds(10,80+(z*20),25,25);
	      lbl[z].setText(""+n);
	      lbl[z].setHorizontalAlignment(SwingConstants.CENTER);
	      frame.getContentPane().add(lbl[z]);
	    }
	    
	    for (int i=0;i<x;i++)
	      for(int j=0;j<y;j++)
	      {
	        ChkArr[i][j] = new JCheckBox();
	        ChkArr[i][j].setBounds(30+(i*50),80+(j*20), 50, 25);
	        int x=i+1;
	        ChkArr[i][j].setText(""+x);
	        ChkArr[i][j].setHorizontalAlignment(SwingConstants.CENTER);
	        frame.getContentPane().add(ChkArr[i][j]);
	      }
		
	    
	    
		JLabel lblNewLabel = new JLabel(" Please Select Your Seats");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 849, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Screen This Way");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(295, 517, 268, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton book = new JButton("Book");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> list = new ArrayList<>();
		        for (int i=0;i<x;i++)
		          for(int j=0;j<y;j++)
		          {
		            if(ChkArr[i][j].isSelected())
		            {
		              count=count+1;
		              list.add((j+1)+"-"+(i+1));
		              }
		          }
				Movies_4 m4=new Movies_4(movie,time,list);
				m4.frame.setVisible(true);
				frame.dispose();
			}
		});
		book.setFont(new Font("Tahoma", Font.PLAIN, 20));
		book.setBounds(669, 529, 136, 40);
		frame.getContentPane().add(book);
	}

}
