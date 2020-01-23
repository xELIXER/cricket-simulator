# Assignment1v2
Game of Cricket:  Write classes CricketGame, Player, Match and MatchController and any class thet they think is required. Write a random function which returns 0,1,2,3,4,5,6 or W.  That is for every ball it says runs or wicket. Match controller to take 2 teams and uses the sequence of random function calls and prints the results. Run multiple times and print results" please create your individual repository on git every time I give an enhancement on the project.. it should be checked in as a new branch

### Files
All the classes with only instance variable and no methods are put into /beans. All the functions that operate on objects and call different functions are put into /controller. /util has all the class with only static functions, i.e. we only use the class name to use the functions defined in them. /main holds the class that has the main function written.
  - Beans
    - Match
    - Player
    - Team
  - Controller
    - MatchController
  - Main
    - CricketApplication
  - Util
    - GetRunsOrWicket
    - PlayerUtil
    - PlayMatch
    - Result
    - Role
    - StartMatchUtil
    - TeamUtil
    - Toss

### Features
- Two teams are assumed, India and Australia.
- A ```toss()``` is done to decide who goes first.
- In the second inning when the batting team scores more than what the previous team made, the game ends and the second team wins.
- A HashMap is used to keep track of the scores. ```-1``` represents Wicket and ```0-6``` represent runs
- When a team looses 10 wickets, turn for that team is over.
- For generating runs and wicket, a ```betterRandom``` function is used that generates random number based on different probabilities in `O(n)` time. Such as the chances of a team earning 5 runs is very rare, so it probability is set to 5%.
    - ```Wicket: 5% probability``` 
    - ```0: 30% probability```
    - ```1: 20% probability```
    - ```2: 18% probability```
    - ```3: 15% probability```
    - ```4: 8% probability```
    - ```5: 1% probability```
    - ```6: 3% probability```
 - Scoreboard is available for each team as well as each player wise.
 - Maiden over feature allows us to see which all bowler did the bowling and gave 0 runs.
### Tech
- Spring Boot 2.2.3
- Java 13
- InteliJ IDEA
- Gradle

### Run

Import the project with InteliJ IDEA. Let the gradle build. Import all the dependencies. Then go the ```CricketApplication``` which holds the main class. The results are returned as HTML responses. Use a browser to test the API. The application runs on ```port: 8080```.
If using PostMan use the Preview mode to see the response.

### Endpoints
- `localhost:8080/`                 : Greeting message.
- `localhost:8080/match`            : Start the game.
- `localhost:8080/scoreboard`       : Scoreboard for the both the teams with all players.
- `localhost:8080/scoreboard/team1` : Scoreboard for 1st team with all players.
- `localhost:8080/scoreboard/team2` : Scoreboard for 2nd team with all players.

