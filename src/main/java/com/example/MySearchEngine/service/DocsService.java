package com.example.MySearchEngine.service;

import com.example.MySearchEngine.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DocsService {

    //defining the map that will hold the words and a set of
    // integers that represent the key in the document map.
    Map<String, Set<Integer>> wordsMap = new HashMap<>();

    //defining the document map that hold keys as integers and string as the document.
    Map<Integer, String> documentsMap = new HashMap<>();
    int keyOfDocumentMap = 0;


    public ResponseEntity<String> indexing(List<String> docs) {

        if (docs.isEmpty()) {
            return new ResponseEntity<>("No Documents found to be indexed", HttpStatus.BAD_REQUEST);
        }

        //starting work with each document
        for (String doc : docs) {
            documentsMap.put(keyOfDocumentMap, doc);

            String[] arr = doc.split("[^a-zA-Z]+");
            for (String word : arr) {
                // check if the word is part of the unwanted words , in this case ill jump this iteration.
                if (!Utils.checkForUnwantedWords(word)) {
                    continue;
                }
                //inserting only lowe case (dealing with  case-sensitive).
                String lowerCaseWord = Utils.changeWordToLowerCase(word);
                // in case the ward not there.
                if (!wordsMap.containsKey(lowerCaseWord)) {
                    //I create a hash map and add the key of the documentsMap.
                    Set<Integer> SetKeysOfDocumentMap = new HashSet<>();
                    SetKeysOfDocumentMap.add(keyOfDocumentMap);
                    wordsMap.put(lowerCaseWord, SetKeysOfDocumentMap);

                    //in case it is  already in the map
                    //I need to add that Document key to the set of integers
                } else {
                    if (wordsMap.containsKey(lowerCaseWord)) {
                        wordsMap.get(lowerCaseWord).add(keyOfDocumentMap);
                    }
                }
            }
            keyOfDocumentMap++;
        }

        return new ResponseEntity<>("successfully indexed the documents", HttpStatus.OK);

    }

    //  second part where the user  insert a ward and output the documents
    public ResponseEntity<Set<String>> findKeywords(String keywords) {

        Set<String> answer = new HashSet<>();
        //split the document
        String[] arr = keywords.split("[^a-zA-Z]+");
        //get for each word a matching document
        for (String word : arr) {

            String lowerCase = Utils.changeWordToLowerCase(word);

            if (wordsMap.containsKey(lowerCase)) {
                Set<Integer> temp = wordsMap.get(lowerCase);
                for (Integer keyOfDocument : temp) {
                    answer.add(documentsMap.get(keyOfDocument));
                }
            }
        }
        if (answer.isEmpty()) {
            return new ResponseEntity<>(answer, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(answer, HttpStatus.OK);

    }

}
