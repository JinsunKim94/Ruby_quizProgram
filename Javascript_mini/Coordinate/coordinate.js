'use strict'
const abnormal = document.querySelector('.abnormal');
const abnormalCoor = abnormal.getBoundingClientRect();

function abnormalCoordinate(abnormal){
    console.log(abnormalCoor);
    console.log(`client = ${abnormal.clientHeight}, ${abnormal.clientWidth}`);
    console.log(`page = ${window.pageXOffset}, ${window.pageYOffset}`);
}

abnormal.addEventListener('click', abnormalCoordinate(abnormal));