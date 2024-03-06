/*
Created: 23.11.2023
Modified: 27.11.2023
Project: Oceanarium
Model: Oceanarium
Company: Warsaw University of Technology
Author: Michał Jęczmieniowski, Igor Czunikin-Krasowicki
Version: 1.0
Database: Oracle 18c
*/


-- Create tables section -------------------------------------------------

-- Table Oceanaria

CREATE TABLE Oceanaria(
  ID_oceanarium Integer NOT NULL,
  Nazwa Varchar2(20 ) NOT NULL,
  Numer_telefonu Varchar2(15 ) NOT NULL,
  Godziny_otwarcia Date NOT NULL,
  Adres_email Varchar2(30 ) NOT NULL,
  Data_zalozenia Date NOT NULL,
  ID_adresu Integer NOT NULL
)
/

-- Create indexes for table Oceanaria

CREATE INDEX IX_adres_oceanarium ON Oceanaria (ID_adresu)
/

-- Add keys for table Oceanaria

ALTER TABLE Oceanaria ADD CONSTRAINT Unique_Identifier1 PRIMARY KEY (ID_oceanarium)
/

-- Table Pracownicy

CREATE TABLE Pracownicy(
  ID_pracownika Integer NOT NULL,
  Imie Varchar2(20 ) NOT NULL,
  Drugie_imie Varchar2(20 ),
  Nazwisko Varchar2(30 ) NOT NULL,
  Data_urodzenia Date NOT NULL,
  PESEL Char(11 ),
  Plec Char(1 ) NOT NULL
        CHECK (Plec IN ('K','M')),
  Adres Varchar2(400 ) NOT NULL,
  Adres_email Varchar2(30 ) NOT NULL,
  Stanowisko Varchar2(20 ) NOT NULL,
  Data_zatrudnienia Date NOT NULL,
  Nr_konta Char(26 ) NOT NULL,
  Numer_telefonu Varchar2(15 ) NOT NULL,
  Wynagrodzenie Number(10,2) NOT NULL,
  ID_oceanarium Integer NOT NULL,
  ID_sklepu Integer,
  ID_adresu Integer NOT NULL
)
/

-- Create indexes for table Pracownicy

CREATE INDEX IX_pracownik_oceanarium ON Pracownicy (ID_oceanarium)
/

CREATE INDEX IX_pracownik_sklepu ON Pracownicy (ID_sklepu)
/

CREATE INDEX IX_adres_pracownika ON Pracownicy (ID_adresu)
/

-- Add keys for table Pracownicy

ALTER TABLE Pracownicy ADD CONSTRAINT Unique_Identifier2 PRIMARY KEY (ID_pracownika)
/

-- Table Odwiedzajacy

CREATE TABLE Odwiedzajacy(
  ID_odwiedzajacego Integer NOT NULL,
  Imie Varchar2(20 ) NOT NULL,
  Nazwisko Varchar2(30 ) NOT NULL,
  Data_urodzenia Date,
  Plec Char(1 ) NOT NULL
        CHECK (Plec IN ('K','M')),
  Adres_email Varchar2(30 ) NOT NULL,
  Numer_telefonu Varchar2(15 ),
  ID_oceanarium Integer NOT NULL,
  ID_adresu Integer
)
/

-- Create indexes for table Odwiedzajacy

CREATE INDEX IX_odwiedzajacy_oceanarium ON Odwiedzajacy (ID_oceanarium)
/

CREATE INDEX IX_adres_odwiedzajacego ON Odwiedzajacy (ID_adresu)
/

-- Add keys for table Odwiedzajacy

ALTER TABLE Odwiedzajacy ADD CONSTRAINT Unique_Identifier3 PRIMARY KEY (ID_odwiedzajacego)
/

-- Table Zwierzeta

CREATE TABLE Zwierzeta(
  ID_zwierzecia Integer NOT NULL,
  Gatunek Varchar2(30 ) NOT NULL,
  Imie Varchar2(30 ),
  Typ_wody Char(4 ) NOT NULL
        CHECK (TYP_WODY IN ('SLOD','SLON')),
  Data_urodzenia Date,
  ID_zbiornika Integer NOT NULL,
  ID_oceanarium Integer NOT NULL
)
/

-- Create indexes for table Zwierzeta

CREATE INDEX IX_zwierze_zbiornika ON Zwierzeta (ID_zbiornika)
/

CREATE INDEX IX_zwierze_oceanarium ON Zwierzeta (ID_oceanarium)
/

-- Add keys for table Zwierzeta

ALTER TABLE Zwierzeta ADD CONSTRAINT Unique_Identifier4 PRIMARY KEY (ID_zwierzecia)
/

-- Table Zbiornik

CREATE TABLE Zbiornik(
  ID_zbiornika Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL,
  Pojemnosc Integer NOT NULL,
  ID_oceanarium Integer NOT NULL,
  ID_pracownika Integer NOT NULL
)
/

-- Create indexes for table Zbiornik

CREATE INDEX IX_zbiornik_oceanarium ON Zbiornik (ID_oceanarium)
/

