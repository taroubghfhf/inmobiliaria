create table apartamento
(
    id varchar(55) not null primary key unique,
    balcon boolean,
    piso integer,
    valor_administracion decimal,
    numero_parqueaderos integer
);

create table chalet
(
    id varchar(55) not null primary key unique,
    agua_potable boolean,
    alcantarillado boolean,
    pozo_septico boolean,
    internet boolean,
    energia_electrica boolean,
    gas_domiciliario boolean
);

create table casa
(
    id varchar(55) not null primary key unique
);

create table vivienda
(
    id varchar(55) not null primary key unique,
    numero_habitaciones integer,
    numero_banos integer,
    material varchar(255),
    id_apartamento varchar(55)
        constraint vivienda_apartamento_id_fk
            references apartamento,
    id_chalet varchar(55)
        constraint vivienda_chalet_id_fk
            references chalet,
    id_casa varchar(55)
        constraint vivienda_casa_id_fk
            references casa
);

create table edificio
(
    id varchar(55) not null primary key unique
);

create table parqueadero
(
    id varchar(55) not null primary key unique
);

create table lote
(
    id varchar(55) not null primary key unique,
    tipo varchar(55)
);

create table bodega
(
    id varchar(55) not null primary key unique,
    tipo varchar(55)
);

create table propiedad
(
    id serial not null primary key unique,
    direccion varchar(255) not null,
    disponible boolean default TRUE,
    precio decimal default 0 not null,
    fecha_creacion timestamp,
    area decimal default 0 not null,
    unidades_area varchar(10) default 'KM2'   not null,
    disposicion_propiedad varchar(55) default 'VENTA',
    id_vivienda varchar(55)
        constraint propiedad_vivienda_id_fk
            references vivienda,
    id_edificio varchar(55)
        constraint propiedad_edificio_id_fk
            references edificio,
    id_bodega varchar(55)
        constraint propiedad_bodega_id_fk
            references bodega,
    id_lote varchar(55)
        constraint propiedad_lote_id_fk
            references lote,
    id_parqueadero varchar(55)
        constraint propiedad_parqueadero_fk
            references parqueadero
);

create table rol
(
    id serial primary key unique,
    tipo_rol varchar(255) not null unique
);

create table usuario
(
    id serial primary key unique,
    email varchar(255) not null unique,
    password varchar(255) not null,
    estado boolean default TRUE,
    id_rol integer not null
        constraint usuario_rol_id_fk
            references rol
);
-- --------------------------------------------------------------
create table empleado
(
    id integer not null primary key unique,
    nombre  varchar(255) not null,
    celular varchar(55)  not null,
    id_usuario integer not null
        constraint empleado_usuario_id_fk
            references usuario
);

create table propietario
(
    id integer not null primary key unique,
    nombre  varchar(255) not null,
    celular varchar(55)  not null
);

create table cliente
(
    id integer not null primary key unique,
    nombre  varchar(255) not null,
    celular varchar(55)  not null
);
-- --------------------------------------------------------------

create table historial_propiedad
(
    id serial primary key unique,
    fecha_modificacion timestamp,
    id_propiedad integer not null
        constraint historial_propiedad_propiedad_id_fk
            references propiedad,
    id_empleado integer not null
        constraint historial_propiedad_empleado_id_fk
            references empleado,
    id_propietario integer
        constraint historial_propiedad_propietario_id_fk
            references propietario,
    id_cliente integer
        constraint historial_propiedad_cliente_id_fk
            references cliente
);


insert into rol (tipo_rol)
values ('Admin');

insert into rol (tipo_rol)
values ('Empleado');

insert into usuario (email, password, id_rol)
VALUES ('admin@inmo.com', 'password_admin', 1);