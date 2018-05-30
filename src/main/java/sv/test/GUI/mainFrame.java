package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame implements ActionListener, KeyListener {
	JButton deposit, withdraw, transfer, exchange, loan, depositWithoutBank, checkBalance, payub;

	public mainFrame() {
		super("Main");

		this.setLayout(new GridLayout(4, 2));

		Container container = this.getContentPane();

		deposit = new JButton("�Ա�");
		withdraw = new JButton("���");
		transfer = new JButton("�۱�");
		payub = new JButton("������");
		exchange = new JButton("ȯ��");
		loan = new JButton("����");
		depositWithoutBank = new JButton("�������Ա�");
		checkBalance = new JButton("�ŷ�������ȸ");

		transfer.addActionListener(this);
		transfer.addKeyListener(this);
		payub.addActionListener(this);
		payub.addKeyListener(this);
		deposit.addActionListener(this);
		deposit.addKeyListener(this);
		withdraw.addActionListener(this);
		withdraw.addKeyListener(this);
		exchange.addActionListener(this);
		exchange.addKeyListener(this);
		loan.addActionListener(this);
		loan.addKeyListener(this);
		depositWithoutBank.addActionListener(this);
		depositWithoutBank.addKeyListener(this);
		checkBalance.addActionListener(this);
		checkBalance.addKeyListener(this);

		container.add(this.deposit);
		container.add(this.transfer);
		container.add(this.withdraw);
		container.add(this.checkBalance);
		container.add(this.loan);
		container.add(this.exchange);
		container.add(this.depositWithoutBank);
		container.add(this.payub);

		this.addKeyListener(this);

		this.setSize(600, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.deposit) {
			new insertFrame(0);
			this.dispose();
		} else if (e.getSource() == this.withdraw) {
			new insertFrame(1);
			this.dispose();
		} else if (e.getSource() == this.exchange) {
			new insertFrame(2);
			this.dispose();
		} else if (e.getSource() == this.loan) {
			new insertFrame(3);
			this.dispose();
		} else if (e.getSource() == this.depositWithoutBank) {
			new inputAccountFrame(0);
			this.dispose();
		} else if (e.getSource() == this.checkBalance) {
			new insertFrame(4);
			this.dispose();
		} else if (e.getSource() == this.transfer) {
			new insertFrame(5);
			this.dispose();
		} else if (e.getSource() == this.payub) {
			new inputAccountFrame(2);
			this.dispose();
		}
	}

	public static void main(String[] args) {
		new mainFrame();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		switch (key) {
		case '1': // �Ա�
			new insertFrame(0);
			this.dispose();
			break;
		case '2': // �۱�
			new insertFrame(5);
			this.dispose();
			break;
		case '3': // ���
			new insertFrame(1);
			this.dispose();
			break;
		case '4': // �ŷ�������ȸ
			new insertFrame(4);
			this.dispose();
			break;
		case '5': // ����
			new insertFrame(3);
			this.dispose();
			break;
		case '6': // ȯ��
			new insertFrame(2);
			this.dispose();
			break;
		case '7': // �������Ա�
			new inputAccountFrame(0);
			this.dispose();
			break;
		case '8': // ������
			new inputAccountFrame(2);
			this.dispose();
			break;
		}
	}
}
