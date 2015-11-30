window.onload = function() {
	var init = function () {
		document.querySelector(".recieved-container").classList.add("hidden");
		document.querySelector(".js-show-sent").parentNode.classList.add("active");
	};
	
	document.querySelector(".js-show-sent").addEventListener("click", function() {
		document.querySelector(".recieved-container").classList.add("hidden");
		document.querySelector(".sent-container").classList.remove("hidden");
		document.querySelector(".js-show-recieved").parentNode.classList.remove("active");
		document.querySelector(".js-show-sent").parentNode.classList.add("active");

	});
	document.querySelector(".js-show-recieved").addEventListener("click", function() {
		document.querySelector(".recieved-container").classList.remove("hidden");
		document.querySelector(".sent-container").classList.add("hidden");
		document.querySelector(".js-show-recieved").parentNode.classList.add("active");
		document.querySelector(".js-show-sent").parentNode.classList.remove("active");	
	});
	
	init();
};