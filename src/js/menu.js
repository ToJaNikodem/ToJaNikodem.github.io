document.getElementById("hamburger").addEventListener("click", showMenu);

const menu = document.getElementById("menu");
const hamburger = document.getElementById("hamburger");

function showMenu() {
	menu.classList.toggle("active");
	hamburger.classList.toggle("active");
}

window.onclick = function (event) {
	if (!event.target.matches("span") || !event.target.matches("#hamburger")) {
		if (
			menu.classList.contains("active") &&
			hamburger.classList.contains("active")
		) {
			menu.classList.remove("active");
			hamburger.classList.remove("active");
		}
	}
};

document.getElementById("menu").addEventListener("click", function (event) {
	event.stopPropagation();
});