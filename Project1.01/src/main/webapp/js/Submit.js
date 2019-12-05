/**
 * 
 */

let buttonOne = document.getElementById('ticketSubmit');
buttonOne.addEventListener('click', getPDF);

function getPDF() {
	console.log("here");
	pdf.text(10, 10, `yay this is a pdf`);
	pdf.save();
}