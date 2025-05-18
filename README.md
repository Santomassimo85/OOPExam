# BookAdvisor 📚

Un'app Java + Spring Boot che permette di cercare libri tramite [Open Library](https://openlibrary.org/developers/api) e salvarli come preferiti.

## Funzionalità principali
- 🔍 Ricerca libri per titolo, autore, o data di pubblicazione
- ⭐ Visualizza copertina, autore, titolo, e aggiunta ai preferiti
- 🗑️ Rimozione singola o totale dei preferiti
- 🌟 Valutazione dei libri da 1 a 5 stelle
- 🌐 Documentazione API con Swagger

## Avvio progetto
```bash
mvn clean install
mvn spring-boot:run
```

Accedi a:
- Interfaccia Web → [http://localhost:35247](http://localhost:35247)
- Swagger API → [http://localhost:35247/swagger-ui.html](http://localhost:35247/swagger-ui.html)
