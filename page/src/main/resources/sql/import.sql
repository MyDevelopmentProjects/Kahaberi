INSERT INTO qr_role (id, date_created, name) VALUES
(1, '2017-04-23 09:26:12', 'USER'),
(2, '2017-04-23 09:26:12', 'ADMIN');

INSERT INTO qr_language (id, date_created, date_updated, description, display_name, short_code) VALUES
(1, '2018-04-14 17:02:22', NULL, NULL, 'ქართული', 'GE'),
(2, '2018-04-14 17:02:22', NULL, NULL, 'English', 'EN');

INSERT INTO `qr_menu_category` (`id`, `date_created`) VALUES
(1, '2018-05-09 04:11:37'),
(2, '2018-05-09 04:11:37');

INSERT INTO `qr_menu_category_locale` (`id`, `title`, `category_id`, `lang_id`) VALUES
(1, 'Shirts', 1, 1),
(2, 'Bots', 2, 1);

INSERT INTO `qr_menu_item` (`id`, `date_created`, `images`, `price`, `category_id`) VALUES
(1, '2018-05-09 04:13:06', '["http://shop.picassostudio.io/assets/img/NIKE-ROSHE-FLYKNIT-PRM-746825_402_A_PREM_1.png","http://shop.picassostudio.io/assets/img/TENNIS-CLASSIC-ULTRA-QS-807175_008_A_PREM_1.png"]', 150,  1),
(2, '2018-05-09 04:13:06', '["http://shop.picassostudio.io/assets/img/NIKE-ROSHE-NM-FLYKNIT-SE-816531_300_A_PREM_1.png", "http://shop.picassostudio.io/assets/img/STEFAN-JANOSKI-MAX-PRM-807497_101_A_PREM_1.png"]', 99,  1),
(3, '2018-05-09 04:13:06', '["http://shop.picassostudio.io/assets/img/INTERNATIONALIST-KJCRD-M-QS-829344_006_A_PREM_1.png", "http://shop.picassostudio.io/assets/img/NIKE-ROSHE-CORTEZ-NM-823299_607_A_PREM_1.png"]', 154,  2),
(4, '2018-05-09 04:13:06', '["http://shop.picassostudio.io/assets/img/NIKE-ROSHE-FLYKNIT-PRM-746825_402_A_PREM_1.png","http://shop.picassostudio.io/assets/img/TENNIS-CLASSIC-ULTRA-QS-807175_008_A_PREM_1.png"]', 150,  1),
(5, '2018-05-09 04:13:06', '["http://shop.picassostudio.io/assets/img/NIKE-ROSHE-NM-FLYKNIT-SE-816531_300_A_PREM_1.png", "http://shop.picassostudio.io/assets/img/STEFAN-JANOSKI-MAX-PRM-807497_101_A_PREM_1.png"]', 99,  1),
(6, '2018-05-09 04:13:06', '["http://shop.picassostudio.io/assets/img/INTERNATIONALIST-KJCRD-M-QS-829344_006_A_PREM_1.png", "http://shop.picassostudio.io/assets/img/NIKE-ROSHE-CORTEZ-NM-823299_607_A_PREM_1.png"]', 154,  2);

INSERT INTO `qr_menu_item_sq` (`item_id`, `size`, `quantity`) VALUES
(1, '1', 15),   (2, '1', 15),
(1, '21', 15),  (2, '21', 15),
(1, '3', 0),    (2, '3', 0),
(1, '4', 11),   (2, '4', 11),
(1, '5', 23),   (2, '5', 23),
(1, '6', 143),  (2, '6', 143),
(1, '7', 1),    (2, '7', 1),
(1, '8', 7),    (2, '8', 7),

(3, '1', 15),   (4, '1', 15),
(3, '21', 15),  (4, '21', 15),
(3, '3', 0),    (4, '3', 0),
(3, '4', 11),   (4, '4', 11),
(3, '5', 23),   (4, '5', 23),
(3, '6', 143),  (4, '6', 143),
(3, '7', 1),    (4, '7', 1),
(3, '8', 7),    (4, '8', 7),

(5, '1', 15),   (6, '1', 15),
(5, '21', 15),  (6, '21', 15),
(5, '3', 0),    (6, '3', 0),
(5, '4', 11),   (6, '4', 11),
(5, '5', 23),   (6, '5', 23),
(5, '6', 143),  (6, '6', 143),
(5, '7', 1),    (6, '7', 1),
(5, '8', 7),    (6, '8', 7);


INSERT INTO `qr_menu_item_locale` (`description`, `title`, `item_id`, `lang_id`) VALUES
('Desc KA', 'Product', 1, 1),
('Desc KA', 'Product', 2, 1),
('Desc KA', 'Product', 3, 1),
('Desc KA', 'Product', 4, 1),
('Desc KA', 'Product', 5, 1),
('Desc KA', 'Product', 6, 1),
('Desc EN', 'Product', 1, 2),
('Desc EN', 'Product', 2, 2),
('Desc EN', 'Product', 3, 2),
('Desc EN', 'Product', 4, 2),
('Desc EN', 'Product', 5, 2),
('Desc EN', 'Product', 6, 2);
