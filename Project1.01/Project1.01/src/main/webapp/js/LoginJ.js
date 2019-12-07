/**
 * Login page
 * create account link 
 * 
 */

/*
 * Login page
 */

let buttonTwo = document.getElementById('create');
buttonTwo.addEventListener('click', createFunc);

function createFunc() {
	window.location.href = "http://localhost:9001/Project1Sadie/create.html";
}