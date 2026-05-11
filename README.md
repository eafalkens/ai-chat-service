# AI Chat Service

Detta projekt är en Spring Boot-applikation som fungerar som en middleware mellan en användare och en AI-tjänst. Applikationen använder ett REST API där användaren kan skicka ett meddelande tillsammans med en vald personality, exempelvis coder eller pirate. Projektet innehåller även enkel minneshantering med sessionId samt använder Spring RestClient för externa anrop.

## Starta projektet lokalt

Klona projektet:

```bash
git clone https://github.com/DITT_USERNAME/ai-chat-service.git
cd ai-chat-service
```

## Starta applikationen
```bash
mvn spring-boot:run
```

## Applikationen körs på:
http://localhost:8080

## Skicka en POST-request till:
http://localhost:8080/api/v1/chat

## Exempel på request body:
```
{
"personality": "coder",
"message": "Hur skriver jag en loop i Java?",
"sessionId": "1"
}
```