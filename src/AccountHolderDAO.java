import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//jdbc code to insert data
public class AccountHolderDAO {

	public static boolean insertDataToDb(AccountHolder accountHolder) {
		try {
		
		//create connection
		Connection connection = ConnectionProvider.createConnection();
		
		//create statement
		String queryString = "INSERT INTO bank(account_number, acc_holder_name, branch, balance) VALUES(?,?,?,?)";
		
		
		PreparedStatement preparedStatement = connection.prepareStatement(queryString);
		preparedStatement.setInt(1, accountHolder.getAccountNumber());
		preparedStatement.setString(2, accountHolder.getAccountHolderName());
		preparedStatement.setString(3, accountHolder.getBranchName());
		preparedStatement.setInt(4, accountHolder.getBalance());
			
		preparedStatement.executeUpdate();
		return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
				
	}

	public static boolean deleteDataFromDb(int num) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionProvider.createConnection();
		String queryString = "DELETE FROM bank WHERE account_number = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, num);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}

	public static void showDB() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionProvider.createConnection();
		String queryString = "SELECT * FROM bank";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int n = resultSet.getInt("account_number");
				String nameString = resultSet.getString("acc_holder_name");
				String branchString = resultSet.getString("branch");
				int balance = resultSet.getInt("balance");
				
				System.out.println("account number " +n);
				System.out.println("name : " +nameString);
				System.out.println("branch name : "+ branchString);
				System.out.println("balance is : "+balance);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static boolean creditAmount(int acc, int amount) {
		Connection connection = ConnectionProvider.createConnection();
		
		try {
			String queryString = "UPDATE bank SET balance = balance + ? WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, amount);
			preparedStatement.setInt(2, acc);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		// TODO Auto-generated method stub
		
	}

	public static boolean debitAmount(int acc, int amount) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionProvider.createConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String queryString = "UPDATE bank SET balance = balance - ? WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, amount);
			preparedStatement.setInt(2, acc);
			preparedStatement.executeUpdate();
			if(issuf(connection, acc, amount)) {
				System.out.println("transaction completed");
				connection.commit();
			}else {
				System.out.println("transation failed");
				connection.rollback();
			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
static boolean issuf(Connection connection, int cn, double amount) {
		
		try {
			
		
			String qString ="SELECT balance FROM bank WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(qString);
			preparedStatement.setInt(1, cn);
			
			ResultSet resultset = preparedStatement.executeQuery();
			
			if(resultset.next()) {
				double b = resultset.getDouble("balance");
				if(amount >b) {
					return false;
				}
				return true;
			}
		}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return false;
	
	}

}
