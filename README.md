# MinimumSnippet Search Engine Project

## Overview

This project focuses on developing an algorithm to efficiently find the shortest subsequence in a document that contains all specified search terms. The `MinimumSnippet` class is at the core of this project, designed to mimic the behavior of search engines that display snippets of search results containing the relevant terms.

### Key Features

- **Search Term Matching:** Finds the minimal-length subsequence in a document that contains all the given search terms.
- **Efficiency:** Implements the fastes possible O(n) algorithm.
- **Customizable:** Can work with any list of search terms and documents.

## Project Description

When you search for a term on the web, search engines often highlight a snippet of text from a document showing your search terms in context. This project simulates this process by locating the shortest possible snippet within a document that contains all provided search terms.

### Example:

Given the document:
K W D A I B D W C D W S D <mark>B F A C</mark> E S D B C D E S A D B X

And the search terms: `A`, `B`, `C`

The algorithm will return the shortest subsequence containing all terms, such as:
B F A C

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Java IDE such as Eclipse etc.

### Installation

1. **Clone the Repository**
   git clone https://github.com/arnavaggarwal75/Minimum-Snippet.git

Open the Project
Import the project into your favorite IDE as a Java project.
Running the Code
Instantiate the MinimumSnippet Class with a document (as a list of words) and a list of search terms.
Retrieve the Result using methods to get the start and end positions of the minimal snippet.
### Example Usage:

```
List<String> document = Arrays.asList("K", "W", "D", "A", "I", "B", "D", "W", "C", "D", "W", "S", "D", "B", "F", "A", "C", "E", "S", "D", "B", "C", "D", "E", "S", "A", "D", "B", "X");
List<String> terms = Arrays.asList("A", "B", "C");

MinimumSnippet snippet = new MinimumSnippet(document, terms);
System.out.println("Shortest snippet starts at: " + snippet.getStartingPos());
System.out.println("Shortest snippet ends at: " + snippet.getEndingPos());
```

### Project Structure:
MinimumSnippet.java: Contains the main logic for finding the minimal-length snippet.
Tests.java: Includes JUnit tests for validating the functionality.

### How It Works
The MinimumSnippet class efficiently identifies the shortest subsequence in a document that contains all the specified search terms. The algorithm works by iterating through the document, tracking the most recent positions of each search term. When all terms are found, it calculates the length of the snippet and updates the shortest one identified so far. The result is the start and end positions of the minimal snippet, ensuring the smallest possible segment of the document that includes all search terms.