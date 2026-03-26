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
)
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
)
create table [group]
(
id int primary key identity(1,1),
[name] varchar(32)
)

create table result(
id int primary key identity(1,1),
homeGoals int null,
awayGoals int null,
_winnerId int null,
[message] nvarchar(1024) null
constraint fk_teams_result foreign key (_winnerId) references Teams(id)
)
create table goals(
    id  int primary key identity(1,1),
    _result_id int not null,
    minute_scored int,
    player_name nvarchar(256),
    constraint fk_result_goals foreign key (_result_id) references result(id)
)
create table yellowCards(
    id  int primary key identity(1,1),
    _result_id int not null,
    [minute] int,
    player_name nvarchar(256)
    constraint fk_result_yellowCard foreign key (_result_id) references result(id)
)
create table secondYellowCards(
    id  int primary key identity(1,1),
    _result_id int not null,
    [minute] int,
    player_name nvarchar(256)
    constraint fk_result_secondyellowCard foreign key (_result_id) references result(id)
)
create table directRedCards(
    id  int primary key identity(1,1),
    _result_id int not null,
    [minute] int,
    player_name nvarchar(256)
    constraint fk_result_redcard foreign key (_result_id) references result(id)
)
create table scoreByPeriods(
id int primary key identity(1,1),
_result_id int not null,
home_team_score int default 0,
away_team_score int default 0,
[date] date

constraint fk_result foreign key (_result_id) references result(id)
)




create table stage(
id varchar(256) primary key not null,
[name] varchar(256),
ordering int 
)



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