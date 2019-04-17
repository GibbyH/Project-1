

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
	
	let xhr = new XMLHttpRequest();
	

	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let response = JSON.parse(xhr.responseText);
			console.log(response);
		}
	};
	xhr.open("GET", "http://localhost:4213/Reimbursements/GetEmpServlet", true);
	xhr.send();
}

