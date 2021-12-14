USE ChefCook
GO
CREATE SCHEMA SaladsS
GO
CREATE SCHEMA VegetablesS
GO
CREATE TABLE SaladsS.Salads
( SaladID int not null identity(1, 1),
SaladName varchar(50) not null,
[Weight] real not null

constraint PK_Salads primary key (SaladID) on [Salads])

CREATE TABLE VegetablesS.Vegetables
( VegetableID int not null identity(1, 1),
SaladID int not null,
VegetableName varchar(50) not null,
Color varchar(20) not null,
[Weight] real not null,
CalCapPerHundGram real not null,
Proteins real not null,
Fats real not null,
Carbs real not null

constraint PK_Vegetables primary key (VegetableID) on [Vegetables],
constraint FK_Salad foreign key (SaladID) references SaladsS.Salads (SaladID))