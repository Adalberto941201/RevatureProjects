/**
 * 
 */

/*
 * pending employee account page
 */
window.onload = function() {
	document.getElementById('viewPendingS').addEventListener('click', getPending);
}

function getPending() {
	let employeeId = document.getElementById('employeeId').value;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let ticket = JSON.parse(xhttp.responseText);
			console.log(ticket);
			setValues(ticket);
		}
	}
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/PendingS.html' + employeeId, true);
	xhttp.send();

}

function setValues(ticket) {

	document.getElementById("submissionDate").innerHTML = ticket.submissionDate
	document.getElementById("ticketNumber").innerHTML = ticket.ticketNumber
	document.getElementById("subjectOfTicket").innerHTML = ticket.subject
	document.getElementById("ticketDescription").innerHTML = ticket.ticketDescription

}

/*
 * past reimbursement finance manager account page
 */
window.onload = function() {
	document.getElementById('viewAllS').addEventListener('click', getAll);
}

function getAll() {
	let employeeId = document.getElementById('employeeId').value;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let ticket = JSON.parse(xhttp.responseText);
			console.log(ticket);
			setValues(ticket);
		}
	}
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/PastReimbS.html' + employeeId, true);
	xhttp.send();

}

function setValues(ticket) {

	document.getElementById("submissionDate").innerHTML = ticket.submissionDate
	document.getElementById("ticketNumber").innerHTML = ticket.ticketNumber
	document.getElementById("subjectOfTicket").innerHTML = ticket.subject
	document.getElementById("ticketDescription").innerHTML = ticket.ticketDescription
	document.getElementById("ticketStatus").innerHTML = ticket.status
}

/*
 *view info finance manager submits
 */
window.onload = function() {
	document.getElementById('viewInfoS').addEventListener('click', getInfo);
}

function getInfo() {
	let employeeId = document.getElementById('employeeId').value;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {

		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let info = JSON.parse(xhttp.responseText);
			console.log(info);
			setValues(info);
		}
	}
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/InfoS.html' + employeeId, true);
	xhttp.send();

}

function setValues(ticket) {

	document.getElementById("employeeId").innerHTML = info.employeeId
	document.getElementById("fName").innerHTML = ticket.fName
	document.getElementById("lName").innerHTML = ticket.lName
	document.getElementById("username").innerHTML = ticket.username
	document.getElementById("password").innerHTML = ticket.password
	document.getElementById("email").innerHTML = ticket.email
	document.getElementById("roleId").innerHTML = ticket.roleId
}

let buttonOne = document.getElementById('logOut');
buttonOne.addEventListener('click', logOutFunc);

function logOutFunc(){
	if(confirm('Are you sure you want to logout? You will be redirected to the main login page.')){
		window.location.href = "http://localhost:9001/Project1Sadie/Login.html";
	}
	else{
		alert('you chose to stay logged in');
	}
}
