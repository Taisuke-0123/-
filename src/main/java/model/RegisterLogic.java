package model;

import java.time.LocalDate;

import dao.AccountsDAO;

public class RegisterLogic {
	public void saveData(String userId, String pass, String petName, String animals, LocalDate petBd) {
		
		AccountsDAO dao = new AccountsDAO();
        dao.saveToDatabase(userId, pass, petName, animals, petBd);
	}

}
