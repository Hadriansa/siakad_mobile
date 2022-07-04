-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2019 at 03:22 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_akademik`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_dosen`
--

CREATE TABLE IF NOT EXISTS `tb_dosen` (
  `nidn` varchar(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jurusan` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_dosen`
--

INSERT INTO `tb_dosen` (`nidn`, `nama`, `jurusan`) VALUES
('11001', 'Aida Indriani, S.Kom, M.Kom', 'Teknik Informatika'),
('11002', 'Asmah, S.Kom, M.Kom', 'Sistem Informasi'),
('11003', 'Evidianti Bintari, S.T., M.Kom', 'Manajemen Informatika'),
('11004', 'Fitria, S.Kom., M.Kom', 'Sistem Informasi');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kelas`
--

CREATE TABLE IF NOT EXISTS `tb_kelas` (
  `kd_kelas` varchar(11) NOT NULL,
  `nama_kelas` varchar(9) NOT NULL,
  `kapasitas` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kelas`
--

INSERT INTO `tb_kelas` (`kd_kelas`, `nama_kelas`, `kapasitas`) VALUES
('K001', 'Kelas A', '40'),
('K002', 'Kelas B', '40'),
('K003', 'Kelas C', '40'),
('K004', 'Kelas D', '39'),
('K005', 'Kelas E', '40'),
('K006', 'Kelas F', '40');

-- --------------------------------------------------------

--
-- Table structure for table `tb_krs`
--

CREATE TABLE IF NOT EXISTS `tb_krs` (
`id_krs` int(11) NOT NULL,
  `kd_krs` varchar(5) NOT NULL,
  `nidn` varchar(11) NOT NULL,
  `kd_mk` varchar(5) NOT NULL,
  `kd_kelas` varchar(4) NOT NULL,
  `hari_krs` varchar(15) NOT NULL,
  `jam_krs` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_krs`
--

INSERT INTO `tb_krs` (`id_krs`, `kd_krs`, `nidn`, `kd_mk`, `kd_kelas`, `hari_krs`, `jam_krs`) VALUES
(2, 'KR001', '11001', 'MK001', 'K001', 'Senin', '11:30:00 AM');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mahasiswa`
--

CREATE TABLE IF NOT EXISTS `tb_mahasiswa` (
  `nim` varchar(9) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jurusan` varchar(25) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `tmplahir` varchar(255) NOT NULL,
  `tgllahir` date NOT NULL,
  `agama` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mahasiswa`
--

INSERT INTO `tb_mahasiswa` (`nim`, `nama`, `jurusan`, `alamat`, `tmplahir`, `tgllahir`, `agama`) VALUES
('16.50.001', 'ansar', 'Sistem Informasi', 'tarakan', 'tarakan', '1988-04-08', ''),
('16.50.002', 'ansar', 'Sistem Informasi', 'tarakan', 'tarakan', '1988-04-08', 'Islam'),
('17.30.001', 'And Niar', 'Manajemen Informatika', 'Jl. Mulawarman', 'Tarakan', '1988-03-01', 'Islam'),
('17.50.001', 'Andi Akbar', 'Sistem Informasi', 'Jl. Gajamadah', 'Nunukan', '1999-04-01', 'Islam'),
('17.51.001', 'Andi Ardi', 'Teknik Informatika', 'Jl. Yos Sudarso', 'Sebatik', '1999-05-01', 'Islam');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mk`
--

CREATE TABLE IF NOT EXISTS `tb_mk` (
  `kd_mk` varchar(5) NOT NULL,
  `nama_mk` varchar(50) NOT NULL,
  `semester` varchar(25) NOT NULL,
  `sifat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_mk`
--

INSERT INTO `tb_mk` (`kd_mk`, `nama_mk`, `semester`, `sifat`) VALUES
('MK001', 'Bahasa Pemgrograman Objek I', 'Genap', 'Wajib'),
('MK002', 'Bahasa Pemgrogaman Android', 'Genap', 'Wajib'),
('MK003', 'Bahasa Pemgrograman Visual I', 'Genap', 'Wajib'),
('Mk004', 'Linux', 'Genap', 'Wajib');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_dosen`
--
ALTER TABLE `tb_dosen`
 ADD PRIMARY KEY (`nidn`);

--
-- Indexes for table `tb_kelas`
--
ALTER TABLE `tb_kelas`
 ADD PRIMARY KEY (`kd_kelas`);

--
-- Indexes for table `tb_krs`
--
ALTER TABLE `tb_krs`
 ADD PRIMARY KEY (`id_krs`);

--
-- Indexes for table `tb_mahasiswa`
--
ALTER TABLE `tb_mahasiswa`
 ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `tb_mk`
--
ALTER TABLE `tb_mk`
 ADD PRIMARY KEY (`kd_mk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_krs`
--
ALTER TABLE `tb_krs`
MODIFY `id_krs` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
