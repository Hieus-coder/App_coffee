-- Tạo cơ sở dữ liệu QLCoffee
CREATE DATABASE QLCOFFEE;

GO
/*--------------------------------------------------------------------*/

-- Sử dụng cơ sở dữ liệu QLCOFFEE
USE QLCOFFEE;

GO
/*--------------------------------------------------------------------*/

-- Tạo bảng ACCOUNT để lưu thông tin tài khoản admin
CREATE TABLE ACCOUNT (
	ID INT PRIMARY KEY,
	TAIKHOAN VARCHAR(50),
	MATKHAU VARCHAR(50)
);

GO

-- Thêm dữ liệu vào bảng ACCOUNT
INSERT INTO ACCOUNT (ID, TAIKHOAN, MATKHAU)
VALUES
	(1, 'admin', '123456');

GO

/*--------------------------------------------------------------------*/

-- Tạo bảng BAN để quản lý thông tin các bàn
CREATE TABLE BAN (
	MABAN VARCHAR(20) PRIMARY KEY,
	TENBAN NVARCHAR(20),
	TRANGTHAI NVARCHAR(100)
);

GO

-- Thêm dữ liệu vào bảng BAN
INSERT INTO BAN (MABAN, TENBAN, TRANGTHAI)
VALUES
	('B01', 'BAN1', 'Đã đặt'),
	('B02', 'BAN2', 'Trống'),
	('B03', 'BAN3', 'Trống'),
	('B04', 'BAN4', 'Trống'),
	('B05', 'BAN5', 'Trống'),
	('B06', 'BAN6', 'Trống'),
	('B07', 'BAN7', 'Trống'),
	('B08', 'BAN8', 'Trống'),
	('B09', 'BAN9', 'Trống'),
	('B10', 'BAN10', 'Trống');

GO
/*--------------------------------------------------------------------*/

-- Tạo bảng DOUONG để lưu thông tin đồ uống
CREATE TABLE DOUONG (
	MADOUONG VARCHAR(20) PRIMARY KEY,
	TENDOUONG VARCHAR(50),
	GIA FLOAT
);

GO

-- Thêm dữ liệu vào bảng DOUONG
INSERT INTO DOUONG (MADOUONG, TENDOUONG, GIA)
VALUES
    ('D01', 'Cà phê đen', 20000),
    ('D02', 'Cà phê sữa', 25000),
    ('D03', 'Bạc xỉu', 30000),
    ('D04', 'Cà phê trứng', 35000),
    ('D05', 'Sinh tố thập cẩm', 40000);

GO
/*--------------------------------------------------------------------*/

-- Tạo bảng ORDER_ để lưu thông tin đơn đặt đồ uống
CREATE TABLE ORDER_ (
	MABAN VARCHAR(20),
	MADOUONG VARCHAR(20),
	GIA FLOAT,
	CONSTRAINT FK_BAN FOREIGN KEY (MABAN) REFERENCES BAN(MABAN),
	CONSTRAINT FK_DOUONG FOREIGN KEY (MADOUONG) REFERENCES DOUONG(MADOUONG)
);

GO

-- Tạo bảng DOANHTHU để lưu thông tin doanh thu
CREATE TABLE DOANHTHU (
    ID INT PRIMARY KEY IDENTITY(1,1),
    NGAY DATE DEFAULT CAST(GETDATE() AS DATE),
    GIO TIME(0) DEFAULT CAST(GETDATE() AS TIME(0)),  -- Độ chính xác 0, chỉ đến giây
    TONGTIEN FLOAT
);

GO




CREATE TRIGGER TRG_UPDATE_GIA
ON ORDER_
AFTER INSERT
AS
BEGIN
    UPDATE ORDER_
    SET GIA = DOUONG.GIA
    FROM ORDER_
    JOIN DOUONG ON ORDER_.MADOUONG = DOUONG.MADOUONG
    WHERE ORDER_.MADOUONG IN (SELECT MADOUONG FROM INSERTED);
END;

GO

INSERT INTO ORDER_ (MABAN, MADOUONG)
VALUES ('B01', 'D01');
go

-- Chèn dữ liệu vào bảng DOANHTHU

INSERT INTO DOANHTHU (NGAY, GIO, TONGTIEN) VALUES ('2024-11-03', '10:30:00', 100000);
INSERT INTO DOANHTHU (NGAY, GIO, TONGTIEN) VALUES ('2024-11-03', '15:45:00', 150000);

INSERT INTO DOANHTHU (NGAY, GIO, TONGTIEN) VALUES ('2024-11-10', '09:20:00', 200000);
INSERT INTO DOANHTHU (NGAY, GIO, TONGTIEN) VALUES ('2024-11-15', '16:50:00', 250000);

INSERT INTO DOANHTHU (NGAY, GIO, TONGTIEN) VALUES ('2024-07-22', '11:00:00', 300000);
INSERT INTO DOANHTHU (NGAY, GIO, TONGTIEN) VALUES ('2024-08-05', '14:30:00', 350000);

GO


select * from ban