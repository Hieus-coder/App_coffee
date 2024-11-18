-- Tạo cơ sở dữ liệu QLCoffee
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
	TENDOUONG NVARCHAR(50),
	GIA FLOAT,
	CHIPHI FLOAT
);

GO
/*--------------------------------------------------------------------*/

-- Tạo bảng ORDER_ để lưu thông tin đơn đặt đồ uống
CREATE TABLE ORDER_ (
    ID INT PRIMARY KEY IDENTITY(1,1),
    MABAN VARCHAR(20),
    MADOUONG VARCHAR(20),
	CHIPHI FLOAT,
    GIA FLOAT,
    CONSTRAINT FK_BAN FOREIGN KEY (MABAN) REFERENCES BAN(MABAN),
    CONSTRAINT FK_DOUONG FOREIGN KEY (MADOUONG) REFERENCES DOUONG(MADOUONG),
);

GO

-- Tạo bảng DOANHTHU để lưu thông tin doanh thu
CREATE TABLE DOANHTHU (
    ID INT PRIMARY KEY IDENTITY(1,1),
    NGAY DATE DEFAULT CAST(GETDATE() AS DATE),
    GIO TIME(0) DEFAULT CAST(GETDATE() AS TIME(0)),  -- Độ chính xác 0, chỉ đến giây
	TONGCHIPHI FLOAT,
    TONGTIEN FLOAT
);

GO

-- Tạo bảng ACCOUNT
CREATE TABLE ACCOUNT (
    ID INT PRIMARY KEY IDENTITY(1,1),
	ID_NHAN_SU INT,
    TAIKHOAN VARCHAR(50),
    MATKHAU VARCHAR(50),
	CHUC_VU NVARCHAR(50),
    FOREIGN KEY (ID_NHAN_SU) REFERENCES NHAN_SU(ID_NHAN_SU)
);

go

ALTER TABLE ACCOUNT
ADD CONSTRAINT FK__ACCOUNT__ID_NHAN__47DBAE45
FOREIGN KEY (ID_NHAN_SU)
REFERENCES NHAN_SU(ID_NHAN_SU)
ON DELETE CASCADE;

go



-- Thêm dữ liệu vào bảng DOUONG
INSERT INTO DOUONG (MADOUONG, TENDOUONG, GIA, CHIPHI)
VALUES
    ('D01', N'Cà phê đen', 20000, 15000),
    ('D02', N'Cà phê sữa', 25000, 18000),
    ('D03', N'Bạc xỉu', 30000, 20000),
    ('D04', N'Cà phê trứng', 35000, 25000),
    ('D05', N'Sinh tố thập cẩm', 40000, 30000);

GO
-- Thêm dữ liệu vào bảng BAN
INSERT INTO BAN (MABAN, TENBAN, TRANGTHAI)
VALUES
	('B01', 'BAN1', N'Trống'),
	('B02', 'BAN2', N'Trống'),
	('B03', 'BAN3', N'Trống'),
	('B04', 'BAN4', N'Trống'),
	('B05', 'BAN5', N'Trống'),
	('B06', 'BAN6', N'Trống')
-- Thêm cột ID_NHAN_SU vào bảng ACCOUNT

go
--------------------------------------------------------------------------------------

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

go

CREATE TRIGGER TRG_UPDATE_GIA_CHIPHI
ON ORDER_
AFTER INSERT
AS
BEGIN
    -- Cập nhật giá và chi phí khi thêm bản ghi mới vào ORDER_
    UPDATE o
    SET o.GIA = d.GIA,
        o.CHIPHI = d.CHIPHI
    FROM ORDER_ o
    JOIN DOUONG d ON o.MADOUONG = d.MADOUONG
    WHERE o.ID IN (SELECT ID FROM INSERTED);
END;

go
select * from ban;
select * from DOUONG
select * from ACCOUNT
SELECT * FROM DOUONG
Select * from ORDER_
SELECT d.MADOUONG, d.TENDOUONG FROM DOUONG d JOIN ORDER_ od ON d.MADOUONG = od.MADOUONG WHERE od.MABAN = 'B01'

INSERT INTO ORDER_ (MABAN, MADOUONG, TENDOUONG, SOLUONG, GIA) VALUES ('B01', 'D01', N'Cà phê đen', 10, 1000000);
SELECT * FROM ORDER_ WHERE MABAN = 'B01'
SELECT MADOUONG FROM DOUONG WHERE TENDOUONG = N'Cà phê đen'

ALTER TABLE ORDER_
ADD  TENDOUONG NVARCHAR(50)
ALTER TABLE ORDER_
ADD TONGTIEN FLOAT;

