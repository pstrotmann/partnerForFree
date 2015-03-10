package org.strotmann.benutzer

import org.springframework.dao.DataIntegrityViolationException
import org.strotmann.benutzer.Benutzer;

class BenutzerController {

    def scaffold = true
	
	def login() {
		if (request.get) {
			return // render the login view
		}
		def u = Benutzer.findByName(params.name)
		if (u) {
			if (u.passwort == params.passwort) {
				session.user = u
				redirect(uri: "/menu", params: [lang: u.sprache])
			}
			else {
				flash.message = "Passwort falsch"
				render(view: "login")
			}
		}
		else {
			flash.message = "User unbekannt"
			flash.name = params.name
			render(view: "login")
		}
	}
	
}
