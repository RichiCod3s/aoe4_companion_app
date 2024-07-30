 	-- table for units
    CREATE TABLE units (
    id integer auto_increment primary key,
    unit_name VARCHAR(50) not null unique, 
    unit_type varchar(50) not null, -- infantry, cavalry, seige
    armour_type varchar(50), -- light, heavy, null(seige)
    attack_type varchar(50) not null -- melee, ranged
    -- text type to add last 3 together? (ex: light ranged infantry)
    );
    
    -- table for civs
    CREATE TABLE civilizations(
    civ_id integer auto_increment key,
    civ_name varchar(50) not null unique    
    );
    
    -- links units with civs
    CREATE TABLE civilizations_units(
    civ_id integer,
    unit_id integer,
    primary key (civ_id, unit_id),
    foreign key(civ_id) references civilizations(civ_id) on delete cascade,
	foreign key(unit_id) references units(id) on delete cascade
    );
    
	-- which units counter enemy well
	CREATE TABLE strong_against(
    unit_id integer,
    enemy_id integer,
    primary key (unit_id, enemy_id),
    foreign key (unit_id) references units(id) on delete cascade,
    foreign key (enemy_id) references units(id) on delete cascade
    );
    
    -- counter to that unit (weak against)
    CREATE TABLE weak_against(
    unit_id integer,
    enemy_id integer,
    primary key (unit_id, enemy_id),
    foreign key (unit_id) references units(id) on delete cascade,
    foreign key (enemy_id) references units(id) on delete cascade
    );