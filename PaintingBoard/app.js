'use strict'
const canvas = document.getElementById("jsCanvas");

let painting = false;

function stopPainting(){
    painting = false;
}

function onMouserEnter(event){
    const x = event.offsetX;
    const y = event.offsetY;
    console.log(x,y);
}

function onMouseDown(event){
    painting = true;
}

function onMouseUp(event){
    stopPainting();
}


if(canvas){
    canvas.addEventListener("mousemove", onMouserEnter);
    canvas.addEventListener("mousedown", onMousedown);
    canvas.addEventListener("mouseup", onmouseup);
    canvas.addEventListener("mouserleave", onmouseleave);
}