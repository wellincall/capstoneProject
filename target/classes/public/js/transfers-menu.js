window.onload = function() {
	var init = function () {
		document.querySelector(".received-container").classList.add("hidden");
		document.querySelector(".js-show-sent").parentNode.classList.add("active");
	};
	
	document.querySelector(".js-show-sent").addEventListener("click", function() {
		document.querySelector(".received-container").classList.add("hidden");
		document.querySelector(".sent-container").classList.remove("hidden");
		document.querySelector(".js-show-received").parentNode.classList.remove("active");
		document.querySelector(".js-show-sent").parentNode.classList.add("active");

	});
	document.querySelector(".js-show-received").addEventListener("click", function() {
		document.querySelector(".received-container").classList.remove("hidden");
		document.querySelector(".sent-container").classList.add("hidden");
		document.querySelector(".js-show-received").parentNode.classList.add("active");
		document.querySelector(".js-show-sent").parentNode.classList.remove("active");	
	});
	
	init();
};