/**
 * 
 */

/*
 * pending employee account page
 */
window.onload = function() {
	document.getElementById('viewPendingE').addEventListener('click', getPending);
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
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/PendingE.html' + employeeId, true);
	xhttp.send();

}

function setValues(ticket) {

	document.getElementById("submissionDate").innerHTML = ticket.submissionDate
	document.getElementById("ticketNumber").innerHTML = ticket.ticketNumber
	document.getElementById("subjectOfTicket").innerHTML = ticket.subject
	document.getElementById("ticketDescription").innerHTML = ticket.ticketDescription

}

/*
 * past reimbursement employee account page
 */
window.onload = function() {
	document.getElementById('viewPastE').addEventListener('click', getAll);
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
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/PastReimbE.html' + employeeId, true);
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
 *view info employee
 */
window.onload = function() {
	document.getElementById('viewInfoE').addEventListener('click', getInfo);
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
	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/InfoE.html' + employeeId, true);
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
		document.getElementById("logOut").href  = "http://localhost:9001/Project1Sadie/Login.html";
	}
	else{
		alert('you chose to stay logged in');
	}
}

/*
 * Employee Dashboard
 */
//
//let buttonTwo= document.getElementById('submitRequests');
//buttonTwo.addEventListener('click', submitFunc);
//function submitFunc() {
//	console.log("hello i submit");
//	window.location.href = "http://localhost:9001/Project1Sadie/SubmitE.html";
//}
//let buttonThree= document.getElementById('viewPastE');
//buttonThree.addEventListener('click', viewPastFunc);
//function viewPastFunc() {
//	console.log("hello i vew");
//	window.location.href = "http://localhost:9001/Project1Sadie/PastReimbE.html";
//}
//
//let buttonFour= document.getElementById('viewPendingE');
//buttonFour.addEventListener('onclick', viewPendingFunc);
//function viewPendingFunc() {
//	console.log("hello i pending");
//	window.location.href = "http://localhost:9001/Project1Sadie/PendingReimbE.html";
//}
//
//let buttonFive= document.getElementById('viewInfoE');
//buttonFour.addEventListener('click', viewInfoFunc);
//function viewInfoFunc() {
//	console.log("hello i info");
//	window.location.href = "http://localhost:9001/Project1Sadie/InfoE.html";
//}