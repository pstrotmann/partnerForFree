package org.strotmann.benutzer

class SecurityFilters {

    def filters = {
        loginCheck(controller: 'benutzer', action: 'login', invert: true) {
		    before = {
				if (controllerName == 'partner')
					return
                if (!session.user) {
					redirect(controller: "benutzer", action: "login")
                }
            }
        }
    }
}
