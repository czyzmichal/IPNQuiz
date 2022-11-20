import requests
import yake
from bs4 import BeautifulSoup, SoupStrainer
import json

import xml.etree.ElementTree as ET
def getUrlsForMainPage():
    tree = ET.parse('sitemap.xml')
    root = tree.getroot()
    urls = []
    for child in root:
        for child1 in child:
            if 'loc' in child1.tag:
                urls.append(child1.text)
    return urls
def resultDiv(url):
    page = requests.get(url)
    soup = BeautifulSoup(page.content, "html.parser")
    return soup.find_all("div", {"class": "res-item"})


class IPNParser:
    def getLinks(self, phrase):
        resultText = ""
        if len(phrase.split(" ")) > 1:
            for text in phrase.split(" "):
                resultText = resultText + "+" + text
        else:
            resultText = phrase
        # url = "https://szukaj.ipn.gov.pl/search?q="+resultText+"&site=&site%5B%5D=pages_przystanek_historia&btnG=Szukaj&client=default_frontend&output=xml_no_dtd&proxystylesheet=default_frontend&sort=date%3AD%3AL%3Ad1&wc=200&wc_mc=1&oe=UTF-8&ie=UTF-8&ud=1&exclude_apps=1&tlen=200&size=10&doctype=WEB&filters=eyJXc3p5c3RraWVfc3Ryb255IjoxNjQyMCwicGFnZXNfcHJ6eXN0YW5la19oaXN0b3JpYSI6OTIwMCwicGFnZXNfcHdpcG4iOjI3MjgsInBhZ2VzX2lwbiI6ODEzLCJwYWdlc19wb3puYW5pcG4iOjUyMiwicGFnZXNfY2VudHJhbGFpcG5fZW4iOjM2NywicGFnZXNfa3NpZWdhcm5pYWlwbiI6MzUyLCJwYWdlc19rYXRvd2ljZWlwbiI6MzM4LCJwYWdlc19jZW50cnVtZWR1a2FjeWpuZSI6MjU5LCJwYWdlc19pcG5wb2N6eXRhaiI6MjU0LCJwYWdlc19lbmN5a2xvcGVkaWFfc29saWRhcm5vc2NpIjoyMDV9"
        url = (
            "https://szukaj.ipn.gov.pl/site/search?q="
            + resultText
            + "&site=&site%5B%5D=pages_przystanek_historia&btnG=Szukaj&client=default_frontend&output=xml_no_dtd&proxystylesheet=default_frontend&sort=date%3AD%3AL%3Ad1&wc=200&wc_mc=1&oe=UTF-8&ie=UTF-8&ud=1&exclude_apps=1&tlen=200&size=50"
        )
        results = resultDiv(url)
        resultsURLs = []
        for result in results:
            resultsURLs.append(result.find("a")["href"])
        return resultsURLs

    def getTextFromPDF(self, url):
        response = requests.get(url)
        my_raw_data = response.content
        texts = []
        with BytesIO(my_raw_data) as data:
            read_pdf = PyPDF2.PdfFileReader(data)
            for page in range(read_pdf.getNumPages()):
                texts.append(read_pdf.getPage(page).extractText())
        return texts

    def getTextsForWEB(self, url):
        page = requests.get(url)
        soup = BeautifulSoup(page.content, "html.parser")
        result = []
        for text in soup.find_all("p"):
            result.append(text.getText())
        return result

    def getKeyWordsForPhrase(self, phrase):
        links = getUrlsForMainPage()
        texts = []
        allTexts = ""
        for link in links:
            # print(link)
            if  ".pdf" not in link:
                texts += self.getTextsForWEB(link)

                
        for text in texts:
            if phrase in text.lower():
                allTexts = allTexts + " "+text
        language = "pl"
        max_ngram_size = 3
        deduplication_threshold = 0.8
        deduplication_algo = "seqm"
        windowSize = 5
        numOfKeywords = 10
        # print(allTexts)
        e = yake.KeywordExtractor(
            lan=language,
            n=max_ngram_size,
            dedupLim=deduplication_threshold,
            dedupFunc=deduplication_algo,
            windowsSize=windowSize,
            top=numOfKeywords, stopwords=None,
            features=None,
        )
        extract = e.extract_keywords(allTexts)
        extract = sorted(extract, key=lambda tup: tup[1])
        phrasesWithSentces = {}
        for extractedPhrase in extract:
            for sentence in allTexts.split("."):
                if extractedPhrase[0] in sentence:
                    if extractedPhrase[0] in phrasesWithSentces:
                        phrasesWithSentces[extractedPhrase[0]]["sentences"].append(
                            sentence.replace("\xa0", " ")
                        )
                    else:
                        phrasesWithSentces[extractedPhrase[0]] = {
                            "value": extractedPhrase[1],
                            "sentences": [sentence.replace("\xa0", " ")],
                        }

        dict(sorted(phrasesWithSentces.items(), key=lambda item: item[1]["value"]))
        result = {}
        for x in list(phrasesWithSentces)[0:10]:
            result[x] = phrasesWithSentces[x]["sentences"]
        with open(phrase+".json", "w") as outfile:
            json.dump(result, outfile)
        return result


# parser = IPNParser()
# phrasesWithSentces = parser.getKeyWordsForPhrase('piłsudski')
# print(phrasesWithSentces)
