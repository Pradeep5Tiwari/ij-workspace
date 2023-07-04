/*

Create a Node.js application printing Hello World

There are 3 steps involve in it
Step 1: We use 'require' directive to load the Node Js module.
Step 2: Create the server.js file which will listen to the client request
Step 3: Read request and return response.

Step 1:
var http = require("http");

Step 2:
server.js:
http.createServer( function(request, response) {
request.writeHead(200, {'Content-Type': 'text/plain'});
response.end('Hello Node!!! This is my first node js application');
}).listen(8081);

console.log('Server running at http://127.0.0.1:8081/');


Step 3:
Let us put Step 1 and Step 2 together in a file called main.js and start out http server as shown below.


var http = require("http");


http.create Server(function (request, response) {

	request.writeHead(200, {'Content-Type': 'text/plain'});

	response.end('Hello Node!!! This is my first node js application');
	}).listen(8081);

	console.log('server running at http://127.0.0.1:8081/');
})

************************************************************************************************************************
 This "server.js" which basically starts the application on port 3000 and then it just says "Welcome" when you access it
 from the browser

 This package.json file which contains this dependency for the express library that we use here to start the
 application. So, this is a super lean and simple and that's the application from which we are going to create a
 Docker-Image and start it as docker container.

  So, in the root of the application we are going to create a new file called "Dockerfile" and once you create file
  with this name you would see that in editor either the icon of the file comes with docker icon image picture or it
  will automatically shows the popup to install docker plugin.

  So, in this Dockerfile we are going to write the definition of how the image should be built from the application
  So, what does our application need is it needs a node installed because node should run our application.

  So, If I wanted to start my application locally for my terminal I would execute command "node server.js" to start the
  application so we need that node command available inside the image.
************************************************************************************************************************
  */

const express = require('express');
const app = express();

app.get('/', (request, response)=> {
response.send("Welcome to my first node js application");
});

app.listen(3000, function () {
console.log("Application listening on port 3000");
});


