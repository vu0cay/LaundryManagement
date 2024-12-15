use LaundryServices;

drop table if exists STATUS_DETAILS;
drop table if exists ORDER_DETAILS;
drop table if exists ORDERS;
drop table if exists LAUNDRY_SERVICES;
drop table if exists ITEMS;
drop table if exists CUSTOMERS;
drop table if exists STAFFS;
drop table if exists LAUNDRYSHOPS;



create table LAUNDRYSHOPS (
 L_id int identity(1,1) primary key,
 L_name varchar(100),
 L_address varchar(150),
 L_phone varchar(20),
);

insert into LAUNDRYSHOPS(L_name, L_address, L_phone) values ('Super Fast Clean', '3/2 Xuan Khanh, Ninh Kieu, TP. Can Tho', '+84 8386 083 860');


create table STAFFS (
 SF_id int identity(1,1) primary key,
 SF_name varchar(100),
 SF_username varchar(100) unique,
 SF_password varchar(100),
 SF_phone varchar(20),
 SF_address varchar(150),
 L_id int foreign key references LAUNDRYSHOPS(L_id),
);

insert into staffs (SF_name, SF_username, SF_password, SF_phone, SF_address, L_id)
	values('Cake','admin','admin','01234567890','Xuan Khanh, Ninh Kieu, TP. Can Tho', 1);


create table CUSTOMERS (
	CUS_id int identity(1,1) primary key,
	CUS_name varchar(100),
	CUS_phone varchar(15)
);





create table ITEMS (
	ITEM_id int identity(1,1) primary key,
	ITEM_type varchar(100),
	ITEM_unit_price float
);

insert into ITEMS (ITEM_type, ITEM_unit_price) values ('clothes',7000);
insert into ITEMS (ITEM_type, ITEM_unit_price) values ('stuffed_animals',40000);
insert into ITEMS (ITEM_type, ITEM_unit_price) values ('bedding',9000);
insert into ITEMS (ITEM_type, ITEM_unit_price) values ('others',10000);

create table LAUNDRY_SERVICES (
	LS_id int identity(1,1) primary key,
	LS_name varchar(50),
	LS_multiplier float
);


insert into LAUNDRY_SERVICES(LS_name, LS_multiplier)
	values ('washing',1);
insert into LAUNDRY_SERVICES(LS_name, LS_multiplier)
	values ('washing and ironing',1.5);
insert into LAUNDRY_SERVICES(LS_name, LS_multiplier)
	values ('quick washing and ironing',2);
insert into LAUNDRY_SERVICES(LS_name, LS_multiplier)
	values ('quick washing',1.5);



create table ORDERS (
	ORDER_id int identity(1,1) primary key,
	CUS_id int foreign key references CUSTOMERS(CUS_id),
	ORDER_order_date date,
	ORDER_pickup_date date,
        ORDER_total_price float
);



create table ORDER_DETAILS (
	LS_id int foreign key references LAUNDRY_SERVICES(LS_id),
	ITEM_id int foreign key references ITEMS(ITEM_id),
	ORDER_id int foreign key references ORDERS(ORDER_id),
	OD_kilos float
);

create table STATUS_DETAILS (
	SF_id int foreign key references STAFFS(SF_id),
	ORDER_id int foreign key references ORDERS(ORDER_id),
	SD_status varchar(20),
	SD_timestamp timestamp
);

--delete from STATUS_DETAILS;
--delete from orders;
--DBCC CHECKIDENT ('ORDERS', RESEED, 0);

select * from items;
select * from LAUNDRY_SERVICES;

insert into CUSTOMERS (CUS_name, CUS_phone) values ('John Son','0123456778');
insert into CUSTOMERS (CUS_name, CUS_phone) values ('Brown','0193756778');
insert into CUSTOMERS (CUS_name, CUS_phone) values ('Chi An','0123493878');
insert into CUSTOMERS (CUS_name, CUS_phone) values ('David Wilson','0123495201');


insert into ORDERS(CUS_id,ORDER_order_date) values (1,'2024-11-10');
insert into ORDERS(CUS_id,ORDER_order_date) values (2,'2024-11-11');
insert into ORDERS(CUS_id,ORDER_order_date) values (1,'2024-11-08');
insert into ORDERS(CUS_id,ORDER_order_date) values (1,'2024-11-01');
insert into ORDERS(CUS_id,ORDER_order_date) values (3,'2024-11-08');
insert into ORDERS(CUS_id,ORDER_order_date) values (4,'2024-11-08');

insert into ORDERS(CUS_id,ORDER_order_date) values (2,'2024-11-12');
insert into ORDERS(CUS_id,ORDER_order_date) values (3,'2024-11-12');

insert into ORDERS(CUS_id,ORDER_order_date) values (1,'2024-11-13');
insert into ORDERS(CUS_id,ORDER_order_date) values (4,'2024-11-13');

