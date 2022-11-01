create table propiedad
(
    id                     varchar(55)                not null
        primary key
        unique,
    direccion              varchar(255)                not null,
    disponible             boolean     default TRUE,
    precio                 decimal     default 0       not null,
    fecha                  timestamp,
    "fechaCreacion" timestamp,
    area                   decimal     default 0 not null,
    "tipoArea"             varchar(10) default 'KM2'   not null,
    "numeroPisos"          int,
    "disposicionPropiedad" varchar(55) default 'VENTA',
    "tipoPropiedad"     varchar(55),
    "numeroHabitaciones"    int,
    "numeroBanos"   int,
    material    varchar(255),
    balcon  boolean,
    ascensor boolean,
    "tipoBodegaLote" varchar(255),
    piso int,
    "numeroParqueaderos" int,
    "valorAdministracion" decimal,
    "aguaPotable" boolean,
    "alcantarillado" boolean,
    "pozoSeptico" boolean,
    internet boolean,
    "energiaElectrica" boolean,
    "gasDomiciliario" boolean
);

create table empleado
(
    id      varchar(55)  not null
        primary key
        unique,
    nombre  varchar(255) not null,
    celular varchar(55)  not null,
    "idUsuario" integer not null
        constraint "Empleado_Usuario_null_fk"
            references usuario
);
create table propietario
(
    id      varchar(55)  not null
        primary key
        unique,
    nombre  varchar(255) not null,
    celular varchar(55)  not null
);

create table usuario
(
    id       serial
        primary key
        unique,
    email    varchar(255) not null
        unique,
    password varchar(255) not null,
    id_rol integer not null
        constraint "Usuario_Rol_null_fk"
            references rol
);

create table rol
(
    id        serial
        primary key
        unique,
    "tipoRol" varchar(255) not null
        unique
);

create table "PropiedadEmpleadoPropietario"
(
    id              serial
        primary key
        unique,
    "idPropiedad"   varchar(55) not null
        constraint propiedadempleadopropietario_propiedad_id_fk
            references propiedad,
    "idEmpleado"    varchar(55) not null
        constraint propiedadempleadopropietario_empleado_id_fk
            references empleado,
    "idPropietario" varchar(55)
        constraint propiedadempleadopropietario_propietario_id_fk
            references propietario,
    "idCliente" varchar(55)
        constraint "PropiedadEmpleadoPropietario_cliente_null_fk"
            references cliente
);

insert into rol ("tipoRol")
values ('Admin');

insert into rol ("tipoRol")
values ('Empleado');

create table cliente
(
    id      varchar(55)  not null
        primary key
        unique,
    nombre  varchar(255) not null,
    celular varchar(55)  not null
);

