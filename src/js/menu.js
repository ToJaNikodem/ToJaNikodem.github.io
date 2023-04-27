document.getElementById("hamburger").addEventListener("click", showMenu);

function showMenu() {
   document.getElementById("menu").classList.toggle("active");
   document.getElementById("hamburger").classList.toggle("active");
}
