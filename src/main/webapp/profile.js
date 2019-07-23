function onProfileLoad(user) {
    clearMessages();
    showContents(['profile-content', 'topnav']);

}

function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

function onBackToProfileClicked() {
    showContents(['profile-content', 'logout-content']);
}