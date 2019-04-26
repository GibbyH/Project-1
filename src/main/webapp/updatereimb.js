window.onload = () => {
	document.getElementById("submit").addEventListener("click", updateReimb);
}

const updateReimb = () => {
	const xhr = new XMLHttpRequest();
	const updateReimbForm = parseCreateReimbForm();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	
	xhr.open("POST", "http://localhost:4213/Reimbursements/UpdateRimbServlet");
	xhr.send(JSON.stringify(updateReimbForm));
}

const parseCreateReimbForm = () => {

	const rqstText = document.getElementById("rqstId").value;
	const statusText = document.getElementById("status").value;
	
	return {
		requestNum: rqstText,
		status: statusText
	}
}