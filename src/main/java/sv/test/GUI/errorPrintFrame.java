package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class errorPrintFrame extends JFrame implements ActionListener, KeyListener {
	GridBagLayout gbl;
	GridBagConstraints gbc;
	JButton ok;
	String[] error = { "�ܾ��� �����մϴ�.", "������ �Ҿ����մϴ�. ���� ���� �߻��� ���� ���Ϳ� ��ȭ���ֽʽÿ�.(1588-1588)", "���������� �߸��Ǿ����ϴ�.",
			"��й�ȣ�� 3ȸ �̻� Ʋ�� �ŷ��� �Ұ��մϴ�.", "�ŷ��Ұ� �����Դϴ�.", "��ȯ���� ����ݺ��� ���� �� �����ϴ�.", "�ѵ��ʰ��Դϴ�.",
			"�Աݰ��¿� �۱ݰ��°� �����Ͽ� �ŷ��� ����˴ϴ�.", "�������� �̹� ���εǾ����ϴ�." };

	public errorPrintFrame(int errorcode) {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		JLabel dd = new JLabel("Error : " + error[errorcode - 1]);
		dd.addKeyListener(this);
		add(dd, 0, 0, 5, 4);
		ok = new JButton("Ȯ��");
		ok.addKeyListener(this);
		ok.addActionListener(this);
		add(ok, 0, 5, 2, 1);
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new mainFrame();
		this.dispose();
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
		new mainFrame();
		this.dispose();
	}
}
