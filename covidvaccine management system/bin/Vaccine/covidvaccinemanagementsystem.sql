-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2021 at 12:36 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `covidvaccinemanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `id` int(255) NOT NULL,
  `adminid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`id`, `adminid`, `name`, `password`) VALUES
(4, 'ADMINANKITA', 'ANKITA ROY', 'ankita'),
(19, 'ADMINIDHI', 'NIDHI', 'NIDHI'),
(20, '1', '1', '1'),
(21, '22', '22', '22');

-- --------------------------------------------------------

--
-- Table structure for table `headadminlogin`
--

CREATE TABLE `headadminlogin` (
  `id` int(11) NOT NULL,
  `headadminid` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `headadminlogin`
--

INSERT INTO `headadminlogin` (`id`, `headadminid`, `password`) VALUES
(1, 'ADMIN', '123');

-- --------------------------------------------------------

--
-- Table structure for table `quarantinecenter`
--

CREATE TABLE `quarantinecenter` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `block` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `quarantinecenter`
--

INSERT INTO `quarantinecenter` (`id`, `name`, `block`) VALUES
(3, 'CTC Musabani', 'Musabani');

-- --------------------------------------------------------

--
-- Table structure for table `usersignup`
--

CREATE TABLE `usersignup` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `aadhar` varchar(255) NOT NULL,
  `dob` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(255) NOT NULL,
  `dose` int(255) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usersignup`
--

INSERT INTO `usersignup` (`id`, `name`, `phone`, `aadhar`, `dob`, `password`, `status`, `dose`, `address`) VALUES
(9, 'Rahul', '4567891235', '789456123456', '2001', 'Rahul@123', 0, 0, ''),
(12, 'Roshni', '9125789643', '222222222222', '2001', 'Roshni', 1, 1, '0'),
(13, 'Aaruhi', '4561237896', '111111222222', '2005', 'Aaruhi@123', 0, 0, '0'),
(14, 'Rahul Singh', '4676796797', '456123789456', '2001', 'Rahul@1234', 0, 0, '0'),
(16, 'SHRUTI', '8051179096', '333333333333', '2000', 'Nidhi@123', 1, 1, 'Sadar Hospital, Parsudih'),
(17, 'shruti', '6015278555', '123123123123', '2000', 'Nidhi@123', 1, 1, 'Sadar Hospital, Parsudih'),
(18, 'ANTHONY', '1234567895', '555555555555', '2000', 'Nidhi@123', 1, 0, 'Sadar Hospital, Parsudih'),
(19, 'RITU', '8051117909', '888888888888', '2001', 'Nidhi@123', 1, 1, 'Ravindra Bhavan, Sakshi'),
(20, 'rohini', '4561237894', '77777777777', '2000', 'Nidhi@123', 1, 0, 'Sadar Hospital, Parsudih'),
(21, 'RAHUL', '1234567895', '777777777777', '2000', 'Nidhi@123', 1, 1, 'Rajendra Vidalaya'),
(22, 'ANTHONY', '6200156715', '123456789123', '2000', 'Nidhi@123', 1, 0, 'Sadar Hospital, Parsudih');

-- --------------------------------------------------------

--
-- Table structure for table `vaccineslot`
--

CREATE TABLE `vaccineslot` (
  `id` int(255) NOT NULL,
  `centerid` varchar(255) NOT NULL,
  `center` varchar(255) NOT NULL,
  `age` int(255) NOT NULL,
  `slot` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vaccineslot`
--

INSERT INTO `vaccineslot` (`id`, `centerid`, `center`, `age`, `slot`) VALUES
(1, '1', 'MGM Medical College, Mango', 18, 17),
(2, '2', 'Sadar Hospital, Parsudih', 18, 17),
(3, '3', 'Rajendra Vidalaya', 18, 17),
(4, '4', 'Ravindra Bhavan, Sakshi', 18, 17),
(5, '5', 'LIC Bhavan, Bistupur', 18, 17),
(6, '6', 'Loyla School, Bistupur', 45, 18),
(7, '7', 'Vidya Bharti Chinmaya, Telco', 45, 18),
(8, '8', 'PM Mall, Bistupur', 45, 10),
(9, '9', 'RKMS, SIdhgora', 45, 44),
(10, '10', 'Mercy Hospital, Baridih', 45, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminlogin`
--
ALTER TABLE `adminlogin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `headadminlogin`
--
ALTER TABLE `headadminlogin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `quarantinecenter`
--
ALTER TABLE `quarantinecenter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usersignup`
--
ALTER TABLE `usersignup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vaccineslot`
--
ALTER TABLE `vaccineslot`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminlogin`
--
ALTER TABLE `adminlogin`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `headadminlogin`
--
ALTER TABLE `headadminlogin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `quarantinecenter`
--
ALTER TABLE `quarantinecenter`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `usersignup`
--
ALTER TABLE `usersignup`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `vaccineslot`
--
ALTER TABLE `vaccineslot`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
