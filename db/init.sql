create table entities (
  id integer primary key,
  name varchar(255) not null,
  type varchar(255)
);

create table entity_stat_names (
  id integer primary key,
  name varchar(255) unique not null
);

create table entity_stats (
  id integer primary key,
  entity_id integer references entities(id),
  name_id integer references entity_stat_names(id),
  value float not null,
  str_value varchar(255),
  start_time timestamp not null,
  end_time timestamp not null,
  src varchar(255)
);

create index on entity_stats(start_time);
create index on entity_stats(end_time);

create table entity_of (
  child integer references entities(id),
  parent integer references entities(id)
);
