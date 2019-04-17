

function get(url) {
	return new Promise((resolve, reject) => {
		let xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					resolve(JSON.parse(xhr.response));
				}
				else {
					reject(Error("Looks like something went wrong!"));
				}
			}
		}

		xhr.open("GET", url);
		xhr.send();
	});
}

function getEmps() {
	let url = "http://http://localhost:4213/Reimbursements/GetEmpServlet"
	let str = ""
	let empTable = document.getElementById("empTable");
	let xhr = new XMLHttpRequest();
	let response;

	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			response = JSON.parse(xhr.responseText);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
	
	console.log(response);

	for (var i in response) {
		str += "<tr>"
			+ "<td>" + response[i].empId + "</td>"
			+ "<td>" + response[i].lastName + "</td>"
			+ "<td>" + response[i].firstName + "</td>"
			+ "<td>" + response[i].email + "</td>"
			+ "<td>" + response[i].pass + "</td>"
			+ "<td>" + response[i].managerId + "</td>"
			+ "</tr>";
	}
	empTable.innerHTML = str;
	
}