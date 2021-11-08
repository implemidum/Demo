# Music Groups Application



This app serves as a demo application for the application to the job offer.

# Building

```bash
cd <project>/src/main/webapp/
npm run build
cd <project>
mvn compile
mvn package
```

# Running

```bash
java -jar target/music-0.0.1-SNAPSHOT.jar
```

Open http://localhost:8080/view/index.html#!/top/groups in the browser.

# Requirements

Implementirati enostavno CRUD aplikacijo za delo z glasbenimi izvajalci.

## Podatkovna baza

- [x] Baza glasbenikov naj vsebuje podatke o **skupinah**, **ljudeh**, **izdanih albumih**, **pesmih** in **državah**, iz katerih ljudje prihajajo.

- [x] Izvedite **iskanje skupin po imenu** in omogočite **iskaje po seznamu rezultatov**.

## Prikaz

- [x] V podrobnostih o skupini prikažite člane skupine in podrobnosti o albumu.

- [x] V podrobnostih o albumu prikažite seznam skladb.

- [x] Omogoči vnos, brisanje in posodabljanje **oseb** in **skupin** (pesmi???).

- [x] Uporabite preprost, minimalen vizualni slog za aplikacijo.

## Arhitektura

- [x] Za ustvarjanje ozadja uporabite Spring Boot.

- [x] Za prikaz podatkov uporabite Angular, JSP, Thymeleaf ali karkoli vam ustreza.

- [x] Za bazo podatkov uporabite H2.

## Časovne omejitve

- [x] Ocenjujemo, da je za rešitev naloge potrebno do 3-5 dni

- [x] zato vaš odgovor pričakujemo v roku enega tedna, torej najkasneje naslednji petek (2021-11-05). 

Zaključeno rešitev zapakirajte in jo pošljite na naš e-naslov skupaj z navodili za zagon ali pošljite povezavo do repozitorija github.



# Relational Model

![](/home/milan/git/repository/music/doc/RelationModel.draw.drawio.png)



# Rest Endpoints

## Music Group

```java
/groups
/groups/{id}
/groups?name=<search>
```

## Member

```java
/members
/members/{id}
/groups/{groupId}/members
```

## Albums

```java
/albums
/albums/{id}
/groups/{groupId}/albums
/groups/{groupId}/albums/{id}
```

## Songs

```java
/songs
/songs/{id}
/albums/{albumId}/songs
/albums/{albumId}/songs/{id}
```

## Countries

```java
/countries
```

