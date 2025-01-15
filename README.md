Team Entity:
Represents a football team.
Fields: id, teamName, teamNationality, yearFounded, teamPlayers, coaches, stadium.
Relationships:
One-to-Many: Players belong to a team.
Many-to-Many: Coaches can manage multiple teams.
One-to-One: Each team has one stadium.

Player Entity:
Represents a football player.
Fields: id, firstName, lastName, age, skillLevel, weight, height, position, nationality, team.
Relationships:
Many-to-One: Each player belongs to one team.

Coach Entity:
Represents a football coach.
Fields: id, firstName, lastName, age, experience, teams.
Relationships:
Many-to-Many: Coaches can manage multiple teams.

Stadium Entity:
Represents a football stadium.
Fields: id, name, location, capacity, homeTeam.
Relationships:
One-to-One: Each stadium belongs to one team.

League Entity:
Represents a football league.
Fields: id, name, teams, matches, standings.
Relationships:
One-to-Many: Contains multiple teams and matches.

Match Entity:
Represents a football match.
Fields: id, team1, team2, duration, teamScore1, teamScore2, matchStadium.
Relationships:
Many-to-One: Matches can reference two teams and one stadium.
Controllers
Controllers define the REST API endpoints and handle HTTP requests and responses.

TeamController:
Manages CRUD operations for teams.
Example endpoints: GET /teams, POST /teams, GET /teams/{id}, DELETE /teams/{id}.

PlayerController:
Manages CRUD operations for players.
Example endpoints: GET /players, POST /players, GET /players/{id}, DELETE /players/{id}.

CoachController:
Manages CRUD operations for coaches.
Example endpoints: GET /coaches, POST /coaches, GET /coaches/{id}, DELETE /coaches/{id}.

StadiumController:
Manages CRUD operations for stadiums and searches by name.
Example endpoints: GET /stadiums, POST /stadiums, GET /stadiums/search?name=Camp Nou.

LeagueController:
Manages CRUD operations for leagues and searches by name.
Example endpoints: GET /leagues, POST /leagues, GET /leagues/search?name=Premier League.

MatchController:
Manages CRUD operations for matches.
Example endpoints: GET /matches, POST /matches, GET /matches/{id}, DELETE /matches/{id}.

Services
Services encapsulate business logic and interact with repositories.

TeamService:
Handles team-specific logic, like saving, finding, or deleting teams.

PlayerService:
Handles player-specific logic, like adding players to teams.

CoachService:
Manages coach-specific logic, like associating coaches with multiple teams.

StadiumService:
Manages stadium-specific logic, like finding stadiums by name.

LeagueService:
Handles league-specific logic, like adding teams to leagues.

MatchService:
Manages match-specific logic, like recording scores and linking matches to teams.
Repositories

Repositories interact with the database using Spring Data JPA.

TeamRepository:
Provides database operations for teams, such as finding by ID or saving teams.

PlayerRepository:
Handles database operations for players.

CoachRepository:
Handles database operations for coaches.

StadiumRepository:
Handles database operations for stadiums, such as searching by name.

LeagueRepository:
Provides methods for league-related database operations.

MatchRepository:
Manages database interactions for matches.

Summary
Entities: Define data and relationships.
Controllers: Expose REST API endpoints.
Services: Contain business logic.
Repositories: Handle database interactions.
