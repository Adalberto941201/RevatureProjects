let buttonOne = document.getElementById('logOut');
buttonOne.addEventListener('click', logOutFunc);

function logOutFunc() {
	if (confirm('Are you sure you want to logout? You will be redirected to the main login page.')) {
		document.getElementById("logOut").href = "http://localhost:9001/Project1Sadie/Login.html";
		window.location.replace("Login.html");
        // or
        window.location.href = "/Login.html";
	} else {
		alert('you chose to stay logged in');
	}
}
