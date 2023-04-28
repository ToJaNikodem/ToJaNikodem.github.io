document.getElementById("hamburger").addEventListener("click", toggleMenu);

const menu = document.getElementById("menu");
const hamburger = document.getElementById("hamburger");

function toggleMenu() {
	menu.classList.toggle("active");
	hamburger.classList.toggle("active");
}

window.onclick = function (event) {
	console.log(event.target);
	if (!event.target.matches("#hamburger") && !event.target.closest("#hamburger")) {
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