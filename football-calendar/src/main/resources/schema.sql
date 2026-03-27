/*

CREATE LOGIN sportradar_user WITH PASSWORD = 'TwojeHaslo123!';
create database sportradar
use sportradar
CREATE USER sportradar_user FOR LOGIN sportradar_user;
ALTER ROLE db_owner ADD MEMBER sportradar_user;
*/
CREATE TABLE Teams (
    id INT PRIMARY KEY IDENTITY(1,1),
    [name] NVARCHAR(100) NOT NULL,
    officialName nvarchar(256) not null,
    slug nvarchar(256) not null,
    abbreviation char(3) not null,
    teamCountryCode char(3) not null,
    stagePosition int null,
    team_information nvarchar(512) null
);
create table event_metadate(
    id int primary key identity(1,1),
    season decimal(4,0) not null,
    [status] varchar(256) null,
    timeVenueUTC TIME not null,
    dateVenue Date not null,
    stadium nvarchar(256) null,
    [group] int,
    originCompetitionId nvarchar(256),
    originCompetitionName nvarchar(256),
    event_descritpion nvarchar(512) null,
    venue_datails nvarchar(512) null
);
create table [group]
(
id int primary key identity(1,1),
[name] varchar(32)
);

create table result(
id int primary key identity(1,1),
homeGoals int null,
awayGoals int null,
_winnerId int null,
[message] nvarchar(1024) null
constraint fk_teams_result foreign key (_winnerId) references Teams(id)
);
create table goals(
    id  int primary key identity(1,1),
    _result_id int not null,
    minute_scored int,
    player_name nvarchar(256),
    constraint fk_result_goals foreign key (_result_id) references result(id)
);
create table yellowCards(
    id  int primary key identity(1,1),
    _result_id int not null,
    [minute] int,
    player_name nvarchar(256)
    constraint fk_result_yellowCard foreign key (_result_id) references result(id)
);
create table secondYellowCards(
    id  int primary key identity(1,1),
    _result_id int not null,
    [minute] int,
    player_name nvarchar(256)
    constraint fk_result_secondyellowCard foreign key (_result_id) references result(id)
);
create table directRedCards(
    id  int primary key identity(1,1),
    _result_id int not null,
    [minute] int,
    player_name nvarchar(256)
    constraint fk_result_redcard foreign key (_result_id) references result(id)
);
create table scoreByPeriods(
id int primary key identity(1,1),
_result_id int not null,
home_team_score int default 0,
away_team_score int default 0,
[date] date

constraint fk_result foreign key (_result_id) references result(id)
);




create table stage(
id varchar(256) primary key not null,
[name] varchar(256),
ordering int 
);



CREATE TABLE Events (
    id INT PRIMARY KEY IDENTITY(1,1),
    _event_metadate_id int null,
    _homeTeam_id int null,
    _awayTeam_id int null,
    _result_id int null,
    _stage_id varchar(256) null,
    _group_id int null

    constraint FK_details_events foreign key  (_event_metadate_id) references event_metadate(id),
    constraint FK_homeTeam_events foreign key  (_homeTeam_id) references Teams(id),
    constraint FK_awayTeam_events foreign key  (_awayTeam_id) references Teams(id),
    constraint FK_result_events foreign key  (_result_id) references result(id),
    constraint FK_stage_events foreign key  (_stage_id) references stage(id),
    constraint FK_group_events foreign key  (_group_id) references [group](id)

);

-- Dru�yny
INSERT INTO Teams (name, officialName, slug, abbreviation, teamCountryCode, stagePosition, team_information)
VALUES 
('Real Madrid', 'Real Madrid Club de F�tbol', 'real-madrid', 'RMA', 'ESP', 1, 'Klub z Madrytu'),
('FC Barcelona', 'Futbol Club Barcelona', 'fc-barcelona', 'BAR', 'ESP', 2, 'Duma Katalonii'),
('Man City', 'Manchester City Football Club', 'man-city', 'MCI', 'GBR', 1, 'Mistrz Anglii'),
('Bayern', 'FC Bayern M�nchen', 'bayern-munich', 'BAY', 'DEU', 1, 'Gigant z Bawarii');

-- Grupy
INSERT INTO [group] ([name]) VALUES ('Group A'), ('Group B');

-- Etapy (Stage)
INSERT INTO stage (id, [name], ordering)
VALUES 
('group_stage', 'Group Stage', 1),
('quarter_final', 'Quarter Final', 2),
('semi_final', 'Semi Final', 3),
('final', 'Final', 4);
-- Wynik meczu (Real vs Barca - Real wygra� 2:1)
INSERT INTO result (homeGoals, awayGoals, _winnerId, [message])
VALUES (2, 1, 1, 'Zaci�te El Cl�sico');

-- Metadane meczu (Stadion, Data, Czas)
INSERT INTO event_metadate (season, [status], timeVenueUTC, dateVenue, stadium, [group], originCompetitionId, originCompetitionName, event_descritpion, venue_datails)
VALUES (2024, 'closed', '20:00:00', '2026-03-27', 'Santiago Bernab�u', 1, 'ucl', 'Champions League', 'Wielki mecz towarzyski', 'Dach zamkni�ty');

-- Bramki (Dla wyniku o ID 1)
INSERT INTO goals (_result_id, minute_scored, player_name)
VALUES 
(1, 12, 'Vin�cius J�nior'),
(1, 45, 'Robert Lewandowski'),
(1, 88, 'Jude Bellingham');

-- Kartki (Dla wyniku o ID 1)
INSERT INTO yellowCards (_result_id, [minute], player_name) VALUES (1, 30, 'Gavi');
INSERT INTO directRedCards (_result_id, [minute], player_name) VALUES (1, 90, 'Ronald Ara�jo');
-- Dodajemy mecz: Real Madryt (ID 1) vs FC Barcelona (ID 2)
INSERT INTO Events (_event_metadate_id, _homeTeam_id, _awayTeam_id, _result_id, _stage_id, _group_id)
VALUES (1, 1, 2, 1, 'group_stage', 1);
/*
go
drop table events
go
drop table stage
go
drop table scoreByPeriods
go
drop table directRedCards
go
drop table secondYellowCards
go
drop table yellowCards
go
drop table goals
go
drop table result
go
drop table [group]
go
drop table event_metadate
go
drop table Teams
go
*/