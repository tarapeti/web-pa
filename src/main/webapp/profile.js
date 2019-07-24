function onProfileLoad(user) {
    clearMessages();
    if (user.role === true){
        showContents(['profile-content', 'topnav', 'pro-content']);

    } else{
        showContents(['profile-content', 'topnav']);
    }

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