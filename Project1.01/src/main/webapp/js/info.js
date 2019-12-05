/**
 * Account information
 */

window.onload = function() {
	console.log('in this onload')
	getUserInfo();
}

function getUserInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log(xhttp.responseText);
			let user = JSON.parse(xhttp.responseText);
			setValues(user);
		}
	}
	
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/Home.do', true);
	xhttp.send();
}

function setValues(user) {
	document.getElementById("username").innerHTML = user.ers_USERNAME;
	document.getElementById("password").innerHTML = user.ers_PASSWORD;
	document.getElementById("fName").innerHTML = user.user_FIRST_NAME;
	document.getElementById("lName").innerHTML = user.user_LAST_NAME;
	document.getElementById("email").innerHTML = user.user_EMAIL;
	document.getElementById("roleId").innerHTML = user.user_ROLE_ID_FK;
	document.getElementById("employeeId").innerHTML = user.ers_USERS_ID;
	
}