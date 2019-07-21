function onRegisterButtonClicked() {
    const regFormEl = document.forms['reg-form'];

    const emailInputEl = regFormEl.querySelector('input[name="email"]');
    const passwordInputEl = regFormEl.querySelector('input[name="password"]');
    const nameInputEl = regFormEl.querySelector('input[name="name"]');

    const email = emailInputEl.value;
    const password = passwordInputEl.value;
    const name = nameInputEl.value;

    const params = new URLSearchParams();
    params.append('email', email);
    params.append('password', password);
    params.append('name', name);
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onRegisterResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'register');
    xhr.send(params);
}

function onRegisterResponse() {
    if (this.status === OK) {
        showContents(['login-content']);
    } else {
        onOtherResponse(schedulesContentDivEl, this);
    }
}

function showRegisterDiv() {
    showContents(['reg-content']);

}