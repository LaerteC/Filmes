package dao;

import dao.implementacao.EM;

public class Transaction {
	
	public static void begin() {
		
		EM.getLocalEm().getTransaction().begin();
		
	}
	
	public static void commit() {
		
		EM.getLocalEm().getTransaction().commit();
		
	}
	
	public static void rollBack() {
		
		EM.getLocalEm().getTransaction().rollback();
		
	}
	
	public static boolean isActive() {
		
		return EM.getLocalEm().getTransaction().isActive();
		
	}

}
