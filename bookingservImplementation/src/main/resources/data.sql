drop if exists booking;
CREATE TABLE booking
(
id int primary key ,
first_ame varchar(255) not null,
last_name varchar(255) not null,
dob date not null,
checkin_datetime timestamp not null,
checkout_datetime timestamp not null,
totalprice double not null,
deposit double not null,
address_id int foreign key references Address(id)
);

drop table if exists address;
CREATE TABLE address
(
id int primary key,
line1 varchar(255) not null,
line2 varchar(255),
city varchar(100) not null,
state varchar(100) not null,
zip_code varchar(20) not null
);