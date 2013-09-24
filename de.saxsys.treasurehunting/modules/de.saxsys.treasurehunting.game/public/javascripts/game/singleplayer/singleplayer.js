/**
 * Initiates the web socket connection for single player mode.
 * 
 * @param url
 *            The url to connect the websocket with.
 */
function initializeSinglePlayerGame(url) {

	console.log("Initializing websocket with URL: "+url);
	
	var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket;
	var socket = new WS(url);
	
	var receiveEvent = function(event) {
		
		if(event.error) {
			socket.close();
			return
		}
		
		var responseAction = JSON.parse(event.data);
		
		initializeGame(responseAction);
	}
	
	socket.onmessage = receiveEvent;
}

/**
 * Initializes the single player game.
 * 
 * @param responseAction
 */
function initializeGame(responseAction) {
	// show response action
	console.log(responseAction);
}

/**
 * Cancels the game.
 */
function cancelGame() {
	
}

/**
 * Restarts the game.
 */
function restartGame() {
	
}

/**
 * Pauses the game.
 */
function pauseGame() {
	
}

/**
 * Resume a paused game.
 */
function resumeGame() {
	
}