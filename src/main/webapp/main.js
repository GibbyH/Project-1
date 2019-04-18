window.onload = () => {
	getEmps();
}

const getEmps = () => {
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let response = JSON.parse(xhr.responseText);
			console.log(response);
			populateEmps(response);
		}
	};
	xhr.open("GET", "http://localhost:4213/Reimbursements/GetEmpServlet", true);
	xhr.send();
}

const populateEmps = (listOfEmps) => {
	
	for(let emp of listOfEmps){
		const tdId = document.createElement("td");
		const tdLastName = document.createElement("td");
		const tdFirstName = document.createElement("td");
		const tdEmail = document.createElement("td");
		const tdPass = document.createElement("td");
		const tdManagerId = document.createElement("td");

		tdId.textContent = emp.empId;
		tdLastName.textContent = emp.lastName;
		tdFirstName.textContent = emp.firstName;
		tdEmail.textContent = emp.email;
		tdPass.textContent = emp.pass;
		tdManagerId.textContent = emp.managerId;

		const row = document.createElement("tr");

		row.appendChild(tdId);
		row.appendChild(tdLastName);
		row.appendChild(tdFirstName);
		row.appendChild(tdEmail);
		row.appendChild(tdPass);
		row.appendChild(tdManagerId);

		document.getElementById("empTable").appendChild(row);
	}
}




