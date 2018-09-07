create table entities (
  id serial primary key,
  name varchar(255) not null,
  type varchar(255),
  description varchar(1027),
  version integer,
  start_time timestamp,
  end_time timestamp,
  owner integer references users(id),
  is_public boolean,
  unique(name, type, owner)
);

create table entity_stats (
  id serial primary key,
  entity_id integer references entities(id),
  name varchar(127),
  value float not null,
  str_value varchar(255),
  start_time timestamp not null,
  end_time timestamp not null,
  src varchar(255),
  description varchar(1027),
  unique(entity_id, name, start_time, end_time)
);

create index on entity_stats(start_time);
create index on entity_stats(end_time);

create table users (
  id serial primary key,
  username varchar(127),
  password varchar(255),
  email varchar(255),
  first_name varchar(127),
  last_name varchar(127),
  unique(username)
);

create table datasets (
  id serial primary key,
  name varchar(255),
  owner integer references users(id),
  is_public boolean,
  unique(name, owner, is_public)
);

create table dataset_fields (
  id serial primary key,
  dataset_id integer references datasets(id),
  entity_id integer references entities(id),
  entity_stat_id integer references entity_stats(id),
  unique(dataset_id, entity_id, entity_stat_id)
);

--create table entity_of (
--  id serial primary key,
--  child integer references entities(id),
--  parent integer references entities(id),
--  unique(child, parent)
--);
