// En timer som räknar ner. Appliceras på <p id="counter> i quiz.html
window.onload= function(){
    var seconds = 20;
    var el = document.getElementById('counter');
    
    function incrementSeconds() {
        seconds -= 1;
        el.innerText =  seconds + " seconds";
        if (seconds<1){
            window.location.href = "/quiz?answered=false";
        }
    }
    setInterval(incrementSeconds, 1000);
 }

 


