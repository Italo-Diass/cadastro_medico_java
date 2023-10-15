create table cidade (
    idcidade serial not null,
    nomecidade varchar (30),
    constraint pk_cidade primary key (idcidade)
);

create table pessoa (
    idpessoa serial not null,
    nomepessoa varchar(40),
    enderecopessoa varchar(40),
    constraint pk_pessoa primary key (idpessoa)
);

create table medico (
    idmedico serial not null,
    crmmedico varchar (40),
    especialidademedico varchar(40),
    idcidade integer,
    idpessoa integer,

    constraint pk_medico primary key (idmedico),

    constraint fk_medico_cidade foreign key(idcidade) references cidade(idcidade),
    constraint fk_medico_pessoa foreign key(idpessoa) references pessoa(idpessoa)            
);

create table convenio (
    idconvenio serial not null,
    nomeconvenio varchar(40),

    constraint pk_convenio primary key(idconvenio)
);

create table medicoconvenio (
    idmedico integer not null,
    idconvenio integer not null,

    constraint pk_medicoconvenio primary key (idmedico, idconvenio),

    constraint fk_medicoconvenio_medico foreign key (idmedico) references medico (idmedico),
    constraint fk_medicoconvenio_convenio foreign key (idconvenio) references convenio (idconvenio)
);