insert into ORDERS(CUS_id,ORDER_order_date) values (2,'2024-11-14');
insert into ORDERS(CUS_id,ORDER_order_date) values (1,'2024-11-15');
insert into ORDERS(CUS_id,ORDER_order_date) values (3,'2024-11-16');
insert into ORDERS(CUS_id,ORDER_order_date) values (3,'2024-11-17');
insert into ORDERS(CUS_id,ORDER_order_date) values (4,'2024-11-18');
insert into ORDERS(CUS_id,ORDER_order_date) values (2,'2024-11-14');
insert into ORDERS(CUS_id,ORDER_order_date) values (3,'2024-11-15');
insert into ORDERS(CUS_id,ORDER_order_date) values (3,'2024-11-16');
insert into ORDERS(CUS_id,ORDER_order_date) values (4,'2024-11-17');
insert into ORDERS(CUS_id,ORDER_order_date) values (2,'2024-11-19');
select* from ORDERs;


select* from orders;

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,1,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,1,'completed');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,1,'paid');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,2,'processing');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,3,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,3,'completed');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,4,'processing');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,5,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,5,'completed');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,5,'paid');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,6,'processing');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,7,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,7,'completed');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,8,'processing');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,9,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,9,'completed');


insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,10,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,10,'completed');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,10,'paid');


insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,12,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,12,'completed');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,12,'paid');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,13,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,13,'completed');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,14,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,14,'completed');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,14,'paid');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,15,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,15,'completed');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,15,'paid');

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,11,'processing');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,11,'completed');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,11,'paid');

--see each order with its status and order-date

--MONTH(getdate());
with latestStatus as 
	(select ORDER_id,SD_status, ROW_NUMBER() over 
	(partition by order_id order by sd_timestamp desc) as row_num
	from STATUS_DETAILS)

select orders.ORDER_id, sd_status, order_order_date
from latestStatus join ORDERS on latestStatus.ORDER_id = ORDERS.ORDER_id
where row_num=1 and MONTH(ORDER_order_date)=9;

--by month
with latestStatus as 
	(select ORDER_id,SD_status, ROW_NUMBER() over 
	(partition by order_id order by sd_timestamp desc) as row_num
	from STATUS_DETAILS)
select sd_status, count(distinct lateststatus.ORDER_id) as num
from 
	latestStatus join ORDERS on latestStatus.ORDER_id = ORDERS.ORDER_id
where
	latestStatus.row_num=1
	and MONTH(ORDER_order_date) = MONTH(getdate())
group by SD_status;

--in 7 days
with latestStatus as 
	(select ORDER_id,SD_status, ROW_NUMBER() over 
	(partition by order_id order by sd_timestamp desc) as row_num
	from STATUS_DETAILS)
select sd_status, count(distinct lateststatus.ORDER_id) as num
from 
	latestStatus join ORDERS on latestStatus.ORDER_id = ORDERS.ORDER_id
where
	latestStatus.row_num=1
	and ORDER_order_date >= DATEADD(DAY, -7, GETDATE())
group by SD_status;


--
with latestStatus as 
	(select ORDER_id,SD_status, ROW_NUMBER() over 
	(partition by order_id order by sd_timestamp desc) as row_num
	from STATUS_DETAILS)

select count (distinct ORDER_id) as remainOrders
from latestStatus where row_num=1 and SD_status='processing';


-----
with latestStatus as 
	(select ORDER_id,SD_status, ROW_NUMBER() over 
	(partition by order_id order by sd_timestamp desc) as row_num
	from STATUS_DETAILS)
select 
sd_status, count(distinct lateststatus.ORDER_id) as num
from 
	latestStatus join ORDERS on latestStatus.ORDER_id = ORDERS.ORDER_id
where
	latestStatus.row_num=1
	and ORDER_order_date = CAST(getdate() as date)
group by SD_status;
----------------

with latestStatus as 
	(select ORDER_id,SD_status, ROW_NUMBER() over 
	(partition by order_id order by sd_timestamp desc) as row_num
	from STATUS_DETAILS)
select 
sd_status, latestStatus.ORDER_id as ORDER_ID, ORDER_total_price as total_price
from 
	latestStatus join ORDERS on latestStatus.ORDER_id = ORDERS.ORDER_id
where
	latestStatus.row_num=1
	and ORDER_order_date >=DATEADD(day,-7,getdate())
group by SD_status, latestStatus.ORDER_id, ORDER_total_price;

-----------------
select* from orders;
select* from ORDERS where ORDER_order_date=CAST(getdate() as date);


------
update LAUNDRYSHOPS set L_email='ldrsm02@gmail.com' where L_id=1;

-------------------------------
insert into ORDERS(CUS_id,ORDER_order_date,ORDER_total_price) values (1,'2024-11-17',56000);
insert into ORDERS(CUS_id,ORDER_order_date,ORDER_total_price) values (1,'2024-11-18',30000);
insert into ORDERS(CUS_id,ORDER_order_date,ORDER_total_price) values (1,'2024-11-19',25000);
insert into ORDERS(CUS_id,ORDER_order_date,ORDER_total_price) values (1,'2024-11-19',42000);
select* from ORDERS;

insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,23,'paid');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,24,'paid');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,25,'paid');
insert into STATUS_DETAILS(SF_id,ORDER_id,SD_status) values (1,22,'paid');

