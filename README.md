# MySearchEngine

Provide design description and major decisions

the designe description is in inside the code.

whice data structure to choose was a major decision,
choose two maps one map to save the document with keys as integer and value type String for the doc,
and the other map for the words, the word was the key and value for each key was a set of integers representing the keys of the other map. 
decisions i made was to deal with upper and lower case, another decisions was to ignore words as: is , if , for etc.


INSTRUCTIONS TO BUILD AND RUN 
in the terminal write docker-compose up 

via postman

then go to localhost:8080/insert    : post request

and put the next content in the body:

["Lord of the rings was an amazing lord , movie that anyone should see",
	"harry potter is cool , Dumbeldor is at his peek ",
 "batman and the joker is the best movie",
 "spring boot is  the best library there is , go spring",
 "aws help you create amazing distributed systems",
 "i love schenizel"
]

after that go to localhost:8080/search

and insert a string "harry is spring"

Thank you very!
