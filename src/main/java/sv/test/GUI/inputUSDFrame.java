package GUI;

import javax.swing.*;

import ATM.MainSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class inputUSDFrame extends JFrame implements ActionListener, KeyListener {
	JLabel money;
	JButton b1, b10, b100, reset, bb, ok;
	JButton[] b;
	MainSystem main;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	int error;
	String str;

	public inputUSDFrame(MainSystem main, String str) {
		super("input money");
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.main = main;
		this.str = str;
		JLabel cc = new JLabel("Input amount of money");
		cc.addKeyListener(this);
		add(cc, 0, 0, 5, 1);
		money = new JLabel(str);
		money.addKeyListener(this);
		add(money, 0, 1, 5, 1);
		b = new JButton[10];
		for (int i = 0; i < 10; i++) {
			b[i] = new JButton(String.valueOf(i));
			b[i].addActionListener(this);
			b[i].addKeyListener(this);
		}
		add(b[0], 1, 6, 1, 1);
		add(b[1], 0, 3, 1, 1);
		add(b[2], 1, 3, 1, 1);
		add(b[3], 2, 3, 1, 1);
		add(b[4], 0, 4, 1, 1);
		add(b[5], 1, 4, 1, 1);
		add(b[6], 2, 4, 1, 1);
		add(b[7], 0, 5, 1, 1);
		add(b[8], 1, 5, 1, 1);
		add(b[9], 2, 5, 1, 1);
		b1 = new JButton("��");
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b10 = new JButton("�ʸ�");
		b10.addActionListener(this);
		b10.addKeyListener(this);
		b100 = new JButton("�鸸");
		b100.addActionListener(this);
		b100.addKeyListener(this);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.addKeyListener(this);
		bb = new JButton("<-");
		bb.addActionListener(this);
		bb.addKeyListener(this);
		ok = new JButton("Enter");
		ok.addActionListener(this);
		ok.addKeyListener(this);
		add(b1, 3, 3, 2, 1);
		add(b10, 3, 4, 2, 1);
		add(b100, 3, 5, 2, 1);
		add(ok, 3, 6, 2, 1);
		add(bb, 0, 6, 1, 1);
		add(reset, 2, 6, 1, 1);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void add(Component c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b[1]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(1) + str);
		} else if (e.getSource() == b[2]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(2) + str);
		} else if (e.getSource() == b[3]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(3) + str);
		} else if (e.getSource() == b[4]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(4) + str);
		} else if (e.getSource() == b[5]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(5) + str);
		} else if (e.getSource() == b[6]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(6) + str);
		} else if (e.getSource() == b[7]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(7) + str);
		} else if (e.getSource() == b[8]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(8) + str);
		} else if (e.getSource() == b[9]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(9) + str);
		} else if (e.getSource() == b[0]) {
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(0) + str);
		} else if (e.getSource() == bb && money.getText().length() > 3) {
			money.setText(money.getText().substring(0, money.getText().length() - 4) + str);
		} else if (e.getSource() == reset) {
			money.setText(str);
		} else if (e.getSource() == b1) {
			if (money.getText().length() > 1) {
				int num = 0;
				for (int k = money.getText().length() - 2; money.getText().charAt(k) == '0'; k--) {
					num++;
				}
				if (num > 4) {
					money.setText(money.getText().substring(0, money.getText().length() - num + 3) + "��");
				} else {
					for (num = 4 - num; num > 0; num--)
						money.setText(money.getText().substring(0, money.getText().length() - 1) + "0��");
				}
			} else
				money.setText("10000��");
		} else if (e.getSource() == b10) {
			if (money.getText().length() > 1) {
				int num = 0;
				for (int k = money.getText().length() - 2; money.getText().charAt(k) == '0'; k--) {
					num++;
				}
				if (num > 5) {
					money.setText(money.getText().substring(0, money.getText().length() - num + 4) + "��");
				} else {
					for (num = 5 - num; num > 0; num--)
						money.setText(money.getText().substring(0, money.getText().length() - 1) + "0��");
				}
			} else
				money.setText("100000��");
		} else if (e.getSource() == b100) {
			if (money.getText().length() > 1) {
				int num = 0;
				for (int k = money.getText().length() - 2; money.getText().charAt(k) == '0'; k--) {
					num++;
				}
				if (num > 6) {
					money.setText(money.getText().substring(0, money.getText().length() - num + 5) + "��");
				} else {
					for (num = 6 - num; num > 0; num--)
						money.setText(money.getText().substring(0, money.getText().length() - 1) + "0��");
				}
			} else
				money.setText("1000000��");
		} else if (e.getSource() == ok) {
			int error;
			if ((error = main.exchange(
					(Integer.parseInt(this.money.getText().substring(0, this.money.getText().length() - 3))),
					str)) == 0) {
				new ReceiptFrame(main);
				this.dispose();
			} else {
				new errorPrintFrame(error);
				this.dispose();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		switch (key) {
		case '0':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(0) + str);
			break;
		case '1':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(1) + str);
			break;
		case '2':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(2) + str);
			break;
		case '3':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(3) + str);
			break;
		case '4':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(4) + str);
			break;
		case '5':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(5) + str);
			break;
		case '6':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(6) + str);
			break;
		case '7':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(7) + str);
			break;
		case '8':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(8) + str);
			break;
		case '9':
			money.setText(money.getText().substring(0, money.getText().length() - 3) + String.valueOf(9) + str);
			break;
		case '\b':
			if (money.getText().length() > 3)
				money.setText(money.getText().substring(0, money.getText().length() - 4) + str);
			break;
		case '\n':
			int error;
			main.bank = Integer.parseInt(this.money.getText().substring(0, this.money.getText().length() - 3));
			main.card = str;
			new inputPasswordFrame(1, main);
			break;
		case 'r':
			money.setText(str);
			break;
		case 'q':
			if (money.getText().length() > str.length()) {
				int num = 0;
				for (int k = money.getText().length() - str.length() - 1; money.getText().charAt(k) == '0'; k--) {
					num++;
				}
				if (num > 4) {
					money.setText(money.getText().substring(0, money.getText().length() - num + 4 - str.length()) + str);
				} else {
					for (num = 4 - num; num > 0; num--)
						money.setText(money.getText().substring(0, money.getText().length() - str.length()) + "0" + str);
				}
			} else
				money.setText("10000" + str);
			break;
		case 'w':
			if (money.getText().length() > str.length()) {
				int num = 0;
				for (int k = money.getText().length() - str.length() - 1; money.getText().charAt(k) == '0'; k--) {
					num++;
				}
				if (num > 5) {
					money.setText(money.getText().substring(0, money.getText().length() - num + 5 - str.length()) + str);
				} else {
					for (num = 5 - num; num > 0; num--)
						money.setText(money.getText().substring(0, money.getText().length() - str.length()) + "0" + str);
				}
			} else
				money.setText("100000" + str);
			break;
		case 'e':
			if (money.getText().length() > str.length()) {
				int num = 0;
				for (int k = money.getText().length() - str.length() - 1; money.getText().charAt(k) == '0'; k--) {
					num++;
				}
				if (num > 6) {
					money.setText(money.getText().substring(0, money.getText().length() - num + 6 - str.length()) + str);
				} else {
					for (num = 6 - num; num > 0; num--)
						money.setText(money.getText().substring(0, money.getText().length() - str.length()) + "0" + str);
				}
			} else
				money.setText("1000000" + str);
			break;
		}
	}
}
