package ATM;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import OFFER.Offer;

public class MainSystem {
	private Account account;
	public String card;
	public Offer[] offer;
	public int bank;
	private int exchangeRate;
	private int wrongPasswordTimes;
	private int errorType;

	public MainSystem() {
		account = new Account();
		card = null;
		offer = new Offer[10];
		for (int i = 0; i < 10; i++)
			offer[i] = new Offer(i);
		exchangeRate = 0;
		wrongPasswordTimes = 0;
		errorType = 0;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	// üũī�� 0, ���� 1, �ſ�ī�� 2, ���ο���3 // ���� // ��������
	public void insert(String str) {
		String[] list_bank = { "��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��" };
		this.card = str;
		this.account.setBank(list_bank[Integer.parseInt(card.charAt(0) + "")]);
		this.account.setAccountNumber(card.substring(1));
	}

	public int lockAccount() {
		String[] list_bank = { "��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��" };
		int bank;
		for(bank = 0; bank < list_bank.length; bank++) {
			if(list_bank[bank].equals(account.getBank()))
				break;
		}
		if ((this.errorType = offer[bank].readDatabase(account)) == 0) {
			account.setIsLocked(true);
			if (offer[bank].updateDatabase(account)) {
				return 0;
			} else
				return 2;
		} else
			return 2;
	}

	public int deposit(int money) {
		String[] list_bank = { "��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��" };
		int bank;
		for(bank = 0; bank < list_bank.length; bank++) {
			if(list_bank[bank].equals(account.getBank()))
				break;
		}
		if (this.account.getBank().substring(2, 4).equals("ī��")) {			
			if ((this.errorType = offer[bank].readDatabase(account)) == 0) {
				if (account.getDept() < money) {
					return 6;
				} else {
					account.setDept(account.getDept() - money);
					String newLog = new Date() + " " + money + " ��ȯ \t( ����� : " + account.getDept() + " )\n";
					newLog = newLog + account.getLog();
					account.setLog(newLog);
					if (offer[bank].updateDatabase(account)) {
						return 0;
					} else {
						return 2;
					}
				}
			} else {
				return 2;
			}
		} else {
			if ((this.errorType = offer[bank].readDatabase(account)) == 0) {
				account.setBalance(account.getBalance() + money);
				String newLog = new Date() + " " + money + " �Ա� \t( �ܾ� : " + account.getBalance() + " )\n";
				newLog = newLog + account.getLog();
				account.setLog(newLog);
				if (offer[bank].updateDatabase(account)) {
					return 0;
				} else {
					return 2;
				}
			} else {
				return 2;
			}
		}
	}

	public int withdraw(int money) {
		String[] list_bank = { "��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��" };
		int bank;
		for(bank = 0; bank < list_bank.length; bank++) {
			if(list_bank[bank].equals(account.getBank()))
				break;
		}
		if ((this.errorType = offer[bank].readDatabase(account)) == 0) {
			if ((account.getBank().equals("��������") && account.getBalance() < money)
					|| (!account.getBank().equals("��������") && account.getBalance() < money + 1300)) {
				return 1;
			} else {
				String newLog;
				if (!account.getBank().equals("��������")) {
					this.takeCharge(account);					
				}
				account.setBalance(account.getBalance() - money);
				newLog = new Date() + " " + money + " ��� \t( �ܾ� : " + account.getBalance() + " )\n" + account.getLog();
				account.setLog(newLog);
				
				if (offer[bank].updateDatabase(account)) {
					return 0;
				} else {
					return 2;
				}
			}
		} else {
			return 2;
		}
	}

	public int transfer(int money, Account newAccount) {
		String[] list_bank = { "��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��" };
		int bank;
		for(bank = 0; bank < list_bank.length; bank++) {
			if(list_bank[bank].equals(account.getBank()))
				break;
		}		
		if (offer[bank].checkValid(account)) {
			if ((this.errorType = offer[bank].readDatabase(account)) == 0) {
				int temp_bank = 20;
				for (int i = 0; i < 10; i++) {
					if (newAccount.getBank().equals(list_bank[i])) {
						temp_bank = i;
						break;
					}
				}
				if (temp_bank == 20) {
					return 3;
				}
				if ((account.getBank().equals("��������") && account.getBalance() < money)
						|| (!account.getBank().equals("��������") && account.getBalance() < money + 1300)) {
					return 1;
				} else {
					if (!account.getBank().equals("��������"))
						this.takeCharge(account);
					if (newAccount.getBank().substring(2, 4).equals("ī��")) {			
						if ((this.errorType = offer[bank].readDatabase(newAccount)) == 0) {
							if (newAccount.getDept() < money) {
								return 6;
							} else {
								newAccount.setDept(newAccount.getDept() - money);
								String newLog = new Date() + " " + money + " ��ȯ \t( ����� : " + newAccount.getDept() + " )\n";
								newLog = newLog + newAccount.getLog();
								newAccount.setLog(newLog);
								if (!offer[bank].updateDatabase(newAccount)) {
									return 2;
								}
								offer[bank].readDatabase(account);
								if(account.getBank() != "��������")
									takeCharge(account);
								account.setBalance(account.getBalance() - money);
								newLog = new Date() + " " + money + " �۱� " + newAccount.getBank() + " "
										+ newAccount.getAccountNumber() + "\t( �ܾ� : " + account.getBalance() + " )\n";
								newLog = newLog + account.getLog();
								account.setLog(newLog);					
								if (offer[bank].updateDatabase(account)) {
									return 0;
								} else {
									newAccount.setDept(newAccount.getDept() + money);
									newLog = new Date() + " " + money + " �����ŷ� ��� \t( ����� : " + newAccount.getDept() + " )\n";
									newLog = newLog + newAccount.getLog();
									newAccount.setLog(newLog);
									if (!offer[bank].updateDatabase(newAccount)) {
										return 2;
									}
									return 2;
								}								
							}
						} else {
							return 2;
						}
					}
					newAccount.setBalance(newAccount.getBalance() + money);
					String tempLog = new Date() + " " + money + " �Ա� " + account.getBank() + " "
							+ account.getAccountNumber() + "\t( �ܾ� : " + newAccount.getBalance() + " )\n";
					System.out.println(tempLog);
					tempLog = tempLog + newAccount.getLog();
					newAccount.setLog(tempLog);
					if (!offer[temp_bank].updateDatabase(newAccount)) {
						return 2;
					}
					offer[bank].readDatabase(account);
					account.setBalance(account.getBalance() - money);
					String newLog = new Date() + " " + money + " �۱� " + newAccount.getBank() + " "
							+ newAccount.getAccountNumber() + "\t( �ܾ� : " + account.getBalance() + " )\n";
					newLog = newLog + account.getLog();
					account.setLog(newLog);					
					if (offer[bank].updateDatabase(account)) {
						return 0;
					} else {
						newAccount.setBalance(newAccount.getBalance() + money);
						tempLog = new Date() + " " + money + " �����ŷ� ��� " + account.getBank() + " "
								+ account.getAccountNumber() + "\t( �ܾ� : " + newAccount.getBalance() + " )\n";
						System.out.println(tempLog);
						tempLog = tempLog + newAccount.getLog();
						newAccount.setLog(tempLog);
						if (!offer[temp_bank].updateDatabase(newAccount)) {
							return 2;
						}
						return 2;
					}
				}
			} else {
				return 2;
			}
		}
		return 2;
	}

	public int exchange(int money, String str) {
		String[] list_bank = { "��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��" };
		int bank;
		for(bank = 0; bank < list_bank.length; bank++) {
			if(list_bank[bank].equals(account.getBank()))
				break;
		}
		int[] exchangeRate = { 1100, 1000, 1280, 200 };
		String[] country = { "USD", "JPY", "EUR", "CNY" };
		int i;
		int won;
		for (i = 0; i < 4; i++) {
			if (str.equals(country[i]))
				break;
		}
		if (this.account.getBalance() < (won = money * exchangeRate[i])) {
			return 1;
		} else {
			account.setBalance(account.getBalance() - won);
			String newLog = new Date() + " " + won + "�� �� " + money + str + "�� ȯ�� " + "\t( �ܾ� : " + account.getBalance()
					+ " )\n";
			newLog = newLog + account.getLog();
			account.setLog(newLog);
			if (offer[bank].updateDatabase(account)) {
				return 0;
			} else {
				return 2;
			}
		}
	}

	public int loan(int money) {
		String[] list_bank = { "��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��" };
		int bank;
		for(bank = 0; bank < list_bank.length; bank++) {
			if(list_bank[bank].equals(account.getBank()))
				break;
		}
		if (account.getLimit() < account.getDept() + money) {
			return 7;
		} else {
			offer[bank].readDatabase(account);
			account.setDept(account.getDept() + money);
			String newLog = new Date() + " " + money + " ���� " + "\t( ���� �ѵ� : "
					+ (account.getLimit() - account.getDept()) + " )\n";
			newLog = newLog + account.getLog();
			account.setLog(newLog);
			if (offer[bank].updateDatabase(account)) {
				return 0;
			} else {
				return 2;
			}
		}
	}

	public void takeCharge(Account account) {
		account.setBalance(account.getBalance() - 1300);
		String newLog = new Date() + " 1300" + " ������ \t( �ܾ� : " + account.getBalance() + " )\n" + account.getLog();
		account.setLog(newLog);
	}

	public int depositWithoutBank(int money) {
		return deposit(money);
	}

	public String checkBalance() {
		return this.account.getLog();
	}

	public int payUtilityBill(Account newAccount) {
		String[] list_bank = { "��������", "�������", "��������", "��������", "��Ƽ����", "�츮����", "�ѱ�����", "�Ｚī��", "����ī��", "�Ե�ī��" };
		int bank;
		for(bank = 0; bank < list_bank.length; bank++) {
			if(list_bank[bank].equals(account.getBank()))
				break;
		}
		if (offer[bank].checkValid(account)) {
			int money = newAccount.getBalance();
			if ((this.errorType = offer[bank].readDatabase(account)) != 0) {
				return 2;
			}
			if ((account.getBank().equals("��������") && account.getBalance() < money)
					|| (!account.getBank().equals("��������") && account.getBalance() < money + 1300)) {
				return 1;
			} else if(newAccount.getBalance() == 0) {
				return 9;
			} else {				
				newAccount.setBalance(newAccount.getBalance() - money);
				String tempLog = new Date() + " " + money + " �����ݳ��� " + account.getBank() + " "
						+ account.getAccountNumber() + "\t( �ܾ� : " + newAccount.getBalance() + " )\n";
				tempLog = tempLog + newAccount.getLog();
				newAccount.setLog(tempLog);
				if (!offer[6].updateDatabase(newAccount)) {
					return 2;
				}
				if (!account.getBank().equals("��������"))
					this.takeCharge(account);
				offer[bank].readDatabase(account);
				account.setBalance(account.getBalance() - money);
				String newLog = new Date() + " " + money + " �����ݳ��� " + newAccount.getBank() + " "
						+ newAccount.getAccountNumber() + "\t( �ܾ� : " + account.getBalance() + " )\n";
				newLog = newLog + account.getLog();
				account.setLog(newLog);				
				if (offer[bank].updateDatabase(account)) {
					return 0;
				} else {
					return 2;
				}
			}
		} else {
			return 2;
		}
	}
}
