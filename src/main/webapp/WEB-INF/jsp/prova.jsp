<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat WebSocket</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/prova.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script type="text/javascript">

        var stompClient = null;
        var id;

        function setChatID(idpass){

            id = idpass;
            console.log(id)
            connect();
        }

        function setConnected(connected) {
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility
                = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            disconnect();
            let socket = new SockJS("/CheckString/chat/" + id );
            stompClient = Stomp.over(socket);
            console.log(stompClient)

            stompClient.connect({}, function(frame) {
                console.log("sono qui")
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/messages/' + id, function(messageOutput) {
                    showMessageOutput(JSON.parse(messageOutput.body));
                });
            });
        }

        function disconnect() {
            if(stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }

        function sendMessage() {
            var from = "`${nome_user}`";
            var text = document.getElementById('text').value;
            stompClient.send("/app/chat/" + id, {},
                JSON.stringify({'from':from, 'text':text}));
        }

        function showMessageOutput(messageOutput) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(messageOutput.from + ": "
                + messageOutput.text + " (" + messageOutput.time + ")"));
            response.appendChild(p);
        }
    </script>
</head>
<body onload="disconnect()">
<div>
    <div>
    </div>
    <br />
    <div>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">
            Disconnect
        </button>
    </div>
    <br />
    <div id="conversationDiv">
        <input type="text" id="text" placeholder="Write a message..."/>
        <button id="sendMessage" onclick="sendMessage();">Send</button>
        <p id="response"></p>
    </div>
    <div id="chat-background">
        <c:forEach var="chat" items="${chats}">
            <div  >
                <span>${chat.user1 eq nome_user ? chat.user2 : chat.user1}</span>
                <button onclick="setChatID(`${chat.id}`)">Chatta</button>
            </div>
            </c:forEach>
    </div>
</div>

</body>
</html>