/**
 * 
 */

let buttonTwo = document.getElementById('logOut');
buttonTwo.addEventListener('click', logOutFunc);

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

let buttonOne = document.getElementById("btn");
buttonOne.addEventListener('click', getPastTicketInfo);

function getPastTicketInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log(xhttp.responseText);
			let pastTicket = JSON.parse(xhttp.responseText);
			console.log("finished let");
			console.log(pastTicket.reimb_ID);
			setValues(pastTicket);
			console.log("hello were a in after set values");

		}
	}

	xhttp.open("GET", 'http://localhost:9001/Project1Sadie/pastTicketGrab.do',
			true);
	xhttp.send();
}

function setValues(pastTicket) {
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
	var td8 = document.createElement('td');
	var td9 = document.createElement('td');
	var text1 = document.createTextNode("ID #");
	var text2 = document.createTextNode("Amount #");
	var text3 = document.createTextNode("Submission Date");
	var text4 = document.createTextNode("Resolved Date");
	var text5 = document.createTextNode("Description");
	var text6 = document.createTextNode("Author");
	var text7 = document.createTextNode("Resolver");
	var text8 = document.createTextNode("Status");
	var text9 = document.createTextNode("Type");
	td1.appendChild(text1);
	td2.appendChild(text2);
	td3.appendChild(text3);
	td4.appendChild(text4);
	td5.appendChild(text5);
	td6.appendChild(text6);
	td7.appendChild(text7);
	td8.appendChild(text8);
	td9.appendChild(text9);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	tr.appendChild(td7);
	tr.appendChild(td8);
	tr.appendChild(td9);
	table.appendChild(tr);

	for (i = 0; i < pastTicket.length; i++) {
		let date = new Date(pastTicket[i].reimb_SUBMITTED);
		let date2 = new Date(pastTicket[i].reimb_RESOLVED);
		var tr = document.createElement('tr');
		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');
		var td6 = document.createElement('td');
		var td7 = document.createElement('td');
		var td8 = document.createElement('td');
		var td9 = document.createElement('td');
		var text1 = document.createTextNode(pastTicket[i].reimb_ID);
		var text2 = document.createTextNode(pastTicket[i].reimb_AMOUNT);
		var text3 = document.createTextNode(date.getMonth()+ "/" + date.getDay() + "/" + date.getFullYear());
		var text4 = document.createTextNode(date2.getMonth()+ "/" + date2.getDay() + "/" + date2.getFullYear());
		var text5 = document.createTextNode(pastTicket[i].reimb_DESCRIPTION);
		var text6 = document.createTextNode(pastTicket[i].reimb_AUTHOR_FK);
		var text7 = document.createTextNode( pastTicket[i].reimb_RESOLVER_FK);
		if (pastTicket[i].reimb_STATUS_ID_FK == 0) {
			text8 = document.createTextNode("Pending");
		} else if (pastTicket[i].reimb_STATUS_ID_FK == 1) {
			text8 = document.createTextNode("Approved");
		} else {
			text8 = document.createTextNode("Denied");
		}
		var text9;
		if (pastTicket[i].reimb_TYPE_ID_FK == 1) {
			text9 = document.createTextNode("Travel");
		} else {
			text9 = document.createTextNode("Supplies");
		}
		td1.appendChild(text1);
		td2.appendChild(text2);
		td3.appendChild(text3);
		td4.appendChild(text4);
		td5.appendChild(text5);
		td6.appendChild(text6);
		td7.appendChild(text7);
		td8.appendChild(text8);
		td9.appendChild(text9);
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tr.appendChild(td7);
		tr.appendChild(td8);
		tr.appendChild(td9);
		table.appendChild(tr);
	}
	 document.getElementById("tabletb").append(table);
	
}