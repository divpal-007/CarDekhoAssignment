# CarDekho AI Assignment 

A minimal, production-ready full-stack Car Analysis project.

## Stack

Java Spring (Backend)
React (Frontend)

---

## Docker (Recommended)

Spin up the entire stack with a single File: StartApplication.bat

###  Q/A For the assigment

### Q1. What did you build and why? What did you deliberately cut?

### ANS:
The Build: I built a full-stack recommendation MVP using React for the frontend and Spring Boot for the backend, containerized with Docker to ensure a single-click startup with th Application file. The application takes  user preferences (such as budget, Family Size, or priority on safety) and passes them to the Spring Boot backend. The backend then runs a filtering and sorting algorithm using streams against the car dataset to return a highly curated shortlist.
The Why: The Assignment asked for a solution that helps a confused buyer transition to being confident about their shortlist
I focused on building a targeted recommendation engine because it directly solves the user's problem of having too many options
This allowed me to deliver a tight, opinionated MVP rather than a half-finished kitchen sink, which directly addresses the product decisions the assignment evaluation.
What I cut: Pixel-Perfect Styling: I built a functional but basic interface because the instructions explicitly stated that a pixel-perfect UI is not being evaluated

User Authentication and Saved States: I cut features like logging in or saving previous shortlists to ensure I stayed strictly within the 2-3 hour time-box

A Heavy Production Database: Rather than spinning up a separate complex database container, I utilized a simplified data loading approach (e.g., in-memory or a mock dataset) within the Spring Boot app. This guaranteed that the evaluators could run the application locally in under 2 minutes

Exhaustive Testing: I focused on keeping the architecture readable and sensible
,but deliberately cut comprehensive unit testing to prioritize execution speed and shipping a working, end-to-end product

### Q2. What’s your tech stack and why did you pick it?

### ANS: 
The Tech Stack I used is 
Java SpringBoot(Backend)
React(Frontend)
Why: From last 4 years I was working a TCS Product which runs on Java and React and I loved working on this tech stack as Java is something which surprises me whenever I stretch my understanding — there's always a deeper layer waiting to be discovered. It is also a mature framework that AI tools (like Claude, Cursor, or Copilot) are highly trained on, making it easy to generate the controllers, services, and entities quickly.
For React It allowed me to rapidly build a functional frontend that a human can interact with, fulfilling the full-stack requirement. The React generally helped me a lot in processing UI and it's code and I am able to make the page responsive firsthand easily.

### Q3. What did you delegate to AI tools vs. do manually? Where did the tools help most?Where did they get in the way?

### ANS:
Since, the Assignment was timeboxed and the recording tool I was using was also limited I had to quickly use the AI tools to generate boilerplate code for both Spring and React so when claude generated all that I downloaded the zip and extracted it to the folder where I was working after that I asked Claude to create docker file too for the project to Run it on the local so it was a step by step guide I was following through research from the google's notebooklm which I generally use to do research for the something I am working and it clears my approach and keep ahead in time.
After that through ChatGpt I generated few codes for backend and frontend. Since, the code is always generic here comes my expertise where I copy the code and add/delete according to my use case or ask something extra from the AI to add in it.
Manual Intervention is always required so here comes my knowledge of the coding langauges and AI Tools. 

Tools Help: Tools assists me in Coding,research,system design and I smoothly implemented them in my code while I was facing some error with my docker but the AI was inefficient in solving those.

Get in the way: The tools were inefficient to fix my issue of Docker and sometimes chatgpt gives me more than what I required or want so I have to cut that down short and getaway only with the required things I want


### Q4. If you had another 4 hours, what would you add?

### ANS: 
I think for the basic functionality the time was enough but if I had some more time I would research on notebooklm for extra features I could add and also I would have used LLMs API to generate realtime response for the user which would be more intelligent approach as user could be more flexible with the questions the LLM agent would ask and generate the response to the accuracy of the customer requirement so yes I would have added an agent for this work too. Next thing I could have added is good UI and if the customer is happy with the response it could redirect to that Car's page in CarDekho website.

