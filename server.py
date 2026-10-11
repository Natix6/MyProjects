import requests

data = requests.get("https://jsonplaceholder.typicode.com/users/1")
data_json = data.json()
print(data_json["username"] + " " + data_json["email"])