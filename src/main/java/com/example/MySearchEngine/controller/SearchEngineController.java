package com.example.MySearchEngine.controller;

import com.example.MySearchEngine.service.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

    @RestController
    public class SearchEngineController {

        @Autowired
        DocsService docsService;

        @PostMapping("/insert")
        public ResponseEntity<String> documentsIndexing(@RequestBody List<String> docs){

          return   docsService.indexing(docs);

        }

        @GetMapping("/search")
        public ResponseEntity<Set<String>> findKeywords(@PathVariable String keywords){

            return  docsService.findKeywords(keywords);

        }
    }


