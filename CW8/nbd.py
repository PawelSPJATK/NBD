import requests
import json
url = 'http://localhost:8098/buckets/s21995/keys/1'
headers = {'Content-Type': 'application/json'}
beer = {
    "nazwa": "Double India Pale Ale",
    "styl": "DIPA",
    "BLG": 18.1,
    "ALK": 7.5
}

r = requests.put(data=json.dumps(beer), url=url, headers=headers)

r = requests.get('http://localhost:8098/buckets/s21995/keys/1')

print("Added: " + r.text)

data = json.loads(r.text)
data['BLG'] = 20

r = requests.put(data=json.dumps(data), url=url, headers=headers)
r = requests.get('http://localhost:8098/buckets/s21995/keys/1')

print("Modified: " + r.text)

r= requests.delete(data=json.dumps(data), url=url, headers=headers)

r = requests.get('http://localhost:8098/buckets/s21995/keys/1')

print("Deleted: " + r.text)
