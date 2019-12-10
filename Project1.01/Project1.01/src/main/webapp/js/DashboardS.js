/**
 * Dashboard for finance manager
 * logout function
 * display name  
 */
//let buttonOne = document.getElementById('logOut');
//buttonOne.addEventListener('click', logOutFunc);
//
//function logOutFunc() {
//	if (confirm('Are you sure you want to logout? You will be redirected to the main login page.')) {
//		document.getElementById("logOut").href = "http://localhost:9001/Project1Sadie/Login.html";
//		window.location.replace("Login.html");
//        // or
//        window.location.href = "/Login.html";
//	} else {
//		alert('you chose to stay logged in');
//	}
//}
//
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
			console.log(user.ers_USERNAME);
			setValues(user);
		}
	}
	
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/Home.do', true);
	xhttp.send();
}

function setValues(user) {
	document.getElementById("fName").innerHTML = user.user_FIRST_NAME;
}
