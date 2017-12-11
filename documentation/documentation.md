# UutisetHarjoitus


Kirjautuminen
```
user:toimittaja
password:paa

```


Harjoitustyö, jossa luodaan uutissivusto. 

## Haasteita

Yritin saada nagigaatiopalkin javascriptillä, jottei tarvistisi copy-pasteta sitä, mutta en osannu.

Yritin tallentaa kuvia tietokantaa, mutta en onnistunut. Virheviesti oli tämä: "Unable to access lob stream". Otin @Lov-annotaation pois ja kuvia lisätään nyt vain url:n perusteella. Url:n oltava melko lyhyt, kun @Lob ei onnistunut.

Myös testien kanssa oli ongelmia, joten niitä on melko rajallinen määrä.

Validointiin asti en ehtinyt.

## Toiminnallisuus

Seuraavassa sivuston toiminnallisuuden esittely

## Sivuston toiminta

Sivuston ulkoasu on seuraavanlainen.


### Etusivu:


Näyttää 5 uusinta uutista ja uutiseen liittyvän:
```
Otsikon
Kuvan
Ingressin

```


#### Toiminnallisuus:


Listaa viikon lukukertojen perusteella.



```
Listaaminen kategorioiden perusteella jäi tekemättä
```

### Navigaatio:

Kirjaudu linkin kautta pääsee muokkaamaan uutisia


## Uutisten käsittely:

Uutisiin liittyy seuraavia toiminnallisuuksia.

### Lisää uutinen:

```
Lisää yksittäisen uutisen ja sen otsikon

```
### Lisää kategoria:
```
Yksittäisen kategorian lisääminen uutiskategorioihin.

```

### Lisää kirjoittaja:
```
Yksittäisen kirjoittajan lisääminen kirjoittajat-kategoriaan.

```

### Muokkaa uutista:

Uutista voi sen lisäämisen jälkeen muokata seuraavilta osin

```
Otsikko
Ingressi
Kuva
Juttu
Kirjoittaja(t)
Kategoria(t)
```

Kirjoittajia ja kategorioita voi vain lisätä. Lisäksi koko uutisen voi poistaa.

## Luokka/tietokantakaavio:
Päivämäärä näyttää myös kellon ja kuva on siis String-muotoinen url-osoite.

![Kaavio](https://github.com/pidrmasiin/uutiset/blob/master/uutiset.jpg?raw=true)

