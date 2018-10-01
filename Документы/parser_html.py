from bs4 import BeautifulSoup
from urllib2 import urlopen
 
html_doc = urlopen('http://python-3.ru').read()
soup = BeautifulSoup(html_doc)
 
print (soup)