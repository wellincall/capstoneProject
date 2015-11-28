window.onload = function() {
	document.querySelector(".js-insert-field").addEventListener("click", function() {
		var field = document.querySelectorAll(".base-group")[0].innerHTML;
		var existingFields = document.querySelectorAll(".form-group").length;
		var htmlToBeAppended = field.replace(/__REPLACE/g, existingFields);
		var node = document.createElement("div");
		node.className = "form-group";
		node.innerHTML = htmlToBeAppended;
		document.querySelector(".fields-container").appendChild(node);
	});
};