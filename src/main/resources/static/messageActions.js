var messageBox = document.querySelector("#messageInBox")
setInterval(getMessages, 500)
messageBox.addEventListener('keyup', (e) => {
	if (event.keyCode === 13 ) {
        console.log(`In Channel id: ${channelId}`)
		const message = {
				"text": messageInBox.value,
				"channelId": channelId,
				"user": user,
				"createdDate": new Date()
		};
		let messageText = messageBox.value
		console.log(`Send message ${messageText}`)
		messageBox.value = ''
		fetch('/message', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json; charset=utf-8'
			},
			body: JSON.stringify(message)
		}).then(response => {getMessages()})
		return false
	}
})

function getMessages () {
	let messageArea = document.querySelector(".message-area")

	fetch(`/message/${channelId}`)
	.then(response => response.json())
	.then(messages => {
		messageArea.innerHTML = ''
		messages.forEach(message => {
		    console.log(`Sent message ${message.user.name}`)
			messageArea.innerHTML += `<div>
			  <span class="timestamp">${message.user.name}: </span>
		  	  <span class="message">${message.text}</span>
			</div>`
		})
	})

	const storedUser = JSON.parse(sessionStorage.getItem("user"));
    document.getElementById("userName").textContent = 'Logged In as: '+ storedUser["name"];
}