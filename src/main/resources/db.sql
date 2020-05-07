create table keywords(
	id serial,
	name varchar(100) not null,
	implementing_class varchar(1024) not null,
	CONSTRAINT unique_name_class unique(name,implementing_class),
	primary key(id)
);

create table parameters(
	id serial primary key,
	name varchar(100),
	keyword_id int,
foreign key (keyword_id) references keywords
);

-- component classes

create table component_nodes (
	id varchar(10) primary key,
	name varchar(100),
	parent_id varchar(10),
	foreign key (parent_id) references component_nodes(id)

);

create table components (
	id varchar(10) primary key,
	name varchar(100),
	description varchar(1024),
	node varchar(10) references component_nodes(id)
);

 -- Seauences
 create sequence node_sequence start 1;
 create sequence component_sequence start 1;