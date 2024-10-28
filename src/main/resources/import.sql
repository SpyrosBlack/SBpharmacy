-- populate user table
INSERT INTO `pharmacydb`.`app_user` (`firstname`, `lastname`, `username`, `userpassword`, `role`) VALUES ('Lakis', 'Spiros', 'Spiros', '1234', 'Pharmacist');
INSERT INTO `pharmacydb`.`app_user` (`firstname`, `lastname`, `username`, `userpassword`, `role`) VALUES ('Lakis', 'Lakis', 'Lakis', '1234', 'Admin');

-- populate medicines
INSERT INTO `pharmacydb`.`medicine` (`medicineprice`, `medicinename`) VALUES (23, 'Medicine 1');
INSERT INTO `pharmacydb`.`medicine` (`medicineprice`, `medicinename`) VALUES (2, 'Medicine 2');
INSERT INTO `pharmacydb`.`medicine` (`medicineprice`, `medicinename`) VALUES (56, 'Medicine 3');

-- populate pharmacy table
INSERT INTO `pharmacydb`.`pharmacy` (`pharmacyaddress`, `pharmacycity`, `pharmacyname`, `lat`, `lng`) VALUES ('lala', 'lala', 'lala', 38.1725, 23.725);
-- populate pharmacist table
INSERT INTO `pharmacydb`.`pharmacist` (`pharmacy_pharmacyid`, `user_username`) VALUES (1, 'Spiros');