CREATE INDEX IX_zbiornik_pracownika ON Zbiornik (ID_pracownika)
/

-- Add keys for table Zbiornik

ALTER TABLE Zbiornik ADD CONSTRAINT Unique_Identifier5 PRIMARY KEY (ID_zbiornika)
/

-- Table Sklepy

CREATE TABLE Sklepy(
  ID_sklepu Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL,
  ID_oceanarium Integer NOT NULL
)
/

-- Create indexes for table Sklepy

CREATE INDEX IX_sklep_oceanarium ON Sklepy (ID_oceanarium)
/

-- Add keys for table Sklepy

ALTER TABLE Sklepy ADD CONSTRAINT Unique_Identifier6 PRIMARY KEY (ID_sklepu)
/

-- Table Bilety

CREATE TABLE Bilety(
  ID_biletu Integer NOT NULL,
  Czy_kupiony_online Char(1 ) NOT NULL,
  Data_waznosci Date NOT NULL,
  Data_skasowania Date,
  Cena Number(10,2) NOT NULL,
  ID_odwiedzajacego Integer NOT NULL
)
/

-- Create indexes for table Bilety

CREATE INDEX IX_bilet_odwiedzajacego ON Bilety (ID_odwiedzajacego)
/

-- Add keys for table Bilety

ALTER TABLE Bilety ADD CONSTRAINT Unique_Identifier7 PRIMARY KEY (ID_biletu)
/

-- Table Atrakcje

CREATE TABLE Atrakcje(
  ID_atrakcji Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL,
  Cena Number(10,2) NOT NULL,
  Opis Varchar2(400 ) NOT NULL,
  ID_oceanarium Integer NOT NULL
)
/

-- Create indexes for table Atrakcje

CREATE INDEX IX_atrakcja_oceanarium ON Atrakcje (ID_oceanarium)
/

-- Add keys for table Atrakcje

ALTER TABLE Atrakcje ADD CONSTRAINT Unique_Identifier8 PRIMARY KEY (ID_atrakcji)
/

-- Table Opiekunowie

CREATE TABLE Opiekunowie(
  ID_pracownika Integer NOT NULL,
  Data_szkolenia Date NOT NULL
)
/

-- Add keys for table Opiekunowie

ALTER TABLE Opiekunowie ADD CONSTRAINT Unique_Identifier9 PRIMARY KEY (ID_pracownika)
/

-- Table Przewodnicy

CREATE TABLE Przewodnicy(
  ID_pracownika Integer NOT NULL,
  Nr_licencji Varchar2(8 ) NOT NULL
)
/

-- Add keys for table Przewodnicy

ALTER TABLE Przewodnicy ADD CONSTRAINT Unique_Identifier10 PRIMARY KEY (ID_pracownika)
/

-- Table Dostepnosci_atrakcji

CREATE TABLE Dostepnosci_atrakcji(
  ID_biletu Integer NOT NULL,
  ID_atrakcji Integer NOT NULL
)
/

-- Table Adresy

CREATE TABLE Adresy(
  ID_adresu Integer NOT NULL,
  Kraj Varchar2(30 ) NOT NULL,
  Miasto Varchar2(30 ) NOT NULL,
  Ulica Varchar2(30 ) NOT NULL,
  Numer_budynku Varchar2(4 ) NOT NULL,
  Numer_lokalu Varchar2(4 ),
  Kod_pocztowy Char(6 ) NOT NULL
)
/

-- Add keys for table Adresy

ALTER TABLE Adresy ADD CONSTRAINT PK_Adresy PRIMARY KEY (ID_adresu)
/

-- Table and Columns comments section

COMMENT ON COLUMN Adresy.ID_adresu IS 'Unikalny identyfiaktor adresu'
/
COMMENT ON COLUMN Adresy.Kraj IS 'Kraj w adresie'
/
COMMENT ON COLUMN Adresy.Miasto IS 'Miasto w adresie'
/
COMMENT ON COLUMN Adresy.Ulica IS 'Ulica w adresie'
/
COMMENT ON COLUMN Adresy.Numer_budynku IS 'Numer budynku w adresie'
/
COMMENT ON COLUMN Adresy.Numer_lokalu IS 'Numer lokalu w adresie'
/
COMMENT ON COLUMN Adresy.Kod_pocztowy IS 'Kod pocztowy w adresie'
/

-- Table Znajomosci_jezykow_obcych

CREATE TABLE Znajomosci_jezykow_obcych(
  ID_pracownika Integer NOT NULL,
  ID_jezyka Integer NOT NULL,
  Poziom_jezyka Char(20 ) NOT NULL
        CHECK (POZIOM_JEZYKA IN ('A1','A2','B1','B2','C1','C2'))
)
/

-- Add keys for table Znajomosci_jezykow_obcych

ALTER TABLE Znajomosci_jezykow_obcych ADD CONSTRAINT PK_Znajomosci_jezykow_obcych PRIMARY KEY (ID_pracownika,ID_jezyka)
/

-- Table and Columns comments section

