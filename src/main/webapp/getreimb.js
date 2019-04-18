window.onload = () => {
	getReimbs();
}

const getReimbs = () => {
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let response = JSON.parse(xhr.responseText);
			console.log(response);
			populateReimbs(response);
		}
	};
	xhr.open("GET", "http://localhost:4213/Reimbursements/GetReimbursementsServlet", true);
	xhr.send();
}

const populateReimbs = (listOfReimbs) => {
	
	for(let reimb of listOfReimbs){
		const tdRequestNum = document.createElement("td");
		const tdEmpId = document.createElement("td");
		const tdAmmount = document.createElement("td");
		const tdSubmitted = document.createElement("td");
		const tdStatus = document.createElement("td");
		
		tdRequestNum.textContent = reimb.requestNum;
		tdEmpId.textContent = reimb.empId;
		tdAmmount.textContent = reimb.amount;
		tdSubmitted.textContent = reimb.submitted;
		tdStatus.textContent = reimb.status;
		
		const row = document.createElement("tr");

		row.appendChild(tdRequestNum);
		row.appendChild(tdEmpId);
		row.appendChild(tdAmmount);
		row.appendChild(tdSubmitted);
		row.appendChild(tdStatus);
		
		document.getElementById("reimbTable").appendChild(row);
	}
}