-- insert configurations
INSERT INTO configuration (configuration_id, camera_front, camera_rear, chipset, cpu, pin, ram, rom, screen, systems)
VALUES (1, "7 MP, f/2.2", "2160p@24/30/60fps, 1080p@30/60/120/240fps", "Apple A11 Bionic", "Hexa-core", "3000", "3gb", "64gb", "Super AMOLED,5.8 inches,1125 x 2436 pixels","iOS 11");
-- insert sale
INSERT INTO sale (sale_id, notes, valuess)
VALUES (1, "", "5"),
(2, "", "10"),
(3, "", "15"),
(4, "", "20"),
(5, "", "25"),
(6, "", "12"),(7, "", "8");
-- insert type product
INSERT INTO product_type (product_type_id, name, notes)
VALUES (1, "Iphone", ""),
(2, "Samsung", ""),
(3, "Lg", ""),
(4, "Xiaomi", ""),
(5, "Nokia", ""),
(6, "Ipad", "");
-- insert product
INSERT INTO product (id, amount, name, color, described, image, price, product_types_id, sales_id, configuration_id)
VALUES (1, 10, "SAMSUNG GALAXY NOTE 10 ", "", "", "business/img/samsungnote10.jpg", 1000000,2,1,1),
 (2, 10, "SAMSUNG Note 10 Plus", "", "", "business/img/samsungnote10.jpg", 1000000,2,1,1),
  (3, 10, "Iphone 11 256gb ", "", "", "business/img/iphone11den.png", 1000000,1,1,1),
   (4, 10, "LG v50 quốc tế ", "black", "", "business/img/lgv50den.jpg", 1000000,3,1,1),
    (5, 10, "IPHONE XS MỚI", "", "", "business/img/samsungnote10.jpg", 1000000,1,1,1),
     (6, 10, "IPHONE 8 ", "black", "", "business/img/iphone8den.jpg", 1000000,1,1,1),
      (7, 10, "Lg g8 thinQ", "red", "", "business/img/lgg8do.jpg", 1000000,3,1,1),
       (8, 10, "Lg V50", "black", "", "business/img/lgv50den.jpg", 1000000,3,1,1),
        (9, 10, "Iphone 11", "", "", "business/img/iphone11.jpg", 1000000,1,1,1),
         (10, 10, "Iphone X ", "black", "", "business/img/iphonexden.jpg", 1000000,1,1,1),
          (11, 10, "Samsung s9", "", "", "business/img/samsungs9.jpg", 1000000,2,1,1);