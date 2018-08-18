# Networking-offline-1-git
Here I have implemented socket programming.

Server side :
Server serves the answer file when exam starts. It keeps track of exam time.

Client side:
After every predefined interval client sends the the answer file to server using socket. So that even if the client lose the answer file (for example s/he has deleted the question file) s/he can again get the latest saved answer file from the server.
