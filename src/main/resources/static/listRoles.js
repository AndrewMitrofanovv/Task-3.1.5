function listRoles(user) {
    let rolesList = document.createElement('ul');

    for (let i = 0; i < user.roles.length; i++) {
        let role = document.createElement('li');
        role.textContent = user.roles[i].name.substring(5) + " ";
        rolesList.appendChild(role);
    }

    return rolesList;
}