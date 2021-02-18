const weather = document.querySelector(".js-weather");

const API_KEY = "f0244bcbc48e49ea5e1e951d3bc9e726";
const COORDS = 'coords';

function getWeather(lat, long){
    fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${long}&appid=${API_KEY}&units=metric`).then(function(JSON){
        console.log(Response);
        return Response.json();
    })
    .then(function(json){
        const temperature = json.main.temp;
        const place = json.name;
        weather.innerText = `${temperature} @ ${place}`;
    });
}

function saveCoorde(coordsObj){
    localStorage.setItem(COORDS, latitude, longitude)
}

function handleGeoSuccess(position){
    const latitude = position.coords.latitude;
    const longtitude =position.coords.longitude;
    const coordsObj = {
        latitude,
        longtitude
    };
    saveCoords(coordsObj);
    getWeather(latitude, longitude);
}

function handleGeoError(){
    console.log('Cant access geo location');
}

function askForCoods(){
    navigator.geolocation.getCurrentPosition(handleGeoSuccess, handleGeoError);
}

function loadCoords(){
    const loaderCords = localStorage.getItem(COORDS);
    if(loadCoords === null){
        askForCoods();
    }else{
        const parseCoords = JSON.parse(loadCoords);
        getWeather(parseCoords.latitude, parseCoords.longitude);
    }
}

function init(){

}
init();