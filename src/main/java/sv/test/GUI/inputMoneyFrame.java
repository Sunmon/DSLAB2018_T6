package GUI;

import javax.swing.*;

import ATM.Account;
import ATM.MainSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class inputMoneyFrame extends JFrame implements ActionListener, KeyListener {
	JLabel money, state;
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
		state = new JLabel("Input amount of money");
		add(state, 0, 0, 5, 1);
		state.addKeyListener(this);
		money = new JLabel("��");
		add(money, 0, 1, 5, 1);
		money.addKeyListener(this);
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
		if (menu == 4) {
			state.setText("������ �ſ����� " + String.valueOf(main.getAccount().getRate()) + "��� �Դϴ�.");
			state.setOpaque(true);
			state.setBackground(Color.LIGHT_GRAY);
		}
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
		JLabel mm = new JLabel("Input amount of money");
		mm.addKeyListener(this);
		add(mm, 0, 0, 5, 1);
		money = new JLabel("��");
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
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(1) + "��");
		} else if (e.getSource() == b[2]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(2) + "��");
		} else if (e.getSource() == b[3]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(3) + "��");
		} else if (e.getSource() == b[4]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(4) + "��");
		} else if (e.getSource() == b[5]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(5) + "��");
		} else if (e.getSource() == b[6]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(6) + "��");
		} else if (e.getSource() == b[7]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(7) + "��");
		} else if (e.getSource() == b[8]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(8) + "��");
		} else if (e.getSource() == b[9]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(9) + "��");
		} else if (e.getSource() == b[0]) {
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(0) + "��");
		} else if (e.getSource() == bb && money.getText().length() > 1) {
			money.setText(money.getText().substring(0, money.getText().length() - 2) + "��");
		} else if (e.getSource() == reset) {
			money.setText("��");
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
			if (money.getText().length() - 1 > 9) {
				state.setText("10�� �̸����θ� �ŷ� �����մϴ�.");
				state.setOpaque(true);
				state.setBackground(Color.LIGHT_GRAY);
			} else if (money.getText().length() < 2) {
				state.setText("�ݾ��� �Է��� �ֽʽÿ�.");
				state.setOpaque(true);
				state.setBackground(Color.LIGHT_GRAY);
			} else {
				switch (menu) {
				case 0: // �Ա�
					if (money.getText().length() > 5 && money.getText()
							.substring(money.getText().length() - 5, money.getText().length() - 1).equals("0000")) {
						if ((error = main.deposit(
								money.getText().substring(0, money.getText().length() - 1))) == 0) {
							new ReceiptFrame(main);
						} else {
							new errorPrintFrame(error);
						}
						this.dispose();
					} else {
						state.setText("10000�� �����θ� �Աݰ����մϴ�.");
						state.setOpaque(true);
						state.setBackground(Color.LIGHT_GRAY);
					}
					break;
				case 1: // �������Ա�
					if (money.getText().length() > 5 && (money.getText()
							.substring(money.getText().length() - 5, money.getText().length() - 1).equals("0000"))) {
						if ((error = main.depositWithoutBank(
								money.getText().substring(0, money.getText().length() - 1))) == 0) {
							new ReceiptFrame(main);
						} else {
							new errorPrintFrame(error);
						}
						this.dispose();
					} else {
						state.setText("10000�� �����θ� �Աݰ����մϴ�.");
						state.setOpaque(true);
						state.setBackground(Color.LIGHT_GRAY);
					}
					break;
				case 2: // ��ü
					main.bank = money.getText().substring(0, money.getText().length() - 1);
					new inputPasswordFrame(4, main, account);
					this.dispose();
					break;
				case 3: // ���
					if (money.getText().length() > 5 && (money.getText()
							.substring(money.getText().length() - 5, money.getText().length() - 1).equals("0000"))) {
						main.bank = (money.getText().substring(0, money.getText().length() - 1));
						new inputPasswordFrame(0, main);
						this.dispose();
					} else {
						state.setText("10000�� �����θ� �Աݰ����մϴ�.");
						state.setOpaque(true);
						state.setBackground(Color.LIGHT_GRAY);
					}
					break;
				case 4: // ����
					if (money.getText().length() > 5 && (money.getText()
							.substring(money.getText().length() - 5, money.getText().length() - 1).equals("0000"))) {
						main.bank = (money.getText().substring(0, money.getText().length() - 1));
						new inputPasswordFrame(2, main);
						this.dispose();
					} else {
						state.setText("10000�� �����θ� �Աݰ����մϴ�.");
						state.setOpaque(true);
						state.setBackground(Color.LIGHT_GRAY);
					}
					break;
				}
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
			if(money.getText().length() > 1)
				money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(0) + "��");
			break;
		case '1':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(1) + "��");
			break;
		case '2':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(2) + "��");
			break;
		case '3':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(3) + "��");
			break;
		case '4':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(4) + "��");
			break;
		case '5':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(5) + "��");
			break;
		case '6':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(6) + "��");
			break;
		case '7':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(7) + "��");
			break;
		case '8':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(8) + "��");
			break;
		case '9':
			money.setText(money.getText().substring(0, money.getText().length() - 1) + String.valueOf(9) + "��");
			break;
		case 'r':
			money.setText("��");
			break;
		case '\b':
			if (money.getText().length() > 1)
				money.setText(money.getText().substring(0, money.getText().length() - 2) + "��");
			break;
		case 'q':
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
			break;
		case 'w':
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
			break;
		case 'e':
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
			break;
		case '\n':
			if (money.getText().length() - 1 > 9) {
				state.setText("10�� �̸����θ� �ŷ� �����մϴ�.");
				state.setOpaque(true);
				state.setBackground(Color.LIGHT_GRAY);
			} else if (money.getText().length() < 2) {
				state.setText("�ݾ��� �Է��� �ֽʽÿ�.");
				state.setOpaque(true);
				state.setBackground(Color.LIGHT_GRAY);
			} else {
				switch (menu) {
				case 0: // �Ա�
					if (money.getText().length() > 5 && money.getText()
							.substring(money.getText().length() - 5, money.getText().length() - 1).equals("0000")) {
						if ((error = main.deposit(
								money.getText().substring(0, money.getText().length() - 1))) == 0) {
							new ReceiptFrame(main);
						} else {
							new errorPrintFrame(error);
						}
						this.dispose();
					} else {
						state.setText("10000�� �����θ� �Է°����մϴ�.");
						state.setOpaque(true);
						state.setBackground(Color.LIGHT_GRAY);
					}
					break;
				case 1: // �������Ա�
					if (money.getText().length() > 5 && (money.getText()
							.substring(money.getText().length() - 5, money.getText().length() - 1).equals("0000"))) {
						if ((error = main.depositWithoutBank(
								money.getText().substring(0, money.getText().length() - 1))) == 0) {
							new ReceiptFrame(main);
						} else {
							new errorPrintFrame(error);
						}
						this.dispose();
					} else {
						state.setText("10000�� �����θ� �Է°����մϴ�.");
						state.setOpaque(true);
						state.setBackground(Color.LIGHT_GRAY);
					}
					break;
				case 2: // ��ü
					main.bank = (money.getText().substring(0, money.getText().length() - 1));
					new inputPasswordFrame(4, main, account);
					this.dispose();
					break;
				case 3: // ���
					if (money.getText().length() > 5 && (money.getText()
							.substring(money.getText().length() - 5, money.getText().length() - 1).equals("0000"))) {
						main.bank = (money.getText().substring(0, money.getText().length() - 1));
						new inputPasswordFrame(0, main);
						this.dispose();
					} else {
						state.setText("10000�� �����θ� �Է°����մϴ�.");
						state.setOpaque(true);
						state.setBackground(Color.LIGHT_GRAY);
					}
					break;
				case 4: // ����
					if (money.getText().length() > 5 && (money.getText()
							.substring(money.getText().length() - 5, money.getText().length() - 1).equals("0000"))) {
						main.bank = money.getText().substring(0, money.getText().length() - 1);
						new inputPasswordFrame(2, main);
						this.dispose();
					} else {
						state.setText("10000�� �����θ� �Է°����մϴ�.");
						state.setOpaque(true);
						state.setBackground(Color.LIGHT_GRAY);
					}
					break;
				}
			}
			break;
		}
	}
}
