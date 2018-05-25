package GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame implements ActionListener{
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
		payub.addActionListener(this);
		deposit.addActionListener(this);
		withdraw.addActionListener(this);
		exchange.addActionListener(this);
		loan.addActionListener(this);
		depositWithoutBank.addActionListener(this);
		checkBalance.addActionListener(this);
		
		container.add(this.deposit);
		container.add(new JButton());
		container.add(new JButton());
		container.add(this.transfer);
		container.add(this.withdraw);
		container.add(new JButton());
		container.add(new JButton());
		container.add(this.checkBalance);
		container.add(this.loan);
		container.add(new JButton());
		container.add(new JButton());
		container.add(this.exchange);
		container.add(this.depositWithoutBank);
		container.add(new JButton());
		container.add(new JButton());
		container.add(this.payub);

		
		this.setSize(600, 800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.deposit) {
			new insertFrame(0);
			this.dispose();
		} else if(e.getSource() == this.withdraw) {
			new insertFrame(1);
			this.dispose();
		} else if(e.getSource() == this.exchange) {
			new insertFrame(2);
			this.dispose();
		} else if(e.getSource() == this.loan) {
			new insertFrame(3);
			this.dispose();
		} else if(e.getSource() == this.depositWithoutBank) {
			new inputAccountFrame(0);
			this.dispose();
		} else if(e.getSource() == this.checkBalance) {
			new insertFrame(4);
			this.dispose();
		} else if(e.getSource() == this.transfer) {
			new insertFrame(5);
			this.dispose();
		} else if(e.getSource() == this.payub) {
			new inputAccountFrame(2);
			this.dispose();
		}
	}
	
	public static void main(String[] args) {
		new mainFrame();
	}
}
