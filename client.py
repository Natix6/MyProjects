import socket
import base64

HOST = "127.0.0.1"
PORT = 9999  


client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((HOST, PORT))
data = client.recv(1024)
hello = base64.b64decode(data)
print(hello)
