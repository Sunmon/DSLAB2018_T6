package OFFER;

// ī���ȣ ���� X-XXXX-XXXX

import java.io.FileOutputStream;
import java.io.FileInputStream;

public class file {
	private String bank;
	private String account;
	private String data;
    private String[] list_bank = {"��������", "��������", "�ϳ�����", "�츮����", "�������", "��������", "��Ƽ����"};
    FileInputStream input;
    FileOutputStream output;
    
	public file() {
		bank = null;
		account = null;
		data = null;
	}
	
	public boolean ReadInput(String input) {
		if(Character.getNumericValue(input.charAt(0)) > 6) {
			System.out.println("error : input error");
			return false;
		}
		bank = list_bank[Character.getNumericValue(input.charAt(0))];
		account = input.substring(1);
		return true;
	}
	
	public void EndBank() {
		bank = null;
		account = null;
		data = null;
	}
	
	
	public boolean CheckValidation(String input) {
		if(!ReadInput(input))
			return false;
		System.out.println("account = " + account + " bank = " + bank);
		try {
			String direc = "./����/" + bank + "/" + account + "/�ܾ�.txt";
			this.input = new FileInputStream(direc);
			this.input.close();
			return true;
		} catch(Exception e) {
			System.out.println("error : invalid input");
			return false;
		}
	}
	
	public boolean Deposit(int money) {
		int sum;
		try {
			String direc = "./����/" + bank + "/" + account + "/�ܾ�.txt";
			input = new FileInputStream(direc);
			sum = input.read();
			System.out.println(sum);
			sum += money;
			input.close();			
			output = new FileOutputStream(direc);
			output.write(sum);			
			output.close();
			EndBank();
		} catch(Exception e) {
			System.out.println("error : deposit");
			return false;
		}
		return true;
	}
}
