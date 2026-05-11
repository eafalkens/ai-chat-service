# AI Chat Service

## 📌 Beskrivning
Detta är en Spring Boot-applikation som fungerar som middleware mellan en klient och en Large Language Model (LLM).  
Applikationen tar emot ett meddelande, väljer en personlighet (system prompt) och skickar vidare requesten till en extern AI-modell.

---

## 🚀 Endpoint

### POST `/api/v1/chat`

### Request body:
```json
{
  "personality": "coder",
  "message": "Hur skriver jag en for-loop i Java?",
  "sessionId": "user-123"
}