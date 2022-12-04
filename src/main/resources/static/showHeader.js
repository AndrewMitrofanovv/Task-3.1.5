showHeader();

function showHeader() {
    fetch('http://localhost:8080/api/getAuthorizedUser')
        .then(response => response.json())
        .then(user => {
            document.getElementById("header_email").innerHTML = user.email;

            let rolesList = document.createElement('ul');
            for (let i = 0; i < user.roles.length; i++) {
                let role = document.createElement('li');
                role.textContent = user.roles[i].name.substring(5) + " ";
                rolesList.appendChild(role);
            }
            document.getElementById("header_roles").innerHTML = 'with roles: ' + rolesList.textContent;
        });
}