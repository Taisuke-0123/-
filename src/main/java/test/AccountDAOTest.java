package test;

import java.time.LocalDate;

import dao.AccountsDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {
	public static void main (String[]args) {
		testFindLoginOK();//ユーザーが見つかる場合のテスト
		testFindLoginNG();//ユーザーが見つからない場合のテスト
	}
	public static void testFindLoginOK() {
		Login login = new Login("Taisuke","0123");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if(result != null &&
		   result.getUserId().equals("Taisuke") &&
		   result.getPass().equals("0123") &&
		   result.getPetName().equals("こあ") &&
		   result.getAnimals().equals("犬") &&
		   result.getPetBd().equals(LocalDate.of(2023,07,05))){
		 System.out.println("testFindByLoginOK:成功しました");
		}else{
		 System.out.println("testFindByLoginOK:失敗しました");
		}
	}
	public static void testFindLoginNG() {
		Login login = new Login("Taisuke","12345");
		AccountsDAO dao = new AccountsDAO();
		Account result = dao.findByLogin(login);
		if (result == null) {
			System.out.println("testFindByLoginNG:成功しました");
		}else{
			System.out.print("testFindByLoginNG:失敗しました");
		}
		
	}

}
