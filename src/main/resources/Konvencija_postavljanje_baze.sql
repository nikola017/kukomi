CREATE TABLE Izlagac
(
  ImeIzlagaca VARCHAR(500) NOT NULL,
  Kompanija VARCHAR(500) NOT NULL,
  Email VARCHAR(500) NOT NULL,
  Telefon VARCHAR(50),
  IzlagacID INT NOT NULL,
  PRIMARY KEY (IzlagacID)
);

CREATE TABLE Termin
(
  TerminID INT NOT NULL,
  Termin VARCHAR(500) NOT NULL,
  CijenaTremina INT NOT NULL,
  PRIMARY KEY (TerminID)
);

CREATE TABLE Dvorana
(
  DvoranaID INT NOT NULL,
  ImeDvorane VARCHAR(50) NOT NULL,
  PRIMARY KEY (DvoranaID)
);

CREATE TABLE ProstorDogađaj
(
  ProstorDogadajID INT NOT NULL,
  ImeProstora VARCHAR(200) NOT NULL,
  CijenaProstora INT NOT NULL,
  DvoranaID INT NOT NULL,
  PRIMARY KEY (ProstorDogadajID),
  FOREIGN KEY (DvoranaID) REFERENCES Dvorana(DvoranaID)
);

CREATE TABLE Zauzece
(
  ZauzeceID INT NOT NULL,
  Zauzeto INT NOT NULL,
  Dan DATE,
  TerminID INT NOT NULL,
  ProstorDogadajID INT NOT NULL,
  PRIMARY KEY (ZauzeceID),
  FOREIGN KEY (TerminID) REFERENCES Termin(TerminID),
  FOREIGN KEY (ProstorDogadajID) REFERENCES ProstorDogađaj(ProstorDogadajID)
);

CREATE TABLE ProstorStand
(
  ProstorStandID INT NOT NULL,
  ImeProstora VARCHAR(50) NOT NULL,
  CijenaProstora INT NOT NULL,
  Zauzeto INT NOT NULL,
  DvoranaID INT NOT NULL,
  PRIMARY KEY (ProstorStandID),
  FOREIGN KEY (DvoranaID) REFERENCES Dvorana(DvoranaID)
);

CREATE TABLE Stand
(
  StandID INT NOT NULL,
  ImeStanda VARCHAR(500) NOT NULL,
  DetaljiStanda VARCHAR(2000) NOT NULL,
  IzlagacID INT NOT NULL,
  ProstorStandID INT NOT NULL,
  PRIMARY KEY (StandID),
  FOREIGN KEY (IzlagacID) REFERENCES Izlagac(IzlagacID),
  FOREIGN KEY (ProstorStandID) REFERENCES ProstorStand(ProstorStandID)
);

CREATE TABLE Događaj
(
  DogadajID INT NOT NULL,
  ImeDogađaja VARCHAR(500) NOT NULL,
  DetaljiDogađaja VARCHAR(2000) NOT NULL,
  TipDoađaja VARCHAR(200) NOT NULL,
  ZauzećeID INT NOT NULL,
  IzlagacID INT NOT NULL,
  PRIMARY KEY (DogadajID),
  FOREIGN KEY (ZauzećeID) REFERENCES Zauzece(ZauzeceID),
  FOREIGN KEY (IzlagacID) REFERENCES Izlagac(IzlagacID)
);

CREATE TABLE Prijavnica
(
  PrijavnicaID INT NOT NULL,
  Placeno INT NOT NULL,
  Odobrena INT NOT NULL,
  IzlagacID INT NOT NULL,
  StandID INT,
  ProstorStandID INT,
  DogadajID INT,
  ZauzećeID INT,
  PRIMARY KEY (PrijavnicaID),
  FOREIGN KEY (IzlagacID) REFERENCES Izlagac(IzlagacID),
  FOREIGN KEY (StandID) REFERENCES Stand(StandID),
  FOREIGN KEY (ProstorStandID) REFERENCES ProstorStand(ProstorStandID),
  FOREIGN KEY (DogadajID) REFERENCES Događaj(DogadajID),
  FOREIGN KEY (TerminID) REFERENCES Termin(TerminID)
);
