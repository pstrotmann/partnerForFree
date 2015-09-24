package org.strotmann.benutzer

import org.strotmann.notiz.Notiz

class SecurityFilters {

    def filters = {
        loginCheck(controller: 'benutzer', action: 'login', invert: true) {
		    before = {
				if (controllerName == 'partner')
					return
				Benutzer u = appUser(controllerName)
				if (u) 
					session.user = appUser()
				if (!session.user ) 
					redirect(controller: "benutzer", action: "login")
            }
        }
    }
	
	Benutzer appUser(String ctrlName){
		Benutzer b = null
		def Notiz n = Notiz.find("from Notiz as n where n.notiztext = 'appUser'")
		if (n) {  
			if (Long.parseLong(n.referenz) > 0) {
				b = Benutzer.get(Long.parseLong(n.referenz))
				if (ctrlName == 'assets') 
					Notiz.executeUpdate("update Notiz n set n.referenz='0' where n.notiztext = 'appUser'")
			}
		}
		b
	}
}
