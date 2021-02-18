//variable
const form = document.querySelector(".js-form"),
input = form.querySelector("input"),
greeting = document.querySelector(".js-greetings");

const USER_LS = "currentUser",SHOWING_CN = "showing"

const noNeeds = "noNeeds";

//function
function saveName(text){
    localStorage.setItem(USER_LS, text);
}

function handleSubmit(event){
    event.preventDefault();//default로 설정되어있는 이벤트(새로고침)를 방지해줌.
    const currentValue = input.value;
    paintGreeting(currentValue);
    saveName(currentValue);
}

function askForName(){
    form.classList.add(SHOWING_CN);
    form.addEventListener("submit", handleSubmit)
}

function paintGreeting(text){
    form.classList.remove(SHOWING_CN);
    greeting.classList.add(SHOWING_CN);
}

function loadName(){
    const currentUser = localStorage.getItem(USER_LS);
    if(currentUser === null){
            askForName();
        }else {
            paintGreeting(currentUser);
        }
}


//init function
function init(){
    loadName();
}

init();

