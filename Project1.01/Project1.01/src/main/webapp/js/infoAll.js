/**
 * 
 */
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

window.onload = function() {
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/accounts.do', true);
	xhttp.send();
	getAccountsInfo();
}

//let buttonOne = document.getElementById("btn");
//buttonOne.addEventListener('click', getPastTicketInfo);

function getAccountsInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log(xhttp.responseText);
			let accounts = JSON.parse(xhttp.responseText);
			console.log("finished let");
			console.log(accounts.reimb_ID);
			setValues(accounts);
			console.log("hello were a in after set values");
		}
	}

	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/accountsGrab.do',
			true);
	xhttp.send();
}

function setValues(accounts) {
	var table = document.createElement('table');
	table.setAttribute("class", "table table-striped table-dark");
	var tr = document.createElement('tr');
	var td1 = document.createElement('td');
	var td2 = document.createElement('td');
	var td3 = document.createElement('td');
	var td4 = document.createElement('td');
	var td5 = document.createElement('td');
	var td6 = document.createElement('td');
	var td7 = document.createElement('td');
	var text1 = document.createTextNode("Employee ID");
	var text2 = document.createTextNode("First Name");
	var text3 = document.createTextNode("Last Name");
	var text4 = document.createTextNode("Username");
	var text5 = document.createTextNode("Password");
	var text6 = document.createTextNode("Email");
	var text7 = document.createTextNode("Role ID");
	td1.appendChild(text1);
	td2.appendChild(text2);
	td3.appendChild(text3);
	td4.appendChild(text4);
	td5.appendChild(text5);
	td6.appendChild(text6);
	td7.appendChild(text7);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	tr.appendChild(td7);
	table.appendChild(tr);

	for (i = 0; i < accounts.length; i++) {
		let date = new Date(accounts[i].reimb_SUBMITTED);
		let date2 = new Date(accounts[i].reimb_RESOLVED);
		var tr = document.createElement('tr');
		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');
		var td6 = document.createElement('td');
		var td7 = document.createElement('td');
		var text1 = document.createTextNode(accounts[i].ers_USERS_ID);
		var text2 = document.createTextNode(accounts[i].user_FIRST_NAME);
		var text3 = document.createTextNode(accounts[i].user_LAST_NAME);
		var text4 = document.createTextNode(accounts[i].ers_USERNAME);
		var text5 = document.createTextNode(accounts[i].ers_PASSWORD);
		var text6 = document.createTextNode(accounts[i].user_EMAIL);
		var text7 = document.createTextNode(accounts[i].user_ROLE_ID_FK);

		td1.appendChild(text1);
		td2.appendChild(text2);
		td3.appendChild(text3);
		td4.appendChild(text4);
		td5.appendChild(text5);
		td6.appendChild(text6);
		td7.appendChild(text7);
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tr.appendChild(td7);
		table.appendChild(tr);
	}
	document.getElementById("tabletb").append(table);

}
