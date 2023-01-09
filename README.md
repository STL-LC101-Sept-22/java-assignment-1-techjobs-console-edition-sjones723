# TechJobs, Console Edition Autograded Rubric

For [this assignment](https://education.launchcode.org/java-web-development/assignments/tech-jobs-console.html), students are asked to complete a console app that allows users to browse, search, and print listings of open jobs.

## Assignment Requirements

1. Implement the `printJobs` method
2. Create the `findByValue` method
3. Make search methods `Case-Insensitive`

## Unit Tests 

The starter code contains unit tests and text files. There is one test class that contains 4 tests. These tests compare students' output to the text files.  

We encourage students to run unit tests after they complete the assignment before submitting. Directions for how to run tests have been provided in the [Java](https://education.launchcode.org/java-web-development/) textbook's [Assignment 0](https://education.launchcode.org/java-web-development/assignments/hello-world.html).

If the output matches the text files, the test will pass. If a student passes all 4 tests, they pass the assignment.  

Submission cannot be graded on unit tests alone. Use the section below as a guide for what to look for before submitting your assignment. 

## Functional App's Appearance and Behavior:

1) After launching your app within the console, it should begin with a user prompt that looks similar to:
  
   ``` 
   Welcome to LaunchCode's TechJobs App!
   View jobs by:
   0 - Search
   1 - List
   ```
 
2) Select *Search*, then *Location*, then enter "new YORk" (or "new york", or "New york", etc.) to confirm that the search function is case-insensitive. One result should be printed:
 
   ```
   View jobs by:
   0 - Search
   1 - List
   0
 
   Search by:
   0 - All
   1 - Position Type
   2 - Employer
   3 - Location
   4 - Skill
   3
 
   Search term:
   new YORk
   ```
  
   ```
   *****
   position type: Other
   name: QA Analyst
   employer: Bandcamp
   location: New York
   core competency: Ruby, Javascript
   *****
   ```
          
3) Next, select *List --> All*. This should print lots of jobs with each of the 5 fields displayed.
4) Next, select *Search --> Location --> "Chicago"*. This should print a reasonable "No results found" message.
5) Next, select *Search --> All --> "ruby"*. This should display 4 results.
 
   ```
   *****
   position type: Web - Front End
   name: Junior Web Developer
   employer: Cozy
   location: Portland
   core competency: Ruby
   *****
 
   *****
   position type: Web - Full Stack
   name: Full Stack Engineer
   employer: Splitwise
   location: Rhode Island
   core competency: Ruby
   *****
 
   *****
   position type: Other
   name: QA Analyst
   employer: Bandcamp
   location: New York
   core competency: Ruby, Javascript
   *****
      
   *****
   position type: Web - Back End
   name: Ruby specialist
   employer: LaunchCode
   location: Saint Louis
   core competency: Javascript
   *****
   ```
 
6) Finally, select *List --> Position Type*. This should produce the following list. The order is not important, since alphabetizing the output is a bonus mission.
 
   ```
   *** All Position Type Values ***
   Data Scientist / Business Intelligence
   Mobile Developer
   Other
   Project Manager / Analyst
   Quality Assurance Analyst
   Software / Enterprise Developer
   System Admin / DB Admin / Network Support
   Technical Assistant / User Support
   Technical Writer
   Web - Back End
   Web - Front End
   Web - Full Stack
   ```   

## Submitting Your Work

To submit your work please follow the [Submission Instructions](https://education.launchcode.org/java-web-development/assignments/hello-world.html#submitting-your-work).
