# Trivia Game

This trivia game allows you to play a game as single player or with multiple players.

## Arguments

- arg[0] players: Specify the number of players
- arg[1] gameMode: Specify the game mode. Use '0' for default questions. '1' to customize questions file. If no filename is specified, questions.txt will be used.
- arg[2] filename: (Optional) Specify the file name if you want to customize the questions file.

## Questions format

Questions txt file should follow this format:
* question (text)
* true/false (boolean)
* difficulty (rate 1-5)