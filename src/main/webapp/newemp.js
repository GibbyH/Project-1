window.onload = () => {
	document.getElementById("createEmp").addEventListener("click", createEmp);
}

const createEmp = () => {
	const xhr = new XMLHttpRequest();
	const createEmpFormData = parseCreateEmoForm();
	
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
		}
	}
	
	xhr.open("POST", "http://localhost:4213/Reimbursements/CreateEmpServlet");
	xhr.send(JSON.stringify(createEmpFormData));
}

const parseCreateEmoForm = () => {

	const empIdText = document.getElementById("empId").value;
	const lastNameText = document.getElementById("lastName").value;
	const firstNameText = document.getElementById("firstName").value;
	const emailText = document.getElementById("email").value;
	const passwordText = document.getElementById("password").value;
	const managerIdText = document.getElementById("managerId").value;

	return {
		empId: empIdText,
		lastName: lastNameText,
		firstName: firstNameText,
		email: emailText,
		pass: passwordText,
		managerId: managerIdText
	}
}