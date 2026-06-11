# Loup-garou
Le jeu du Loup garou fait en Java

mon-projet/
├── src/
│   ├── server/
│   │   ├── Server.java # Point d'entrée du serveur
│   │   ├── ClientHandler.java # Gère chaque client (1 thread par joueur)
│   │   └── GameManager.java # Orchestre les parties
│   │
│   ├── game/
│   │   ├── Game.java # Interface commune à tous les jeux
│   │   ├── RockPaperScissors.java
│   │   ├── Werewolf.java
│   │   └── ...  
│   │
│   ├── protocol/
│   │   ├── Message.java # Structure d'un message
│   │   ├── MessageType.java # Enum des types de messages
│   │   └── Protocol.java # Encode / décode les messages
│   │
│   └── client/
│       └── Client.java