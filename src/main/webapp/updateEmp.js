window.onload = () => {
	document.getElementById("updateEmp").addEventListener("click", updateEmp);
}

const updateEmp = () => {
	const xhr = new XMLHttpRequest();
	const updateEmpFormData = parseUpdateEmpForm();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	
	xhr.open("POST", "http://localhost:4213/Reimbursements/UpdateEmpServlet");
	xhr.send(JSON.stringify(updateEmpFormData));
}

const parseUpdateEmpForm = () => {

	const empIdText = document.getElementById("empId").value;
	const lastNameText = document.getElementById("lastName").value;
	const firstNameText = document.getElementById("firstName").value;
	const emailText = document.getElementById("email").value;
	const passwordText = document.getElementById("password").value;
	const managerIdText = document.getElementById("managerId").value;

	return {
		lastName: lastNameText,
		firstName: firstNameText,
		email: emailText,
		pass: passwordText,
        managerId: managerIdText,
        empId: empIdText
	}
}