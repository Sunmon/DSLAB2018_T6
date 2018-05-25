package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class errorPrintFrame extends JFrame implements ActionListener{
	GridBagLayout gbl;
	GridBagConstraints gbc;
	JButton ok;
	String[] error = {"E�ܾ��� �����մϴ�.", "������ �Ҿ����մϴ�. ��õ��� ���� ���� �߻��� ���� ���Ϳ� ��ȭ���ֽʽÿ�.(1588-1588)", "���������� �߸��Ǿ����ϴ�.", "��й�ȣ�� 3ȸ �̻� Ʋ�� �ŷ��� �Ұ��մϴ�."};
	public errorPrintFrame(int errorcode) {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		add(new JLabel("Error : "+error[errorcode-1]), 0, 0, 5, 4);
		ok = new JButton("Ȯ��");
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
}
