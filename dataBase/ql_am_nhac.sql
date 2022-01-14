-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th1 14, 2022 lúc 03:37 AM
-- Phiên bản máy phục vụ: 5.7.31-log
-- Phiên bản PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ql_am_nhac`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baihat`
--

DROP TABLE IF EXISTS `baihat`;
CREATE TABLE IF NOT EXISTS `baihat` (
  `MABH` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TENBH` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NAMST` int(11) NOT NULL,
  `MANS` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MABH`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `baihat`
--

INSERT INTO `baihat` (`MABH`, `TENBH`, `NAMST`, `MANS`) VALUES
('B01', 'Thuyền và biển', 1981, 'NS01'),
('1', 'thu', 2022, 'NS001'),
('011', 'Bình Minh', 2020, 'NS01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `casi`
--

DROP TABLE IF EXISTS `casi`;
CREATE TABLE IF NOT EXISTS `casi` (
  `MACS` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TENCS` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MACS`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `casi`
--

INSERT INTO `casi` (`MACS`, `TENCS`) VALUES
('CS01', 'Quang Lý'),
('0012', 'thu'),
('a', '12'),
('b', '1'),
('001', 'Minh hằngg1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacsi`
--

DROP TABLE IF EXISTS `nhacsi`;
CREATE TABLE IF NOT EXISTS `nhacsi` (
  `MANS` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TENNS` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MANS`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacsi`
--

INSERT INTO `nhacsi` (`MANS`, `TENNS`) VALUES
('NS01', 'Phan Huỳnh Điểu '),
('NS001', 'Trần Dần');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `user` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`user`, `password`) VALUES
('admin', '1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtinbieudien`
--

DROP TABLE IF EXISTS `thongtinbieudien`;
CREATE TABLE IF NOT EXISTS `thongtinbieudien` (
  `MABD` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MACS` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MABH` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NGAYBD` date NOT NULL,
  `DIADIEM` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`MABD`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thongtinbieudien`
--

INSERT INTO `thongtinbieudien` (`MABD`, `MACS`, `MABH`, `NGAYBD`, `DIADIEM`) VALUES
('01', 'CS01', 'B01', '2013-03-03', 'Sân khấu Lan Anh'),
('02', 'CS01', 'B01', '2013-03-28', 'Sân khấu Lan Anh'),
('03', 'CS012', 'B01f', '2013-03-19', 'Sân khấu Lan Anh 1'),
('0011', 'CS01', 'B01', '2022-01-13', 'HCM');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
