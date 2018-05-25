package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ATM.Account;
import ATM.MainSystem;

public class insertFrame extends JFrame implements ActionListener{
	JTextField tf;
	JButton ok, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bb, reset;
	JComboBox<String> combo;
	MainSystem main, temp;
	int menu;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	public insertFrame(int menu) {
		super("insert");
		String[] list_bank = {"��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��"};
		combo = new JComboBox<String>(list_bank);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		this.menu = menu;
		this.main = new MainSystem();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		tf = new JTextField();
		tf.setEditable(false);
		ok = new JButton("Enter");
		reset = new JButton("Reset");
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bb = new JButton("<-");
		tf.addActionListener(this);
		ok.addActionListener(this);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bb.addActionListener(this);
		reset.addActionListener(this);
		
		if(menu == 6) {
			combo.setSelectedItem(7);
			combo.setEnabled(false);
		}
		
		add(this.b7, 0, 4, 1, 1);
		add(this.b8, 1, 4, 1, 1);
		add(this.b9, 2, 4, 1, 1);
		add(this.b4, 0, 3, 1, 1);
		add(this.b5, 1, 3, 1, 1);
		add(this.b6, 2, 3, 1, 1);
		add(this.b1, 0, 2, 1, 1);
		add(this.b2, 1, 2, 1, 1);
		add(this.b3, 2, 2, 1, 1);
		add(this.bb, 3, 2, 1, 1);
		add(this.b0, 1, 5, 1, 1);
		add(this.ok, 3, 4, 1, 2);
		add(this.reset, 3, 3, 1, 1);
		add(this.tf, 0, 1, 4, 1);
		add(this.combo, 0, 0, 4, 1);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public insertFrame(int menu, MainSystem main) {
		super("�Ա��Ͻ� ���¸� �Է����ּ���");
		String[] list_bank = {"��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��"};
		combo = new JComboBox<String>(list_bank);
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		this.menu = menu;
		this.main = main;
		this.temp = new MainSystem();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		tf = new JTextField();
		tf.setEditable(false);
		ok = new JButton("Enter");
		reset = new JButton("Reset");
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bb = new JButton("<-");
		tf.addActionListener(this);
		ok.addActionListener(new myActionListener());
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bb.addActionListener(this);
		reset.addActionListener(this);
		
		if(menu == 6) {
			combo.setSelectedItem(7);
			combo.setEnabled(false);
		}
		
		add(this.b7, 0, 4, 1, 1);
		add(this.b8, 1, 4, 1, 1);
		add(this.b9, 2, 4, 1, 1);
		add(this.b4, 0, 3, 1, 1);
		add(this.b5, 1, 3, 1, 1);
		add(this.b6, 2, 3, 1, 1);
		add(this.b1, 0, 2, 1, 1);
		add(this.b2, 1, 2, 1, 1);
		add(this.b3, 2, 2, 1, 1);
		add(this.bb, 3, 2, 1, 1);
		add(this.b0, 1, 5, 1, 1);
		add(this.ok, 3, 4, 1, 2);
		add(this.reset, 3, 3, 1, 1);
		add(this.tf, 0, 1, 4, 1);
		add(this.combo, 0, 0, 4, 1);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void add(Component c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b0) {
			tf.setText(tf.getText() + "0");
		} else if (e.getSource() == b1) {
			tf.setText(tf.getText() + "1");
		} else if (e.getSource() == b2) {
			tf.setText(tf.getText() + "2");
		} else if (e.getSource() == b3) {
			tf.setText(tf.getText() + "3");
		} else if (e.getSource() == b4) {
			tf.setText(tf.getText() + "4");
		} else if (e.getSource() == b5) {
			tf.setText(tf.getText() + "5");
		} else if (e.getSource() == b6) {
			tf.setText(tf.getText() + "6");
		} else if (e.getSource() == b7) {
			tf.setText(tf.getText() + "7");
		} else if (e.getSource() == b8) {
			tf.setText(tf.getText() + "8");
		} else if (e.getSource() == b9) {
			tf.setText(tf.getText() + "9");
		} else if (e.getSource() == ok) {
			this.main.insert(String.valueOf(combo.getSelectedIndex()) + tf.getText());
			if(main.offer[combo.getSelectedIndex()].checkValid(main.getAccount())) {
				main.offer[combo.getSelectedIndex()].readDatabase(main.getAccount());
				switch(menu){
				case 0:	//deposit
					new inputMoneyFrame(0, main);
					this.dispose();
					break;
				case 1:	//withdraw
					new inputPasswordFrame(0, main);
					this.dispose();
					break;
				case 2:	//exchange
					new inputPasswordFrame(1, main);
					this.dispose();
					break;
				case 3:	//loan
					new inputPasswordFrame(2, main);
					this.dispose();
					break;
				case 4:	//checkbalance
					new inputPasswordFrame(3, main);
					this.dispose();
					break;
				case 5:	//transfer
					new inputAccountFrame(1, main);
					this.dispose();
					break;
				case 6:	//payub
					new inputPasswordFrame(5, main, temp.getAccount());
					this.dispose();
					break;
				}
			} else {
				new errorPrintFrame(3);
				this.dispose();
			}
		} else if (e.getSource() == bb && tf.getText().length() > 0) {
			tf.setText(tf.getText().substring(0, tf.getText().length()-1));
		} else if (e.getSource() == reset) {
			tf.setText("");
		}
	}
	
	class myActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
