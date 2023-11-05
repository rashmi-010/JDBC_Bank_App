import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome!!");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Press 1 to add account holder/s");
			System.out.println("Press 2 to delete account holder");
			System.out.println("Press 3 to display account holder");
			System.out.println("Press 4 to credit account");
			System.out.println("Press 5 to debit account");
			System.out.println("Press 6 to exit");
			
			
			int choice = sc.nextInt();
			
			if(choice ==1) {
				System.out.println("Enter account holder name");
				String nameString = sc.next();
				System.out.println("Enter branch name");
				String branchString = sc.next();
				System.out.println("Enter account number");
				int accountNumber = sc.nextInt();
				System.out.println("Enter balance");
				int balance = sc.nextInt();
				
				AccountHolder accountHolder = new AccountHolder(accountNumber, nameString, branchString, balance);
				System.out.println(accountHolder);
				boolean added = AccountHolderDAO.insertDataToDb(accountHolder);
				
				if(added) {
					System.out.println("account added successfully");
				}else {
					System.out.println("failed to add account");
				}
				
			}else if (choice ==2) {
				System.out.println("enter the acc no. to delete");
				int num = sc.nextInt();
				
				boolean deleted = AccountHolderDAO.deleteDataFromDb(num);
				if(deleted)
				{
					System.out.println("account deleted successfully");
				}else {
					System.out.println("failed to delete account");
				}
			}else if (choice==3) {
				AccountHolderDAO.showDB();
				
			}else if (choice==4) {
				System.out.println("enetr the acc number to credit");
				int acc = sc.nextInt();
				System.out.println("enetr the ammount to credit");
				int amount = sc.nextInt();
				boolean credited = AccountHolderDAO.creditAmount(acc, amount);
				if(credited)
				{
					System.out.println("account credited successfully");
				}else {
					System.out.println("failed to credit account");
				}
			}else if (choice==5) {
				System.out.println("enetr the acc number to debit");
				int acc = sc.nextInt();
				System.out.println("enetr the ammount to debit");
				int amount = sc.nextInt();
				boolean debited = AccountHolderDAO.debitAmount(acc, amount);
			}else if (choice==6) {
				break;
			}else {
				System.out.println("wrong choice!!");
			}
		}
		sc.close();
	}

}
