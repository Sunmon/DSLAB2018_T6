package GUI;

import javax.swing.*;

import ATM.Account;
import ATM.MainSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inputMoneyFrame extends JFrame implements ActionListener{
	JLabel money;
	JButton b1, b10, b100, reset, bb, ok;
	JButton[] b;
	MainSystem main;
	Account account;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	int menu, error;
	
	public inputMoneyFrame(int menu, MainSystem main) {
		super("input money");
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.main = main;
		this.menu = menu;
		add(new JLabel("Input amount of money"), 0, 0, 5, 1);
		money = new JLabel("��");
		add(money, 0, 1, 5, 1);
		b = new JButton[10];
		for(int i = 0; i < 10; i++) {
			b[i] = new JButton(String.valueOf(i));
			b[i].addActionListener(this);
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
		b10 = new JButton("�ʸ�");
		b10.addActionListener(this);
		b100 = new JButton("�鸸");
		b100.addActionListener(this);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		bb = new JButton("<-");
		bb.addActionListener(this);
		ok = new JButton("Enter");
		ok.addActionListener(this);
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
	
	public inputMoneyFrame(int menu, MainSystem main, Account account) {
		super("input money");
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		this.main = main;
		this.account = account;
		this.menu = menu;
		add(new JLabel("Input amount of money"), 0, 0, 5, 1);
		money = new JLabel("��");
		add(money, 0, 1, 5, 1);
		b = new JButton[10];
		for(int i = 0; i < 10; i++) {
			b[i] = new JButton(String.valueOf(i));
			b[i].addActionListener(this);
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
		b10 = new JButton("�ʸ�");
		b10.addActionListener(this);
		b100 = new JButton("�鸸");
		b100.addActionListener(this);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		bb = new JButton("<-");
		bb.addActionListener(this);
		ok = new JButton("Enter");
		ok.addActionListener(this);
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
		gbc.gridwidth  = w;
		gbc.gridheight = h;
		gbl.setConstraints(c, gbc);
		add(c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b[1]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(1) + "��");
		} else if(e.getSource() == b[2]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(2) + "��");
		} else if(e.getSource() == b[3]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(3) + "��");
		} else if(e.getSource() == b[4]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(4) + "��");
		} else if(e.getSource() == b[5]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(5) + "��");
		} else if(e.getSource() == b[6]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(6) + "��");
		} else if(e.getSource() == b[7]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(7) + "��");
		} else if(e.getSource() == b[8]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(8) + "��");
		} else if(e.getSource() == b[9]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(9) + "��");
		} else if(e.getSource() == b[0]) {
			money.setText(money.getText().substring(0, money.getText().length()-1) + String.valueOf(0) + "��");
		} else if(e.getSource() == bb && money.getText().length() > 1) {
			money.setText(money.getText().substring(0, money.getText().length()-2) + "��");
		} else if(e.getSource() == reset) {
			money.setText("��");
		} else if(e.getSource() == b1) {
			if(money.getText().length() > 1)
				money.setText(money.getText().substring(0, money.getText().length()-1) + "0000��");
			else
				money.setText("10000��");
		} else if(e.getSource() == b10) {
			if(money.getText().length() > 1)
				money.setText(money.getText().substring(0, money.getText().length()-1) + "00000��");
			else
				money.setText("100000��");
		} else if(e.getSource() == b100) {
			if(money.getText().length() > 1)
				money.setText(money.getText().substring(0, money.getText().length()-1) + "000000��");
			else
				money.setText("1000000��");
		} else if(e.getSource() == ok) {
			switch(menu) {
			case 0: //�Ա�
				if((error = main.deposit(Integer.parseInt(money.getText().substring(0, money.getText().length()-1)))) == 0) {
					new ReceiptFrame(main);
				} else {
					new errorPrintFrame(error);					
				}
				this.dispose();
				break;
			case 1: //�������Ա�
				if((error = main.depositWithoutBank(Integer.parseInt(money.getText().substring(0, money.getText().length()-1)))) == 0) {
					new ReceiptFrame(main);					
				} else {
					new errorPrintFrame(error);					
				}
				this.dispose();
				break;
			case 2: //��ü
				if((error = main.transfer(Integer.parseInt(money.getText().substring(0, money.getText().length()-1)), this.account)) == 0) {
					new ReceiptFrame(main);					
				} else {
					new errorPrintFrame(error);					
				}
				this.dispose();
				break;
			case 3:	//���
				if((error = main.withdraw(Integer.parseInt(money.getText().substring(0, money.getText().length()-1)))) == 0){
					new ReceiptFrame(main);
				} else {
					new errorPrintFrame(error);					
				}
				this.dispose();	
				break;
			case 4: //����
				if((error = main.loan(Integer.parseInt(money.getText().substring(0, money.getText().length()-1)))) == 0){
					new ReceiptFrame(main);
				} else {
					new errorPrintFrame(error);
				}
				this.dispose();
				break;
			}
		}
	}
}
