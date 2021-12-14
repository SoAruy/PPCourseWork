CREATE DATABASE ChefCook
ON PRIMARY
( NAME = ChefCook_dat,  
    FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\chefcookdat.mdf',  
    SIZE = 10,    
    FILEGROWTH = 5 ), 
filegroup[Salads]
( NAME = Salads_dat,
	FILENAME =  'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\saladsdat.ndf',  
    SIZE = 10,    
    FILEGROWTH = 5 ),
filegroup[Vegetables]
( NAME = Vegetables_dat,
	FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\vegetablesdat.ndf',  
    SIZE = 10,    
    FILEGROWTH = 5 )
LOG ON  
( NAME = Cinema_log,  
    FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\cinemalog.ldf',  
    SIZE = 5MB,  
    MAXSIZE = 25MB,  
    FILEGROWTH = 5MB ) ;
