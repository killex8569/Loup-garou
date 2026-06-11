public enum MessageType {
    // Client --> Serveur

    JOIN_GAME,
    SELECT_GAME,
    ACTION,
    LEFT_GAME,



    // Serveur --> Client

    ACK_CONNEXION,
    GAME_STAT,
    TURN,
    GAME_OVER,
    ERROR
}
