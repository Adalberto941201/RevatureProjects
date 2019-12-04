/**
 * 
 */

/*
 * Login page
 */
let buttonOne = document.getElementById('log');
buttonOne.addEventListener('click', logFunc);
let buttonTwo = document.getElementById('create');
buttonTwo.addEventListener('click', createFunc);
function logFunc() {
	console.log("hi");
}
function createFunc() {
	window.location.href = "http://localhost:9001/Project1Sadie/create.html";
}

let buttonThree = document.getElementById('createA');
buttonThree.addEventListener('click', successFunc);

function successFunc() {
	console.log("hi");
	// make an image populate and take over whole page to say success waiting for
	// email
}


//home access
window.onload = function() {
	getUserInfo();
}

function getUserInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = fucntion()
	{
		if (xhttp.readyState == 4 && xhttp.status == 200) {
		}
		let user = JSON.parse(xhtttp.responseText);
		setValues(user);
	}
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/Home.do', true);
	xhttp.send();
}

function setValues(user){
	document.getElementById("username").innerHTML = "Employee's username" + user.username;
	document.getElementById("password").innerHTML = "Employee's password" + user.password;
	document.getElementById("fName").innerHTML = "Employee's username" + user.fName;
	document.getElementById("lName").innerHTML = "Employee's password" + user.lName;
	document.getElementById("email").innerHTML = "Employee's username" + user.email;
	document.getElementById("userRole").innerHTML = "Employee's password" + user.userRole;
}

