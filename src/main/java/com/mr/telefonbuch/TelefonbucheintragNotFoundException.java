package com.mr.telefonbuch;

class TelefonbucheintragNotFoundException extends RuntimeException {

	TelefonbucheintragNotFoundException(Long id) {
		super("Telefonbucheintrag nicht gefunden " + id);
	}
}
