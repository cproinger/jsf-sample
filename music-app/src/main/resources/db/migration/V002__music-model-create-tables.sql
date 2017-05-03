CREATE TABLE Artist
(
    Artist_id INTEGER  NOT NULL,
    Name NVARCHAR(120),
    CONSTRAINT PK_Artist PRIMARY KEY  (Artist_id)
);

CREATE TABLE Album
(
    Album_id INTEGER  NOT NULL,
    Title NVARCHAR(160)  NOT NULL,
    Artist_id INTEGER  NOT NULL,
    CONSTRAINT PK_Album PRIMARY KEY  (Album_id),
    FOREIGN KEY (Artist_id) REFERENCES Artist (Artist_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE Employee
(
    Employee_id INTEGER  NOT NULL,
    LastName NVARCHAR(20)  NOT NULL,
    FirstName NVARCHAR(20)  NOT NULL,
    Title NVARCHAR(30),
    ReportsTo INTEGER,
    BirthDate DATETIME,
    HireDate DATETIME,
    Address NVARCHAR(70),
    City NVARCHAR(40),
    State NVARCHAR(40),
    Country NVARCHAR(40),
    PostalCode NVARCHAR(10),
    Phone NVARCHAR(24),
    Fax NVARCHAR(24),
    Email NVARCHAR(60),
    CONSTRAINT PK_Employee PRIMARY KEY  (Employee_id),
    FOREIGN KEY (ReportsTo) REFERENCES Employee (Employee_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION
);



CREATE TABLE Customer
(
    Customer_id INTEGER  NOT NULL,
    FirstName NVARCHAR(40)  NOT NULL,
    LastName NVARCHAR(20)  NOT NULL,
    Company NVARCHAR(80),
    Address NVARCHAR(70),
    City NVARCHAR(40),
    State NVARCHAR(40),
    Country NVARCHAR(40),
    PostalCode NVARCHAR(10),
    Phone NVARCHAR(24),
    Fax NVARCHAR(24),
    Email NVARCHAR(60)  NOT NULL,
    SupportRep_id INTEGER,
    CONSTRAINT PK_Customer PRIMARY KEY  (Customer_id),
    FOREIGN KEY (SupportRep_id) REFERENCES Employee (Employee_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE Genre
(
    Genre_id INTEGER  NOT NULL,
    Name NVARCHAR(120),
    CONSTRAINT PK_Genre PRIMARY KEY  (Genre_id)
);



CREATE TABLE Invoice
(
    Invoice_id INTEGER  NOT NULL,
    Customer_id INTEGER  NOT NULL,
    InvoiceDate DATETIME  NOT NULL,
    BillingAddress NVARCHAR(70),
    BillingCity NVARCHAR(40),
    BillingState NVARCHAR(40),
    BillingCountry NVARCHAR(40),
    BillingPostalCode NVARCHAR(10),
    Total NUMERIC(10,2)  NOT NULL,
    CONSTRAINT PK_Invoice PRIMARY KEY  (Invoice_id),
    FOREIGN KEY (Customer_id) REFERENCES Customer (Customer_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE MediaType
(
    MediaType_id INTEGER  NOT NULL,
    Name NVARCHAR(120),
    CONSTRAINT PK_MediaType PRIMARY KEY  (MediaType_id)
);

CREATE TABLE Playlist
(
    Playlist_id INTEGER  NOT NULL,
    Name NVARCHAR(120),
    CONSTRAINT PK_Playlist PRIMARY KEY  (Playlist_id)
);


CREATE TABLE Track
(
    Track_id INTEGER  NOT NULL,
    Name NVARCHAR(200)  NOT NULL,
    Album_id INTEGER,
    MediaType_id INTEGER  NOT NULL,
    Genre_id INTEGER,
    Composer NVARCHAR(220),
    Milliseconds INTEGER  NOT NULL,
    Bytes INTEGER,
    UnitPrice NUMERIC(10,2)  NOT NULL,
    CONSTRAINT PK_Track PRIMARY KEY  (Track_id),
    FOREIGN KEY (Album_id) REFERENCES Album (Album_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (Genre_id) REFERENCES Genre (Genre_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (MediaType_id) REFERENCES MediaType (MediaType_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION
);

create view AlbumTracks as
select Album_id, count(*) as count from Track
group by Album_id;

CREATE TABLE PlaylistTrack
(
    Playlist_id INTEGER  NOT NULL,
    Track_id INTEGER  NOT NULL,
    CONSTRAINT PK_PlaylistTrack PRIMARY KEY  (Playlist_id, Track_id),
    FOREIGN KEY (Playlist_id) REFERENCES Playlist (Playlist_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (Track_id) REFERENCES Track (Track_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE InvoiceLine
(
    InvoiceLine_id INTEGER  NOT NULL,
    Invoice_id INTEGER  NOT NULL,
    Track_id INTEGER  NOT NULL,
    UnitPrice NUMERIC(10,2)  NOT NULL,
    Quantity INTEGER  NOT NULL,
    CONSTRAINT PK_InvoiceLine PRIMARY KEY  (InvoiceLine_id),
    FOREIGN KEY (Invoice_id) REFERENCES Invoice (Invoice_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (Track_id) REFERENCES Track (Track_id) 
		ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE INDEX IFK_AlbumArtist_id ON Album (Artist_id);

CREATE INDEX IFK_CustomerSupportRep_id ON Customer (SupportRep_id);

CREATE INDEX IFK_EmployeeReportsTo ON Employee (ReportsTo);

CREATE INDEX IFK_InvoiceCustomer_id ON Invoice (Customer_id);

CREATE INDEX IFK_InvoiceLineInvoice_id ON InvoiceLine (Invoice_id);

CREATE INDEX IFK_InvoiceLineTrack_id ON InvoiceLine (Track_id);

CREATE INDEX IFK_PlaylistTrackTrack_id ON PlaylistTrack (Track_id);

CREATE INDEX IFK_TrackAlbum_id ON Track (Album_id);

CREATE INDEX IFK_TrackGenre_id ON Track (Genre_id);

CREATE INDEX IFK_TrackMediaType_id ON Track (MediaType_id);
