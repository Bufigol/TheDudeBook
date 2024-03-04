package com.bufigol.bbdd;

public class DDBB_Operations {

	private DDBB_Conection connection;
	
	public DDBB_Operations() {
		this.connection = new DDBB_Conection();
		this.connection.openConection();
		this.connection.closeConection();
	}

	public boolean USR_Exist(String nick) {
		// TODO Auto-generated method stub
		return false;
	}
}
