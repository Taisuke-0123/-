package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Account;
import model.Login;

public class AccountsDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/ingestionChecker";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public Account findByLogin(Login login) {
		Account account = null;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e){
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			//SELECT文を準備
			String sql = "SELECT USER_ID,PASS,PET_NAME,ANIMALS,PET_BD FROM ACCOUNTS WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				//ユーザーが存在したらデータを取得
				//そのユーザーを表すAccountインスタンスを生成
				String userId = rs.getString("USER_ID").trim();
				String pass = rs.getString("PASS");
				String petName = rs.getString("PET_NAME");
				String animals = rs.getString("ANIMALS");
				LocalDate petBd = rs.getDate("PET_BD").toLocalDate();
				account = new Account(userId,pass,petName,animals,petBd);
			}				
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return account;
	}
	public void saveToDatabase(String userId, String pass, String petName, String animals, LocalDate petBd) {
        // ここでデータベースへの保存処理を実行
        // 使用するデータベースの種類に応じてJDBCやHibernate等を利用
		// JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }

        // データベースとの接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // INSERT文を準備
            String sql = "INSERT INTO ACCOUNTS (USER_ID, PASS, PET_NAME, ANIMALS, PET_BD) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
                // パラメータの設定
                pStmt.setString(1, userId);
                pStmt.setString(2, pass);
                pStmt.setString(3, petName);
                pStmt.setString(4, animals);
                pStmt.setDate(5, java.sql.Date.valueOf(petBd));

                // INSERT文を実行
                int result = pStmt.executeUpdate();

                if (result != 1) {
                    // INSERTが成功しなかった場合の処理
                    throw new SQLException("データの書き込みに失敗しました");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 例外処理を適切に行う
        }
    } 

}
