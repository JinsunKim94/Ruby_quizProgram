'use strict'
const abnormal = document.querySelector('.abnormal');
abnormal.addEventListener('click', event =>{
    const abnormalRect = abnormal.getBoundingClientRect();
    console.log(abnormalRect);
    console.log(`client = ${event.clientX}, ${event.clientY}`);
    console.log(`page = ${event.pageX}, ${event.pageY}`);
});

const scrollBy = document.querySelector('.scroll__by');
const scrollTo = document.querySelector('.scroll__to');
const scrollAbnormal = document.querySelector('.scroll__abnormal');
scrollBy.addEventListener('click', event => {
    window.scrollBy({top:100, left:0, behavior: 'smooth'});//100px씩 부드럽게
});
scrollTo.addEventListener('click', event => {
    window.scrollTo(0, 100);//100px인 곳으로
});
scrollAbnormal.addEventListener('click', event => {
    window.scrollTo(8, 800);
});