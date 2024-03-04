package com.bufigol.controladores;

import com.bufigol.modelo.Usuario;

public interface CON_Usuarios {

	public static Usuario login(String nick, String pwd) {
		if (CON_BBDD.USR_Exist(nick)) {
			if (CON_BBDD.checkPassword(nick, pwd)) {
				return CON_BBDD.GET_USR_INFO(nick);
			}
		}
		return null;
	}
}
