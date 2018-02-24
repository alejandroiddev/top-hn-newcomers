# Top 10 Hacker News Newcomers

This spring-boot app creates a top 10 Stories from the 500 newest stories in hacker news.

It has an endpoint (`/top-ten-newcomers`) to retrieve the top 10. 

The ranking is established by the average rate of point growth, this given by the story current points divided by its 
life time

## Algorithm

The application retrieves the 500 newest stories using the hn api(url de la api) and then access each of those stories 
to retrieve all its information, with the given information it creates a top stories with smaller size. this happens 
every 2 minutes.

When the endpoint is called the top stories are refreshed using the HN information to update the score. It also checks 
if there is a new newcomer in NH to check if it has to be in the top ten.

To keep in mind:
- People are predictable :)
- The returned list from the 500 newest endpoints stories is ordered.
- The list is for about a twelve hours range
- If the story has almost no points and its old. it wont be getting any more points.
- It takes about one minute and a half to retrieve al 500 items going one by one


## Requirements

You need to have version 1.8 of Java installed. 

## Usage

With the application running the endpoint can be accessed from 
[http://localhost:8080/top-ten-newcomers](http://localhost:8080/top-ten-newcomers)

### - Development

to use the application  in development run: 

    ./mvnw spring-boot:run

### - Production

for production usage yoo can create an executable file with the following command: 

    ./mvnw clean package

and then run the created package: 

    java -jar target/*.jar

## Future features 

 - Documentation
 - profiles: dev, prod and test.
 - update to java 1.9
 - docker
 - CI
 - Concurrent threads to check stories from NH API
 - Global exception handling
 - Logging aspect
 - Simple web with top ten board
 - Reactive 
 - Cucumber tests
 - ...