-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 09, 2016 at 03:10 PM
-- Server version: 5.6.30
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `Comments`
--

CREATE TABLE IF NOT EXISTS `Comments` (
  `comments_id` bigint(20) NOT NULL,
  `comments_author` varchar(60) NOT NULL,
  `comments_date` varchar(60) NOT NULL,
  `comments_comment` text NOT NULL,
  `lot_name` varchar(100) NOT NULL,
  `comments_stars` tinyint(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Comments`
--

INSERT INTO `Comments` (`comments_id`, `comments_author`, `comments_date`, `comments_comment`, `lot_name`, `comments_stars`) VALUES
(1, 'Anonymous', '10/25/2016 14:17:10', 'I bought it yesterday', 'Samsung Galaxy S6', 5);

-- --------------------------------------------------------

--
-- Table structure for table `Lot`
--

CREATE TABLE IF NOT EXISTS `Lot` (
  `lot_id` bigint(20) NOT NULL,
  `lot_name` varchar(100) NOT NULL,
  `lot_type` varchar(100) NOT NULL,
  `lot_price` double NOT NULL,
  `lot_country` varchar(100) NOT NULL,
  `lot_image` varchar(100) NOT NULL,
  `lot_imageBig` varchar(100) NOT NULL,
  `lot_description` text NOT NULL,
  `lot_descriptionBig` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Lot`
--

INSERT INTO `Lot` (`lot_id`, `lot_name`, `lot_type`, `lot_price`, `lot_country`, `lot_image`, `lot_imageBig`, `lot_description`, `lot_descriptionBig`) VALUES
(1, 'Samsung Galaxy S6', 'smartphone', 127, 'South Korea', '/resources/images/phones/galaxy6.jpg', '/resources/images/phones/bigImg/galaxy6.jpg', 'Samsung Galaxy S6, Samsung Galaxy S6 Edge, and Samsung Galaxy S6 Edge+ are Android smartphones manufactured and marketed by Samsung Electronics. ', 'The Galaxy S6, S6 Edge and S6 Edge+ received mostly positive reviews from critics, who praised the devices'' upgraded build quality over prior models, along with improvements to their displays, performance, camera, and other changes. However, Samsung''s decision to remove the ability to expand their storage or remove the battery was panned as being potentially alienating to power users, and the S6 Edge was also panned for not making enough use of its curved display to justify its increased cost over the standard Samsung Galaxy S6 which resulted into the release of the bigger S6 Edge+ later on.'),
(2, 'Samsung Galaxy S7', 'smartphone', 199.99, 'South Korea', '/resources/images/phones/galaxy7.jpg', '/resources/images/phones/bigImg/galaxy7.jpg', 'Samsung Galaxy S7 and Samsung Galaxy S7 Edge are Android smartphones manufactured and marketed by Samsung Electronics. The S7 series is a successor to the 2015 ', 'Samsung Galaxy S7 and Samsung Galaxy S7 Edge are Android smartphones manufactured and marketed by Samsung Electronics. The S7 series is a successor to the 2015 Galaxy S6, S6 Edge and S6 Edge+, and was officially unveiled on 21 February 2016 during a Samsung press conference at Mobile World Congress, with a European and North American release scheduled for 11 March 2016. As with the S6, the S7 is produced in a standard model with a display size of 5.1 inches, as well as an Edge variant whose 5.5-inch display is curved along the wide sides of the screen.\r\n\r\nThe Galaxy S7 is an evolution of the prior year''s model, restoring features from the Galaxy S5 such as IP certification for water and dust resistance, as well as expandable storage.'),
(3, 'iPhone 5', 'smartphone', 112.39, 'USA', '/resources/images/phones/iphone5.jpg', '/resources/images/phones/bigImg/iphone5.jpg', 'The iPhone 5 is a smartphone that was designed and marketed by Apple Inc. It is the sixth generation of the iPhone, succeeding the iPhone 4S and preceding the iPhone 5S and iPhone 5C.', 'The iPhone 5 is a smartphone that was designed and marketed by Apple Inc. It is the sixth generation of the iPhone, succeeding the iPhone 4S and preceding the iPhone 5S and iPhone 5C. Formally unveiled as part of a press event on September 12, 2012, it was released on September 21, 2012. It was the first iPhone to be completely developed under the guidance of Tim Cook.\r\n\r\nThe iPhone 5 featured major design changes in comparison to its predecessor. These included an aluminum-based body which was thinner and lighter than previous models, a taller screen with a nearly 16:9 aspect ratio, the Apple A6 system-on-chip, LTE support, and Lightning, a new compact dock connector which replaced the 30-pin design used by previous iPhone models. This was the second Apple phone to include its new Sony made 8MP Camera, first introduced on the iPhone 4S.'),
(4, 'iPhone 6', 'smartphone', 169.99, 'USA', '/resources/images/phones/iphone6.jpg', '/resources/images/phones/bigImg/iphone6.jpg', 'The iPhone 6 and iPhone 6 Plus are smartphones designed and marketed by Apple Inc. The devices are part of the iPhone series and were announced on September 9, 2014, and released on September 19, 2014.', 'Big descriptionThe iPhone 6 and iPhone 6 Plus include a number of changes over their predecessor, including models with larger 4.7 and 5.5 inches (120 and 140 mm) displays, a faster processor, upgraded cameras, improved LTE and Wi-Fi connectivity and support for a near field communications-based mobile payments offering.\r\n\r\nPre-orders of the iPhone 6 and iPhone 6 Plus exceeded four million within its first 24 hours of availabilityâan Apple record. More than ten million iPhone 6 and iPhone 6 Plus devices were sold in the first three days, another Apple record.'),
(5, 'iPhone 6S', 'smartphone', 200.99, 'USA', '/resources/images/phones/iphone6s.jpg', '/resources/images/phones/bigImg/iphone6s.jpg', 'The iPhone 6S and iPhone 6S Plus (stylized as iPhone 6s and iPhone 6s Plus) are smartphones designed by Apple Inc. ', 'The iPhone 6S and iPhone 6S Plus are the performance versions over their respective predecessors, featuring improved hardware specifications, including 3D Touch, a force-sensitive touchscreen; upgraded rear-facing and front-facing cameras; a faster processor; a new chassis made of a stronger 7000 series aluminum alloy; second-generation fingerprint recognition Touch ID; improved LTE and Wi-Fi connectivity; and a new rose gold finish in addition to the space gray, silver, and gold finishes found on the previous models, while maintaining an identical design. The devices ship with iOS 9 preinstalled.'),
(6, 'Lenovo', 'notebook', 100, 'China', '/resources/images/notebooks/lenovo.png', '/resources/images/notebooks/bigImg/lenovo.png', 'Lenovo Group Ltd. /lɛnˈoʊvoʊ/ (simply as Lenovo) is a Chinese multinational technology company ', 'Lenovo Group Ltd. /lɛnˈoʊvoʊ/ (simply as Lenovo) is a Chinese multinational technology company with headquarters in Beijing, China, and Morrisville, North Carolina, United States. It designs, develops, manufactures and sells personal computers, tablet computers, smartphones, workstations, servers, electronic storage devices, IT management software and smart televisions. In 2015, Lenovo was the world''s largest personal computer vendor by unit sales. It markets the ThinkPad line of notebook computers, IdeaPad line of notebook laptops, IdeaCentre line of desktops, Yoga line of notebook laptops, and the ThinkCentre line of desktops.'),
(7, 'Asus', 'notebook', 120.59, 'Taiwan', '/resources/images/notebooks/asus.png', '/resources/images/notebooks/bigImg/asus.png', 'ASUSTeK Computer Inc is a Taiwanese multinational computer hardware and electronics company headquartered in Beitou District, Taipei, Taiwan.', 'Asus is the world''s 4th-largest PC vendor by 2015 unit sales.[3] Asus appears in BusinessWeekâs "InfoTech 100" and "Asiaâs Top 10 IT Companies" rankings, and it ranked first in the IT Hardware category of the 2008 Taiwan Top 10 Global Brands survey with a total brand value of $1.3 billion.\r\n\r\nAsus has a primary listing on the Taiwan Stock Exchange under the ticker code 2357 and a secondary listing on the London Stock Exchange under a ticker code ASKD.\r\n'),
(8, 'HP', 'notebook', 211.78, 'USA', '/resources/images/notebooks/hp.png', '/resources/images/notebooks/bigImg/hp.png', 'The Hewlett-Packard Company was an American multinational information technology company.', 'The company was founded in a one-car garage in Palo Alto by William "Bill" Redington Hewlett and David "Dave" Packard, and initially produced a line of electronic test equipment. HP was the world''s leading PC manufacturer from 2007 to Q2 2013, after which Lenovo remained ranked ahead of HP. It specialized in developing and manufacturing computing, data storage, and networking hardware, designing software and delivering services. Major product lines included personal computing devices, enterprise and industry standard servers, related storage devices, networking products, software and a diverse range of printers and other imaging products. HP marketed its products to households, small- to medium-sized businesses and enterprises directly as well as via online distribution, consumer-electronics and office-supply retailers, software partners and major technology vendors. HP also had services and consulting business around its products and partner products.'),
(9, 'Dell', 'notebook', 223.99, 'USA', '/resources/images/notebooks/dell.png', '/resources/images/notebooks/bigImg/dell.png', 'Dell Inc. (stylized as DELL) is an American privately owned multinational computer technology company based in Round Rock, Texas, United States.', 'Dell sells personal computers (PCs), servers, data storage devices, network switches, software, computer peripherals, HDTVs, cameras, printers, MP3 players, and electronics built by other manufacturers. The company is well known for its innovations in supply chain management and electronic commerce, particularly its direct-sales model and its "build-to-order" or "configure to order" approach to manufacturingâdelivering individual PCs configured to customer specifications. Dell was a pure hardware vendor for much of its existence, but with the acquisition in 2009 of Perot Systems, Dell entered the market for IT services. The company has since made additional acquisitions in storage and networking systems, with the aim of expanding their portfolio from offering computers only to delivering complete solutions for enterprise customers.');

-- --------------------------------------------------------

--
-- Table structure for table `ShoppingCart`
--

CREATE TABLE IF NOT EXISTS `ShoppingCart` (
  `cart_id` bigint(20) NOT NULL,
  `cart_name` varchar(100) NOT NULL,
  `cart_price` double NOT NULL,
  `cart_image` varchar(100) NOT NULL,
  `cart_user` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ShoppingCart`
--

INSERT INTO `ShoppingCart` (`cart_id`, `cart_name`, `cart_price`, `cart_image`, `cart_user`) VALUES
(26, 'Samsung Galaxy S6', 127, '/resources/images/phones/galaxy6.jpg', 'Yuriy'),
(27, 'Samsung Galaxy S7', 199.99, '/resources/images/phones/galaxy7.jpg', 'Yuriy'),
(29, 'iPhone 5', 112.39, '/resources/images/phones/iphone5.jpg', 'Yuriy');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `users_id` bigint(20) NOT NULL,
  `users_name` varchar(100) NOT NULL,
  `users_email` varchar(100) NOT NULL,
  `users_country` varchar(60) NOT NULL,
  `users_city` varchar(100) NOT NULL,
  `users_password` varchar(255) NOT NULL,
  `users_role` varchar(20) NOT NULL DEFAULT 'ROLE_USER',
  `enabled` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`users_id`, `users_name`, `users_email`, `users_country`, `users_city`, `users_password`, `users_role`, `enabled`) VALUES
(1, 'Yuriy', 'yura@gmail.com', 'Ukraine', 'i', 'bc759e17ff6499e8537e1f34eac176f5', 'ROLE_ADMIN', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Comments`
--
ALTER TABLE `Comments`
  ADD PRIMARY KEY (`comments_id`);

--
-- Indexes for table `Lot`
--
ALTER TABLE `Lot`
  ADD PRIMARY KEY (`lot_id`);

--
-- Indexes for table `ShoppingCart`
--
ALTER TABLE `ShoppingCart`
  ADD PRIMARY KEY (`cart_id`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`users_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Comments`
--
ALTER TABLE `Comments`
  MODIFY `comments_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `Lot`
--
ALTER TABLE `Lot`
  MODIFY `lot_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `ShoppingCart`
--
ALTER TABLE `ShoppingCart`
  MODIFY `cart_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `users_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
