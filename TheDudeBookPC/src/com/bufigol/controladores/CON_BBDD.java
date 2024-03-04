package com.bufigol.controladores;

import com.bufigol.bbdd.DDBB_Operations;
import com.bufigol.modelo.Usuario;

public interface CON_BBDD {

	public static boolean USR_Exist(String nick) {
		boolean out = false;
		DDBB_Operations ddbb = new DDBB_Operations();
		out = ddbb.USR_Exist(nick);
		return out;
	}

	public static boolean checkPassword(String nick, String pwd) {
		boolean out = false;
		return out;
	}

	public static Usuario GET_USR_INFO(String nick) {
		// TODO Auto-generated method stub
		return null;
	}
}
