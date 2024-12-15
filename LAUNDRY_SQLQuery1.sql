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
	values('Nguyen Hoang Vu','admin','admin','0327151625','Xuan Khanh, Ninh Kieu, TP. Can Tho', 1);


create table CUSTOMERS (
	CUS_id int identity(1,1) primary key,
	CUS_name varchar(100),
	CUS_phone varchar(15)
);

insert into customers (CUS_name, CUS_phone) values (?, ?);


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
	ORDER_pickup_date date
        ORDER_total_price float
);


insert into ORDERS (CUS_id, ORDER_order_date, ORDER_pickup_date, ORDER_total_price) values (?, ?, ?, ?);
create table ORDER_DETAILS (
	LS_id int foreign key references LAUNDRY_SERVICES(LS_id),
	ITEM_id int foreign key references ITEMS(ITEM_id),
	ORDER_id int foreign key references ORDERS(ORDER_id),
	OD_kilos float
);

insert into ORDER_DETAILS (LS_id, ITEM_id, ORDER_id, OD_kilos) values(?, ?, ?, ?);

create table STATUS_DETAILS (
	SF_id int foreign key references STAFFS(SF_id),
	ORDER_id int foreign key references ORDERS(ORDER_id),
	SD_status varchar(20),
	SD_timestamp timestamp
);

insert into STATUS_DETAILS (SF_id, ORDER_id, SD_status, SD_timestamp) values(1, 19, "Pending", '2024-11-14 10:30:00');
INSERT INTO STATUS_DETAILS (SF_id, ORDER_id, SD_status, SD_timestamp)
VALUES (1, 1001, 'In Progress', '2024-11-14 10:30:00');
select * from items;
select * from LAUNDRY_SERVICES;

public void insertStatus(int staffId, int orderId, String status) {
    String sql = "INSERT INTO STATUS_DETAILS (SF_id, ORDER_id, SD_status) VALUES (?, ?, ?)";

    try (Connection con = database.openConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setInt(1, staffId);
        pstmt.setInt(2, orderId);
        pstmt.setString(3, status);

        pstmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(ex.getMessage());
        alert.showAndWait();
    }
}

    @FXML
    private Button btnOrderListEditCancel;

    @FXML
    private Button btnOrderListEditSave;
    
    @FXML
    private ComboBox<?> rmenuOrderListEdit;    

    @FXML
    private DialogPane paneOrderList_editStatus;