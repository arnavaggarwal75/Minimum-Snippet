# MinimumSnippet Search Engine Project

## Overview

This project focuses on developing an algorithm to efficiently find the shortest subsequence in a document that contains all specified search terms. The `MinimumSnippet` class is at the core of this project, designed to mimic the behavior of search engines that display snippets of search results containing the relevant terms.

### Key Features

- **Search Term Matching:** Finds the minimal-length subsequence in a document that contains all the given search terms.
- **Efficiency:** Designed to handle large documents efficiently.
- **Customizable:** Can work with any list of search terms and documents.

## Project Description

When you search for a term on the web, search engines often highlight a snippet of text from a document showing your search terms in context. This project simulates this process by locating the shortest possible snippet within a document that contains all provided search terms.

### Example:

Given the document:
K W D A I B D W C D W S D B F A C E S D B C D E S A D B X

r
Copy code

And the search terms: `A`, `B`, `C`

The algorithm will return the shortest subsequence containing all terms, such as:
B F A C

markdown
Copy code

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Java IDE such as Eclipse or IntelliJ IDEA

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/MinimumSnippet.git
Open the Project
Import the project into your favorite IDE as a Java project.
Running the Code
Instantiate the MinimumSnippet Class with a document (as a list of words) and a list of search terms.
Retrieve the Result using methods to get the start and end positions of the minimal snippet.
Example Usage
java
Copy code
List<String> document = Arrays.asList("K", "W", "D", "A", "I", "B", "D", "W", "C", "D", "W", "S", "D", "B", "F", "A", "C", "E", "S", "D", "B", "C", "D", "E", "S", "A", "D", "B", "X");
List<String> terms = Arrays.asList("A", "B", "C");

MinimumSnippet snippet = new MinimumSnippet(document, terms);
System.out.println("Shortest snippet starts at: " + snippet.getStartingPos());
System.out.println("Shortest snippet ends at: " + snippet.getEndingPos());
Project Structure
MinimumSnippet.java: Contains the main logic for finding the minimal-length snippet.
PublicTests.java: Includes JUnit tests for validating the functionality.
How It Works
The algorithm iterates through the document, keeping track of the positions of the search terms, and dynamically calculates the shortest subsequence that includes all terms. It efficiently narrows down the results, ensuring that the shortest possible snippet is identified.