COMMENT ON COLUMN Znajomosci_jezykow_obcych.Poziom_jezyka IS 'Poziom języka'
/

-- Table Jezyki

CREATE TABLE Jezyki(
  ID_jezyka Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL
)
/

-- Add keys for table Jezyki

ALTER TABLE Jezyki ADD CONSTRAINT PK_Jezyki PRIMARY KEY (ID_jezyka)
/

-- Table and Columns comments section

COMMENT ON COLUMN Jezyki.ID_jezyka IS 'Unikalny identyfikator języka'
/
COMMENT ON COLUMN Jezyki.Nazwa IS 'Nazwa języka'
/

-- Table Wynagrodzenia

CREATE TABLE Wynagrodzenia(
  ID_wynagrodzenia Integer NOT NULL,
  Data_zakwitowania Date NOT NULL,
  Pensja_podstawowa Number(10,2) NOT NULL,
  Premia Number(10,2),
  ID_pracownika Integer NOT NULL
)
/

-- Create indexes for table Wynagrodzenia

CREATE INDEX IX_wynagrodzenia_pracownika ON Wynagrodzenia (ID_pracownika)
/

-- Add keys for table Wynagrodzenia

ALTER TABLE Wynagrodzenia ADD CONSTRAINT PK_Wynagrodzenia PRIMARY KEY (ID_wynagrodzenia)
/

-- Table and Columns comments section

COMMENT ON COLUMN Wynagrodzenia.ID_wynagrodzenia IS 'Unikalny identyfikator wynagrodzenia'
/
COMMENT ON COLUMN Wynagrodzenia.Data_zakwitowania IS 'Data zakwitowania wynagrodzenia'
/
COMMENT ON COLUMN Wynagrodzenia.Pensja_podstawowa IS 'Pensja podstawowa pracownika'
/
COMMENT ON COLUMN Wynagrodzenia.Premia IS 'Premia do wynagrodzenia'
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Pracownicy ADD CONSTRAINT Zatrudnia FOREIGN KEY (ID_oceanarium) REFERENCES Oceanaria (ID_oceanarium)
/



ALTER TABLE Odwiedzajacy ADD CONSTRAINT Posiada_odwiedzajacego FOREIGN KEY (ID_oceanarium) REFERENCES Oceanaria (ID_oceanarium)
/



ALTER TABLE Zbiornik ADD CONSTRAINT Posiada_zbiornik FOREIGN KEY (ID_oceanarium) REFERENCES Oceanaria (ID_oceanarium)
/



ALTER TABLE Zwierzeta ADD CONSTRAINT Posiada_zwierze FOREIGN KEY (ID_zbiornika) REFERENCES Zbiornik (ID_zbiornika)
/



ALTER TABLE Sklepy ADD CONSTRAINT Posiada_sklep FOREIGN KEY (ID_oceanarium) REFERENCES Oceanaria (ID_oceanarium)
/



ALTER TABLE Bilety ADD CONSTRAINT Kupuje_bilet FOREIGN KEY (ID_odwiedzajacego) REFERENCES Odwiedzajacy (ID_odwiedzajacego)
/



ALTER TABLE Atrakcje ADD CONSTRAINT Oferuje_atrakcje FOREIGN KEY (ID_oceanarium) REFERENCES Oceanaria (ID_oceanarium)
/



ALTER TABLE Zbiornik ADD CONSTRAINT Opiekuje_sie FOREIGN KEY (ID_pracownika) REFERENCES Pracownicy (ID_pracownika)
/



ALTER TABLE Pracownicy ADD CONSTRAINT Obsluguje_sklep FOREIGN KEY (ID_sklepu) REFERENCES Sklepy (ID_sklepu)
/



ALTER TABLE Zwierzeta ADD CONSTRAINT Ma_zwierze FOREIGN KEY (ID_oceanarium) REFERENCES Oceanaria (ID_oceanarium)
/



ALTER TABLE Wynagrodzenia ADD CONSTRAINT Pracownik_otrzymuje_wynagrodzenie FOREIGN KEY (ID_pracownika) REFERENCES Pracownicy (ID_pracownika)
/



ALTER TABLE Odwiedzajacy ADD CONSTRAINT Odwiedzajacy_ma_adres FOREIGN KEY (ID_adresu) REFERENCES Adresy (ID_adresu)
/



ALTER TABLE Oceanaria ADD CONSTRAINT Oceanarium_ma_adres FOREIGN KEY (ID_adresu) REFERENCES Adresy (ID_adresu)
/



ALTER TABLE Znajomosci_jezykow_obcych ADD CONSTRAINT Jezyk_jest_znany FOREIGN KEY (ID_jezyka) REFERENCES Jezyki (ID_jezyka)
/



ALTER TABLE Znajomosci_jezykow_obcych ADD CONSTRAINT Przewodnik_zna_jezyki FOREIGN KEY (ID_pracownika) REFERENCES Przewodnicy (ID_pracownika)
/



ALTER TABLE Pracownicy ADD CONSTRAINT Pracownik_ma_adres FOREIGN KEY (ID_adresu) REFERENCES Adresy (ID_adresu)
/





