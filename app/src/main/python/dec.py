import request
def backend(txt):
    txt=str(txt)
    url="https://api.dictionaryapi.dev/api/v2/entries/en/"+txt.lower()
    meaning=requests.get(url).json()
    return meaning[0]['meaning'][0]['definations'][0]['definations']