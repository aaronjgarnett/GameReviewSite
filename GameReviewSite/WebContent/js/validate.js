function validate() {
	'use strict';
	var password = document.getElementById('password').value, validPass = new RegExp(
			"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})"), passResult = validPass
			.test(password);

	if (passResult === false) {
		alert('Enter a valid password');
		return false;
	}
	return true;
};

function sendMessage() {
	'use strict';
	return alert('Thank you! Your message has been sent!');
};

function addGame() {
	'use strict';
	return alert('Game will be added to the database!');
};