$(function() {
	'use strict'
	$('.grade').each(function() {
		var value = $(this).text()
		var color;

		if (value >= 7) {
			color = '#00ff00';
		}
		if (value < 7 && value >= 5) {
			color = '#ffff00';
		}
		if (value < 5) {
			color = '#ff0000';
		}

		$(this).css('background', color);
	});
});