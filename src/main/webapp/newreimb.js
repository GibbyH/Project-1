window.onload = () => {
	document.getElementById("createRqst").addEventListener("click", createReimb);
}

const createReimb = () => {
	const xhr = new XMLHttpRequest();
	const createReimbForm = parseCreateReimbForm();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	
	xhr.open("POST", "http://localhost:4213/Reimbursements/CreateReimbServlet");
	xhr.send(JSON.stringify(createReimbForm));
}

const parseCreateReimbForm = () => {

	const rqstText = document.getElementById("rqstId").value;
	const empIdText = document.getElementById("empId").value;
	const amountText = document.getElementById("amount").value;
	
	return {
		requestNum: rqstText,
		empId: empIdText,
		amount: amountText,
		submitted: Date.now,
		status: "pending"
	}
}