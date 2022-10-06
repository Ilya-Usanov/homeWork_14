create table world_car (id serial constraint world_car_pk primary key, brand  varchar, fuel_economy double precision);

alter table world_car owner to postgres;

create unique index world_car_id_uindex on world_car (id);

create table world_track(id serial constraint world_track_pk primary key, track  varchar, laps integer, lap_distance integer);

alter table world_track owner to postgres;

create unique index world_track_id_uindex on world_track (id);

INSERT INTO world_car (brand , fuel_economy )
    values ('Ferrari' , 85.5);
INSERT INTO world_car (brand , fuel_economy )
    values ('Mercedes' , 80.0);
INSERT INTO world_track (track , laps, lap_distance )
    values ('Spa' , 25, 6976);
INSERT INTO world_track (track , laps, lap_distance )
    values ('Nurburgring' , 30, 5148);