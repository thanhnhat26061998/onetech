-- insert product type
INSERT INTO `product_type` (`product_type_id`, `name`, `notes`) VALUES 
('1', 'iphone', NULL), 
('2', 'lg', NULL),
('3', 'samsung', NULL),
('4', 'xiaomi', NULL),
('5', 'huawei', NULL),
('6', 'google', NULL),
('7', 'sony', NULL),
('8', '', NULL),
('9', '', NULL);
-- insert image
INSERT INTO `image` (`image_id`, `image1`, `image2`, `image3`, `image4`, `image5`, `image6`, `notes`) VALUES 
('1', 'business/img/iphone11.jpg', NULL, NULL, NULL, NULL, NULL, 'iphone'),
('2', 'business/img/iphone8red.jpg', NULL, NULL, NULL, NULL, NULL, 'iphone'),
('3', 'business/img/iphone8trang.jpg', NULL, NULL, NULL, NULL, NULL, 'iphone'),
('4', 'business/img/lgg8do.jpg', NULL, NULL, NULL, NULL, NULL, 'lg'),
('5', 'business/img/lgv50den.jpg', NULL, NULL, NULL, NULL, NULL, 'lg'),
('6', 'business/img/lgv50den.jpg', NULL, NULL, NULL, NULL, NULL, 'lg'),
('7', 'business/img/samsungs9den_.jpg', NULL, NULL, NULL, NULL, NULL, 'samsung'),
('8', 'business/img/samsungs9tim.png', NULL, NULL, NULL, NULL, NULL, 'iphone');
-- insert sale
INSERT INTO `sale` (`sale_id`, `end`, `name`, `notes`, `start`, `valuess`) VALUES ('1', NULL, NULL, NULL, NULL, '10');
-- insert product
INSERT INTO `product` (`id`, `amount`, `color`, `described`, `image`, `name`, `price`, `configuration_id`, `image_id`, `product_types_id`, `sales_id`) VALUES 
('1', '12', NULL, NULL, NULL, 'iphone x', '10000000', NULL, '1', '1', '1'),
('2', '12', NULL, NULL, NULL, 'iphone 8', '800000', NULL, '2', '1', '1'),
('3', '12', NULL, NULL, NULL, 'iphone 11', '2000000', NULL, '1', '1', '1'),
('4', '12', NULL, NULL, NULL, 'lg g8', '400000', NULL, '2', '4', '1'),
('5', '12', NULL, NULL, NULL, 'lg v50', '700000', NULL, '2', '5', '1'),
('6', '12', NULL, NULL, NULL, 'lg g7', '300000', NULL, '2', '5', '1'),
('7', '12', NULL, NULL, NULL, 'samsung note 10', '1000000', NULL, '7', '3', '1'),
('8', '12', NULL, NULL, NULL, 'samsung s9', '800000', NULL, '8', '3', '1'),
('9', '12', NULL, NULL, NULL, 'iphone 11', '1000000', NULL, '1', '1', '1'),
('10', '12', NULL, NULL, NULL, 'iphone 11', '1000000', NULL, '1', '1', '1'),
('11', '12', NULL, NULL, NULL, 'iphone 11', '1000000', NULL, '1', '1', '1'),
('12', '12', NULL, NULL, NULL, 'iphone 11', '1000000', NULL, '1', '1', '1'),
('13', '12', NULL, NULL, NULL, 'iphone 11', '1000000', NULL, '1', '1', '1'),
('14', '12', NULL, NULL, NULL, 'iphone 11', '1000000', NULL, '1', '1', '1'),
('15', '12', NULL, NULL, NULL, 'iphone 8', '800000', NULL, '2', '1', '1'),
('16', '12', NULL, NULL, NULL, 'iphone 8', '880000', NULL, '2', '1', '1');