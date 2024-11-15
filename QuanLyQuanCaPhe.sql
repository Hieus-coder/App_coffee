﻿-- Tạo cơ sở dữ liệu QLCoffee
CREATE DATABASE QLCOFFEE;

GO
/*--------------------------------------------------------------------*/
-- Sử dụng cơ sở dữ liệu QLCOFFEE
USE QLCOFFEE;

GO
/*--------------------------------------------------------------------*/
CREATE TABLE NHAN_SU (
    ID_NHAN_SU INT PRIMARY KEY IDENTITY(1,1),
    HO_VA_TEN NVARCHAR(100) NOT NULL,
    GIOI_TINH NVARCHAR(10),
    NAM_SINH INT,
    CHUC_VU NVARCHAR(50),
    QUE_QUAN NVARCHAR(100),
    SO_DIEN_THOAI NVARCHAR(15)
);

go

/*--------------------------------------------------------------------*/
-- Tạo bảng BAN để quản lý thông tin các bàn
CREATE TABLE BAN (
	MABAN VARCHAR(20) PRIMARY KEY,
	TENBAN NVARCHAR(20),
	TRANGTHAI NVARCHAR(100)
);

GO
/*--------------------------------------------------------------------*/

-- Tạo bảng DOUONG để lưu thông tin đồ uống
CREATE TABLE DOUONG (
	MADOUONG VARCHAR(20) PRIMARY KEY,
	TENDOUONG VARCHAR(50),
	GIA FLOAT
);

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

-- Tạo bảng ACCOUNT
CREATE TABLE ACCOUNT (
    ID INT PRIMARY KEY IDENTITY(1,1),
    TAIKHOAN VARCHAR(50),
    MATKHAU VARCHAR(50),
    ID_NHAN_SU INT,
    FOREIGN KEY (ID_NHAN_SU) REFERENCES NHAN_SU(ID_NHAN_SU)
);

go

ALTER TABLE ACCOUNT
ADD CONSTRAINT FK__ACCOUNT__ID_NHAN__47DBAE45
FOREIGN KEY (ID_NHAN_SU)
REFERENCES NHAN_SU(ID_NHAN_SU)
ON DELETE CASCADE;

go

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

/*INSERT INTO ORDER_ (MABAN, MADOUONG)
VALUES ('B01', 'D01');
go*/

-- Chèn dữ liệu vào bảng DOANHTHU

INSERT INTO DOANHTHU (NGAY, GIO, TONGTIEN) 
VALUES 
	('2024-11-03', '10:30:00', 100000),
	('2024-11-03', '15:45:00', 150000),
	('2024-11-10', '09:20:00', 200000),
	('2024-11-15', '16:50:00', 250000),
	('2024-07-22', '11:00:00', 300000),
	('2024-08-05', '14:30:00', 350000);

GO

-- Thêm dữ liệu vào bảng DOUONG
INSERT INTO DOUONG (MADOUONG, TENDOUONG, GIA)
VALUES
    ('D01', N'Cà phê đen', 20000),
    ('D02', N'Cà phê sữa', 25000),
    ('D03', N'Bạc xỉu', 30000),
    ('D04', N'Cà phê trứng', 35000),
    ('D05', N'Sinh tố thập cẩm', 40000);

GO
-- Thêm dữ liệu vào bảng BAN
INSERT INTO BAN (MABAN, TENBAN, TRANGTHAI)
VALUES
	('B01', 'BAN1', N'Trống'),
	('B02', 'BAN2', N'Trống'),
	('B03', 'BAN3', N'Trống'),
	('B04', 'BAN4', N'Trống'),
	('B05', 'BAN5', N'Trống'),
	('B06', 'BAN6', N'Trống'),
	('B07', 'BAN7', N'Trống'),
	('B08', 'BAN8', N'Trống'),
	('B09', 'BAN9', N'Trống'),
	('B10', 'BAN10', N'Trống');
-- Thêm cột ID_NHAN_SU vào bảng ACCOUNT

go
-- Thêm dữ liệu vào bảng ACCOUNT
INSERT INTO ACCOUNT (TAIKHOAN, MATKHAU, ID_NHAN_SU)
VALUES 
    (N'admin', N'12345', 1),  
    (N'nhanviena', N'12345', 2),   
    (N'nhanvienb', N'12345', 3);
GO


INSERT INTO NHAN_SU (HO_VA_TEN, GIOI_TINH, NAM_SINH, CHUC_VU, QUE_QUAN, SO_DIEN_THOAI)
VALUES 
    (N'Nguyễn Văn A', N'Nam', 1990, N'Pha chế', N'Hà Nội', N'0912345678'),
    (N'Trần Thị B', N'Nữ', 1992, N'Bồi bàn', N'TP Hồ Chí Minh', N'0987654321'),
    (N'Lê Văn C', N'Nam', 1988, N'Lao công', N'Đà Nẵng', N'0932123456');

go

/*Them cot trong bang accout*/

ALTER TABLE ACCOUNT
ADD CHUC_VU NVARCHAR(50);

go

UPDATE ACCOUNT
SET CHUC_VU = NS.CHUC_VU
FROM ACCOUNT A
JOIN NHAN_SU NS ON A.ID_NHAN_SU = NS.ID_NHAN_SU;

go

CREATE TRIGGER TRG_UPDATE_CHUC_VU
ON NHAN_SU
AFTER UPDATE
AS
BEGIN
    UPDATE ACCOUNT
    SET CHUC_VU = NS.CHUC_VU
    FROM ACCOUNT A
    JOIN NHAN_SU NS ON A.ID_NHAN_SU = NS.ID_NHAN_SU
    WHERE NS.ID_NHAN_SU IN (SELECT ID_NHAN_SU FROM INSERTED);
END;
