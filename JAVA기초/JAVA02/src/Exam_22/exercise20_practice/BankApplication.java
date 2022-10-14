package Exam_22.exercise20_practice;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("----------------------------------------");
			System.out.println("1.계좌생성| 2.계좌목록| 3.예금| 4.출금| 5.종료");
			System.out.println("----------------------------------------");
			System.out.println("선택> ");
			
			int selectNo = sc.nextInt();
			if(selectNo == 1) {
				createAccount();
				
			}
			else if(selectNo == 2) {
				accountList();
				
			}
			else if(selectNo == 3) {
				deposit();
			}
			else if(selectNo == 4) {
				withdraw();
			}
			else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}



	private static void createAccount() {
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");
		System.out.println("계좌번호: ");
		String ano = sc.next();
		System.out.println("계좌주: ");
		String owner = sc.next();
		System.out.println("초기입금액");
		int balance = sc.nextInt();
		
		int i;
		Account ac = new Account(ano,owner,balance);
		for(i = 0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i]=ac;
				break;
			}
		}
		System.out.println("결과: 계좌가 생성되었습니다.");
		
	}

	private static void accountList() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");
		
		int i;
		for(i=0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				break;
			}
			System.out.printf("%s \t %s \t %d \n", accountArray[i].getAno(), accountArray[i].getOwner()
					,accountArray[i].getBalance());
		}
		
	}


	private static void deposit() {
		System.out.println("--------");
		System.out.println("예금");
		System.out.println("--------");
		System.out.println("계좌번호: ");
		String ano = sc.next();
		Account ac = FindAccount(ano);
		System.out.println("예금액: ");
		int deposit = sc.nextInt();
		
		int currentBalance = ac.getBalance();
		int nextBalance = currentBalance + deposit;
		ac.setBalance(nextBalance);
		System.out.println("결과: 예금이 성공되었습니다."+ac.getBalance());
		
		
	}


	private static void withdraw() {
		System.out.println("--------");
		System.out.println("출금");
		System.out.println("--------");
		System.out.println("계좌번호: ");
		String ano = sc.next();
		Account ac = FindAccount(ano);
		System.out.println("출금액: ");
		int withdraw = sc.nextInt();
		
		int currentBalance = ac.getBalance();
		int nextBalance = currentBalance - withdraw;
		ac.setBalance(nextBalance);
		System.out.println("결과: 출금이 성공되었습니다."+ac.getBalance());
	}
	
	private static Account FindAccount(String ano) {
		int i;
		for(i=0; i<accountArray.length; i++) {
			if(ano.equals(accountArray[i].getAno())) {
				break;
			}
		}
		return accountArray[i];
	}

}
