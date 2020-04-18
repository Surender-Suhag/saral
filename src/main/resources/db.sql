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

create table ComponentsClasses (
id serial primary key,
name varchar(100),
parent_id int,

foreign key (parent_id) references ComponentsClasses(id)
)