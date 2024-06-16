var warningTimeout = 50000;
var timoutNow = 50000;
var warningTimerID,timeoutTimerID;
var logoutUrl = 'index'; // URL to logout page.

function startTimer() {
    // window.setTimeout returns an Id that can be used to start and stop a timer
    warningTimerID = window.setTimeout(warningInactive, warningTimeout);
}

function warningInactive() {
    window.clearTimeout(warningTimerID);
    timeoutTimerID = window.setTimeout(IdleTimeout, timoutNow);
}

function resetTimer() {
    window.clearTimeout(timeoutTimerID);
    window.clearTimeout(warningTimerID);
    startTimer();
}

// Logout the user.
function IdleTimeout() {
    signOut();
    alert("Zostałeś wylogowany, z powodu braku aktywności.");
}

function setupTimers () {
    document.addEventListener("mousemove", resetTimer, false);
    document.addEventListener("mousedown", resetTimer, false);
    document.addEventListener("keypress", resetTimer, false);
    document.addEventListener("touchmove", resetTimer, false);
    document.addEventListener("onscroll", resetTimer, false);
    startTimer();
}

function signOut() {
    // Create a form element
    var form = document.getElementById("LogOutForm")

    // Submit the form
    form.submit();
}


$(document).on('click','#btnStayLoggedIn',function(){
    resetTimer();
});

$(document).ready(function(){
    setupTimers();
});