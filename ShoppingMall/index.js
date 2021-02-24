'use strict';
const hello = document.getElementById("test");

const DEFAULT_COLOR = "black";

function helloWorld(){
    const helloColor = document.getElementById("test");
    helloColor.style.color = DEFAULT_COLOR;
}

if(hello){
    hello.addEventListener("click", helloWorld);
}
