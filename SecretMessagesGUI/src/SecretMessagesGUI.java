import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class SecretMessagesGUI extends JPanel {
	private JTextField txtKey;
	private JTextArea txtOut;
	private JTextArea txtIn;
	private JSlider slider;
	
	
	public String encode(String message, int k) {
		String out = "";
		char key = (char)k;
		for(int x = 0; x < message.length(); x++) {
			//out += (message.charAt(x));
			//out += (char)(message.charAt(x) + key);
			char in = message.charAt(x);
			if (in >= 'A' && in <= 'Z') 
			{
				in += key;
				//in += intKey;
				if (in > 'Z') {
					in -= 26;
				}
				if (in < 'A') {
					in += 26;
				}
			}
			if (in >= 'a' && in <= 'z') {
				in += key;
				//in += intKey;
				if (in > 'z') {
					in -= 26;
				}
				if (in < 'A') {
					in += 26;
				}
			}
			out += in;
		}
		return out;
	}
	
	
	public SecretMessagesGUI() {
		setLayout(null);
		
		txtIn = new JTextArea();
		txtIn.setText("");
		txtIn.setBounds(25, 13, 501, 118);
		add(txtIn);
		
		JLabel lblKey = new JLabel("Key: ");
		lblKey.setHorizontalAlignment(SwingConstants.TRAILING);
		lblKey.setBounds(235, 160, 56, 16);
		add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtKey.setText("0");
		txtKey.setBounds(303, 157, 56, 22);
		add(txtKey);
		txtKey.setColumns(3);
		
		JButton btnEncode = new JButton("Encode/Decode");
		btnEncode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//get the message from txtIn
				String message = txtIn.getText();
				//get the key amount from txtKey
				int key = Integer.parseInt(txtKey.getText());
				
				//enocde that message with that key
				String output = encode(message, key);
				//show the message in txtOut
				txtOut.setText(output);
			}
		});
		btnEncode.setBounds(373, 156, 136, 25);
		add(btnEncode);
		
		txtOut = new JTextArea();
		txtOut.setColumns(10);
		txtOut.setBounds(25, 201, 501, 106);
		add(txtOut);
		setPreferredSize(new Dimension(550, 320));
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtKey.setText("" + slider.getValue() );
			}
		});
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(13);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setValue(0);
		slider.setMaximum(13);
		slider.setMinimum(-13);
		slider.setBounds(35, 140, 200, 48);
		add(slider);
	}
	public static void main(String[] args) {
		//set up a window Jframe for the app
		JFrame frame = new JFrame ("Dr. Payne's Secret Message App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add the encoder panel to the frame
		frame.getContentPane().add(new SecretMessagesGUI());
		
		frame.pack();
		frame.setVisible(true);
	}
}
