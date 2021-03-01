"use strict";
//Function 
// - fundamental building block in the program
// - performs a task or calculates a value

// 1. Function declaration
// function name(param1, param2) { body... return; }
// one function === one thing
// naming: doSomething, command, verb
// e.g. createCardAndPoint -> createCard, createPoint
// function is object in JS (function은 object의 일종이다.)
function printHello(){
    console.log('Hello');
}
printHello();

function log(message){
    console.log(message);
}
log('Hello@');
log(1234);

// 2. Parameters
// premitive parameters: passed by value
// object parameters: passed by reference
function changeName(obj){
    obj.name = 'coder';
}
const jinsun = { name: 'jinsun'};
changeName(jinsun);
console.log(jinsun);

// 3. Default parameters (added in ES6)
function showMessage(message, from = 'unknown'){
    /*if(from === undefined){
        from = 'unknown';
    } 프로그램이 undefined일 때를 대비해서 default 저장했음*/
    console.log('${message} by ${from}');
}
showMessage('Hi!');

// 4. Rest parameters (added in ES6)
function printAll(...args){// '...'는 배열 3칸
    for(let i = 0; i < args.length; i++){
        console.log(args[i]);
    }

    for(const arg of args){//args에 있는 모든 값들이 arg에 들어감
        console.log(arg);
    }

    args.forEach((arg) => console.log(arg));
}
printAll('dream', 'coding', 'ellie');

// 5. local scope
let globalMessage = 'global'; //global variable
function printMessage(){
    let message = 'hello';
    console.log(message); // local variable
    console.log(globalMessage);
    function printAnother(){
        console.log(message);
        let childMessage = 'hello';
    }
    console.log(childMessage);//에러발생
}
printMessage();

// 6. Return a value
function sum(a, b){
    return a + b;
}
const result = sum(1, 2); // 3
console.log(`sum: ${sum(1, 2)}`);//return 타입이 없는 함수는 return undefined가 들어가 있는 것과 같다.

// 7. Early return early exit
// bad
function upgradeUser(user){
    if(user.point > 10){
        // long upgrade logic...
    }
}

// good
function upgradeUser(user){
    if(user.point <= 10){
        return;//조건이 맞지 않을 때는 함수를 return으로 빨리 종료
    }
    // long upgrade logic...
}

// First-class function
// functions are treated like any other variable
// can be assigned as a value to variable
// can be passed as an argument to other functions.
// can be retruned by another function

// 1. Function expression 
// a function declaration can be called earlier than it is defined. (hoisted)
// a function expression is created when the execution reaches it.
const print = function (){ // anonymous function 
    console.log('print');// function declaration은 호이스팅이 가능
};
print();
const printAgain = print;
printAgain();
const sumAgain = sum;
console.log(sumAgain(1, 3));

// 2. Callback function using function expression
function randomQuiz(answer, printYes, printNo){
    if(answer === 'love you'){
        printYes();
    }else{
        printNo();
    }
}
// anonymous function
const printYes = function(){
    console.log('yes!');
};

// named function 
// better debugging in debugger's stack traces
// recursions
const printYes = function print(){
    console.log('no!');
    print();
    // 함수 안에서 자신을 호출하면 recursion이라서 프로그램이 죽어버린다.
};
randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo);

// Arrow function
// always anonymous
const simplePrint = function(){
    console.log('simplePrint!');
};
const simplePrint = () => console.log('simplePrint!');

const add = function(a, b) {
    return a + b;
};
const add = (a, b) => a + b;//한 줄 인 경우에는 블럭 없어도 된다.
const simpleMultiply = (a, b) => {
    // do something more
    return a * b;
};// 한 줄을 넘게 되면 블럭사용

// IIFE: Immediately Invoked Function Expression
(function hello(){
    console.log('IIFE');
})();// 바로 호출

// Quiz
// function calculate(command, a, b)
// command: add, substract, divide, multiply, remainer
function calculate(command, a, b){
    switch (command) {
        case 'add':
          return a + b;
        case 'substract':
          return a - b;
        case 'divide':
          return a / b;
        case 'multiply':
          return a * b;
        case 'remainder':
          return a % b;
        default:
          throw Error('unkonwn command');
    }
}
console.log(calculate('add', 2, 4));
